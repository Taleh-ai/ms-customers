-- liquibase/changelog/V1__create_user_entity_table.sql

CREATE SEQUENCE user_entity_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE user_entity (
                             id BIGINT DEFAULT nextval('user_entity_seq') PRIMARY KEY,
                             full_name VARCHAR(255) NOT NULL,
                             gender INTEGER NOT NULL,
                             date_of_birth DATE,
                             username VARCHAR(255),
                             email VARCHAR(255),
                             password VARCHAR(255),
                             phone_number VARCHAR(255)
);