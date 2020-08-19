alter table orders add constraint UK_g6qdabs0ppy3lg8o8c1wd7wxx foreign key (shipping_id) references shipping (shipping_id);

alter table cars add constraint FKcki51tfk2udss8oujqvpu1mpj foreign key (car_type_id) references car_type (car_type_id);

alter table cars add constraint FK1itgarrpxn99j57gfqhlotuel foreign key (price_id) references price_list (price_id);

alter table contracts add constraint FKqurdng6t94by3nbreeptwwr65 foreign key (car_id) references cars (car_id);

alter table contracts add constraint FKgcu7bfqv1j7nltm5uhk91kxcy foreign key (customer_id) references customers (customer_id);

alter table contracts add constraint FKf5c9xgkxh0n28hbhsgo5rkq58 foreign key (employee_id) references employees (employee_id);

alter table contracts add constraint FK5yknvfmbs6bdjclgsgi0iv80k foreign key (order_id) references orders (order_id);

alter table contracts add constraint FKt5atsteaw65mg24uibbwed85y foreign key (price_id) references price_list (price_id);

alter table contracts add constraint FK2v2425lub4bbrnrhkuif8st1g foreign key (shipping_id) references orders (shipping_id);

alter table customers add constraint FKnocgjt6jhrsogjs2ocp7vebx5 foreign key (reputation_id) references reputation (reputation_id);

alter table employees add constraint FKagakceqm38ji4lb8q3j6rj8ij foreign key (position_id) references position (position_id);

alter table favorites add constraint FKipk6i6da281si71callklgsbx foreign key (customer_id) references customers (customer_id);

alter table favorites_car add constraint FK94ck5w15qe2xxuj0qeguweqob foreign key (car_id) references cars (car_id);

alter table favorites_car add constraint FK8vdavcmy7jy7khk3wig2n4xf1 foreign key (favorites_id) references favorites (favorites_id);

alter table orders add constraint FKd2p23ixwrrt395glgi9nnbj23 foreign key (car_id) references cars (car_id);

alter table orders add constraint FKpxtb8awmi0dk6smoh2vp1litg foreign key (customer_id) references customers (customer_id);

alter table orders add constraint FKsemahq4easllj6if07wtarony foreign key (shipping_id) references shipping (shipping_id);

alter table shipping add constraint FKb6np5ccwhvtp24emop9phtbi7 foreign key (region_id) references region (region_id);

alter table user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles (role_id);

alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (user_id);

alter table cars add constraint FK6p09ycqydk56o2i8tv3a200jk foreign key (brand_id) references brand (brand_id);