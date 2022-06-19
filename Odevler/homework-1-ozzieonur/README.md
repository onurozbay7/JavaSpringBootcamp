# Homework-1
````
1. Java platform bağımsızlığını nasıl sağlar ?
````

   Cevap:
   Java derlendiğinde diğer dillerin aksine 0 ve 1 bit değerlerinden oluşan makiene diline çevrilmez.
   Java'nın kaynak kodları yalnızca Java Sanal Makine'sinin (JVM) anlayabileceği bitkodlarına derlenir.
   Bu bitkodlar işlemci seçmez. Bu sayede Java platform bağımsızlığını sağlar.
<br><br>

````   
2. Java neden çoklu kalıtımı desteklemez? Hangi diller bu duruma neden izin verir?
````
   Cevap: Aslında tam olarak Java çoklu kalıtımı desteklemez diyemeyiz. Java çoklu kalıtımı (tanımına uygun şekilde) classlar üzerinden desteklemez.
   Çünkü çoklu kalıtım ortaya karmaşık ve anlaşılması zor kalıtım ağaçları çıkartabilir ve SOLID'in ilk kuralı olan Single Responsibility prensibini ihlal edebilir.
   Java en güçlü yanlarından biri olan az karmaşıklık ve basit dil ilkelerine uymayan çoklu kalıtım özelliğini aslında ilkelere uyacak şekilde Interface'ler üzerinden sağlar.
   Tabi bu duruma "Kalıtım" demek ne derece doğru orası tartışılır.
   Çoklu kalıtımda en sık karşılaşılan problem olan Diamond Problem'in çalışma zamanı hatasını engelleyecek çeşitli çözümler getirmiş olan C++,Python gibi diller Çoklu Kalıtımı destekler.
   Ancak bu dillerde de bu özelliği çok sık kullanmak tavsiye edilmiyor.
````   
3. Build Tool nedir? Java ekosistemindeki toollar neler?
````
Cevap: Build tool'u, bir yazılım yapısının oluşturulmasını sağlayan, bağımlılıkları yöneten, gerekli kütüphane ve paketlere erişimi kolaylaştıran ve kaynak kodtan yürütülebilir uygulamaların derlenmesini sağlayan bir araç olarak nitelendirebiliriz.
Java'nın ekosisteminde Gradle, Ant ve Maven gibi build toollar yer alır.

````
4. Collection framework içerisindeki yapılar
````
Java Collection framework öğelerimizi topluluk halinde tutan dizi yapısının gelişmiş hali gibi düşünülebilir.
Bu yapılar dizilerde sıralama, dizi içerisinde arama yapma, diziyi ekrana yazdırma gibi uygulamak istediğimiz bir çok methodu hazır halde
bize interface ve interfacelerden oluşan kurgular üzerinden sunuyor. <br> <br>
``1) Set<E> : ``
Küme mantığıyla çalışır ve sıralama garantisi vermez. Aynı elemanların küme içerisinde olmasına izin vermez.
Bu sayede içerisinde benzersiz veriler barındırır. HashSet , LinkedHashSet ve TreeSet bu interface üzerinden kurgulanır  <br> <br>
`● HashSet<E> :` Hafızadaki kayıtları hashlerle sırasız şekilde tutuyor. null değeri de tutulabilir. <br>
Örnekleyelim:
````
HashSet<String> hayvanlar = new HashSet<String>();

hayvanlar.add("Kedi");
hayvanlar.add("Köpek");
hayvanlar.add("Kuş");

// Aynı elementten birtane daha eklemeyi deneyelim
hayvanlar.add("Kedi"); 

//null değer eklemeye çalışalım.
hayvanlar.add(null);


hayvanlar.forEach(hayvan -> System.out.print(hayvan + " "));
````

Kod çıktısı:
``null Kuş Köpek Kedi``



``● LinkedHashSet<E> :`` HashSet yapısıyla çok benzer yapıdadır. Tek farkı eklediğimiz elementler ekleme sırasına göre tutulur. <br>
Örnekleyelim:
````
LinkedHashSet<String> hayvanlar = new LinkedHashSet<String>();

hayvanlar.add("Kedi");
hayvanlar.add("Köpek");
hayvanlar.add("Kuş");

// Aynı elementten birtane daha eklemeyi deneyelim
hayvanlar.add("Kedi"); 

//null değer eklemeye çalışalım.
hayvanlar.add(null);


hayvanlar.forEach(hayvan -> System.out.print(hayvan + " "));
````
Bu sefer ekleğimiz sıraya göre bir çıktı alacağız:
```Kedi Köpek Kuş null ```

``● TreeSet<E> :`` İsminden de anlaşılacağı üzere ağaç yapısı gibi düşünebiliriz. Elementler artan sıralamayla yani asceding order mantığıyla tutuluyor. Null değerini bu yapıya ekleyemiyoruz.  <br>

Bu sefer anlayabilmek adına Integer değerler üzerinden işlem yapalım:
````
TreeSet<Integer> sayilar = new TreeSet<Integer>();

sayilar.add(5);
sayilar.add(15);
sayilar.add(10);

// Aynı elementten birtane daha eklemeyi deneyelim
sayilar.add(5); 

// Null atamaya çalıştığımızda NullPointerException hatası alacağımız yorum satırına alıyorum.
// sayilar.add(null);

sayilar.forEach(hayvan -> System.out.print(hayvan + " "));
````
```Çıktı şu şekilde: 5 10 15  ```

``2) List<E> :`` List yapısı array yapısına çok benzer bir yapıda. Set'in aksine tekrarlı element eklememize izin verir, elementleri sıralı şekilde tutar ve istediğimiz index'e elementleri ekleyebilmemizi sağlar.
ArrayList, LinkedList ve Vector gibi yapılar bu Interface üzerinden sağlanır.

``● ArrayList<E> :`` Collectionslardan en çok kullandığımız yapıdır. List özelliklerinin hepsini barındırır.<br>
Örnekleyelim: 
````
ArrayList<String> icecekler = new ArrayList<String>();

icecekler.add("Kola");
icecekler.add("Fanta");
icecekler.add("MeyveSuyu");
// Aynı elementten birtane daha eklemeyi deneyelim
icecekler.add("Kola");

icecekler.forEach(icecek -> System.out.print(icecek + " "));
````
Çıktımız:
``Kola Fanta MeyveSuyu Kola``

``● LinkedList<E> :`` Sonuçlarını incelediğimizde ArrayList ile aynıdır. Ancak fonksiyonlara göre notasyonları değişmekte. Arama işlemlerinde ArrayList kullanımı daha avantajlıdır. Ekeleme Çıkarma işlemlerimiz çok ise LinkedList kullanmamız daha doğru olur.  <br>

``● Vector<E> :`` Çok sık kullanılan bir apı değildir. Senkronize bir yapıdadır ve varsayılan kapasitesi 10'dur. Daha fazla eleman eklemek istediğimizde otomatik olarak kapasite 20ye yükselir ancak kapasiteyi ve artış değerini kullanıcı belirleyebilir. <br>

``3) Queue<E> :`` Fifo prensibiyle çalışır, yani ilk giren element ilk çıkar. Kuyruk mantığıyla çalışır. Bellekteki yerinin önemi yoktur. Çıktısı Fifo'ya uygun şekilde sıralı gelir. <br>

``4) Map<K,V> : `` Kısaca eşleme tabloları diyebiliriz. Key, Value olmak üzere 2 değerli bir liste tutar. Her Key değerine bir Value değeri eşlenir. Tuttuğu adresi kendi belirler. HashMap, TreeMap, HashTable gibi yapılar bu Interface üzerinden tanımlanır. <br>

``● HashMap<K, V> :`` Null key değeri ve Null value değeri kabul eder. Sıralama garantisi vermez. <br>
Örnekleyelim: 
````
HashMap<Integer, String> musteriler = new HashMap<Integer, String>();
        musteriler.put(1, "Onur");
        musteriler.put(2, "Ufuk");
        musteriler.put(3, "Ümit");
        

        musteriler.forEach((musteriId, musteriName) -> System.out.print(musteriId + "-" +musteriName + " | "));
````
Çıktıda da göreceğimiz gibi her müşteri id'sine karşılık müşteri ismini bize getiriyor: <br>
``1-Onur | 2-Ufuk | 3-Ümit | 4-Hüseyin | ``

``● TreeMap<K, V> :``Yine isimden de anlaşılacağı gibi ağaç yapısına benzer. HashMap yapısından tek farkı, elementleri artan sıralama (ascending) ile tutmasıdır. <br>
Örnekleyelim: 
````
TreeMap<Integer, String> musteriler = new TreeMap<>();
        musteriler.put(1, "Onur");
        musteriler.put(7, "Ufuk");
        musteriler.put(6, "Hüseyin");
        musteriler.put(3, "Ümit");


        musteriler.forEach((musteriId, musteriName) -> System.out.print(musteriId + "-" +musteriName + " | "));
````
Çıktı: `` 1-Onur | 3-Ümit | 6-Hüseyin | 7-Ufuk | ``


``● HashTable<K, V> :`` HashMap ile benzer bir yapıya sahip ancak farklar mevcuttur. HashTable senkronize yapıdadır, dolayısıyla performansı düşüktür. HashMap null değer alırken HashTable alamaz. <br>

``Maven komutları ve çıktıları:``

``mvn validate : `` Projenin target dosyasını siler ve daha sonra hatalı kısımları tarayarak Projenin doğruluğunu kontrol eder.

Çıktı :
````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.128 s
[INFO] Finished at: 2022-06-15T22:12:45+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````
<br>

``mvn compile : `` Projeyi clean ve validate eder ardından Kaynak kodu derler.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.170 s
[INFO] Finished at: 2022-06-15T22:15:38+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````
<br>

``mvn test : `` Derlenmiş koda uygun bir unit test ile test eder.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ homework-1-ozzieonur ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.043 s - in com.example.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.853 s
[INFO] Finished at: 2022-06-15T22:16:26+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````

<br>

``mvn package :`` Projeyi testlerini yapar ve eğer hata yoksa projeyi paketler. jar dosyasını oluşturur.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ homework-1-ozzieonur ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.034 s - in com.example.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ homework-1-ozzieonur ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.290 s
[INFO] Finished at: 2022-06-15T22:18:53+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````

<br>

``mvn verify :`` Entegrasyon teslerinin sonuçlarını kontrol ederek kalite kriterine ulaşıldığından emin olur.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ homework-1-ozzieonur ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.036 s - in com.example.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ homework-1-ozzieonur ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.115 s
[INFO] Finished at: 2022-06-15T22:20:04+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````

<br>

``mvn install :`` Diğer projelerde dependency olarak kullanmak için paketleri local depoya yükler.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ homework-1-ozzieonur ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ homework-1-ozzieonur ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.045 s - in com.example.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ homework-1-ozzieonur ---
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ homework-1-ozzieonur ---
[INFO] Installing C:\Users\ONUR\homework-1-ozzieonur\target\homework-1-ozzieonur-1.0-SNAPSHOT.jar to C:\Users\ONUR\.m2\repository\com\example\homework-1-ozzieonur\1.0-SNAPSHOT\homework-1-ozzieonur-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\ONUR\homework-1-ozzieonur\pom.xml to C:\Users\ONUR\.m2\repository\com\example\homework-1-ozzieonur\1.0-SNAPSHOT\homework-1-ozzieonur-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.143 s
[INFO] Finished at: 2022-06-15T22:20:49+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````

<br>

``mvn clean  :`` Projenin derlenmesi sırasında oluşan target klasörünün(build işlemi sonucunda üretilen) silinmesini sağlar.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ homework-1-ozzieonur ---
[INFO] Deleting C:\Users\ONUR\homework-1-ozzieonur\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.530 s
[INFO] Finished at: 2022-06-15T22:21:23+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````

<br>

``mvn site  :`` Projenin site dökümantasyonunu oluşturur.

Çıktı :

````
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< com.example:homework-1-ozzieonur >------------------
[INFO] Building homework-1-ozzieonur 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-site-plugin:3.7.1:site (default-site) @ homework-1-ozzieonur ---
[INFO] configuring report plugin org.apache.maven.plugins:maven-project-info-reports-plugin:3.0.0
[INFO] 15 reports detected for maven-project-info-reports-plugin:3.0.0: ci-management, dependencies, dependency-info, dependency-management, distribution-management, index, issue-management, licenses, mailing-lists, modules, plugin-management, plugins, scm, summary, team
[INFO] Rendering site with default locale English (en)
[INFO] Relativizing decoration links with respect to localized project URL: http://www.example.com
[INFO] Rendering content with org.apache.maven.skins:maven-default-skin:jar:1.2 skin.
[INFO] Generating "Dependencies" report  --- maven-project-info-reports-plugin:3.0.0:dependencies
[INFO] Generating "Dependency Information" report --- maven-project-info-reports-plugin:3.0.0:dependency-info
[INFO] Generating "About" report         --- maven-project-info-reports-plugin:3.0.0:index
[INFO] Generating "Plugin Management" report --- maven-project-info-reports-plugin:3.0.0:plugin-management
[INFO] Generating "Plugins" report       --- maven-project-info-reports-plugin:3.0.0:plugins
[INFO] Generating "Summary" report       --- maven-project-info-reports-plugin:3.0.0:summary
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.569 s
[INFO] Finished at: 2022-06-15T22:27:16+03:00
[INFO] ------------------------------------------------------------------------

Process finished with exit code 0
````

<br>

``mvn deploy  :`` Projeyi uygulama sunucusuna yükler.

Projemizi bizden bir sunucu URL'i bekler. Ancak biz şuanda bir sunucu kullanmadığımız için kod çıktısı hata verecektir:

````
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ homework-1-ozzieonur ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\ONUR\homework-1-ozzieonur\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ homework-1-ozzieonur ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\ONUR\homework-1-ozzieonur\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ homework-1-ozzieonur ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.051 s - in com.example.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ homework-1-ozzieonur ---
[INFO] Building jar: C:\Users\ONUR\homework-1-ozzieonur\target\homework-1-ozzieonur-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ homework-1-ozzieonur ---
[INFO] Installing C:\Users\ONUR\homework-1-ozzieonur\target\homework-1-ozzieonur-1.0-SNAPSHOT.jar to C:\Users\ONUR\.m2\repository\com\example\homework-1-ozzieonur\1.0-SNAPSHOT\homework-1-ozzieonur-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\ONUR\homework-1-ozzieonur\pom.xml to C:\Users\ONUR\.m2\repository\com\example\homework-1-ozzieonur\1.0-SNAPSHOT\homework-1-ozzieonur-1.0-SNAPSHOT.pom
[INFO] 
[INFO] --- maven-deploy-plugin:2.8.2:deploy (default-deploy) @ homework-1-ozzieonur ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.532 s
[INFO] Finished at: 2022-06-15T22:32:00+03:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.8.2:deploy (default-deploy) on project homework-1-ozzieonur: Deployment failed: repository element was not specified in the POM inside distributionManagement element or in -DaltDeploymentRepository=id::layout::url parameter -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

Process finished with exit code 1


````
