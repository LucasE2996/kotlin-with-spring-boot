create table role(
    id BIGINT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO role(id, name) VALUES (1, 'READ_WRITE');