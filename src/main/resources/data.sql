DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO users (id, first_name, last_name) VALUES
    (1, 'Shipra', 'Behera'),
    (2, 'Vandana', 'Sridhar'),
    (3, 'Pranav', 'Sivakumar');

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts(
 account_no BIGINT PRIMARY KEY,
 pin INT,
 account_type VARCHAR(10),
 balance REAL,
 user_id INT,
 foreign key (user_id) references users(id)
);

INSERT INTO accounts(account_no, pin, account_type, balance, user_id) VALUES
    (23456, 1212, 'SAVINGS', 4112, 1);
INSERT INTO accounts(account_no, pin, account_type, balance, user_id) VALUES
    (76345, 8001, 'CHECKING', 5234, 2);