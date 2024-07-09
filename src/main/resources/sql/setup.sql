DROP DATABASE IF EXISTS car_dealership;

CREATE DATABASE car_dealership;

CREATE TABLE dealerships
(
    dealership_id SERIAL PRIMARY KEY,
    name          VARCHAR(50),
    address       VARCHAR(50),
    phone         VARCHAR(12)
);

CREATE TABLE vehicles
(
    vehicle_id SERIAL PRIMARY KEY,
    vin        VARCHAR(17),
    year       int,
    make       VARCHAR(50),
    model      VARCHAR(50),
    color      VARCHAR(50),
    mileage    INT,
    price      DECIMAL(10, 2),
    sold       BOOLEAN
);

CREATE TABLE inventory
(
    dealership_id INT NOT NULL,
    vehicle_id    INT NOT NULL,
    FOREIGN KEY (dealership_id) REFERENCES dealerships (dealership_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id)
);

CREATE TABLE customers
(
    customer_id SERIAL PRIMARY KEY,
    first_name  VARCHAR(50),
    last_name   VARCHAR(50),
    address     VARCHAR(50),
    email       VARCHAR(50),
    phone       VARCHAR(50)
);

CREATE TABLE sales_contracts
(
    sale_id       SERIAL PRIMARY KEY,
    vehicle_id    INT NOT NULL,
    customer_id   INT NOT NULL,
    sale_price    INT,
    sale_date     DATE,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


