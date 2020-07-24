drop table if exists people;

create table people (
id bigint not null auto_increment,
age integer not null,
first_name varchar(255),
last_name varchar(255),
primary key (id));
