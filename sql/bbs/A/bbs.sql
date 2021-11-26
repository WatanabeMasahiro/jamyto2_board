create table bbs (
  id int AUTO_INCREMENT PRIMARY KEY,
  data_time BIGINT,
  author VARCHAR(64),
  subject VARCHAR(255),
  body TEXT
);

insert into bbs (data_time, author, subject, body)
values (0, 'ソクラテス', '知らないことは', 'わからな～い');

ALTER TABLE bbs RENAME COLUMN data_time to date_time;

ALTER TABLE bbs add password varchar(20);
ALTER TABLE bbs add edit_date_time BIGINT;

ALTER TABLE bbs MODIFY password VARCHAR(225);

ALTER TABLE bbs add password_set BOOLEAN NOT NULL;
ALTER TABLE bbs DROP COLUMN password_set;
ALTER TABLE bbs add password_set BOOLEAN;

ALTER TABLE bbs add parent_id int default 0;