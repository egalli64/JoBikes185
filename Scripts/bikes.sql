CREATE TABLE CITIES(
	CITY_ID NUMBER (3),
	CITY_NAME VARCHAR2(20) NOT NULL,
	
	CONSTRAINT "CITY_ID_PK" PRIMARY KEY ("CITY_ID")
)

SELECT * FROM CITIES

DROP TABLE CITIES;

INSERT INTO CITIES VALUES (1, 'Milano');

CREATE TABLE STATIONS(
	STATION_ID NUMBER (3)
	CONSTRAINT STATION_ID_PK PRIMARY KEY,
	STATION_NAME VARCHAR2(20) NOT NULL,
	CITY_ID NUMBER (3),
	CONSTRAINT CITY_ID_fk FOREIGN KEY (city_id)
 		REFERENCES cities (city_id)
);

SELECT * FROM STATIONS;

CREATE TABLE preferences (
	NAME VARCHAR2(25),
	SQL NUMBER(1),
	Java NUMBER(1),
	HTML NUMBER(1),

	CONSTRAINT NAME_PK PRIMARY KEY (NAME)
)

DROP TABLE preferences;

SELECT * FROM preferences

INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Giovanna', 1, 3, 2);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Alessio', 1, 2, 3);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Karolina', 1, 3, 2);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Ariam',  3, 1, 2);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Federico', 2, 3, 1);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Arturo', 3, 2, 1);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Virginia', 2, 1, 3);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Selena', 2, 3, 1);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Giuseppe', 3, 1, 2);
INSERT INTO preferences (NAME, SQL, Java, HTML) VALUES ('Susanna', 2, 1, 3);

delete from preferences
where name = '';
