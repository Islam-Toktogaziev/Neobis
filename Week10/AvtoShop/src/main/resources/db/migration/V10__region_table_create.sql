create table region (
                        region_id bigint not null,
                        region varchar(255),
                        primary key (region_id)
);

create table region_seq (next_val bigint);

insert into region_seq values ( 1 );

