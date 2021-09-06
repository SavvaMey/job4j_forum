create table posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now(),
    user_id int not null references users(id)
);

create table comment (
    id serial primary key,
    author varchar(2000),
    message text,
    created timestamp without time zone not null default now(),
    post_id int references posts(id)
);
