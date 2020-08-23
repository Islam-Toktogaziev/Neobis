create table position (
                          position_id bigint not null,
                          position varchar(255),
                          primary key (position_id)
);

create table position_seq (next_val bigint);

insert into position_seq values ( 1 );