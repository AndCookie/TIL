
/* Drop Tables */

DROP TABLE IDOL_FAN_CLUB CASCADE CONSTRAINTS;
DROP TABLE IDOL_MEMBER CASCADE CONSTRAINTS;
DROP TABLE IDOL_TEAM CASCADE CONSTRAINTS;
DROP TABLE AGENCY CASCADE CONSTRAINTS;
-- CONSTRAINTS�� ���� �����ϵ��� ��



/* Create Tables */

CREATE TABLE AGENCY
(
	-- AGENCY ���̵�
	AGENCY_ID number NOT NULL,
	-- �Ҽӻ��
	AGENCY_NAME varchar2(50) UNIQUE,
	-- ��ǥ��
	CEO varchar2(20) NOT NULL,
	-- ��ǥ��ȭ
	TEL varchar2(20) NOT NULL,
	-- ���忩��
	STOCK char(1) DEFAULT 'N' CHECK (STOCK IN ('Y', 'N')),
	-- ��������
	FOUNDED_YEAR number(4),
	-- �����ϴ� ���̵� �� ��
	IDOL_TEAM_COUNT number(3) DEFAULT 1,
	PRIMARY KEY (AGENCY_ID)
);


CREATE TABLE IDOL_FAN_CLUB
(
	-- ��Ŭ����
	CLUB_NAME varchar2(20) NOT NULL,
	PAY number DEFAULT 50000,
	-- ��¡��
	COLOR varchar2(30),
	-- ��Ŭ��_ȸ����
	FAN_CNT number DEFAULT 0,
	-- ���� �����ϱ� ���� �⺻Ű
	TEAM_ID number NOT NULL,
	PRIMARY KEY (CLUB_NAME)
);


CREATE TABLE IDOL_MEMBER
(
	-- ���̵�_��ȣ
	IDOL_ID number NOT NULL,
	-- ����
	TEAM_NAME varchar2(50),
	-- ���̵� �̸�
	IDOL_NAME varchar2(50),
	-- ����
	BIRTHDAY date,
	-- ����
	COUNTRY varchar2(30),
	POSITIONS varchar2(30),
	-- ����
	GENDER char(1) CHECK (GENDER IN ('M', 'F')),,
	-- ���� �����ϱ� ���� �⺻Ű
	TEAM_ID number NOT NULL,
	PRIMARY KEY (IDOL_ID)
);


CREATE TABLE IDOL_TEAM
(
	-- ���� �����ϱ� ���� �⺻Ű
	TEAM_ID number NOT NULL,
	-- ����
	TEAM_NAME varchar2(50),
	-- �����
	MEMBER_CNT number,
	LEADER char(1) CHECK (LEADER IN('Y', 'N')),
	-- ������
	DEBUTE_DATE date,
	-- AGENCY ���̵�
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



