Docker compose dosyasi icinde 3 adet Container ayaga kalkacak.
    1-PHPMyAdmin : mySQL veritabani icin grafik arayuzu
    2-MySQL : veritabani
    3-rabbitmq : Mesaj kuyruklama servisi

bunlari yapabilmek icin bash scripte gecin, 
    1- klasoru decompress yapip dosyalarin oldugu dizine bash ile gelin
    2- bash script console ekraninda source killrestart yazin hepsini kendi kuracak.


Container'lar ayaga kalktiktan sonra asagidaki bilgilerle erisebilirsiniz.
    1. PhpMyAdmin , http://localhost:8090
    2. mySQL ,port:8091 server: ib_mysql , username: root , password: 123456
    2.1 default-tables.sql dosyasi mysql konteynirinda calistirilmis halde ayaga kalkacak
    3. rabbitmq , http://localhost:8092

default-tables.sql dosyasinin duzenlenmesi icin katki saglarsaniz gelistirme ortamimiz daha faydali olur.

Umit Tas