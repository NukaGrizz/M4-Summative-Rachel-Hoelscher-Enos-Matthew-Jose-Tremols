drop schema game_store;
create schema if not exists game_store;
use game_store;


create table if not exists game (
    game_id int not null auto_increment primary key,
    title varchar(50) not null,
    esrb_rating varchar(50) not null,
    description varchar(255) not null,
    price decimal(5, 2) not null,
    studio varchar(50) not null,
    quantity int not null
);

create table if not exists console (
    console_id int not null auto_increment primary key,
    model varchar(50) not null,
    manufacturer varchar(50) not null,
    memory_amount varchar(20),
    processor varchar(20),
    price decimal(5, 2) not null,
    quantity int not null
);

create table if not exists t_shirt (
    t_shirt_id int not null auto_increment primary key,
    size varchar(20) not null,
    color varchar(20) not null,
    description varchar(255) not null,
    price decimal(5,2) not null,
    quantity int not null
);

create table if not exists sales_tax_rate (
    state char(2) not null,
    rate decimal(3,2) not null
);

create unique index ix_state_rate on sales_tax_rate (state);

create table if not exists processing_fee (
    product_type varchar(20) not null,
    fee decimal (4,2)
);

create unique index ix_product_type_fee on processing_fee (product_type);

create table if not exists invoice (
    invoice_id int not null auto_increment primary key,
    name varchar(80) not null,
    street varchar(30) not null,
    city varchar(30) not null,
    state char(2) not null,
    zipcode varchar(5) not null,
    item_type varchar(20) not null,
    item_id int not null,
    unit_price decimal(5,2) not null,
    quantity int not null,
    subtotal decimal(5,2) not null,
    tax decimal(5,2) not null,
    processing_fee decimal (5,2) not null,
    total decimal(5,2) not null
);

insert into game (description, esrb_rating, price, quantity, studio, title) values
("pacman", "e", 29.99, 100, "capcom", "pacman"),
("pong", "e", 29.99, 100, "atari", "pong"),
("mario", "e", 29.99, 100, "nintendo", "mario bros");

insert into console (model, manufacturer, memory_amount, processor, price, quantity) values
("xbox", "microsoft", "16GB", "8x Cores", 499.99, 200),
("playstation", "sony", "16GB", "32-bit RISC", 499.99, 120),
("N64", "nintendo", "8GB", "64-bit NEC", 99.99, 50);

insert into t_shirt (size, color, description, price, quantity) values
("small", "red", "dri-fit",  10.99, 100),
("medium", "red", "dri-fit",  10.99, 100),
("large", "red", "dri-fit",  10.99, 100),
("small", "green", "organic cotton", 12.99, 80),
("medium", "green", "organic cotton", 12.99, 80),
("large", "green", "organic cotton", 12.99, 80),
("small", "blue", "long-sleeve", 14.99, 50),
("medium", "blue", "long-sleeve", 14.99, 50),
("large", "blue", "long-sleeve", 14.99, 50);

insert into processing_fee (product_type, fee) values
("console", 14.99),
("game", 1.49),
("tshirt", 1.98);

insert into sales_tax_rate (state, rate) values
("AL", 0.05),
("AK", 0.06),
("AZ", 0.04),
("AR", 0.06),
("CA", 0.06),
("CO", 0.04),
("CT", 0.03),
("DE", 0.05),
("FL", 0.06),
("GA", 0.07),
("HI", 0.05),
("ID", 0.03),
("IL", 0.05),
("IN", 0.05),
("IA", 0.04),
("KS", 0.06),
("KY", 0.04),
("LA", 0.05),
("ME", 0.03),
("MD", 0.07),
("MA", 0.05),
("MI", 0.06),
("MN", 0.06),
("MS", 0.05),
("MO", 0.05),
("MT", 0.03),
("NE", 0.04),
("NV", 0.04),
("NH", 0.06),
("NJ", 0.05),
("NM", 0.05),
("NY", 0.06),
("NC", 0.05),
("ND", 0.05),
("OH", 0.04),
("OK", 0.04),
("OR", 0.07),
("PA", 0.06),
("RI", 0.06),
("SC", 0.06),
("SD", 0.06),
("TN", 0.05),
("TX", 0.03),
("UT", 0.04),
("VT", 0.07),
("VA", 0.06),
("WA", 0.05),
("WV", 0.05),
("WI", 0.03),
("WY", 0.04);

select * from game;