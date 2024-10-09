CREATE TABLE item
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    need          INT          NOT NULL,
    want          INT          NOT NULL,
    likely_to_use INT          NOT NULL,
    price DOUBLE NOT NULL
);

INSERT INTO item (name, need, want, likely_to_use, price)
VALUES ('Gitar', 3, 3, 3, 10000.0);
INSERT INTO item (name, need, want, likely_to_use, price)
VALUES ('Panelovn', 2, 2, 1, 1000.0);
INSERT INTO item (name, need, want, likely_to_use, price)
VALUES ('Toppmatet fryser', 1, 1, 2, 2500.0);