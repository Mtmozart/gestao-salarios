CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    email VARCHAR (100) NOT NULL,
    password VARCHAR (100) NOT NULL,

    PRIMARY KEY(id)
);


CREATE TABLE profiles(
    id BIGINT NOT NULL AUTO_INCREMENT,
    type VARCHAR (100) NOT NULL,

    PRIMARY KEY(id)
);
CREATE TABLE users_profiles(
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,

    PRIMARY KEY(user_id, profile_id),
    CONSTRAINT USERS_PROFILES_FK_USER FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT USERS_PROFILES_FK_PROFILE FOREIGN KEY(profile_id) REFERENCES profiles(id)
);

INSERT INTO profiles VALUES(1, 'ROLE_ADMIN');
INSERT INTO profiles VALUES(2, 'ROLE_MANAGER');
INSERT INTO profiles VALUES(3, 'ROLE_EMPLOYEE');

INSERT INTO users VALUES(1, 'admin', 'admin@email.com.br', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');

INSERT INTO users_profiles values(1, 1);
