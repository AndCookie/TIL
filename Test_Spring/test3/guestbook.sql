-- test3에서 작업
-- 방명록 테이블
DROP TABLE guestbook;
DROP SEQUENCE guestbook_seq;

CREATE TABLE guestbook
(
    seq      NUMBER          PRIMARY KEY,           -- 일련번호
    usrname  VARCHAR2(50)    NOT NULL,              -- 글쓴이
    usrpwd   VARCHAR2(20)    NOT NULL,              -- 비밀번호
    text     VARCHAR2(2000)  DEFAULT '다녀갑니다',  -- 글 내용
    regdate  DATE            DEFAULT SYSDATE        -- 글 쓴 날짜
);

CREATE SEQUENCE guestbook_seq;

/*
일련번호	: 		: NUMBER PK 	 SEQUENCE 객체 (guestbook_seq)를 이용
글쓴이	  : usrname	: VARCHAR2(50)	  : NN
비밀번호   : usrpsw	: VARCHAR2(20)	  : NN
글 내용	   : text		: VARCHAR2(2000) : DEFAULT ‘다녀갑니다’
글 쓴 날짜 : regdate	: DATE		  : DEFAULT SYSDATE
*/