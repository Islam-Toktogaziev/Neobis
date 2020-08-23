create table price_list (
                            price_id bigint not null,
                            price double precision not null,
                            primary key (price_id)
);

create table price_list_seq (next_val bigint);

insert into price_list_seq values ( 2 );