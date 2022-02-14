CREATE TABLE IF NOT EXISTS users (
    uuid            UUID            NOT NULL        PRIMARY KEY,
    email           VARCHAR(255)
        constraint uk_6dotkott2kjsp8vw4d0m25fb7     UNIQUE,
    name            VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS queue_items (
    uuid            UUID            NOT NULL        PRIMARY KEY,
    position        INTEGER         NOT NULL,
    queue_id uuid                   NOT NULL,
    user_id  uuid                   NOT NULL
        CONSTRAINT fkb5fvrh5idivhwqxeip3hqhbp1      REFERENCES users
);


CREATE TABLE IF NOT EXISTS queues (
    uuid            UUID            NOT NULL        PRIMARY KEY,
    name            VARCHAR(255)    NOT NULL,
    head            UUID            NOT NULL
        CONSTRAINT uk_sedxcwtf42x64tmk3kh3am0j4     UNIQUE
        CONSTRAINT fk9kibkd18e4vhfjelpqr1tio96      REFERENCES queue_items,
    tail            UUID            NOT NULL
        CONSTRAINT uk_2x03029hon9jw0ti0k0g863xw     UNIQUE
        CONSTRAINT fkj4xjnfifg34vwjk961gq0k8pv      REFERENCES queue_items
);

ALTER TABLE queue_items
add CONSTRAINT fk1jfnwveuy81rovhq30yq1mqoi
    FOREIGN KEY (queue_id) REFERENCES queues;
