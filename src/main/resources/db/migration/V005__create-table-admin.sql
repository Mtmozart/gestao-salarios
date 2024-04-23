CREATE TABLE admins(
    admin_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    PRIMARY KEY(admin_id),
    CONSTRAINT ADMINS_FK_USER FOREIGN KEY(user_id) REFERENCES users(id)
);
