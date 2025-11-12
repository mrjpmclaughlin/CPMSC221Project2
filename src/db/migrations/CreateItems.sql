CREATE TABLE ITEMS (
                       ITEM_ID int NOT NULL PRIMARY KEY,
                       NAME VARCHAR(50) NOT NULL,
                       CATEGORY VARCHAR(30),
                       PRICE DECIMAL(6,2) NOT NULL,
                       AVAILABLE BOOLEAN DEFAULT TRUE
);