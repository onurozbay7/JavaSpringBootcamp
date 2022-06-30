>• Singleton Pattern'i CustomerService yapısında kullanıldı. AbstractFactory pattern'i implemente eden kod AbstractFactory paketinin içinde oluşturuldu.


## Java dünyasındaki frameworkler ve çözdükleri problemler

#### ``• Spring MVC: ``
Spring MVC aslında Spring Framework'ün sağladığı bir modüldür. Model View Controller katmanlı yapısı sayesinde daha kolay bir şekilde Web Projelerimizi geliştirmeye yarar.
``Model`` katmanında projemizdeki ana nesnelerimizi ve verilerimizi tutarız. ``Controller`` katmanında bu nesneler ve veriler üzerinden işlemler yapıp, ``View`` katmanında son kullanıcıya bunu gösteririz.

#### ``• JSP: ``
Java Server Pages projemizin önyüz kısmında HTML kodları içerisine Java komutlarını yazmamıza olanak tanıyan bir Java EE kütüphanesidir.
JSP statik bir web sayfasını backend tarafı ile iletişime geçirerek dinamik hale getirmemizi sağlar. Java Servlet üzerine inşa edilmiştir.

#### ```• Apache Struts: ```
Aslında Spring MVC modülünün sağladığı kullanıma benzer bir yapısı vardır. Java Servlet API yapısını kullanır ve MVC mimarisini kullanarak web projeleri geliştirmemize olanak sağlar.
AJAX, REST ve SOAP'ı destekler. Structs Spring MVC'den daha eski bir frameworktür ancak günümüzde her ikisi de kullanılıyor.
Spring gevşek bağımlı modüllere sahiptir, Structs daha bağımlı modüllerle çalışır. Bu konuda Spring avantajlıdır.

#### ``• Vaadin: ``
Vaadin, Java dilini kullanarak performanslı ve hızlı web sayfaları(Önyüz) geliştirmemize yarayan bir frameworktür.Bir çok javascript kütüphanesini entegre edebiliriz. Bu sayede de Javascript ve HTML ile ilgili bir çok detaydan kurtulmamızı sağlar. Ancak istersek yine de JS ve HTML kullanabiliriz.
## • Katmanlı mimari nedir?

Katmanlı mimari projelerimizde belli bir standart yakalamak ve o standarta göre projeyi geliştirmemizi sağlayan yapıdır.<br>
Katmanlı mimari ile geliştirdiğimiz projelerin kod okunabilirliği daha yüksek olur ve hata yönetimi daha kolay sağlanır.
Projedeki verilerimize nasıl erişeceğimiz, o veriler üzerinde ne gibi işlemler yapacağımız ve son kullanıcıya nasıl göstereceğimiz gibi işlemleri Katmanlı Mimari ile çok daha rahat yönetebiliriz.
<br><br>

Katmanlı mimari temelde 3 katmandan oluşur ancak projelerin durumuna göre ara katmanlar da oluşturulabilir.
Bu yüzden kimi yerlerde katmanlı mimari yapısının ismini üç katmanlı mimari olarak da görebiliriz.
<br><br>
Temel 3 katmanı "Data Access Layer", "Business Layer" ve "Presentation Layer" olarak söyleyebiliriz.

 ``Data Access Layer`` katmanında veriye erişim işlemleri gerçekleştirilir. Veri tabanı bağlantısı, ekleme, silme, güncelleme ve veri çekme gibi işlemler burada bulunur.

``Business Layer`` katmanında iş yükleri belirlenir. Yani Data Access Layer katmanı ile aldığımız verileri burada projenin isterlerine göre işleriz veya kullanıcıdan gelen veriler öncelikle Business katmanına gider, oradan işlenerek Data Access katmanına aktarılır. Bu katmanda ayrıca bu verilere kimlerin erişebileceğini belirleyebiliriz.

``Presentation Layer`` katmanında ise kullanıcı ile etkileşime girilen katmandır. Kullanıcıdan istediğimiz verileri veya göstereceğimiz verileri burada belirtiriz. Bu katman bir web sitesi, desktop uygulaması, mobil uygulama gibi çeşitli yapılarda olabilir.

## • Garbage collector nedir, nasıl çalışır?

Projelerdeki verilerimiz arttıkça ve projemiz büyüdükçe projenin çalıştığı makinadaki bellek yükü artar. Haliyle projemiz yavaş ve verimsiz çalışır.
Projelerimizi optimize etmek için bellek yönetimi yapmamız gerekir. Bellek yönetimi genel haliyle memory allocation ve deallocation işlemleridir.<br>
C++ gibi dillerde bu yönetimi yazılımcının yapması gerekir. Javada bunun aksine JVM içindeki Garbage Collector (Çöp toplayıcısı) sizin yerinize otomatik olarak gerçekleştirir. Bu yapı Javanın en güçlü özelliklerinden biridir.
<br>
``Garbage Collector`` heap belleğe bakıp, kullanılan objelerin tespit edilmesi ve referans edilmeyenlerin silinmesi üzerine kuruludur.
Kullanılmayan/referans edilmeyen nesnelerin kapladığı alan bellekte boşa çıkarılır ve bellekte boş yer açılmış olur.


## • Spring frameworkünün kullandığı design patternlar nelerdir?
#### Creational Patterns:
[Factory Method](https://github.com/LogoYazilimJavaSpringBootcamp/homework-2-ozzieonur#1-factory-method) <br>
[Singleton](https://github.com/LogoYazilimJavaSpringBootcamp/homework-2-ozzieonur#4-singleton-) <br>
[Prototype](https://github.com/LogoYazilimJavaSpringBootcamp/homework-2-ozzieonur#5-prototype-)<br>

#### Structural:
#### ``• Proxy: ``
Proxy pattern'i, sıkça kullanılan nesnelerin cache yapısına alınarak her defasında yeniden türetilmesini engellemek amacı ile kullanılmaktadır.
Spring Framework’ün en çok faydalandığı pattern denilebilir. Scoped bean oluşturmada ve Spring AOP kabiliyetinin sunulmasında bu pattern kullanılmaktadır.

#### Behavioral

#### ``• Template Method: ``
Template Method pattern'i, üst sınıflarda algoritmaların bir iskeletini oluşturan, alt sınıfların iskeleti değiştirmeden bu algoritmaların belirli adımlarını değiştirmesine izin veren bir yapıdadır.
Spring’in veri erişim altyapısı bu pattern üzerine kuruldur. JdbcTemplate, HibernateTemplate, JpaTemplate, RestTemplate gibi örneklemeleri mevcuttur.

#### ``• Observer: ``
Observer pattern'i, bir nesne kümesi arasındaki one-to-many ilişkiyi tanımlar. Bir nesnenin durumu değiştiğinde, bütün bağımlılarına bildirildiği bir abonelik mekanizması oluşturmayı amaçlar.
ApplicationContext’in event yönetimi bir abonelik örneğidir.

#### ``• Mediator: ``
Mediator pattern'i, nesneler arasındaki doğrudan iletişimi sınırlar ve sadece mediator nesnesi üzerinden haberleşmeye zorlar. Bu durum nesneler arasındaki bağımlılıkları azaltmaya yarar.
Birbirleri ile haberleşmek isteyen bean’lar Mediator Pattern ile loosely coupled (gevşek bağlı) halde kalabilmektedirler. Sadece ApplicationContext’i(Bu durumdaki mediator) tanırlar.

## • Creational Patternler nelerdir?

### ``1) Factory Method:``
Factory Method pattern'i, nesne oluşumunu soyutlayarak merkezi bir yerden kontrol etmemizi sağlar.
Class'lar, Interface'ler üzerinden türetilir. Böylece, Client ile nesne birbirinden ayrılarak gevşek bağlılık sağlanır. Oluşturulacak nesnelerden birbirine benzer olanlar aynı Interface üzerinden türetilerek gruplandırılır.

### ``2) Abstract Factory: ``
Abstract Factory pattern'i, Factory Method ile benzer özelliklere sahiptir. Factory Method ile farkı tek bir Interface üzerinden değil, her ürün ailesi için farklı bir Interface'ten nesne oluşturmasıdır.
Bu metod birden fazla ürün ailesi ile çalışmak durumunda kaldığımızda, kullanacağınız ürün ailesi ile Client tarafını soyutlamak için kullanılır.

### ``3) Builder: ``
Ana nesnemizi oluşturmayı sağlayan nesneler birden fazla sayıda olabilirler ama tek bir üst sınıftan türerler.
Builder pattern'i bu nesnelerin oluşturulmasının sorumluluğunu kendine alır. Oluşturulması istenilen nesneyi adım adım oluşturur ve en son halini bize verir.

### ``4) Singleton: ``
Singleton pattern'i, bir sınıfın tek bir örneğini oluşturmak için kullanılır. Amaç, oluşturulan nesneye global erişim noktası sağlamaktır. Tüm isteklere oluşturulan tek örnek üzerinden cevap verilir. Sistem çalıştığı sürece ikici bir örnek oluşturulamaz.

### ``5) Prototype: ``
Prototype pattern'i kendisi üzerinden yaratılacak nesneler için prototip görevi üstlenen bir yapı sunmaktadır. Diğer bir deyişle, sınıflardan nesne yaratırken yeni nesnelerin baştan yaratılmayıp, mevcutlarını örnek kabul ederek yaratılmasını sağlar. Bu pattern sayesinde nesneler, kaynaklar gereksiz yere meşgul edilmeden yaratılırlar.

