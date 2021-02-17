DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
 `id`          VARCHAR(32) NOT NULL COMMENT '主键',
 `name`        VARCHAR(32) NOT NULL COMMENT '学生姓名',
 `gender`      TINYINT(1) NOT NULL COMMENT '性别，0：未知，1：男，2：女',
 `age`         VARCHAR(64) NOT NULL COMMENT '年龄',
 `phone_number` VARCHAR(16) NOT NULL COMMENT '学生手机号',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;