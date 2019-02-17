--DROP SEQUENCE USERS_SEQ;

--DROP TABLE USERS;

CREATE SEQUENCE users_seq;

CREATE TABLE users (
    user_id         NUMERIC NOT NULL,
    first_name      VARCHAR(30),
    last_name       VARCHAR(50),
    address         VARCHAR(100),
    email           VARCHAR(50),
    phone           VARCHAR(16),
    password        VARCHAR NOT NULL,
    created_at      DATE DEFAULT now() NOT NULL,
    updated_at      DATE DEFAULT now() NOT NULL,
    status          CHAR(1) DEFAULT 'A' NOT NULL,
    date_of_birth   DATE,
    CONSTRAINT users_pk PRIMARY KEY (user_id),
    CONSTRAINT users_ck1 CHECK (status IN ('A', 'D'))
);