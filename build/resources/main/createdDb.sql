create table if not exists authors
(
    id serial not null
        constraint authors_pk
            primary key,
    first_name varchar not null,
    last_name varchar not null,
    birth timestamp not null,
    created_date timestamp not null,
    email varchar
);

alter table authors owner to postgres;

create unique index if not exists authors_id_uindex
    on authors (id);

create table if not exists publishers
(
    id serial not null
        constraint publishers_pk
            primary key,
    name varchar not null,
    city varchar not null
);

alter table publishers owner to postgres;

create table if not exists books
(
    id serial not null
        constraint books_pk
            primary key,
    name varchar not null,
    series varchar,
    isbn integer not null,
    created_date timestamp not null,
    publisher_id integer not null
        constraint books_publishers_id_fk
            references publishers
);

alter table books owner to postgres;

create unique index if not exists books_id_uindex
    on books (id);

create unique index if not exists books_isbn_uindex
    on books (isbn);

create table if not exists books_authors
(
    author_id integer not null
        constraint books_authors_authors_id_fk
            references authors,
    books_id integer not null
        constraint books_authors_books_id_fk
            references books,
    constraint books_authors_pk
        primary key (author_id, books_id)
);

alter table books_authors owner to postgres;

create unique index if not exists publishers_id_uindex
    on publishers (id);

