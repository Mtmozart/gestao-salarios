CREATE TABLE payments (
    id BIGINT NOT NULL AUTO_INCREMENT,
    from_manage BIGINT NOT NULL,
    to_employee BIGINT NOT NULL,
    price DECIMAL(8, 2) NOT NULL,
    payment_date DATE NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT PAYMENTS_FK_FROM_MANAGE FOREIGN KEY (from_manage) REFERENCES manages (manage_id),
    CONSTRAINT PAYMENTS_FK_TO_EMPLOYEE FOREIGN KEY (to_employee) REFERENCES employees (employee_id)
);

