CREATE SCHEMA IF NOT EXISTS `hotelmg` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `hotelmg`;

CREATE TABLE IF NOT EXISTS branch
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                  -- 支店ID
    `branch_code`               VARCHAR(40) NOT NULL,			                 -- 支店コード
    `branch_name`               VARCHAR(100) NOT NULL,                    		 -- 支店名
    `device_register_code`      VARCHAR(80) NOT NULL UNIQUE,                     -- デバイス登録コード
    `create_user_id`            INT,                                             -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    -- 登録日時
    `update_user_id`            INT,                                             -- 更新ユーザ
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    -- 更新日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                   -- 削除フラグ
);

CREATE TABLE IF NOT EXISTS version
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                  -- バージョンID
    `version_no`                VARCHAR(10) NOT NULL,                            -- バージョンNo.
    `device_type`               INT NOT NULL,                                    -- アプリ種類
    `file_key`                  VARCHAR(512) NOT NULL,                           -- アプリファイル
    `change_point`              VARCHAR(256),                                    -- 変更点
    `create_user_id`            INT,                                             -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    -- 登録日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                   -- 削除フラグ
);

CREATE TABLE IF NOT EXISTS `user`
(
    `id`                        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,        -- ユーザID
    `password`                  VARCHAR(100) NOT NULL,                          -- パスワード
    `full_name`                 VARCHAR(100) NOT NULL,                          -- ユーザー名
    `email`                     VARCHAR(100) NOT NULL,                          -- メードアドレス
    `user_role`                 INT NOT NULL,
    `branch_id`                 INT DEFAULT NULL,                               -- 支店ID
    `create_user_id`            INT,                                            -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 登録日時
    `update_user_id`            INT,                                            -- 更新ユーザ
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 更新日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                  -- 削除フラグ
);

CREATE TABLE IF NOT EXISTS custody_cert
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                 -- 預り証ID
    `guest_name`                VARCHAR(100) NOT NULL,                          -- ゲスト名
    `guest_tel_no`              VARCHAR(12),                                    -- 電話番号
    `delivery_slip_no`          VARCHAR(100)         ,                          -- 送り状伝票
    `guest_baggage_number`      INT NOT NULL,                                   -- 荷物個数
    `note`                      TEXT,                                           -- 備考
    `type`                      INT NOT NULL,                                   -- 預かりタイプ
    `branch_id`                 INT NOT NULL,                                   -- 支店ID
    `room_number`				VARCHAR(40),							        -- 部屋番号
    `check_in_date`				DATE NULL DEFAULT NULL,                         -- チェックイン日
    `reservation_no`			VARCHAR(100),									-- 予約番号
    `qrcode_id`                 VARCHAR(100) NOT NULL UNIQUE,                   -- QRコードID
    `create_user_id`            INT,                                            -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 登録日時
    `update_user_id`            INT,                                            -- 更新ユーザ
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 更新日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                  -- 削除フラグ
);

CREATE TABLE IF NOT EXISTS baggage_tag
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                 -- 荷物タグID
    `baggage_tag_name`          VARCHAR(100) NOT NULL,                          -- プラスチックタグに書かれたタグ識別名
    `branch_id`                 INT NOT NULL,                                   -- 支店ID
    `create_user_id`            INT,                                            -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 登録日時
    `update_user_id`            INT,                                            -- 更新ユーザ
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 更新日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                  -- 削除フラグ
);

CREATE TABLE IF NOT EXISTS shelf
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                 -- 棚ID
    `shelf_name`                VARCHAR(100) NOT NULL,                          -- 棚の識別名
    `shelf_type`				INT NOT NULL,									-- Type Shelf
    `branch_id`                 INT NOT NULL,                                   -- 支店ID
    `create_user_id`            INT,                                            -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 登録日時
    `update_user_id`            INT,                                            -- 更新ユーザ
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 更新日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                  -- 削除フラグ
);

CREATE TABLE IF NOT EXISTS baggage_tag_custody_cert_shelf
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                 -- ID
    `custody_cert_id`           INT NOT NULL,                                   -- 預り証ID
    `baggage_tag_id`            INT NOT NULL,                                   -- 荷物タグID
    `shelf_id`                  INT DEFAULT NULL,                               -- 棚ID
    `branch_id`                 INT NOT NULL,                                   -- 支店ID
    `status`                    INT NOT NULL,                                   -- ステータス
    `leave_date`                TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 預り日時
    `return_date`               TIMESTAMP NULL DEFAULT NULL,                    -- 返却日時
    `staff_name`    			VARCHAR(100) NOT NULL,                          -- 担当者名(クローク担当者
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP    -- 更新日時
);

CREATE TABLE IF NOT EXISTS device
(
    `id`                        INT PRIMARY KEY AUTO_INCREMENT,                 -- 端末ID
    `device_token`              VARCHAR(256) NOT NULL,
    `device_type`               INT NOT NULL,                                   -- アプリ種類
    `user_agent`                VARCHAR(512),
    `device_name`               VARCHAR(100),                                   -- 端末名
    `branch_id`                 INT NOT NULL,                                   -- 支店ID
    `status`                    INT NOT NULL DEFAULT 0,
    `last_time_access`          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 前回アクセス
    `create_user_id`            INT,                                            -- 登録ユーザ
    `create_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 登録日時
    `update_user_id`            INT,                                            -- 更新ユーザ
    `update_date`               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 更新日時
    `delete_flag`               BOOLEAN NOT NULL DEFAULT FALSE                  -- 削除フラグ
);

-- FOREIGN KEY
ALTER TABLE baggage_tag_custody_cert_shelf ADD FOREIGN KEY (custody_cert_id) REFERENCES custody_cert(id);
ALTER TABLE baggage_tag_custody_cert_shelf ADD FOREIGN KEY (baggage_tag_id) REFERENCES baggage_tag(id);
ALTER TABLE baggage_tag_custody_cert_shelf ADD FOREIGN KEY (shelf_id) REFERENCES shelf(id);
ALTER TABLE baggage_tag_custody_cert_shelf ADD FOREIGN KEY (branch_id) REFERENCES branch(id);


ALTER TABLE user ADD FOREIGN KEY (branch_id) REFERENCES branch(id);
ALTER TABLE custody_cert ADD FOREIGN KEY (branch_id) REFERENCES branch(id);
ALTER TABLE baggage_tag ADD FOREIGN KEY (branch_id) REFERENCES branch(id);
ALTER TABLE shelf ADD FOREIGN KEY (branch_id) REFERENCES branch(id);
ALTER TABLE device ADD FOREIGN KEY (branch_id) REFERENCES branch(id);


-- CREATE INDEX
CREATE INDEX user_email_index ON user (email);
CREATE INDEX device_token_index ON device(device_token);
CREATE INDEX branch_code_index ON branch(branch_code);

CREATE INDEX custody_check_in_date_index ON custody_cert(check_in_date);
CREATE INDEX baggage_tag_custody_cert_shelf_leave_date ON baggage_tag_custody_cert_shelf(leave_date);
CREATE INDEX baggage_tag_custody_cert_shelf_return_date ON baggage_tag_custody_cert_shelf(return_date);