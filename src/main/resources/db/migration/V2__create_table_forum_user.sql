create table forum_user(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into forum_user values(1, 'Lucas Rosa', 'lucasrosa@test.com');