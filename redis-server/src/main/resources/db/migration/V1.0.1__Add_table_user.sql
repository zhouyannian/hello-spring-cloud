use `flyway`;
CREATE TABLE if not exists `sys_user`
(
    `user_id`         int(10) unsigned NOT NULL AUTO_INCREMENT,
    `username`        varchar(100)     NOT NULL unique,
    `encode_password` varchar(100)     NOT NULL,
    `age`             int(3)           NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

insert into flyway.sys_user
values (1, 'Felordcn', '{noop}12345', 18);