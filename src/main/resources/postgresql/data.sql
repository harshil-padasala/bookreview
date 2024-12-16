-- Inserting temporary data into the `book` table
INSERT INTO book (title, author) VALUES
    ('Moby Dick', 'Herman Melville'),
    ('War and Peace', 'Leo Tolstoy'),
    ('The Hobbit', 'J.R.R. Tolkien'),
    ('Jane Eyre', 'Charlotte Bronte'),
    ('Crime and Punishment', 'Fyodor Dostoevsky');

-- Inserting reviews into the `review` table
INSERT INTO review (bookId, text) VALUES
    (1, 'A thrilling tale of obsession and revenge.'),
    (2, 'An epic novel exploring human history and love.'),
    (3, 'A delightful adventure through Middle-earth.'),
    (4, 'A story of resilience and self-discovery.'),
    (5, 'A profound psychological exploration of morality.');
