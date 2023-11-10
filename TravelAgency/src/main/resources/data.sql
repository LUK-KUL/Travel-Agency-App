INSERT INTO continent_model
VALUES (1,'AFRICA');
INSERT INTO continent_model
VALUES (2, 'ANTARCTICA');
INSERT INTO continent_model
VALUES (3, 'ASIA');
INSERT INTO continent_model
VALUES (4, 'AUSTRALIA');
INSERT INTO continent_model
VALUES (5, 'EUROPE');
INSERT INTO continent_model
VALUES (6, 'NORTH_AMERICA');
INSERT INTO continent_model
VALUES (7, 'SOUTH_AMERICA');

INSERT INTO country_model (id, country, continent_id)
VALUES (1,'EGYPT', 1);
INSERT INTO country_model (id, country, continent_id)
VALUES (2,'CHINA', 3);
INSERT INTO country_model (id, country, continent_id)
VALUES (3,'AUSTRALIA', 4);
INSERT INTO country_model (id, country, continent_id)
VALUES (4,'SPAIN', 5);
INSERT INTO country_model (id, country, continent_id)
VALUES (5,'USA', 6);
INSERT INTO country_model (id, country, continent_id)
VALUES (6,'ARGENTINA', 7);

INSERT INTO city_model (id, city, country_id)
VALUES (1,'HURGHADA', 1);
INSERT INTO city_model (id, city, country_id)
VALUES (2,'SYDNEY', 3);
INSERT INTO city_model (id, city, country_id)
VALUES (3,'BEIJING',2);
INSERT INTO city_model (id, city, country_id)
VALUES (4,'NEW_YORK', 5);
INSERT INTO city_model (id, city, country_id)
VALUES (5,'MADRID', 4);
INSERT INTO city_model (id, city, country_id)
VALUES (6,'BUENOS_AIRES', 6)

/*INSERT INTO airport_model (id, airport, city_id)
VALUES (1,'HURGHADA', 1);
INSERT INTO airport_model (id, airport, city_id)
VALUES (2,'MADRID_BAHARAS', 5);
INSERT INTO airport_model (id, airport, city_id)
VALUES (3,'BEIJING_NANYUAN', 3);
INSERT INTO airport_model (id, airport, city_id)
VALUES (4,'SYDNEY', 2);
INSERT INTO airport_model (id, airport, city_id)
VALUES (5,'BUENOS_AIRES_EZEIZA', 6);
INSERT INTO airport_model (id, airport, city_id)
VALUES (6,'NEW_YORK_JFK', 4);
*/
