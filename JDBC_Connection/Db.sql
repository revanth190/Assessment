CREATE DATABASE testdb;
USE testdb;

CREATE TABLE IF NOT EXISTS users (
    id    INT PRIMARY KEY,
    name  VARCHAR(50),
    email VARCHAR(50)
);

INSERT INTO users VALUES (101, 'Arjun', 'arjun@gmail.com');
INSERT INTO users VALUES (102, 'Meera', 'meera@gmail.com');
INSERT INTO users VALUES (103, 'Rahul', 'rahul@gmail.com');

SELECT * FROM users;