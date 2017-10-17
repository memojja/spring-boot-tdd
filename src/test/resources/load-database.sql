INSERT INTO person (name, tc) VALUES ('Iago', '86730543540');

INSERT INTO telephone (number,person_id) VALUES ('423654', (SELECT id FROM person WHERE tc = '86730543540'));


INSERT INTO address (publicPlace, number, complement, neighborhood, city, state, person_id) VALUES ('Rua dos Gerânios', '478', 'XXXX', 'Pricumã', 'Boa Vista', 'RR', (SELECT id FROM person WHERE tc = '86730543540'));


