CREATE TABLE `BOARD` (
	`board_no`	BIGINT	NOT NULL,
	`user_no`	INT	NOT NULL,
	`board_title`	VARCHAR(256)	NULL,
	`bord_content`	LONGTEXT	NULL,
	`create_date`	DATETIME	NULL,
	`del_yn`	TINYINT	NULL
);

CREATE TABLE `SSO_LOGIN` (
	`sso_login_id`	INT	NOT NULL,
	`user_no`	INT	NOT NULL,
	`social_code`	TINYINT	NULL,
	`external_id`	VARCHAR(256)	NULL,
	`access_token`	VARCHAR(256)	NULL,
	`modify_date`	DATETIME	NULL
);

CREATE TABLE `MEMBER` (
	`user_no`	INT	NOT NULL,
	`login_id`	VARCHAR(256)	NULL,
	`user_name`	VARCHAR(256)	NULL,
	`password`	VARCHAR(256)	NULL,
	`email`	VARCHAR(128)	NULL,
	`gender`	TINYINT	NULL,
	`birtthday`	VARCHAR(128)	NULL,
	`cell_phone`	VARCHAR(128)	NULL,
	`gen_date`	DATETIME	NULL,
	`modify_date`	DATETIME	NULL,
	`user_status`	TINYINT	NULL
);

ALTER TABLE `BOARD` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`board_no`
);

ALTER TABLE `SSO_LOGIN` ADD CONSTRAINT `PK_SSO_LOGIN` PRIMARY KEY (
	`sso_login_id`,
	`user_no`
);

ALTER TABLE `MEMBER` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`user_no`
);

ALTER TABLE `SSO_LOGIN` ADD CONSTRAINT `FK_MEMBER_TO_SSO_LOGIN_1` FOREIGN KEY (`user_no`)REFERENCES `MEMBER` (`user_no`);

