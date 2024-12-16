-- Drop the tables if they exist
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `book`;

-- Create the book table
CREATE TABLE `book` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `title` VARCHAR(128) NOT NULL,
    `author` VARCHAR(128) NOT NULL
);

-- Create the review table with a partial index on 'text'
CREATE TABLE `review` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `bookId` BIGINT NOT NULL,
    `text` VARCHAR(1024) NOT NULL,
    UNIQUE KEY `unique_text` (`text`(255))  -- Limit the index size to 255 characters
);

-- Add foreign key constraint for review.bookId referencing book.id
ALTER TABLE `review`
    ADD CONSTRAINT `book_review_fk` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`);

-- Create the users table
CREATE TABLE `users` (
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,  -- TINYINT for boolean-like behavior
    PRIMARY KEY (`username`)
);

-- Insert data into the users table
INSERT INTO `users` (`username`, `password`, `enabled`)
VALUES
    ('john', '{noop}test123', 1),
    ('mary', '{noop}test123', 1),
    ('susan', '{noop}test123', 1);

-- Create the authorities table
CREATE TABLE `authorities` (
    `username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`username`, `authority`)  -- Set composite primary key to enforce uniqueness
);

-- Add foreign key constraint for authorities.username referencing users.username
ALTER TABLE `authorities`
    ADD CONSTRAINT `users_authorities_fk` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

-- Insert data into the authorities table
INSERT INTO `authorities` (`username`, `authority`)
VALUES
    ('john', 'ROLE_USER'),
    ('mary', 'ROLE_USER'),
    ('susan', 'ROLE_USER'),
    ('susan', 'ROLE_ADMIN');
