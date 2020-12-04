CREATE TABLE IF NOT EXISTS employees (
    id serial PRIMARY KEY,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    email VARCHAR(25)
);
INSERT INTO employees(first_name, last_name, email) VALUES('ahmed', 'moustafa','ahmed@email.com');