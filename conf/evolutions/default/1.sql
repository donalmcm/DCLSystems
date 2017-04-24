# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table all_sales (
  id                            bigint not null,
  date                          varchar(255),
  fuel_type                     varchar(255),
  unit_sp                       double,
  unit_net                      double,
  unit_cp                       double,
  unit_profit                   double,
  qty_sold                      integer,
  val_sold                      integer,
  net                           integer,
  profit                        double,
  constraint pk_all_sales primary key (id)
);
create sequence all_sales_seq;

create table diesel_sale (
  id                            bigint not null,
  date                          varchar(255),
  unit_sp                       double,
  unit_net                      double,
  unit_cp                       double,
  unit_profit                   double,
  qty_sold                      integer,
  val_sold                      integer,
  net                           integer,
  profit                        double,
  constraint pk_diesel_sale primary key (id)
);
create sequence diesel_sale_seq;

create table fuel_price (
  id                            bigint not null,
  name                          varchar(255),
  price                         double,
  constraint pk_fuel_price primary key (id)
);
create sequence fuel_price_seq;

create table reward_member (
  id                            bigint not null,
  name                          varchar(255),
  address                       varchar(255),
  contact_number                integer,
  points                        integer,
  constraint pk_reward_member primary key (id)
);
create sequence reward_member_seq;

create table tank (
  id                            integer not null,
  name                          varchar(255),
  capacity                      integer,
  dip                           integer,
  ullage                        integer,
  constraint pk_tank primary key (id)
);
create sequence tank_seq;

create table unleaded_sale (
  id                            bigint not null,
  date                          varchar(255),
  unit_sp                       double,
  unit_net                      double,
  unit_cp                       double,
  unit_profit                   double,
  qty_sold                      integer,
  val_sold                      integer,
  net                           integer,
  profit                        double,
  constraint pk_unleaded_sale primary key (id)
);
create sequence unleaded_sale_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);


# --- !Downs

drop table if exists all_sales;
drop sequence if exists all_sales_seq;

drop table if exists diesel_sale;
drop sequence if exists diesel_sale_seq;

drop table if exists fuel_price;
drop sequence if exists fuel_price_seq;

drop table if exists reward_member;
drop sequence if exists reward_member_seq;

drop table if exists tank;
drop sequence if exists tank_seq;

drop table if exists unleaded_sale;
drop sequence if exists unleaded_sale_seq;

drop table if exists user;

