INSERT INTO roles(role_id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO user(user_id,user_name,password)
VALUES (1, 'admin','$2a$10$7.s0VeuV9utntQ3AMRkC1uyW9jH9g8ouzdpiN6LA5.VBnsD6fntrW');

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 2);