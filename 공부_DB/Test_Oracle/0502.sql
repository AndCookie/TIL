SELECT *
FROM MY_TABLE;

SELECT FIRST_NAME, DEPARTMENT_NAME, SALARY
FROM DEPARTMENTS d INNER JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
ORDER BY 1;



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


SELECT * FROM fitness
ORDER BY USERNAME;

SELECT * FROM fitness
WHERE USERID = 'hong';

DELETE FROM fitness
WHERE USERID = 'palpal';

UPDATE fitness
SET HEIGHT = 180,
    WEIGHT = 75
WHERE USERID = 'hong';

commit;