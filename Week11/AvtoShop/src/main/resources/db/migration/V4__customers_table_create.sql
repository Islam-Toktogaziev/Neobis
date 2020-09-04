create table customers (
                           customer_id bigint not null,
                           address varchar(255),
                           customer_name varchar(255),
                           email varchar(255),
                           number varchar(255),
                           reputation_id bigint,
                           primary key (customer_id)
);

create table customer_seq (next_val bigint);

insert into customer_seq values ( 1 );
