CREATE TABLE person (id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id));

INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(10001,'Sourav','Kolkata',current_date());
INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(10002,'Yash','Siliguri',current_date());
INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(10003,'Jash','New Town',current_date());
