CREATE TABLE IF NOT EXISTS `USER`(
                                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       EMAIL VARCHAR(255),
                                       PASSWORD VARCHAR(255)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;