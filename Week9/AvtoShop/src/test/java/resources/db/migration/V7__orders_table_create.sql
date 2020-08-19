create table orders (
                        order_id bigint not null,
                        created_at datetime not null,
                        updated_at datetime not null,
                        status varchar(255),
                        car_id bigint,
                        customer_id bigint,
                        shipping_id bigint,
                        primary key (order_id)
);

create table order_seq (next_val bigint);

insert into order_seq values ( 2 );
