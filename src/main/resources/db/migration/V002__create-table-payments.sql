CREATE TABLE payments(
    id BIGINT NOT NULL AUTO_INCREMENT,
    price DECIMAL (8, 2) NOT NULL,
    payment_date DATE NOT NULL,
    PRIMARY KEY(id)
);

