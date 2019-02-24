--DROP SEQUENCE ticket_seq;

--DROP TABLE ticket;

CREATE SEQUENCE ticket_seq;

CREATE TABLE ticket (
    ticket_id     NUMERIC(20) NOT NULL,
    price         NUMERIC(20),
    seat_number   NUMERIC(20),
    event_id      NUMERIC(20),
    user_id       NUMERIC(20),
    created_at    TIMESTAMP DEFAULT now() NOT NULL,
    updated_at    TIMESTAMP DEFAULT now() NOT NULL,
    status        CHAR(1) DEFAULT 'A' NOT NULL,
    CONSTRAINT ticket_pk PRIMARY KEY (ticket_id),
    CONSTRAINT ticket_fk1 FOREIGN KEY (event_id) REFERENCES event (event_id),
    CONSTRAINT ticket_fk2 FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT ticket_ck1 CHECK (status IN ('A', 'D'))
);