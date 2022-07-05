CREATE TABLE IF NOT EXISTS customerType(
    id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(200) NOT NULL,

    PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS customer (
    id int(11)  NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    surname varchar(50)NOT NULL,
    email varchar(50) NOT NULL,
    phone varchar(20) NOT NULL,
    type int(11) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (type) REFERENCES customerType(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS companyType(
    id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(200) NOT NULL,

    PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS companySector(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    description varchar(200) NOT NULL,
    
    PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS company(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    type int(11) NOT NULL,
    description varchar(200) NULL,
    sector int(11) NOT NULL,

    PRIMARY KEY(id,type,sector),
    FOREIGN KEY (type) REFERENCES companyType(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS uom(
    /* unit of measure */
    id int(11) NOT NULL AUTO_INCREMENT,
    shortName varchar(5) NOT NULL,
    description varchar(50) NOT NULL,

    PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS item(
    id int(11) NOT NULL AUTO_INCREMENT,
    itemcode varchar(200) NOT NULL,
    description varchar(200) NOT NULL,
    itemgroup int NOT NULL,
    uom int NOT NULL,

    PRIMARY KEY(id,itemcode),
    FOREIGN KEY (uom) REFERENCES uom(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO customerType
    (description)
VALUES
    ('Customer'),
    ('Provider'),
    ('Customer and Provider');

INSERT INTO companyType
    (description) 
VALUES
    ('Private'),
    ('Public'),
    ('General');

INSERT INTO companySector(description)
VALUES
    ('Software & Technology'),
    ('Transport'),
    ('Retail'),
    ('Food & Beverage'),
    ('Tourism & Hospitality'),
    ('Consumer Electronics'),
    ('Cleaning items'),
    ('Building tools'),
    ('Medical');
    

INSERT INTO uom
    (shortName,description) 
VALUES
    ('mtr','meter'),
    ('qty','quantity'),
    ('box','box'),
    ('ltr','litre'),
    ('ton','tonne'),
    ('kg','kilogram'),
    ('set','set'),
    ('dia','inch diameter'),
    ('mm','Milimeter thickness');

INSERT INTO company(name,sector,type)
VALUES 
    ('Logo Yazilim',1,3),
    ('patika.dev',1,3),
    ('Sok',3,3),
    ('A101',3,3),
    ('Migros',3,3),
    ('Bim',3,3),
    ('CarrefourSA',3,3),
    ('Makro center',3,3),
    ('Mediamarkt',5,3),
    ('TeknoSA',5,3),
    ('Vatan Bilgisayar',5,3),
    ('Baran yapi malzemeleri',8,3),
    ('Ekrem Coskun doner',4,3),
    ('Gunaydin Iskender',4,3),
    ('Nurgul Eczanesi',9,3),
    ('Lara Eczanesi',9,3),
    ('Turk Hava yollari',2,3),
    ('Pegasus Hava yollari',2,3),
    ('Kamil Koc Seyahat',2,3),
    ('Buzlu Turizm Seyahat',2,3),
    ('Mardan Palace',5,3),
    ('Sheraton Barut Hotel',5,3),
    ('Arda temizlik malzemeleri',7,3);