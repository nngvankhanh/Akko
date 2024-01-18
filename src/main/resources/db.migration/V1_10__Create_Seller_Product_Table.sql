CREATE TABLE IF NOT EXISTS `SELLER_PRODUCT`(
                                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       ID_SELLER BIGINT,
                                       ID_PRODUCT BIGINT,
                                       FOREIGN KEY (ID_SELLER) REFERENCES SELLER(ID),
                                       FOREIGN KEY (ID_PRODUCT) REFERENCES PRODUCT(ID)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;