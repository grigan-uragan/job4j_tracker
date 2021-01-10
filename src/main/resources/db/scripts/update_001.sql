drop table if exists items;
create table items (
    id serial primary key not null,
    name varchar(200)
);