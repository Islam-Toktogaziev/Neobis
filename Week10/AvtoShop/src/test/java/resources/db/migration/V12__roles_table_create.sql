create table roles (
                       role_id bigint not null,
                       name varchar(255),
                       primary key (role_id)
);

create table role_seq (next_val bigint);

insert into role_seq values ( 3 );