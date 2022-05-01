CREATE TABLE forum_user_role(
    id BIGINT NOT NULL AUTO_INCREMENT,
    forum_user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(forum_user_id) REFERENCES forum_user (id),
    FOREIGN KEY(role_id) REFERENCES role (id)
);

INSERT INTO forum_user_role(id, forum_user_id, role_id) VALUES (1, 1, 1);