--DROP SEQUENCE event_seq;

--DROP TABLE event;

CREATE SEQUENCE event_seq;

CREATE TABLE event (
    event_id            NUMERIC(20) NOT NULL,
    event_name          VARCHAR(100) NOT NULL,
    event_description   VARCHAR(100),
    event_location      VARCHAR(100) NOT NULL,
    image_location      VARCHAR(100),
    event_start         TIMESTAMP NOT NULL,
    event_end           TIMESTAMP NOT NULL,
    total_seats         NUMERIC(20) NOT NULL,
    free_seats          NUMERIC(20) NOT NULL,
    created_at          TIMESTAMP DEFAULT now() NOT NULL,
    updated_at          TIMESTAMP DEFAULT now() NOT NULL,
    status              CHAR(1) DEFAULT 'A' NOT NULL,
    CONSTRAINT event_pk PRIMARY KEY (event_id),
    CONSTRAINT event_ck1 CHECK (status IN ('A', 'D'))
);