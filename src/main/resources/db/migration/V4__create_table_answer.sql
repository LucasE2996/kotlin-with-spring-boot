create table answer(
    id bigint not null auto_increment,
    message varchar(50) not null,
    creation_date datetime not null,
    topic_id bigint not null,
    author_id bigint not null,
    solution boolean,
    primary key(id),
    foreign key(topic_id) references topic(id),
    foreign key(author_id) references forum_user(id)
);