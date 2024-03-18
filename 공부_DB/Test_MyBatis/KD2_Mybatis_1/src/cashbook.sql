-- 필요한 테이블과 시퀀스를 생성

DROP TABLE cashitems;
DROP TABLE cashbook;
DROP SEQUENCE cashbook_seq;

CREATE TABLE cashitems
(
	itemid		VARCHAR2(5)		PRIMARY KEY,
	itemname	VARCHAR2(100)	NOT NULL
);


CREATE TABLE cashbook
(
	seq			NUMBER			PRIMARY KEY,
	dates		DATE			DEFAULT SYSDATE,
	itemid		VARCHAR2(5)		REFERENCES cashitems(itemid),
	detail		VARCHAR2(100)	NOT NULL,
	amount		NUMBER,
	note		VARCHAR2(300)
);

CREATE SEQUENCE cashbook_seq;



-- 아래의 샘플 데이터를 입력한다.
INSERT INTO cashitems VALUES(1, '식비');
INSERT INTO cashitems VALUES(2, '문화예술');
INSERT INTO cashitems VALUES(3, '미용(의복)');
INSERT INTO cashitems VALUES(4, '교통비');
INSERT INTO cashitems VALUES(5, '경조사비');
INSERT INTO cashitems VALUES(6, '금융(저축 등)');
INSERT INTO cashitems VALUES(7, '기타');

commit;
