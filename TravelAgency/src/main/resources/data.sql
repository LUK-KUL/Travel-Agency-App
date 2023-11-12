INSERT INTO continent_model (continent)
VALUES ('AFRICA');
INSERT INTO continent_model (continent)
VALUES ('ANTARCTICA');
INSERT INTO continent_model (continent)
VALUES ('ASIA');
INSERT INTO continent_model (continent)
VALUES ('AUSTRALIA');
INSERT INTO continent_model (continent)
VALUES ('EUROPE');
INSERT INTO continent_model (continent)
VALUES ('NORTH_AMERICA');
INSERT INTO continent_model (continent)
VALUES ('SOUTH_AMERICA');

INSERT INTO country_model (country, continent_id)
VALUES ('EGYPT', 1);
INSERT INTO country_model (country, continent_id)
VALUES ('CHINA', 3);
INSERT INTO country_model (country, continent_id)
VALUES ('AUSTRALIA', 4);
INSERT INTO country_model (country, continent_id)
VALUES ('SPAIN', 5);
INSERT INTO country_model (country, continent_id)
VALUES ('USA', 6);
INSERT INTO country_model (country, continent_id)
VALUES ('ARGENTINA', 7);

INSERT INTO city_model (city, country_id)
VALUES ('HURGHADA', 1);
INSERT INTO city_model (city, country_id)
VALUES ('SYDNEY', 3);
INSERT INTO city_model (city, country_id)
VALUES ('BEIJING', 2);
INSERT INTO city_model (city, country_id)
VALUES ('NEW_YORK', 5);
INSERT INTO city_model (city, country_id)
VALUES ('MADRID', 4);
INSERT INTO city_model (city, country_id)
VALUES ('BUENOS_AIRES', 6);
INSERT INTO city_model (city, country_id)
VALUES ('KAIR', 1);
INSERT INTO city_model (city, country_id)
VALUES ('BARCELONA', 4);

INSERT INTO airport_model (airport, city_id)
VALUES ('HURGHADA_AP', 1);
INSERT INTO airport_model (airport, city_id)
VALUES ('MADRID_BAHARAS', 5);
INSERT INTO airport_model (airport, city_id)
VALUES ('BEIJING_NANYUAN', 3);
INSERT INTO airport_model (airport, city_id)
VALUES ('SYDNEY_AP', 2);
INSERT INTO airport_model (airport, city_id)
VALUES ('BUENOS_AIRES_EZEIZA', 6);
INSERT INTO airport_model (airport, city_id)
VALUES ('NEW_YORK_JFK', 4);

