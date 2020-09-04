create table favorites (
                           favorites_id bigint not null,
                           customer_id bigint,
                           primary key (favorites_id)
);

create table favorites_car (
                               favorites_id bigint not null,
                               car_id bigint not null,
                               primary key (favorites_id, car_id)
);

create table favorites_seq (next_val bigint);

insert into favorites_seq values ( 1 );