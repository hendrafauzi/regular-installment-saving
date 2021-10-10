create database installment;
use installment;

CREATE TABLE saving_account(id INT PRIMARY KEY AUTO_INCREMENT, tenor INT NOT NULL,
first_deposit DOUBLE NOT NULL, monthly_deposit DOUBLE NOT NULL, purpose VARCHAR(16) NOT NULL);
CREATE INDEX saving_account_getId ON saving_account (id);

INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');
INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');
INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');
INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');
INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');
INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');
INSERT INTO saving_account (tenor, first_deposit, monthly_deposit, purpose) values (5, 60000, 10000, 'Education');