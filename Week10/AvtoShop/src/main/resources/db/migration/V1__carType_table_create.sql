create table car_type (
                          car_type_id bigint not null,
                          car_type varchar(255),
                          primary key (car_type_id)
);

create table car_type_seq (next_val bigint);

insert into car_type_seq values ( 1 );
