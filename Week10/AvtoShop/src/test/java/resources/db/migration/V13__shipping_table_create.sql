create table shipping (
                          shipping_id bigint not null,
                          shipping_cost double precision not null,
                          shipping_type varchar(255),
                          region_id bigint not null,
                          primary key (shipping_id)
);

create table shipping_seq (next_val bigint);

insert into shipping_seq values ( 2 );