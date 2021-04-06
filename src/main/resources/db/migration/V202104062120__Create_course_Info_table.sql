DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `id`         VARCHAR(32) NOT NULL COMMENT '主键',
    `student_id` VARCHAR(32) NOT NULL COMMENT '学生id',
    `name`       VARCHAR(32) NOT NULL COMMENT '课程名称',
    `semester`   VARCHAR(32) NOT NULL COMMENT '课程所上学期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;