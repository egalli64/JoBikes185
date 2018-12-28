-- my tables
SELECT DISTINCT OBJECT_NAME
FROM USER_OBJECTS
WHERE OBJECT_TYPE = 'TABLE';

SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID, REGION_NAME
FROM COUNTRIES NATURAL JOIN REGIONS;

SELECT *
FROM REGIONS;

INSERT INTO REGIONS VALUES(5, 'Oceania');

DELETE FROM REGIONS
WHERE REGION_ID = 5;