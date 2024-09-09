DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE book
(
    id     LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title  VARCHAR(128) NOT NULL,
    author VARCHAR(128) NOT NULL
);

CREATE TABLE review
(
    id     LONG AUTO_INCREMENT PRIMARY KEY NOT NULL,
    bookId LONG          NOT NULL,
    text   VARCHAR(1024) NOT NULL UNIQUE
);

ALTER TABLE review
    ADD CONSTRAINT book_review_fk FOREIGN KEY (bookId) REFERENCES book (id);

--
-- Table structure for table `users`
--

CREATE TABLE users
(
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    enabled  tinyint     NOT NULL,
    PRIMARY KEY (`username`)
);

--
-- Inserting data for table `users`
--

INSERT INTO users
VALUES ('john', '{noop}test123', 1),
       ('mary', '{noop}test123', 1),
       ('susan', '{noop}test123', 1);


--
-- Table structure for table `authorities`
--

CREATE TABLE authorities
(
    username  varchar(50) NOT NULL,
    authority varchar(50) NOT NULL
);

--
-- Altering Table to adding constraint
--
ALTER TABLE authorities
    ADD CONSTRAINT users_authorities_fk FOREIGN KEY (username) REFERENCES users (username);

ALTER TABLE authorities
    ADD CONSTRAINT authorities_unique_key UNIQUE (username, authority);

--
-- Inserting data for table `authorities`
--

INSERT INTO authorities
VALUES ('john', 'ROLE_USER'),
       ('mary', 'ROLE_USER'),
       ('susan', 'ROLE_USER'),
       ('susan', 'ROLE_ADMIN');


