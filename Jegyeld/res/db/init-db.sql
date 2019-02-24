INSERT INTO users (
    user_id,
    first_name,
    last_name,
    address,
    phone,
    email,
    password,
    date_of_birth
) VALUES (
    nextval('users_seq'),
    'Elek',
    'Teszt',
    'Fürdő utca 2',
    '+36 80 123 4567',
    'teszt.elek@gmail.com',
    '123456',
    TO_DATE('2000-01-03', 'YYYY-MM-DD')
);