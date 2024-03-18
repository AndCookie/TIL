/* 4월27일

********** SEQUENCE 생성하기 **********
- 일련번호 자동 생성 객체
- 발생 속성 : NEXTVAL
- 번호 확인 : CURRVAL
CREATE SEQUENCE 시퀀스명; (권고 : 테이블명_SEQ // ex) BOARD_SEQ)
****************************************

********** 이클립스에 ERD 그리기 **********
1) ERMaster 플러그인 설치
    - Eclipse > help > NewInstallSoftware > Add
      > NAME : ERMaster & LOCATION : http://ermaster.sourceforge.net/update-site
      > ADD > 네모클릭 > NEXT > NEXT > I accept the terms of the license agreements
      > FINISH > 맨우측하단에 Installing Software 진행 > Warning에서 InstallAnyway > RESTART NOW
    - https://ermaster.sourceforge.net/ 접속하여 USER MANUAL 이용하기
2) Eclipse 재설치
    - eclipse.org 접속 > DOWNLOAD 배너 클릭
    - DOWNLOAD PACKAGES!!! > Eclipse IDE for Enterprise Java and Web Developers
      > Windows x86_64 > FILE 하이퍼링크 클릭 > 다운로드
      > C:\Users\user\Downloads\eclipse-jee-~에 압축 해제

3) 생성
    - IDOL PROJECT에서 우클릭 > NEW > OTHER > ERMaster > NEXT
      > FILE_NAME : idol > NEXT > ORACLE 선택 > 테이블 더블 클릭

4) 테이블 정보
    - 물리명 : AGENCY
    - 논리명 : AGENCY // 우리가 편하게 보기 위한 용도이므로 한글도 ㄱㅊ
    - (컬럼) 추가
        1) 물리명: AGENCY_ID // 형식 : number // 설명 : AGENCY 아이디 // 기본키 클릭 (PK : PK시 NN 자동임)
    - OK 클릭

DOWNLOAD PACKAGES!!! >
****************************************




-- [문제] KPOP 테이블 생성하기
-- 아이돌 정보 & 소속사 정보 * 팬클럽 정보를 저장한 테이블 생성하기
조무보 테이블 : 소속사
부모 테이블 : 아이돌
자식 테이블 : 팬클럽
-- 소속사의 FK가 아이돌의 PK이므로 & 아이돌의 FK가 팬클럽의 PK이므로
-- 소속사와 아이돌은 일대다 단계
-- 아이돌과 팬클럽은 일대일 관계 (대표팬덤)

-- (테이블) 소속사 정보를 컬럼 수집 - 부모
테이블 명 : AGENCY
AGENCY_ID(NUMBER): PK
AGENCY_NAME(VARCHAR2(50)): 소속사명 UQ
CEO(VARCHAR2(20)) : 대표명 NN
TEL(VARCHAR2(20)) : 대표전화 NN
STOCK(CHAR(1)) : 상장여부 ('Y', 'N') DEFAULT 'N'
FOUNDED_YEAR(NUMBER(4)) : 설립연도 
IDOL_TEAM_COUNT(NUMBER(3)) : 관리하는 아이돌 팀 수 DEFAULT 1


테이블 명 : IDOL_TEAM
TEAM_ID(NUMBER) : PK
TEAM_NAME(VARCHAR2(50)) : 팀명
MEMBER_CNT
LEADER(CHAR(1)) : 팀리더 ('Y', 'N')
DEBUT_DATE(DATE) : 데뷔일
AGENCY_ID(NUMBER) : FK

-- (테이블)아이돌 그룹정보를 저장하고자 하는 컬럼 수집 (자식) (부모)
테이블명 : IDOL_MEMBER
IDOL_ID(NUMBER) : PK
TEAM_NAME(VARCHAR2(50)) : 팀명(BTS)
IDOL_NAME(VARCHAR2(50)) : 아이돌 이름 (사람이름)
BIRTHDAY(DATE) : 팀원 생년월일
COUNTRY(VARCHAR2(30)) : 국적
POSITIONS(VARCHAR2(30)) : 역할 (예: 보컬, 랩, 댄스, 비주얼)
GENDER(CHAR(1)) : 성별 ('M', 'F')
TEAM_ID(NUMBER) : FK

-- (테이블) 팬클럽 정보 (자식)
테이블명:IDOL_FAN_CLUB
CLUB_NAME(VARCHAR2(20)) : 팬클럽명 PK
PAY(NUMBER) : 가입비 DEFAULT 50000
COLOR(VARCHAR2(30)) : 팬클럽 색상
FAN_CNT(NUMBER) : 팬클럽 회원 수 DEFAULT 0
TEAM_ID(NUMBER) : FK
*/

DROP TABLE IDOL_FAN_CLUB;
DROP TABLE IDOL_MEMBER;
DROP TABLE IDOL_TEAM;
DROP TABLE AGENCY;

DROP SEQUENCE AGENCY_SEQ;
DROP SEQUENCE IDOL_MEMBER_SEQ;





CREATE TABLE AGENCY
( -- 소속사번호 소속사명 대표명 대표전화 상장여부 설립연도 관리하는아이돌팀수
    AGENCY_ID    NUMBER       CONSTRAINTS AGENCY_ID_PK PRIMARY KEY,
    AGENCY_NAME  VARCHAR2(50) CONSTRAINTS AGENCY_NAME_UQ UNIQUE, -- UNIQUE에 NOT NULL 포함되어 있음
    CEO          VARCHAR2(20) CONSTRAINTS AGENCY_CEO_NN NOT NULL,
    TEL          VARCHAR2(20) CONSTRAINTS AGENCY_TEL_NN NOT NULL,
    STOCK        CHAR(1)      DEFAULT 'N' CONSTRAINTS AGENCY_STOCK_CK CHECK (STOCK IN ('Y', 'N')),
    FOUNDED_YEAR NUMBER(4), -- INSERT때 생략시 자동으로 NULL로 입력됨
    IDOL_TEAM_COUNT NUMBER(3)    DEFAULT 1
);
-- 시퀀스 객체 생성 (1~)
CREATE SEQUENCE AGENCY_SEQ;

SELECT *
FROM AGENCY;


-- 데이터 추가1
INSERT INTO AGENCY
(AGENCY_ID, AGENCY_NAME, CEO, TEL, FOUNDED_YEAR, IDOL_TEAM_COUNT)
VALUES
(AGENCY_SEQ.NEXTVAL, 'KITA ENT', '삼장법사', '02-111-8888', 2023, 5);

-- 데이터 추가2
INSERT INTO AGENCY
(AGENCY_ID, AGENCY_NAME, CEO, TEL, FOUNDED_YEAR, IDOL_TEAM_COUNT, STOCK)
VALUES
(AGENCY_SEQ.NEXTVAL, '(주)SM', '이수만', '02-333-0000', 1990, 20, 'Y');

-- 현재 시퀀스 확인
SELECT AGENCY_SEQ.CURRVAL
FROM DUAL;

-- 데이터 조회
SELECT * FROM AGENCY;

COMMIT;



CREATE TABLE IDOL_TEAM
( -- 팀번호 팀명 멤버수 리더여부 데뷔일)
  TEAM_ID    NUMBER  PRIMARY KEY,
  TEAM_NAME  VARCHAR2(50),
  MEMBER_CNT NUMBER(2),
  LEADER     CHAR(1) DEFAULT 'N' CHECK (LEADER IN('Y', 'N')),
  DEBUT_DATE DATE,
  AGENCY_ID  NUMBER REFERENCES AGENCY(AGENCY_ID)
 );





CREATE TABLE IDOL_MEMBER
( -- 분류번호 그룹명 아티스트명 데뷔일 생년월일 국적 역할 리더 성별 소속사번호
    IDOL_ID     NUMBER       CONSTRAINTS IDOL_ID_PK PRIMARY KEY,
    TEAM_NAME   VARCHAR2(50) CONSTRAINTS IDOL_TEAM_NN  NOT NULL,
    IDOL_NAME   VARCHAR2(50) CONSTRAINTS IDOL_NAME_NN  NOT NULL,    
    BIRTHDAY    DATE,
    COUNTRY     VARCHAR2(30),
    POSITIONS   VARCHAR2(30),
    GENDER      CHAR(1)      CONSTRAINTS IDOL_GENDER_CK CHECK (GENDER IN ('M', 'F')),
    TEAM_ID     NUMBER       REFERENCES IDOL_TEAM(TEAM_ID) ON DELETE CASCADE
);

-- 시퀀스 객체 생성 (1~)
CREATE SEQUENCE IDOL_MEMBER_SEQ;

SELECT *
FROM IDOL_MEMBER;

DROP TABLE IDOL_MEMBER;

INSERT INTO IDOL_MEMBER
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (1, '블랙핑크', '제니', 25, '95/01/01');

INSERT INTO IDOL_MEMBER
VALUES (2, '블랙핑크', '리사', 27, 'Vietnam', '93/01/01');

INSERT INTO IDOL_MEMBER
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (3, '레드벨벳', '아이린', 31, '89/01/01');

INSERT INTO IDOL_MEMBER
VALUES (4, '레드벨벳', '웬디', 28, 'America', '92/01/01' );

COMMIT;





CREATE TABLE IDOL_FAN_CLUB
( -- 팬클럽명 가입비 색상 회원수 팀번호
    CLUB_NAME   VARCHAR2(20) CONSTRAINTS FAN_CN_PK PRIMARY KEY,
    PAY         NUMBER       DEFAULT 50000,
    COLOR       VARCHAR2(30),
    FAN_CNT     NUMBER       DEFAULT 0,
    TEAM_ID     NUMBER       NOT NULL REFERENCES IDOL_TEAM(TEAM_ID) ON DELETE CASCADE
);

SELECT *
FROM IDOL_FAN_CLUB;

DROP TABLE IDOL_FAN_CLUB;

INSERT INTO IDOL_FAN_CLUB
(SEQ_NO, GROUP_NAME, FAN_NAME)
VALUES (1, '블랙핑크', 'BP');

INSERT INTO IDOL_FAN_CLUB
VALUES (2, '블랙핑크', '핑크', 1800000);

INSERT INTO IDOL_FAN_CLUB
VALUES (3, '레드벨벳', 'LEVEL', 98765);

COMMIT;



-- INNER JOIN을 이용하여 조회하기
SELECT ROWNUM, GROUP_NAME, SOLO_NAME, AGE, COMP_NAME, FAN_NAME, FAN_CNT
FROM IDOL INNER JOIN AGENCY
USING (GROUP_NAME)
JOIN IDOL_FAN_CLUB
USING (GROUP_NAME);


