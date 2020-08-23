create table employees (
                           employee_id bigint not null,
                           address varchar(255),
                           email varchar(255),
                           employee_name varchar(255),
                           number varchar(255),
                           salary double precision not null,
                           position_id bigint,
                           primary key (employee_id)
);

create table employee_seq (next_val bigint);

insert into employee_seq values ( 1 );
