CREATE TABLE IF NOT EXISTS CART(
                                      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      SIZE VARCHAR(255) NOT NULL,
                                      COLOR VARCHAR(255) NOT NULL,
                                      QUANTITY INT NOT NULL,
                                      ID_PRODUCT BIGINT,
                                      ID_USER BIGINT,
                                      FOREIGN KEY(ID_PRODUCT) REFERENCES PRODUCT(ID),
                                      FOREIGN KEY(ID_USER) REFERENCES USER(ID)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;