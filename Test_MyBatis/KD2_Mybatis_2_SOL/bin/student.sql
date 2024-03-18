-- 42기 1차 역량평가 재평가
drop table school_score;
drop table school_student;

-- 학생 정보 테이블
create table school_student (
	stnum 	varchar2(10) primary key,	--학생 구분번호
	stclass	char(1) default 'A' check (stclass in ('A', 'B', 'C')),		--반
	stname	varchar2(20) not null		--이름
);

-- 성적 테이블
create table school_score (
	stnum	varchar2(10) unique references school_student(stnum) on delete cascade,		--학생 구분번호
	java	number(3) default 0,		--java과목 점수
	sql		number(3) default 0,		--sql과목 점수
	spring	number(3) default 0			--spring과목 점수
	
);

