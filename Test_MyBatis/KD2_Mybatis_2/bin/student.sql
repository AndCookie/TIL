
drop table school_score;
drop table school_student;

-- 1) 학생 정보 테이블 : school_student
CREATE TABLE school_student
(
	stnum	VARCHAR2(10)	PRIMARY KEY,
	stclass CHAR(1)			DEFAULT 'A' CHECK (stclass in('A', 'B', 'C')),
	stname  VARCHAR2(20)    NOT NULL
);


-- 2) 성적 테이블 : school_score
CREATE TABLE school_score
(
	stnum	VARCHAR2(10)	UNIQUE REFERENCES school_student(stnum) ON DELETE CASCADE,
	java    NUMBER(3)		DEFAULT 0,
	sql     NUMBER(3)		DEFAULT 0,
	spring  NUMBER(3)		DEFAULT 0
);


