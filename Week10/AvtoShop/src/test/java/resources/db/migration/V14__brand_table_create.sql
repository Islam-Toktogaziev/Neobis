create table brand (
    brand_id bigint not null,
    brand varchar(255),
    primary key (brand_id)
                   );

create table brand_seq (next_val bigint);

insert into brand_seq values ( 2 );