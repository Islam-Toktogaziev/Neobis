create table user (
                      user_id bigint not null,
                      password varchar(255),
                      user_name varchar(255),
                      primary key (user_id)
);

create table user_roles (
                            user_id bigint not null,
                            role_id bigint not null,
                            primary key (user_id, role_id)
);

create table user_seq (next_val bigint);

insert into user_seq values ( 2 );
