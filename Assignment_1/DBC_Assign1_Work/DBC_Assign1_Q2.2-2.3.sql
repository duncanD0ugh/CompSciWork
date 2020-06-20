drop table customers;
drop table orders;

CREATE TABLE orders(
   orderNo    INTEGER   
  ,productNo  VARCHAR(10) 
  ,quantity   INTEGER  
  ,unitPrice  NUMERIC(10,2) 
  ,salesRep   VARCHAR(15) 
  ,customerNo INTEGER
  ,primary key (orderNo)
  ,foreign key (customerNo) references customers
);

CREATE TABLE customers(
   customerNo   INTEGER 
  ,customerName VARCHAR(30) 
  ,phone        VARCHAR(20) 
  ,address      VARCHAR(30) 
  ,city         VARCHAR(15) 
  ,state        VARCHAR(10)
  ,postCode     VARCHAR(10) 
  ,country      VARCHAR(10) 
  ,primary key (customerNo)
);

INSERT INTO customers VALUES (103,'Atelier graphique','40.32.2555','54 rue Royale','Nantes',NULL,'44000','France');
INSERT INTO customers VALUES (103,'Atelier graphique','40.32.2555','54 rue Royale','Nantes',NULL,'44000','France');
INSERT INTO customers VALUES (112,'Signal Gift Stores','7025551838','8489 Strong St.','Las Vegas','NV','83030','USA');
INSERT INTO customers VALUES (119,'La Rochelle Gifts','40.67.8555','67 rue des Cinquante Otage','Nantes',NULL,'44000','France');
INSERT INTO customers VALUES (121,'Baane Mini Imports','07-98 9555','Erling Skakkes gate 78','Stavern',NULL,'410','Norway');
INSERT INTO customers VALUES (114,'Australian Collectors','03 9520 4555','636 St Kilda Road Level 3','Melbourne','Victoria','3004','Australia');
INSERT INTO customers VALUES (128,'Blauer See Auto Co.','(49) 69 66 90 2555','Lyonerstr. 34','Frankfurt',NULL,'60528','Germany');
INSERT INTO customers VALUES (141,'Euro+ Shopping Channel','(91) 555 94 44','C/ Moralzarzal 86','Madrid',NULL,'28034','Spain');
INSERT INTO customers VALUES (129,'Mini Wheels Co.','6505555787','5557 North Pendale Street','San Francisco','CA','94217','USA');
INSERT INTO customers VALUES (119,'La Rochelle Gifts','40.67.8555','67 rue des Cinquante Otage','Nantes',NULL,'44000','France');
INSERT INTO customers VALUES (125,'Havel & Zbyszek Co','(26) 642-7555','ul. Filtrowa 68','Warsawa',NULL,'01-012','Poland');
INSERT INTO customers VALUES (119,'La Rochelle Gifts','40.67.8555','67 rue des Cinquante Otage','Nantes',NULL,'44000','France');
INSERT INTO customers VALUES (124,'Mini Gifts Distributors Ltd','4155551450','5677 Strong St.','San Rafael','CA','97562','USA');
INSERT INTO customers VALUES (119,'La Rochelle Gifts','40.67.8555','67 rue des Cinquante Otage','Nantes',NULL,'44000','France');
INSERT INTO customers VALUES (231,'Land of Toys Inc.','2125557818','897 Long Airport Avenue','NYC','NY','10022','USA');
INSERT INTO customers VALUES (129,'Mini Wheels Co.','6505555787','5557 North Pendale Street','San Francisco','CA','94217','USA');
INSERT INTO customers VALUES (124,'Mini Gifts Distributors Ltd','4155551450','5677 Strong St.','San Rafael','CA','97562','USA');
INSERT INTO customers VALUES (129,'Mini Wheels Co.','6505555787','5557 North Pendale Street','San Francisco','CA','94217','USA');

INSERT INTO orders VALUES (10100,'S18_1749',30,136,'Adam Jones',103);
INSERT INTO orders VALUES (10103,'S10_4325',30,119.67,'Adam Jones',103);
INSERT INTO orders VALUES (10167,'S18_1749',50,136,'Will Smith',112);
INSERT INTO orders VALUES (10564,'S24_1345',49,35.9,'Mark Fox',119);
INSERT INTO orders VALUES (10732,'S11_9087',25,108.04,'Mark Lee',121);
INSERT INTO orders VALUES (10897,'S18_4409',22,34.5,'Cameron Box',114);
INSERT INTO orders VALUES (10903,'S21_4532',46,44.53,'Bill Green',128);
INSERT INTO orders VALUES (11045,'S17_2091',26,213.56,'Sam Will',141);
INSERT INTO orders VALUES (11412,'S18_3409',39,90.23,'Will Smith',129);
INSERT INTO orders VALUES (11453,'S24_1345',49,35.9,'Amanda Kay',119);
INSERT INTO orders VALUES (11509,'S20_9083',45,32.87,'Judith Max',125);
INSERT INTO orders VALUES (11897,'S18_5690',49,55.04,'Max Williams',119);
INSERT INTO orders VALUES (12098,'S12_2795',26,167.06,'Sam Will',124);
INSERT INTO orders VALUES (12345,'S19_2313',49,43.21,'Bob Karl',119);
INSERT INTO orders VALUES (12954,'S20_9083',41,32.87,'Karl Marx',231);
INSERT INTO orders VALUES (13209,'S21_5092',39,95.12,'Max Williams',129);
INSERT INTO orders VALUES (13456,'S12_8904',26,176.23,'Sam Will',124);
INSERT INTO orders VALUES (14321,'S22_4501',39,94.23,'Will Smith',129);
