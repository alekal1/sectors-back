CREATE TABLE user (
    id              IDENTITY       NOT NULL,
    username        VARCHAR(255)   NOT NULL,
    sector          BIGINT,
    agree_to_terms  BOOLEAN        NOT NULL,

    CONSTRAINT user_pk PRIMARY KEY (id),
    FOREIGN KEY (sector) REFERENCES sector (id)
);


CREATE TABLE sector (
    id              IDENTITY       NOT NULL,
    name            VARCHAR(255)   NOT NULL,
    user            BIGINT,
    type            VARCHAR(15)    NOT NULL,
    parent_sector   BIGINT,

    CONSTRAINT selector_pk PRIMARY KEY (id),
    FOREIGN KEY (parent_sector) REFERENCES sector (id),
    FOREIGN KEY (user) REFERENCES user (id)
);