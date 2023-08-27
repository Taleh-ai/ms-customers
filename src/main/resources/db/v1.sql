-- liquibase/changelog/V1__create_user_entity_table.sql
--
-- CREATE SEQUENCE user_entity_seq START WITH 1 INCREMENT BY 1;
--
create table customers
(
    customer_id   bigserial
        primary key,
    creation_date timestamp,
    email         varchar(255),
    first_name    varchar(255),
    gender        varchar(255),
    last_name     varchar(255),
    password      varchar(255),
    phone_number  varchar(255),
    role          varchar(255),
    update_date   timestamp
);