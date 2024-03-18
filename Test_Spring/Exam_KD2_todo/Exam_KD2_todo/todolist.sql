-- 2023년 7월 3일 KITA Digital 2기 웹 역량평가

-- 테이블
DROP TABLE todolist;
DROP SEQUENCE todolist_seq;
DROP TABLE person;

-- 제시한 테이블과 시퀀스 생성 코드 기입
 -- 1) 회원 테이블
CREATE TABLE person
(
    todoid    VARCHAR2(50)    PRIMARY KEY,   -- 사용자 식별용 ID
    todopwd   VARCHAR2(100)   NOT NULL,      -- 사용자 비밀번호
    todoname  VARCHAR2(20)    NOT NULL,      -- 사용자 이름
    enabled   NUMBER(1)       DEFAULT 1 CHECK(enabled IN(0,1)), -- 계정 상태 (1:사용가능 / 0:휴면상태)
    rolename  VARCHAR2(20)    DEFAULT 'ROLE_USER' -- 사용자의 역할/권한 구분
);

-- 2) TODO 정보 테이블
CREATE TABLE todolist
(
    seqno      NUMBER          PRIMARY KEY,     -- 일련번호
    todoid     VARCHAR2(50)    REFERENCES person(todoid) ON DELETE CASCADE, -- 참고하는 아이디
    regdate    DATE            DEFAULT SYSDATE, -- 작성일
    status     VARCHAR2(10)    CHECK(status IN('완료', '진행', '지연')), -- 진행 상태
    importance VARCHAR2(10)    CHECK(importance IN('높음', '보통', '낮음')), -- 중요도
    categories VARCHAR2(6)     DEFAULT '개인' CHECK(categories IN('개인', '회사')), -- TODO 종류
    todo       VARCHAR2(3000)  DEFAULT '할일 없음' -- 할일 정보
);

-- 3) TODO 일련번호를 위한 시퀀스 객체
CREATE SEQUENCE todolist_seq;