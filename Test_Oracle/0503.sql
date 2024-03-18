CREATE TABLE userinfo
(
    USERID   VARCHAR2(20) PRIMARY KEY,
    USERNAME VARCHAR2(20) NOT NULL,
    GENDER   VARCHAR2(5) CHECK(GENDER IN ('³²', '¿©')),
    PHONE    VARCHAR2(20),
    BIRTHDAY DATE
);

COMMIT;

SELECT *
FROM userinfo;


CREATE TABLE school_student
(
	stnum	VARCHAR2(10)	PRIMARY KEY,
	stclass CHAR(1)			DEFAULT 'A' CHECK (stclass in('A', 'B', 'C')),
	stname  VARCHAR2(20)    NOT NULL
);

CREATE TABLE school_student
(
	stnum	VARCHAR2(10)	UNIQUE REFERENCES school_student(stnum) ON DELETE CASCADE,
	java    NUMBER(3)		DEFAULT 0,
	sql     NUMBER(3)		DEFAULT 0,
	spring  NUMBER(3)		DEFAULT 0
);

drop table school_score;
drop table school_student;

CREATE TABLE school_score
(
	stnum	VARCHAR2(10)	UNIQUE REFERENCES school_student(stnum) ON DELETE CASCADE,
	java    NUMBER(3)		DEFAULT 0,
	sql     NUMBER(3)		DEFAULT 0,
	spring  NUMBER(3)		DEFAULT 0
);


CREATE TABLE school_student
(
	stnum	VARCHAR2(10)	PRIMARY KEY,
	stclass CHAR(1)			DEFAULT 'A' CHECK (stclass in('A', 'B', 'C')),
	stname  VARCHAR2(20)    NOT NULL
);

CREATE TABLE school_score
(
	stnum	VARCHAR2(10)	UNIQUE REFERENCES school_student(stnum) ON DELETE CASCADE,
	java    NUMBER(3)		DEFAULT 0,
	sql     NUMBER(3)		DEFAULT 0,
	spring  NUMBER(3)		DEFAULT 0
);


SELECT *
FROM school_student st JOIN school_score sc
USING (stnum)
ORDER BY 1;

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