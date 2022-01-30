CREATE TABLE book
(
    id serial
    constraint books_pk
    primary key,
    name varchar NOT NULL,
    genre varchar NOT NULL,
    isbn varchar NOT NULL
);