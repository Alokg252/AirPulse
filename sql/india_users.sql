-- Indian Users - SQL Insert
-- Make sure to set password using setPlainPassword() method or hash accordingly

INSERT INTO users (username, email, name, uuid, gender, dob, password, created_by, created_date, last_modified_by, last_modified_date)
VALUES
('raj_kumar', 'raj.kumar@email.com', 'Raj Kumar', UUID(), 'MALE', '1990-05-15', '$2a$10$slYQmyNdGzin7olVN3p5Be7DH5ttzO9rp3toHHev.KJqDfRiG2stamm', 'admin', NOW(), 'admin', NOW()),
('priya_singh', 'priya.singh@email.com', 'Priya Singh', UUID(), 'FEMALE', '1992-08-22', '$2a$10$slYQmyNdGzin7olVN3p5Be7DH5ttzO9rp3toHHev.KJqDfRiG2stamm', 'admin', NOW(), 'admin', NOW()),
('amit_patel', 'amit.patel@email.com', 'Amit Patel', UUID(), 'MALE', '1988-03-10', '$2a$10$slYQmyNdGzin7olVN3p5Be7DH5ttzO9rp3toHHev.KJqDfRiG2stamm', 'admin', NOW(), 'admin', NOW()),
('neha_reddy', 'neha.reddy@email.com', 'Neha Reddy', UUID(), 'FEMALE', '1995-11-28', '$2a$10$slYQmyNdGzin7olVN3p5Be7DH5ttzO9rp3toHHev.KJqDfRiG2stamm', 'admin', NOW(), 'admin', NOW()),
('arjun_das', 'arjun.das@email.com', 'Arjun Das', UUID(), 'MALE', '1991-07-05', '$2a$10$slYQmyNdGzin7olVN3p5Be7DH5ttzO9rp3toHHev.KJqDfRiG2stamm', 'admin', NOW(), 'admin', NOW());

SELECT COUNT(*) AS total_users FROM users;

