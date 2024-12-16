-- Inserting temporary data into the library table
INSERT INTO book (title, author) VALUES
    ('The Catcher in the Rye', 'J.D. Salinger'),
    ('To Kill a Mockingbird', 'Harper Lee'),
    ('1984', 'George Orwell'),
    ('Pride and Prejudice', 'Jane Austen'),
    ('The Great Gatsby', 'F. Scott Fitzgerald');

-- Inserting reviews into the review table
INSERT INTO review (bookId, text) VALUES
    (1, 'A classic coming-of-age novel.'),
    (2, 'A powerful exploration of racial injustice.'),
    (3, 'Dystopian masterpiece.'),
    (4, 'Timeless romance novel with wit and humor.'),
    (5, 'Captivating portrayal of the Roaring Twenties.');
