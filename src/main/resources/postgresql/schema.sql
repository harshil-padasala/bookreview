-- Drop tables if they exist
DROP TABLE IF EXISTS authorities CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS review CASCADE;
DROP TABLE IF EXISTS book CASCADE;

-- Create `book` table
CREATE TABLE book
(
    id     BIGSERIAL PRIMARY KEY,
    title  VARCHAR(128) NOT NULL,
    author VARCHAR(128) NOT NULL
);

-- Create `review` table
CREATE TABLE review
(
    id     BIGSERIAL PRIMARY KEY,
    bookId BIGINT NOT NULL,
    text   VARCHAR(1024) NOT NULL UNIQUE,
    CONSTRAINT book_review_fk FOREIGN KEY (bookId) REFERENCES book (id)
);

-- Create `users` table
CREATE TABLE users
(
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled  SMALLINT    NOT NULL,
    PRIMARY KEY (username)
);

-- Insert data into `users` table
INSERT INTO users (username, password, enabled)
VALUES ('john', '{noop}test123', 1),
       ('mary', '{noop}test123', 1),
       ('susan', '{noop}test123', 1);

-- Create `authorities` table
CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT users_authorities_fk FOREIGN KEY (username) REFERENCES users (username),
    CONSTRAINT authorities_unique_key UNIQUE (username, authority)
);

-- Insert data into `authorities` table
INSERT INTO authorities (username, authority)
VALUES ('john', 'ROLE_USER'),
       ('mary', 'ROLE_USER'),
       ('susan', 'ROLE_USER'),
       ('susan', 'ROLE_ADMIN');
