create table contracts (
                           contract_id bigint not null,
                           created_at datetime not null,
                           updated_at datetime not null,
                           car_id bigint,
                           customer_id bigint,
                           employee_id bigint,
                           order_id bigint,
                           price_id bigint,
                           shipping_id bigint,
                           primary key (contract_id)
);

create table contracts_seq (next_val bigint);

insert into contracts_seq values ( 1 );