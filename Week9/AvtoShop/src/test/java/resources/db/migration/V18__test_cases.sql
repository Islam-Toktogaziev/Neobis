insert into brand (brand_id, brand) VALUES (1,'Toyota'),
(
 2,'testDel'
);

insert into car_type (car_type_id, car_type) VALUEs (1,'coupe'),
    (
     2,'testDel'
        );

insert into position (position_id, position) values (1,'Manager'),
    (
     2,'testDel'
        );

insert into price_list (price_id, price) VALUEs (1,2500),
    (
     2,2555
        );

insert into region (region_id, region) VALUEs (1, 'Bishkek'),
    (
     2,'testDel'
        );

insert into reputation (reputation_id, reputation) VALUEs (1,'NiceMan'),
    (
     2,'testDel'
        );

insert into employees (employee_id, address, email, employee_name, number, salary, position_id)
    VALUEs (
           1,
           'Bishkek 312',
           'qwe123@gmail.com',
           'Arthur',
           '0123456789',
           '25000',
           1
    );

insert into customers (customer_id, address, customer_name, email, number, reputation_id)
    value (
           1,
           'Bishkek 312',
           'James',
           'James123@gmail.com',
           '0123456789',
           1
    ),(
        2,
      'Bishkek',
      'Vanya',
      'qwertasdf',
      '7894656123',
      1
    );

insert into shipping (shipping_id, shipping_cost, shipping_type, region_id)
    value (
           1,
           100,
           'Dostavka',
           1
    ),
    (
        2,
    2500,
    'Samovyvoz',
    2
        );

insert into cars (car_id, car_name, color, engine_displacement, car_type_id, price_id, brand_id)
    value (
           1,
           'CAMRY',
           'Black',
           2.5,
           1,
           1,
           1
    ),(
                 2,
                 'CAMRY',
                 'Black',
                 2.5,
                 1,
                 1,
                 1
    );

insert into orders (order_id, status, car_id, customer_id, shipping_id,created_at,updated_at)
    value (
           1,
           'ready',
           1,
           1,
           1,
           STR_TO_DATE('18/02/2019 11:15:45','%d/%m/%Y %H:%i:%s'),
           STR_TO_DATE('18/02/2019 11:15:45','%d/%m/%Y %H:%i:%s')
    ),(
                 2,
                 'ready',
                 2,
                 1,
                 1,
                 STR_TO_DATE('18/02/2019 11:15:45','%d/%m/%Y %H:%i:%s'),
                 STR_TO_DATE('18/02/2019 11:15:45','%d/%m/%Y %H:%i:%s')
    );

insert into favorites (favorites_id, customer_id)
    value (
           1,
           1
    ),
    (
     2,
     1
        );

insert into favorites_car (favorites_id, car_id)
values (
           1,
           1
       ),
       (
           2,
           1
       );

insert into contracts (contract_id, car_id, customer_id, employee_id, order_id, price_id,
                       shipping_id,created_at,updated_at)
values (
           1,
           1,
           1,
           1,
           1,
           1,
           1,
           STR_TO_DATE('18/02/2019 11:15:45','%d/%m/%Y %H:%i:%s'),
        STR_TO_DATE('18/02/2019 11:15:45','%d/%m/%Y %H:%i:%s')
       );