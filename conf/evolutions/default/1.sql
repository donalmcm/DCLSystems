# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table fuel_price (
  id                            bigint not null,
  name                          varchar(255),
  price                         double,
  constraint pk_fuel_price primary key (id)
);
create sequence fuel_price_seq;

create table fuel_sales (
  id                            integer not null,
  fuel_type                     varchar(255),
  date                          varchar(255),
  unit_sp                       double,
  unit_net                      double,
  unit_cp                       double,
  unit_profit                   double,
  qty_sold                      integer,
  val_sold                      integer,
  net                           integer,
  profit                        double,
  constraint pk_fuel_sales primary key (id)
);
create sequence fuel_sales_seq;

create table tank (
  id                            integer not null,
  name                          varchar(255),
  capacity                      integer,
  dip                           integer,
  ullage                        integer,
  constraint pk_tank primary key (id)
);
create sequence tank_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);


# --- !Downs

drop table if exists fuel_price;
drop sequence if exists fuel_price_seq;

drop table if exists fuel_sales;
drop sequence if exists fuel_sales_seq;

drop table if exists tank;
drop sequence if exists tank_seq;

drop table if exists user;

