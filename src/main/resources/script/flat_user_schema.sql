CREATE TABLE flat_users
(
    id            INT PRIMARY KEY,
    name          VARCHAR(30) NOT NULL,
    date_of_birth TIMESTAMP   NOT NULL,
    city_name     VARCHAR(30) NOT NULL,
    country_name  VARCHAR(30) NOT NULL
);
