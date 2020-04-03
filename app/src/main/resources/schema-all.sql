DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    status SMALLINT
);

INSERT INTO people(person_id, first_name, last_name, status) VALUES(1, 'Barack', 'Obama', 0);
INSERT INTO people(person_id, first_name, last_name, status) VALUES(2, 'George', 'Bush', 0);
INSERT INTO people(person_id, first_name, last_name, status) VALUES(3, 'Donald', 'Trump', 0);