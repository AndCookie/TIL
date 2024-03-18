/* 4��27��

********** SEQUENCE �����ϱ� **********
- �Ϸù�ȣ �ڵ� ���� ��ü
- �߻� �Ӽ� : NEXTVAL
- ��ȣ Ȯ�� : CURRVAL
CREATE SEQUENCE ��������; (�ǰ� : ���̺��_SEQ // ex) BOARD_SEQ)
****************************************

********** ��Ŭ������ ERD �׸��� **********
1) ERMaster �÷����� ��ġ
    - Eclipse > help > NewInstallSoftware > Add
      > NAME : ERMaster & LOCATION : http://ermaster.sourceforge.net/update-site
      > ADD > �׸�Ŭ�� > NEXT > NEXT > I accept the terms of the license agreements
      > FINISH > �ǿ����ϴܿ� Installing Software ���� > Warning���� InstallAnyway > RESTART NOW
    - https://ermaster.sourceforge.net/ �����Ͽ� USER MANUAL �̿��ϱ�
2) Eclipse �缳ġ
    - eclipse.org ���� > DOWNLOAD ��� Ŭ��
    - DOWNLOAD PACKAGES!!! > Eclipse IDE for Enterprise Java and Web Developers
      > Windows x86_64 > FILE �����۸�ũ Ŭ�� > �ٿ�ε�
      > C:\Users\user\Downloads\eclipse-jee-~�� ���� ����

3) ����
    - IDOL PROJECT���� ��Ŭ�� > NEW > OTHER > ERMaster > NEXT
      > FILE_NAME : idol > NEXT > ORACLE ���� > ���̺� ���� Ŭ��

4) ���̺� ����
    - ������ : AGENCY
    - ���� : AGENCY // �츮�� ���ϰ� ���� ���� �뵵�̹Ƿ� �ѱ۵� ����
    - (�÷�) �߰�
        1) ������: AGENCY_ID // ���� : number // ���� : AGENCY ���̵� // �⺻Ű Ŭ�� (PK : PK�� NN �ڵ���)
    - OK Ŭ��

DOWNLOAD PACKAGES!!! >
****************************************




-- [����] KPOP ���̺� �����ϱ�
-- ���̵� ���� & �Ҽӻ� ���� * ��Ŭ�� ������ ������ ���̺� �����ϱ�
������ ���̺� : �Ҽӻ�
�θ� ���̺� : ���̵�
�ڽ� ���̺� : ��Ŭ��
-- �Ҽӻ��� FK�� ���̵��� PK�̹Ƿ� & ���̵��� FK�� ��Ŭ���� PK�̹Ƿ�
-- �Ҽӻ�� ���̵��� �ϴ�� �ܰ�
-- ���̵��� ��Ŭ���� �ϴ��� ���� (��ǥ�Ҵ�)

-- (���̺�) �Ҽӻ� ������ �÷� ���� - �θ�
���̺� �� : AGENCY
AGENCY_ID(NUMBER): PK
AGENCY_NAME(VARCHAR2(50)): �Ҽӻ�� UQ
CEO(VARCHAR2(20)) : ��ǥ�� NN
TEL(VARCHAR2(20)) : ��ǥ��ȭ NN
STOCK(CHAR(1)) : ���忩�� ('Y', 'N') DEFAULT 'N'
FOUNDED_YEAR(NUMBER(4)) : �������� 
IDOL_TEAM_COUNT(NUMBER(3)) : �����ϴ� ���̵� �� �� DEFAULT 1


���̺� �� : IDOL_TEAM
TEAM_ID(NUMBER) : PK
TEAM_NAME(VARCHAR2(50)) : ����
MEMBER_CNT
LEADER(CHAR(1)) : ������ ('Y', 'N')
DEBUT_DATE(DATE) : ������
AGENCY_ID(NUMBER) : FK

-- (���̺�)���̵� �׷������� �����ϰ��� �ϴ� �÷� ���� (�ڽ�) (�θ�)
���̺�� : IDOL_MEMBER
IDOL_ID(NUMBER) : PK
TEAM_NAME(VARCHAR2(50)) : ����(BTS)
IDOL_NAME(VARCHAR2(50)) : ���̵� �̸� (����̸�)
BIRTHDAY(DATE) : ���� �������
COUNTRY(VARCHAR2(30)) : ����
POSITIONS(VARCHAR2(30)) : ���� (��: ����, ��, ��, ���־�)
GENDER(CHAR(1)) : ���� ('M', 'F')
TEAM_ID(NUMBER) : FK

-- (���̺�) ��Ŭ�� ���� (�ڽ�)
���̺��:IDOL_FAN_CLUB
CLUB_NAME(VARCHAR2(20)) : ��Ŭ���� PK
PAY(NUMBER) : ���Ժ� DEFAULT 50000
COLOR(VARCHAR2(30)) : ��Ŭ�� ����
FAN_CNT(NUMBER) : ��Ŭ�� ȸ�� �� DEFAULT 0
TEAM_ID(NUMBER) : FK
*/

DROP TABLE IDOL_FAN_CLUB;
DROP TABLE IDOL_MEMBER;
DROP TABLE IDOL_TEAM;
DROP TABLE AGENCY;

DROP SEQUENCE AGENCY_SEQ;
DROP SEQUENCE IDOL_MEMBER_SEQ;





CREATE TABLE AGENCY
( -- �Ҽӻ��ȣ �Ҽӻ�� ��ǥ�� ��ǥ��ȭ ���忩�� �������� �����ϴ¾��̵�����
    AGENCY_ID    NUMBER       CONSTRAINTS AGENCY_ID_PK PRIMARY KEY,
    AGENCY_NAME  VARCHAR2(50) CONSTRAINTS AGENCY_NAME_UQ UNIQUE, -- UNIQUE�� NOT NULL ���ԵǾ� ����
    CEO          VARCHAR2(20) CONSTRAINTS AGENCY_CEO_NN NOT NULL,
    TEL          VARCHAR2(20) CONSTRAINTS AGENCY_TEL_NN NOT NULL,
    STOCK        CHAR(1)      DEFAULT 'N' CONSTRAINTS AGENCY_STOCK_CK CHECK (STOCK IN ('Y', 'N')),
    FOUNDED_YEAR NUMBER(4), -- INSERT�� ������ �ڵ����� NULL�� �Էµ�
    IDOL_TEAM_COUNT NUMBER(3)    DEFAULT 1
);
-- ������ ��ü ���� (1~)
CREATE SEQUENCE AGENCY_SEQ;

SELECT *
FROM AGENCY;


-- ������ �߰�1
INSERT INTO AGENCY
(AGENCY_ID, AGENCY_NAME, CEO, TEL, FOUNDED_YEAR, IDOL_TEAM_COUNT)
VALUES
(AGENCY_SEQ.NEXTVAL, 'KITA ENT', '�������', '02-111-8888', 2023, 5);

-- ������ �߰�2
INSERT INTO AGENCY
(AGENCY_ID, AGENCY_NAME, CEO, TEL, FOUNDED_YEAR, IDOL_TEAM_COUNT, STOCK)
VALUES
(AGENCY_SEQ.NEXTVAL, '(��)SM', '�̼���', '02-333-0000', 1990, 20, 'Y');

-- ���� ������ Ȯ��
SELECT AGENCY_SEQ.CURRVAL
FROM DUAL;

-- ������ ��ȸ
SELECT * FROM AGENCY;

COMMIT;



CREATE TABLE IDOL_TEAM
( -- ����ȣ ���� ����� �������� ������)
  TEAM_ID    NUMBER  PRIMARY KEY,
  TEAM_NAME  VARCHAR2(50),
  MEMBER_CNT NUMBER(2),
  LEADER     CHAR(1) DEFAULT 'N' CHECK (LEADER IN('Y', 'N')),
  DEBUT_DATE DATE,
  AGENCY_ID  NUMBER REFERENCES AGENCY(AGENCY_ID)
 );





CREATE TABLE IDOL_MEMBER
( -- �з���ȣ �׷�� ��Ƽ��Ʈ�� ������ ������� ���� ���� ���� ���� �Ҽӻ��ȣ
    IDOL_ID     NUMBER       CONSTRAINTS IDOL_ID_PK PRIMARY KEY,
    TEAM_NAME   VARCHAR2(50) CONSTRAINTS IDOL_TEAM_NN  NOT NULL,
    IDOL_NAME   VARCHAR2(50) CONSTRAINTS IDOL_NAME_NN  NOT NULL,    
    BIRTHDAY    DATE,
    COUNTRY     VARCHAR2(30),
    POSITIONS   VARCHAR2(30),
    GENDER      CHAR(1)      CONSTRAINTS IDOL_GENDER_CK CHECK (GENDER IN ('M', 'F')),
    TEAM_ID     NUMBER       REFERENCES IDOL_TEAM(TEAM_ID) ON DELETE CASCADE
);

-- ������ ��ü ���� (1~)
CREATE SEQUENCE IDOL_MEMBER_SEQ;

SELECT *
FROM IDOL_MEMBER;

DROP TABLE IDOL_MEMBER;

INSERT INTO IDOL_MEMBER
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (1, '����ũ', '����', 25, '95/01/01');

INSERT INTO IDOL_MEMBER
VALUES (2, '����ũ', '����', 27, 'Vietnam', '93/01/01');

INSERT INTO IDOL_MEMBER
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (3, '���座��', '���̸�', 31, '89/01/01');

INSERT INTO IDOL_MEMBER
VALUES (4, '���座��', '����', 28, 'America', '92/01/01' );

COMMIT;





CREATE TABLE IDOL_FAN_CLUB
( -- ��Ŭ���� ���Ժ� ���� ȸ���� ����ȣ
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
VALUES (1, '����ũ', 'BP');

INSERT INTO IDOL_FAN_CLUB
VALUES (2, '����ũ', '��ũ', 1800000);

INSERT INTO IDOL_FAN_CLUB
VALUES (3, '���座��', 'LEVEL', 98765);

COMMIT;



-- INNER JOIN�� �̿��Ͽ� ��ȸ�ϱ�
SELECT ROWNUM, GROUP_NAME, SOLO_NAME, AGE, COMP_NAME, FAN_NAME, FAN_CNT
FROM IDOL INNER JOIN AGENCY
USING (GROUP_NAME)
JOIN IDOL_FAN_CLUB
USING (GROUP_NAME);


