-- test5용 테이블

DROP TABLE cashbook_member;
DROP TABLE cashbook_info;
DROP SEQUENCE cashbook_seq;

CREATE TABLE cashbook_member
(
    memberid    VARCHAR2(20)    PRIMARY KEY,
    memberpw    VARCHAR2(100)   NOT NULL,
    membername  VARCHAR2(20)    NOT NULL,
    enabled     NUMBER(1)       DEFAULT 1,
    rolename    VARCHAR2(20)    DEFAULT 'ROLE_USER'
);

CREATE TABLE cashbook_info
(
    infonum     NUMBER          PRIMARY KEY,
    memberid    VARCHAR2(20)    NOT NULL REFERENCES cashbook_member(memberid) ON DELETE CASCADE,
    type        VARCHAR2(20)    NOT NULL,
    memo        VARCHAR2(1000)  NOT NULL,
    amount      NUMBER          DEFAULT 0,
    inputdate   DATE            DEFAULT SYSDATE
);

CREATE SEQUENCE cashbook_seq;

SELECT * FROM cashbook_member;




SELECT DISTINCT TO_CHAR(tb.inputdate, 'YYYY') as YEAR,
    (SELECT SUM(amount) FROM cashbook_info WHERE memberid=#{memberid} AND type='지출'AND TO_CHAR(tb.inputdate, 'YYYY') = tb.inputdate) as outtotal,
    (SELECT SUM(amount) FROM cashbook_info WHERE memberid=#{memberid} AND type='수입'AND TO_CHAR(tb.inputdate, 'YYYY') = tb.inputdate) as intotal
FROM cashbook_info tb
WHERE memberid=#{memberid}
ORDER BY YEAR