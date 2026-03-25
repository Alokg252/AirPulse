-- Indian Cities - Copy-Paste SQL Commands

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI101', 'Delhi', 'Mumbai', '2026-02-15 08:00:00', '2026-02-15 10:30:00', 5500.00, 120, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('SG201', 'Delhi', 'Mumbai', '2026-02-20 14:00:00', '2026-02-20 16:30:00', 6000.00, 100, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('BA301', 'Delhi', 'Mumbai', '2026-03-10 18:00:00', '2026-03-10 20:30:00', 5800.00, 90, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI102', 'Delhi', 'Bangalore', '2026-02-18 09:00:00', '2026-02-18 11:45:00', 7500.00, 110, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('SG202', 'Delhi', 'Bangalore', '2026-03-15 15:30:00', '2026-03-15 18:15:00', 7800.00, 105, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI103', 'Mumbai', 'Bangalore', '2026-02-22 07:00:00', '2026-02-22 09:30:00', 4200.00, 130, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('SG203', 'Mumbai', 'Bangalore', '2026-03-20 13:00:00', '2026-03-20 15:30:00', 4500.00, 125, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI104', 'Mumbai', 'Chennai', '2026-02-25 10:00:00', '2026-02-25 12:45:00', 3800.00, 140, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('BA302', 'Mumbai', 'Chennai', '2026-03-25 16:00:00', '2026-03-25 18:45:00', 4100.00, 135, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI105', 'Bangalore', 'Kolkata', '2026-03-01 11:00:00', '2026-03-01 14:30:00', 6800.00, 95, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('SG204', 'Bangalore', 'Kolkata', '2026-03-22 17:30:00', '2026-03-22 21:00:00', 7200.00, 100, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI106', 'Delhi', 'Hyderabad', '2026-03-05 08:30:00', '2026-03-05 10:45:00', 6500.00, 115, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('BA303', 'Delhi', 'Hyderabad', '2026-03-28 14:30:00', '2026-03-28 16:45:00', 6800.00, 110, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('AI107', 'Chennai', 'Pune', '2026-03-08 09:15:00', '2026-03-08 11:30:00', 3200.00, 145, 'admin', NOW(), 'admin', NOW());

INSERT INTO flights (flight_number, from_city, to_city, departure_time, arrival_time, price, available_seats, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('SG205', 'Chennai', 'Pune', '2026-03-30 15:45:00', '2026-03-30 18:00:00', 3500.00, 140, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (1, 1, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (2, 1, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (3, 2, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (4, 2, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (5, 3, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (6, 3, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (7, 4, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (8, 4, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (9, 5, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (10, 5, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (11, 1, 'admin', NOW(), 'admin', NOW());

INSERT INTO flight_booking (flight_id, user_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES (12, 2, 'admin', NOW(), 'admin', NOW());

SELECT COUNT(*) FROM flights;
SELECT COUNT(*) FROM flight_booking;

