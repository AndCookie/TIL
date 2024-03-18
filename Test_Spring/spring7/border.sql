-- 회원전용 게시판 설계
-- 2023년 5월30일

DROP TABLE members;
DROP TABLE reply;
DROP TABLE board;

DROP SEQUENCE reply_seq;
DROP SEQUENCE board_seq;


-- 1) 회원 테이블
CREATE TABLE members
(
    memberid    VARCHAR2(20)    PRIMARY KEY,   -- 사용자 식별용 ID
    memberpwd   VARCHAR2(100)   NOT NULL,      -- 사용자 비밀번호
    membername  VARCHAR2(30)    NOT NULL,      -- 사용자 이름
    email       VARCHAR2(50),                  -- 사용자 이메일
    phone       VARCHAR2(50),                  -- 사용자 전화번호
    address     VARCHAR2(200),                 -- 사용자 주소
    enabled     NUMBER(1) DEFAULT 1 CHECK(enabled IN(0,1)), -- 계정 상태 (1:사용가능 / 0:휴면상태)
    rolename    VARCHAR2(20) DEFAULT 'ROLE_USER' CHECK(rolename IN('ROLE_USER', 'ROLE_ADMIN')) -- 사용자의 역할 구분
);

-- 2) 게시판 테이블
CREATE TABLE board
(
    boardseq     NUMBER          PRIMARY KEY,     -- 게시글 번호
    memberid     VARCHAR2(20),                    -- 글쓴이 ID
    title        VARCHAR2(200)   DEFAULT '제목없음' NOT NULL, -- 글 제목
    boardtext    VARCHAR2(3000)  NOT NULL,        -- 글 내용
    regdate      DATE            DEFAULT SYSDATE, -- 작성일
    hitcount     NUMBER          DEFAULT 0,       -- 조회수
    originalfile VARCHAR2(200),                   -- 첨부파일의 원래 이름
    savedfile    VARCHAR2(200)                   -- 첨부파일이 서버에 저장될 때의 파일명
);

-- 3) 게시글 번호를 위한 시퀀스 객체
CREATE SEQUENCE board_seq;


-- 4) 댓글 테이블
CREATE TABLE reply
(
    replyseq    NUMBER PRIMARY KEY,            -- 댓글 번호
    boardseq    NUMBER REFERENCES board(boardseq) ON DELETE CASCADE,   -- 참고하는 게시글 번호
    memberid    VARCHAR2(2),                 -- 댓글 작성자
    replytext   VARCHAR2(1000) NOT NULL,    -- 댓글 내용
    regdate     DATE DEFAULT SYSDATE        -- 댓글 작성일
);

-- 5) 댓글 번호를 위한 시퀀스 객체
CREATE SEQUENCE reply_seq;