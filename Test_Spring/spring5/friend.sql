-- 2023년 5월 26일
-- spring5에서 작업

DROP TABLE friend;

CREATE TABLE friend
(
	fname   VARCHAR2(30) NOT NULL,
	age		NUMBER(3)	 DEFAULT 0,
	phone	VARCHAR2(15) UNIQUE,
	active  CHAR(1)		 DEFAULT '1'	
);

SELECT * FROM friend;