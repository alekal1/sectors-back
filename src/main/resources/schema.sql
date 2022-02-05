CREATE TABLE user (
    id              IDENTITY       NOT NULL,
    username        VARCHAR(255)   NOT NULL,
    agree_to_terms  BOOLEAN        NOT NULL,

    CONSTRAINT user_pk PRIMARY KEY (id)
);


CREATE TABLE sector (
    id              IDENTITY       NOT NULL,
    name            VARCHAR(255)   NOT NULL,
    type            VARCHAR(15)    NOT NULL,
    parent_sector   BIGINT,

    CONSTRAINT selector_pk PRIMARY KEY (id),
    FOREIGN KEY (parent_sector) REFERENCES sector (id)
);