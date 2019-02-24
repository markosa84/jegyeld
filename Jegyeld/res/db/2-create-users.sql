--DROP SEQUENCE users_seq;

--DROP TABLE users;

CREATE SEQUENCE users_seq;

CREATE TABLE users (
    user_id         NUMERIC(20) NOT NULL,
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    address         VARCHAR(100),
    email           VARCHAR(50),
    phone           VARCHAR(16),
    password        VARCHAR(50) NOT NULL,
    date_of_birth   DATE,
    created_at      TIMESTAMP DEFAULT now() NOT NULL,
    updated_at      TIMESTAMP DEFAULT now() NOT NULL,
    status          CHAR(1) DEFAULT 'A' NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id),
    CONSTRAINT users_ck1 CHECK (status IN ('A', 'D'))
);