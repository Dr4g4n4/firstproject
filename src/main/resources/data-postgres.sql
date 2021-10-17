INSERT INTO fueltype(name) VALUES ('benzin');
INSERT INTO fueltype(name) VALUES ('dizel');
INSERT INTO fueltype(name) VALUES ('metan');
INSERT INTO fueltype(name) VALUES ('etan');
INSERT INTO fueltype(name) VALUES ('elektricno');
INSERT INTO fueltype(name) VALUES ('hybrid');

INSERT INTO engine_type(cylinder_type, h_power, motor_power, number_of_cylinders, primary_fuel, secondary_fuel, volume) VALUES ('V', 205, 6000, 4, 'DIESEL', 'DIESEL', 300);
INSERT INTO engine_type(cylinder_type, h_power, motor_power, number_of_cylinders, primary_fuel, secondary_fuel, volume) VALUES ('I', 220, 5000, 3, 'DIESEL', 'PETROL', 150);
INSERT INTO engine_type(cylinder_type, h_power, motor_power, number_of_cylinders, primary_fuel, secondary_fuel, volume) VALUES ('I', 180, 2300, 3, 'PETROL', 'DIESEL', 250);

INSERT INTO carchassis(chasiss_type, color, height, length, volume, width) VALUES ('SEDAN', 'BLUE', 100, 200, 100, 70);
INSERT INTO carchassis(chasiss_type, color, height, length, volume, width) VALUES ('LIMOUSINE', 'WHITE', 300, 100, 200, 100);
INSERT INTO carchassis(chasiss_type, color, height, length, volume, width) VALUES ('SEDAN', 'GRAY', 150, 220, 130, 50);

INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('peugeot', '123fseSDF242', 'KLFDGJD8', '2020-11-14', 120000, 'MF 307', '2019-11-14', 1, 1);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('passat', '8578KJNK09j', '88775', '2018-11-10', 10000, '2255', '2017-11-14', 1, 1);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('passat', 'klnmk89JMK', '11223344', '2018-11-14', 7000, 'AB 234', '2019-11-14', 2, 2);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('peugeot', '11111KL', '55667788', '2017-11-14', 255000, 'F 3G7', '2016-11-14', 2, 2);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('stepway ', 'KNFGK98789JFDG', '9910101111', '2017-11-14', 120000, 'N 897', '2016-11-14', 1, 2);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('stepway ', 'LKDFMLD8NDFGKJDN', '12121311314115H', '2015-11-14', 150000, 'MF 307', '2014-11-14', 2, 1);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('peugeot', 'LKMFDG9IMDK', '1010101', '2020-10-14', 150000, 'MF 307', '2019-11-14', 3, 3);
INSERT INTO car(brand, chassis_serial_number, engine_number, first_registration, mileage, model, production_date, chassis_id, engine_type_id) VALUES ('stepway ', '89YGNJ8', '1717171313131', '2020-09-14', 10000, 'MF 352', '2019-11-14', 1, 3);