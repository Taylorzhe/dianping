CREATE TABLE `dianpingdb`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`created_at` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00',
`updated_at` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00',
`telephone` VARCHAR(40) NOT NULL DEFAULT '',
`password` VARCHAR(200) NOT NULL DEFAULT '',
`nick_name` VARCHAR(40) NOT NULL DEFAULT '',
`gender` INT NOT NULL DEFAULT 0,
PRIMARY KEY (`id`),
UNIQUE INDEX `telphone_unique_index` (`telephone`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `dianpingdb`.`seller`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '',
  `created_at` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `disabled_flag` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);
