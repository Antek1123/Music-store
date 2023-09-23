INSERT INTO product (id, description, name, production_date, state, weight)
VALUES (1, 'opis', 'nazwa', '2023-03-03', 'AVAILABLE', 60);

INSERT INTO product (id, description, name, production_date, state, weight)
VALUES (2, 'opis gitary', 'nazwa gitary', '2022-02-02', 'AVAILABLE', 100);

INSERT INTO instrument (serial_number, product_id, instrument_type)
VALUES ('asdfa123412asdf', '2', 'GUITAR');

INSERT INTO instrument_type (name) VALUES ('GUITAR');

INSERT INTO operator (birth_date, date_of_employment, deleted_at, email, name, password, surname, address_id, last_logged_at)
VALUES ('1989-09-09', '2020-09-23', null, 'darek@gmail.com', 'Dariusz', '$2a$12$nXFqT3B14DGAuA4QUxsrvOUUl0LcYtV8ZbFtWxhIJ6FsFpNMZkimG', 'Podebski', null, NULL);
