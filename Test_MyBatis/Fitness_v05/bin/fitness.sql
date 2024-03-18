보관용!

-- 2023년 5월2일

DROP TABLE fitness;
DROP SEQUENCE fitness_seq;

CREATE TABLE fitness
(
    seqno       NUMBER       NOT NULL,
    -- serial no. 일련번호 만들기 : 시퀀스 객체로 만들 것이므로 NOT NULL이라고 굳이 안해줘도 되긴 함
    userid      VARCHAR2(20) PRIMARY KEY,
    username    VARCHAR2(20) NOT NULL,
    height      NUMBER(5,2)  DEFAULT 0,
    weight      NUMBER(5,2)  DEFAULT 0
);

CREATE SEQUENCE fitness_seq;


INSERT INTO fitness
(seqno, userid, username, height, weight)
VALUES
(fitness_seq.NEXTVAL, 'hong', '홍길동', 175.5, 69.7);
-- seqno를 제외한 모든 것이 place holder가 들어갈 자리라는 것을 기억해두기
