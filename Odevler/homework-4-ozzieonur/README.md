#### Mysql veya PostgreSQL ile controller katmanlarının çalışabilmesi için gerekli repository katmanları tüm modeller için oluşturuldu.

#### Isbasi-email-service kuyruktan veriyi okuduktan sonra gerekli model class’ı oluşturulup ``MongoDB`` veritabanına kaydedildi.

#### JDBC, JdbcTemplate ve Hibernate ile gerekli repository katmanları oluşturuldu. Polimorfizm’den yararlanarak Account tablosuna üç yöntem ile CRUD işlemleri yazıldı.


``JDBC`` kullanmanın yazılımcı açısından sürekli connection açılıp kapatılması, her bir işlem için statement oluşturulması gibi kod kalabalığı yaratan dezavantajları mevcut.

``JdbcTemplate`` bu durumu bizim için ortadan kaldırıyor. Yazılımcı sadece gerekli Sql sorgularını yazarak bunu template'e gönderiyor. Geri kalan işlemleri template arka planda bizim yerimize hallediyor.

``Hibernate`` ise Sql sorgu yazımı dahil tüm gerekli kod betiklerini, aldığı metod isimlerine göre arka planda hallediyor. Yazılımcıya sadece gerekli metod ismini tanıtması görevini üstlendiriyor. 

#### NoSQL yapılar ve kullanım amaçları (MongoDB, CouchBase,Redis) Medium makalesine [buradan](https://medium.com/@ozzieonur/nosql-yap%C4%B1lar-ve-kullan%C4%B1m-ama%C3%A7lar%C4%B1-mongodb-couchbase-redis-30ea46f9d30d) ulaşabilirsiniz.
