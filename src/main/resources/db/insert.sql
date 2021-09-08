insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$ntuwcJpILuQPD.KEJdgzn.2/qL8MEhYqS2bd.OpUj7lm8hogWru9W',
        (select id from authorities where authority = 'ROLE_ADMIN'));

insert into posts (name, user_id) values ('О чем этот форум?', 1);