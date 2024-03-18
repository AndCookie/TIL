
/* Drop Tables */

DROP TABLE IDOL_FAN_CLUB CASCADE CONSTRAINTS;
DROP TABLE IDOL_MEMBER CASCADE CONSTRAINTS;
DROP TABLE IDOL_TEAM CASCADE CONSTRAINTS;
DROP TABLE AGENCY CASCADE CONSTRAINTS;
-- CONSTRAINTS도 같이 삭제하도록 함



/* Create Tables */

CREATE TABLE AGENCY
(
	AGENCY_ID number NOT NULL, -- AGENCY 아이디
	AGENCY_NAME varchar2(50) UNIQUE, -- 소속사명
	CEO varchar2(20) NOT NULL, -- 대표명
	TEL varchar2(20) NOT NULL, -- 대표전화
	STOCK char(1) DEFAULT 'N', -- 상장여부
	FOUNDED_YEAR number(4), -- 설립연도
	IDOL_TEAM_COUNT number(3) DEFAULT 1, -- 관리하는 아이돌 팀 수
	PRIMARY KEY (AGENCY_ID)
    -- 컬럼 레벨 라벨조건이 아닌, 테이블 레벨 라벨조건이라 아래에 명시
);


CREATE TABLE IDOL_FAN_CLUB
(
	-- 팬클럽명
	CLUB_NAME varchar2(20) NOT NULL,
	PAY number DEFAULT 50000,
	-- 상징색
	COLOR varchar2(30),
	-- 팬클럽_회원수
	FAN_CNT number DEFAULT 0,
	-- 팀을 관리하기 위한 기본키
	TEAM_ID number NOT NULL,
	PRIMARY KEY (CLUB_NAME)
);


CREATE TABLE IDOL_MEMBER
(
	-- 아이돌_번호
	IDOL_ID number NOT NULL,
	-- 팀명
	TEAM_NAME varchar2(50),
	-- 아이돌 이름
	IDOL_NAME varchar2(50),
	-- 생일
	BIRTHDAY date,
	-- 국적
	COUNTRY varchar2(30),
	POSITIONS varchar2(30),
	-- 성별
	GENDER char(1),
	-- 팀을 관리하기 위한 기본키
	TEAM_ID number NOT NULL,
	PRIMARY KEY (IDOL_ID)
);


CREATE TABLE IDOL_TEAM
(
	-- 팀을 관리하기 위한 기본키
	TEAM_ID number NOT NULL,
	-- 팀명
	TEAM_NAME varchar2(50),
	-- 멤버수
	MEMBER_CNT number,
	LEADER char(1),
	-- 데뷔일
	DEBUTE_DATE date,
	-- AGENCY 아이디
	AGENCY_ID number NOT NULL,
	PRIMARY KEY (TEAM_ID)
);



/* Create Foreign Keys */

ALTER TABLE IDOL_TEAM
	ADD FOREIGN KEY (AGENCY_ID)
	REFERENCES AGENCY (AGENCY_ID)
;


ALTER TABLE IDOL_FAN_CLUB
	ADD FOREIGN KEY (TEAM_ID)
	REFERENCES IDOL_TEAM (TEAM_ID)
;


ALTER TABLE IDOL_MEMBER
	ADD FOREIGN KEY (TEAM_ID)
	REFERENCES IDOL_TEAM (TEAM_ID)
;



