create table reputation (
                            reputation_id bigint not null,
                            reputation varchar(255),
                            primary key (reputation_id)
);

create table reputation_seq (next_val bigint);

insert into reputation_seq values ( 1 );