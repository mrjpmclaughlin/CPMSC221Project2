CREATE TABLE ORDERS (
                          Order_ID int NOT NULL PRIMARY KEY,
                          Order_Price int NOT NULL,
                          Order_Date_TIME TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          Item_Name VARCHAR(50) NOT NULL
);