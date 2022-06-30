## ActiveMQ, Kafka ve RabbitMQ karşılaştırılması ve örnek kod üzerinden çalışma mantığı

RabbitMQ, ActiveMQ ve Apache Kafka genel tabirle mesaj kuyruk sistemleridir. Servisler arasında asenkron iletişimi sağlayan protokoller kullanırlar.
Servislerin birbiriyle haberleşmesini, veri alıp gönderilmesini sıraya alarak sağlarlar.
Gönderilen mesajın sahibi olarak Producer, mesajın alıcısı olarak Consumer ve mesajların depolandığı kuyruk olarak da Queue ifadeleri tanımlıdır.


Mesak kuyruk sisteminde farklı protokoller kullanılacaksa, daha az sayıda mesaj gönderilip mesajların ulaşma garantisi isteniyorsa ve kolay bir entegrasyon isteniyorsa ``RabbitMQ`` kullanımı daha uygundur.
RabbitMQ yüksek hacimli mesaj kuyrukları için çok kullanışlı değildir.

Burada imdadımıza ``Kafka`` yetişiyor :). Mesajların kaybolmamasını istiyorsak ve aynı anda çok fazla mesaj göndermemiz gerekiyorsa, sıranın kuyrukta nerde kaldığını Cunsomer'ın kontrol etmesi isteniyorsa Apache Kafka kullanmak çok daha uygun olacaktır.

``ActiveMQ`` diğer mesajlaşma servislerinden biraz daha farklı bir tanıma sahiptir. AMQP, STOMP, MQTT gibi birkaç mesajlaşma protokolünü destekleyen genel amaçlı bir "mesaj aracısı" olarak tanımlanır.
Genelde, özellikle Servis Odaklı Mimari içindeki uygulamalar/hizmetler arasında entegrasyon için kullanılır.

Kafka Producer'ı alıcıdan yani Consumer'den onay beklemek zorunda değildir. Ancak ActiveMQ her iletinin teslim durumunu kontrol eder.
Geleneksel mesajlaşma için AvtiveMQ kullanılırken, Kafka akış platformu olarak kullanılır.


### RabbitMQ kullanımı:
•> Öncelikle gerekli property ayarlarını resources -> application.properties yapısında belirtiyoruz.

````
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=admin
spring.rabbitmq.password=123456
rabbitmq.exchange=bilisimio.exchange
rabbitmq.queue=bilisimio.queue
rabbitmq.routingkey=bilisimio.routingkey
spring.main.allow-bean-definition-overriding=true
````

•> Docker ile RabbitMQ servisini ayağa kaldıralım.
```` 
docker run -d --hostname my-rabbit --name myrabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=123456 -p 5672:5672 -p 15672:15672 rabbitmq:3-management
````

•> Ardından maven ile dependency'mizi ekleyelim.
````
<dependency>
        <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
````
•> RabbitMQ için gerekli configrasyonu ve servisi AmqpTemplate interface'i üzerinden sağlayabiliyoruz. Ancak kendi configrasyonumuzu ve servis yapımızı da oluşturabiliriz.

•> Ben AmqpTemplate interface'inin bize sağladığı configrasyon ve servis üzerinden devam edeceğim. AmqpTemplate servisini kullacağımız servise enjekte edelim.

````
import com.logo.Model.Customer;
import com.logo.Model.User;
import com.logo.Repository.UserRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


// !!!!! Amqp servisini UserService'e @Autowired anotasyonuyla enjekte ediyoruz.
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    
    }
````

•>  Artık AmqpTemplate üzerinden oluşturduğumuz nesneyi kullanarak kuyruğa mesaj gönderebiliriz. User create eden bir işlem üzerinden örnekleme yapalım. Her create edilen user işlemi için user'ın emailini kuyruğa ekleyen kod:

````
public User createUser(User request) {
        //nesne üzerinden convertAndSend metodunu kullanarak mesajımızı kuyruğa ekleyen kod:
        (Henüz kuyruk oluşmamışsa bizim için otomatik oluşturuyor.)
       
         rabbitTemplate.convertAndSend("isbasi.email", request.getEmail());

        

        return userRepository.save(request);
    }
````

### Kafka Kullanımı:
Kullanım şekli açısından rabbitMQ'a benzemektedir.

Burada da spring içerisinden gelen DefaultKafkaProducerFactory classından faydalanacağız.

Ardından spring boot içerisindeki KafkaTemplate yardımı ile datalarımızı kafkaya gönderebiliriz.

•> Gerekli dependency'leri ekledikten sonra konfigrasyon ayarlarını yapalım.

````
@Configuration
 public class KafkaProducerConfig
 {
 
 @Value(“${kafka.bootstrap-servers}”)
 private String bootstrapServers;
 
 @Bean
 public Map<String, Object> producerConfigs() {
 Map<String, Object> props = new HashMap<>();
 props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
 bootstrapServers);
 props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
 StringSerializer.class);
 props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
 StringSerializer.class);
 props.put(ProducerConfig.ACKS_CONFIG,”all”);
 return props;
 }
 
 @Bean
 public ProducerFactory<String, String> producerFactory() {
 return new DefaultKafkaProducerFactory<>(producerConfigs());
 }
 
 @Bean
 public KafkaTemplate<String, String> kafkaTemplate() {
 return new KafkaTemplate<>(producerFactory());
 }
 }
````
•> Ardından kullanacağımız servisimizi ayarlayalım. Burada RabbitMQ aksine Topic yani göndereceğimiz mesaj yapısını da belirtiyoruz.

````
@Service

public class KafkaMessageSenderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")

    private String kafkaTopic;

    public void send(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }
}
````
•> Artık oluşturduğumuz yapıyı controllerda (veya istersek servis katmanımızda) kullanabiliriz.

````
@RestController
@RequestMapping("/sendtokafka")
public class SampleController {
    //Oluşturduğumuz service yapısından enjekte ettiğimiz nesneyi belirtiyoruz.
    
    @Autowired
    KafkaMessageSenderService kafkaMessageSenderService;
    
    @GetMapping
    public String sendMessagetoKafka()
    {
        // Mesajı gönderen kod bloğu
        kafkaMessageSenderService.send("spring to kafka");
        
        return "gonderildi";
    }
````



### ActiveMQ Kullanımı

•> Gerekli dependency'i ekleyelim.

````
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-activemq</artifactId>
</dependency>
````

•> Diğerlerinde olduğu gibi hazır templateler üzerinden ilerleyebiliriz. AvtiveMQ da sıkça kullanılan JMSTemplate yapısını kullarak 'javainuse' adlı yeni kuyruğu ekleyelim. converAndSend metoduyla mesajımızı kuyruğa ekleyebiliriz.
````
package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootHelloWorldApplication.class, args);
		
		//JMS Template üzerinden oluşturulan kuyruğumuz.
		JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		
		// Oluşturduğumuz kuyruğa veri gönderen metod.
		jms.convertAndSend("javainuse", "test message");
	}
}
````









## • Microservis vs Monolith mimari

Projelerimiz genel olarak 3 temele sahiptir. Kullanıcıya hitap eden Client kısmı, isteklerin yönetildiği ve algoritmaların tutulduğu Server kısmı ve verilerin depolandığı Database kısmı..

Monolith mimari kısaca kendi kendine yeten uygulama mimarisidir. Tek bir kod tabanında çalışılır ve tüm uygulamayı build eden tek bir derleme sistemine sahiptir.
Bununla birlikte çalıştırılabilir tek bir çıktı verir. Bu yapı sistemin tümüyle hareket etmesini zorunlu kılar. Başlatılacağı ve durdurulacağı zaman veya sistemin herhangir bir yerinde sorun oluştuğunda tüm sistem bundan etkilenir.
Bu yapı sistemde en ufak bir güncelleme yapılacağı zaman uygulamanın tümüne müdahale etmemizi gerektirmektedir.


Microservis mimarisi ise tüm projenin tek bir işine odaklı işlevsel küçük bir parçasını ifade eder. Projenin her bir işlevsel yapıtaşları ayrı birer servis olarak tasarlanır ve ayrık bir yapı oluşur.
Bu sayede projenin herhangi bir yerinde bir sorun çıktığında veya güncelleme gerektiğinde tüm sistem bundan etkilenmez. Sadece o servis üzerinde değişiklik yapılması yeterli olur.
Mikroservis olarak tasarlanan bir servis ayrıca tek bir projede kullanılmak zorunda değildir. Farklı projeler için tekrar tekrar kullanılabilir.
Bu özellikleri ile mikroservis mimarisi daha esnek, daha çevik ve ölçeklenebilir yapılar kurmamızı sağlar.


## • SOAP vs RESTFUL

SOAP ve RESTFUL iletişim protokollerini anlamak için öncelikle Web Servis tanımını yapmak uygun olacaktır.
### ``• Web Servis``
Web servis yapısı farklı platformlar arasındaki iletişimi belirli bir standarta indirgeyen, bu iletişimi veri formatları ve protokollere göre yapılabilmesini sağlayan yapılardır.

``SOAP`` dağıtık uygulamalarda ve web servislerin haberleşmesinde kullanılan bir iletişim protokolüdür. XML tabanlı olarak çalışır. Bir soap mesajı genel olarak http protokolleri ile ancak kimi zamanda TCP/IP protokolü ğzerinden gönderilir. 
Yapısı Envelope, Header ve Body'den oluşur. Envelope Soap mesajının root etiketidir. Head kısmında mesajın meta-data bilgileri, body kısmında mesajın ana içeriği gönderilir. Mesaj alışverişi methodlar üzerinden yapılır.
Güvenlik için SOAP hazır fonksiyonlar bulundurur ve kompleks yapısıyla beraber güvenlik açısından daha avantajlı denilebilir.


``REST`` içerisinde URL, XML, HTTP, JSON gibi standartları barındırabilen bir mimaridir. SOAP'tan farklı olarak mesaj alışverişini methodlar üzerinden değil http protokolleri üzerinden sağlar. İçerisindeki standart çokluğu sayesinde daha esnek ve kullanışlı bir yapıya sahiptir.
SOAP'in aksine istekleri oluşturmak için W3C standartı WSDL dili kullanmak zorunda değildir. Rest bu istekleri URI'ler üzerinden oluşturabilir. Dil bağımlılığı olmadığı için tasarımı ve kullanımı daha kolaydır.




