create table cars (
                      car_id bigint not null,
                      car_name varchar(255),
                      color varchar(255),
                      engine_displacement double precision not null,
                      car_type_id bigint,
                      price_id bigint,
                      brand_id bigint,
                      primary key (car_id)
);

create table car_seq (next_val bigint);

insert into car_seq values ( 2 );