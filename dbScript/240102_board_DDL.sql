CREATE TABLE `board` (
	`board_no`	BIGINT	NOT NULL,
	`user_no`	INT	NOT NULL,
	`board_title`	VARCHAR(256)	NULL,
	`board_content`	LONGTEXT	NULL,
    `modify_date`	DATETIME	NULL,
	`create_date`	DATETIME	NULL,
	`del_yn`	TINYINT	NULL
);

CREATE TABLE `sso_login` (
	`sso_login_id`	INT	NOT NULL,
	`user_no`	INT	NOT NULL,
	`social_code`	TINYINT	NULL,
	`external_id`	VARCHAR(256)	NULL,
	`access_token`	VARCHAR(256)	NULL,
	`modify_date`	DATETIME	NULL,
    `create_date`	DATETIME	NULL
);

CREATE TABLE `member` (
	`user_no`	INT	NOT NULL,
	`login_id`	VARCHAR(256)	NULL,
	`user_name`	VARCHAR(256)	NULL,
	`password`	VARCHAR(256)	NULL,
	`email`	VARCHAR(128)	NULL,
	`gender`	TINYINT	NULL,
	`birtthday`	VARCHAR(128)	NULL,
	`cell_phone`	VARCHAR(128)	NULL,
	`modify_date`	DATETIME	NULL,
	`create_date`	DATETIME	NULL,
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
