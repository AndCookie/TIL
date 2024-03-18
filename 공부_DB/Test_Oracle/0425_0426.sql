/*
[연습문제]
1. 80번 부서의 급여 평균, 최고, 최저, 인원수를 구하시오.

2. 각 부서별 급여의 평균, 최고, 최저, 인원수를 구하시오.

3. 각 부서별 평균 월급, 전체 월급, 최저 월급을 구하여 평균 월급이 많은 순으로 출력하시오.
단, 부서번호가 NULL이면 출력하지 않는다.

-- ** 4. 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수를 출력하시오.

-- ** 5. 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오.
*/


-- 1. 80번 부서의 급여 평균, 최고, 최저, 인원수를 구하시오.
SELECT AVG(SALARY) AS "평균 급여",
    MAX(SALARY) AS "최고 급여",
    MIN(SALARY) AS "최저 급여",
    COUNT(SALARY) AS "인원수"   
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80;
-- WHERE 대신 GROUP BY 사용 가능
-- GROUP BY DEPARTMENT_ID
-- HAVING DEPARTMENT_ID=80;


-- 2. 각 부서별 급여의 평균, 최고, 최저, 인원수를 구하시오.
SELECT DEPARTMENT_ID,
    AVG(SALARY) AS "평균 급여",
    MAX(SALARY) AS "최고 급여",
    MIN(SALARY) AS "최저 급여",
    COUNT(SALARY) AS "인원수"   
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY 1;


-- 3. 각 부서별 평균 월급, 전체 월급, 최저 월급을 구하여 평균 월급이 많은 순으로 출력하시오.
-- 단, 부서번호가 NULL이면 출력하지 않는다.
SELECT DEPARTMENT_ID,
    AVG(SALARY)/12 AS "평균 월급",
    SUM(SALARY)/12 AS "전체 월급",
    MIN(SALARY)/12 AS "최저 월급",
    COUNT(SALARY)/12 AS "인원수"   
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING DEPARTMENT_ID IS NOT NULL
ORDER BY 2 DESC;


-- 4. 각 부서별 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무명, 인원수를 출력하시오.
SELECT DEPARTMENT_ID AS "부서번호",
    JOB_ID AS "업무명",
    COUNT(JOB_ID) AS "인원수"   
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY 1;
-- GROUP BY에 JOB_ID가 없다면 오류 발생!!


-- 5. 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하시오.
SELECT 
    JOB_ID AS "업무명",
    COUNT(JOB_ID) AS "인원수"   
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING COUNT(JOB_ID) >= 4
ORDER BY 2 DESC;







/* JOIN
- 둘 이상의 테이블로부터 질의해오는 것
- 테이블들은 보통 PK와 FK의 관계를 갖고 있음
*/

-- [예제] 이름(E), 급여(E), 부서명(D)

-------------------- 2889개 행 --------------------
------------------ 107명*27부서 -------------------
-- CARTESIAN JOIN : 모든 경우의 수를 다 보여주는 조인

-- 방법1 -- dot.
SELECT EMPLOYEES.FIRST_NAME, EMPLOYEES.SALARY, DEPARTMENTS.DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS;

-- 방법2 -- 별칭
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d -- as 쓰면 안됨!!
ORDER BY 1;


-------------------- 106개 행 --------------------
-- EQUI JOIN : PK와 FK가 매칭되는 조인 (오라클 문법)
-- ==> INNER JOIN과 결과는 같으나 명령어가 다름
-- PK와 FK가 같아야 조인이 됨
-- FK가 NULL인 경우 조인되지 않을 수 있다

-- 방법3 -- EQUI JOIN (오라클 문법)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d
WHERE d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;
-- 27 = NULL 때문에 107명이 아닌 106명이 나오는 것



-------------------- 106개 행 --------------------
-- INNER JOIN : PK와 FK가 매칭되는 조인 (ANSI 표준)
-- INNER 키워드는 생략 가능
-- ON (PK=FK) 또는 USING (컬렴명/괄호생략불가)

-- 방법4 -- INNER JOIN ~ ON (PK=FK)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;

-- 방법5 -- INNER JOIN ~ USING (컬럼명)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e JOIN DEPARTMENTS d
USING (DEPARTMENT_ID) -- 괄호 생략 불가!!
ORDER BY 1;



-- [연습] 2개 테이블 조인하기
-- 부서명(DEPARTMNET_NAME), 도시명(CITY)을 조회하시오.
-- 1) 오라클 문법 / EQUI JOIN
SELECT d.DEPARTMENT_NAME, l.CITY
FROM DEPARTMENTS d, LOCATIONS l
WHERE d.LOCATION_ID = l.LOCATION_ID
ORDER BY 1;

-- 2) ANSI 표준 / INNER JOIN ~ ON
SELECT d.DEPARTMENT_NAME, l.CITY
FROM DEPARTMENTS d JOIN LOCATIONS l
ON d.LOCATION_ID = l.LOCATION_ID
ORDER BY 1;

-- 3) ANSI 표준 / INNER JOIN ~ USING
SELECT d.DEPARTMENT_NAME, l.CITY
FROM DEPARTMENTS d JOIN LOCATIONS l
USING (LOCATION_ID)
ORDER BY 1;


-- [연습] 3개 테이블 조인하기
-- 부서명(DEPARTMNET_NAME), 도시명(CITY), 나라명(COUNTRY_NAME)을 조회하시오.
-- 1) 오라클 문법 / EQUI JOIN
SELECT d.DEPARTMENT_NAME, l.CITY, c.COUNTRY_NAME
FROM DEPARTMENTS d, LOCATIONS l, COUNTRIES c
WHERE
    d.LOCATION_ID = l.LOCATION_ID
    AND
    c.COUNTRY_ID = l.COUNTRY_ID
ORDER BY 1;

-- 2) ANSI 표준 / INNER JOIN ~ ON
SELECT d.DEPARTMENT_NAME, l.CITY, c.COUNTRY_NAME
    FROM DEPARTMENTS d JOIN LOCATIONS l
    ON d.LOCATION_ID = l.LOCATION_ID
    JOIN COUNTRIES c    
    ON l.COUNTRY_ID = c.COUNTRY_ID
ORDER BY 1;

-- 3) ANSI 표준 / INNER JOIN ~ USING
SELECT d.DEPARTMENT_NAME, l.CITY, c.COUNTRY_NAME
    FROM DEPARTMENTS d JOIN LOCATIONS l
    USING (LOCATION_ID)
    JOIN COUNTRIES c    
    USING (COUNTRY_ID)
ORDER BY 1;




-- [연습] 3개 테이블 조인하기
-- 직원명(E), 입사일(E), 근속연수(연산), 부서명(D), 직급명(J), 급여(E)를 조회하시오.

-- 1) 오라클 문법 / EQUI JOIN
SELECT e.FIRST_NAME, e.HIRE_DATE,
    CEIL((SYSDATE-e.HIRE_DATE)/365) AS "근속연수",
    d.DEPARTMENT_NAME, j.JOB_TITLE, e.SALARY
FROM EMPLOYEES e, DEPARTMENTS d, JOBS j
WHERE
    e.DEPARTMENT_ID = d.DEPARTMENT_ID
    AND
    e.JOB_ID = j.JOB_ID
ORDER BY 1;
    
-- 2) ANSI 표준 / INNER JOIN ~ ON
SELECT FIRST_NAME, HIRE_DATE, -- 테이블명 생략 가능하긴 하지만 되도록이면 붙여주기
    TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIRE_DATE, 'YYYY'))+1 AS "근속연수",
    DEPARTMENT_NAME, JOB_TITLE, SALARY
    FROM EMPLOYEES e JOIN DEPARTMENTS d
    ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
    JOIN JOBS j
    ON e.JOB_ID = j.JOB_ID
ORDER BY 1;

-- 3) ANSI 표준 / INNER JOIN ~ USING
SELECT e.FIRST_NAME, e.HIRE_DATE,
    CEIL((SYSDATE-e.HIRE_DATE)/365) AS "근속연수",
    d.DEPARTMENT_NAME, j.JOB_TITLE, e.SALARY
    FROM EMPLOYEES e JOIN JOBS j
    USING (JOB_ID)
    JOIN DEPARTMENTS d
    USING (DEPARTMENT_ID)
ORDER BY 1;





-------------------- 107개 행 --------------------
/* OUTER JOIN
-- FK를 가진 테이블의 데이터가 NULL일 때, 조회되지 않는 데이터를 조회하기 위한 조인 방법
-- 교집합 보다는 합집합의 개념
-- JOIN 조건이 같지 않을 경우에도 결과를 반환받고자 할 때
-- 종류 : LEFT OUTER, RIGHT OUTER, FULL OUTER
*/


----------------- LEFT OUTER JOIN -----------------
-- 먼저 왼쪽 테이블의 데이터를 가져오고, 오른쪽 테이블을 붙이는 방법
-- 조인 조건이 안맞는 경우, NULL로 채움
-- 자식 테이블을 "왼쪽"에 쓰고 부모 테이블을 "오른쪽"에 쓴다!!
-- 자식 테이블에는 NULL값이 있을 수 있으나, 부모 테이블에는 NULL이 있으면 안된다!!

-- 방법 1 -- EQUI JOIN (오라클 문법)
SELECT e.FIRST_NAME, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d
WHERE d.DEPARTMENT_ID(+) = e.DEPARTMENT_ID 
ORDER BY 1;
-- (PK)27 = (FK)NULL을 포함하므로 106명이 아닌 107명이 나오는 것


-- 방법2 -- LEFT OUTER JOIN ~ ON (PK=FK)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;

-- 방법3 -- LEFT OUTER JOIN ~ USING (컬럼명)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
USING (DEPARTMENT_ID) -- 괄호 생략 불가!! + USING은 컬럼명이 동일한 경우에만 사용 가능
ORDER BY 1;



----------------- RIGHT OUTER JOIN -----------------
-- 먼저 오른쪽 테이블의 데이터를 가져오고, 왼쪽 테이블을 붙이는 방법
-- 조인 조건이 안맞는 경우, NULL로 채움
-- 자식 테이블을 "오른쪽"에 쓰고 부모 테이블을 "왼쪽"에 쓴다!!
-- 자식 테이블에는 NULL값이 있을 수 있으나, 부모 테이블에는 NULL이 있으면 안된다!!

-- 방법 1 -- EQUI JOIN (오라클 문법)
SELECT e.FIRST_NAME, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d
WHERE d.DEPARTMENT_ID(+) = e.DEPARTMENT_ID 
ORDER BY 1;
-- (PK)27 = (FK)NULL을 포함하므로 106명이 아닌 107명이 나오는 것

-- 방법2 -- RIGHT OUTER JOIN ~ ON (PK=FK)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM DEPARTMENTS d RIGHT OUTER JOIN EMPLOYEES e
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;

-- 방법3 -- RIGHT OUTER JOIN ~ USING (컬럼명)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM DEPARTMENTS d RIGHT OUTER JOIN EMPLOYEES e
USING (DEPARTMENT_ID) -- 괄호 생략 불가!! + USING은 컬럼명이 동일한 경우에만 사용 가능
ORDER BY 1;




----------------- SELF JOIN -----------------
-- 하나의 테이블 내에 PK, FK가 모두 존재하는 경우

-- 1) 오라클 문법 
SELECT
    e2.EMPLOYEE_ID/*PK*/, e2.FIRST_NAME/*PK*/ AS "직원명",
    e2.MANAGER_ID /*FK*/, e1.FIRST_NAME /*PK*/ AS "MANAGER명"
FROM EMPLOYEES e1, EMPLOYEES e2
WHERE e1.EMPLOYEE_ID(+) = e2.MANAGER_ID
ORDER BY 3;
-- e1 : 자식테이블로서 FK를 갖고 있음 // NULL이 없는 쪽에 +
-- e2 : 부모테이블로서 PK를 갖고 있음


-- 2) INNER JOIN ~ ON
SELECT
    e2.EMPLOYEE_ID/*PK*/, e2.FIRST_NAME/*PK*/ AS "직원명",
    e2.MANAGER_ID /*FK*/, e1.FIRST_NAME /*PK*/ AS "MANAGER명"
FROM EMPLOYEES e1 INNER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
ORDER BY 3;


-- 3) RIGHT OUTER JOIN ~ ON
SELECT
    e2.EMPLOYEE_ID/*PK*/, e2.FIRST_NAME/*PK*/ AS "직원명",
    e2.MANAGER_ID /*FK*/, e1.FIRST_NAME /*PK*/ AS "MANAGER명"
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
ORDER BY 3;


-- 4) JOIN ~ USING은 불가능
-- 공통 KEY가 없으므로




------------------- 서브 쿼리 ---------------------
/*
서브쿼리 (Sub Query)
    -	Query 문장 안에 또다른 Query 문장이 포함된 쿼리
    -	메인쿼리와 서브쿼리
1)	메인 쿼리 :
    -	실행의 결과가 조회되는 쿼리
    -	서브쿼리에 의해 실행된 쿼리문의 결과에 의해 메인쿼리가 실행된다. 
2)	서브 쿼리 :
    -	메인쿼리 안쪽에 위치한 쿼리
    -	서브쿼리의 실행 결과가 메인 쿼리의 조건이나 결과로 사용된다
    -	대부분 서브쿼리가 먼저 실행되고 난 후 그 결과가 메인쿼리에 전달되어 실행됨
    -	서브쿼리에는 ORDER BY절 사용 불가
    -	서브쿼리의 사용 위치
	    where 절 : 값 1개로 나오는 결과 또는 컬럼 1개짜리 결과
	    having 절 : 메인쿼리에서 그룹행 함수를 사용했을 때
	    from 절
	    select 절
	    insert 문의 into 절
	    update 문의 set 절
-	다양한 서브쿼리의 종류
	-   1. 단일행 서브쿼리
            : 서브쿼리의 결과가 하나인 경우
	-   2. 단일열
	-   3. 다중행 서브쿼리
            : 서브쿼리의 결과가 하나 이상인 경우
            : 연산자와 함꼐 사용 (IN, ANY, ALL, EXISTS)
	-   4. 다중열
*/

-------------------------------------------
-- WHERE절에서 사용하는 서브쿼리

-- 13. 사원번호가 109인 사원보다 급여가 많은 사원을 표시(사원이름과 담당) 조회하시오.
-- 방법 1 -- 일반 쿼리 2개로 작업한 내용
SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 109;

SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > 9000;

-- 방법2 -- 단일행 서브쿼리로 작업한 내용
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 109);

-- [실습] 162번의 급여와 동일한 직원의 이름, 급여, 부서번호를 조회하시오.
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 162);


------------------------------------------------------
-- FROM절에서 사용하는 서브쿼리
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50;

SELECT ROWNUM, tbl.*
FROM (SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
      FROM EMPLOYEES
      WHERE DEPARTMENT_ID = 50) tbl
WHERE SALARY > 3000
AND ROWNUM <= 10;
-- ROWNUM은 동적으로 번호가 부여되다보니 무조건 1부터 가져오므로 범위 지정 불가!!
-- AND ROWNUM BETWEEN 11 AND 20;

SELECT *
FROM (
    SELECT ROWNUM AS rno, tbl.*
    FROM (SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
          FROM EMPLOYEES
          WHERE DEPARTMENT_ID = 50) tbl
    WHERE SALARY > 3000)
WHERE rno BETWEEN 11 AND 20;
-- 더이상 동적 부여되지 않으므로 범위 지정 가능~~
-- ex) 게시판 스크롤 내려서 2번 블럭 클릭시 11~21번 게시글 조회 가능


-- [연습] FROM절에 서브쿼리 사용
-- 03년 이전에 입사한 일련번호(ROWNUM)와 직원의 직원명, 급여, 입사일, 부서명 조회
SELECT temp.*
FROM (
    SELECT ROWNUM AS RNO, FIRST_NAME, SALARY, HIRE_DATE, DEPARTMENT_NAME
    FROM EMPLOYEES INNER JOIN DEPARTMENTS
    USING (DEPARTMENT_ID)
    ) temp
WHERE HIRE_DATE < '03/01/01';


-- [연습] WHERE절에 서브쿼리 사용
-- 이름이 'Lisa'인 사원의 매니저명과 성을 조회하시오
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
                     FROM EMPLOYEES
                     WHERE FIRST_NAME='Lisa');


-- [연습] 하나의 문장 안에 서브쿼리 두 개 => 조건절
-- 성이 'Greenberg' 또는 'Errazuriz'인 직원의 이름과 성을 조회하시오
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME = 'Greenberg' OR LAST_NAME = 'Errazuriz';

-- Greenberg 보다 급여가 많으면서 성이 'Errazuriz'인 직원의 매니저명을 조회하시오
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE LAST_NAME='Greenberg')
AND EMPLOYEE_ID = (SELECT MANAGER_ID
                   FROM EMPLOYEES
                   WHERE LAST_NAME='Errazuriz');


-------------------------------------------------------------------------
-- SELECT절에서 사용하는 서브쿼리
-- 열로 펼치고 싶을 때 사용

-- [연습] Bruce와 Daniel의 성을 조회하시오
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME IN ('Bruce', 'Daniel');

-- 서브쿼리로
SELECT 
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Bruce') AS "Bruce의 성",
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Daniel') AS "Daniel의 성"
FROM DUAL;


-- [문제] 서브쿼리
-- 'Valli'라는 이름을 가진 직원의 부서명을 조회하시오.
SELECT DEPARTMENT_NAME AS "부서명"
FROM DEPARTMENTS
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                       FROM EMPLOYEES
                       WHERE FIRST_NAME='Valli');

/*
-------------------------------------------------
다중행 서브쿼리 = 복수행 서브쿼리
1) IN 연산자
2) ANY / ALL 연산자
3) EXISTS 연산자
_________________________________________________
*/

-- 1) IN 연산자
SELECT *
FROM EMPLOYEES
WHERE JOB_ID IN (SELECT JOB_ID
                 FROM EMPLOYEES
                 WHERE DEPARTMENT_ID = 30);
                 
                 
-- 2) ANY/ALL 연산자
-- 서브쿼리로 조회된 결과에 하나 이상 만족하는 행이 있는지 조회
-- > ANY, < ANY, = ANY (IN과 동일), !=ANY, >= ANY, <=ANY
-- 서브쿼리로 조회된 결과에 만족하는 모든 행을 조회
-- > ALL, < ALL, = ALL, !=ALL, >= ALL, <=ALL
-- 비교 연산자와 함께 사용한다!!!

-- [연습1] ST_MAN 직군의 가장 높은 급여보다 적게 받는 사람들의 이름, 급여를 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2;
-- 서브쿼리의 결과 중 가장 큰 값보다 작은 값들
-- 8200보다 작은 모든 연봉

-- [연습2] ST_MAN 직군의 가장 낮은 급여보다 더 많이 받는 사람들의 이름, 급여를 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2; 
-- 서브쿼리의 결과 중 가장 작은 값보다 큰 값들
-- 5800보다 큰 모든 연봉

-- [연습3] ST_MAN 직군의 가장 낮은 급여보다 더 적게 받는 사람들의 이름, 급여를 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < ALL (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2;
-- 서브쿼리의 결과 중 가장 작은 값보다 작은 값들
-- 5800보다 작은 모든 연봉

-- [연습4] ST_MAN 직군의 가장 높은 급여보다 더 많이 받는 사람들의 이름, 급여를 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ALL (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2;
-- 서브쿼리의 결과 중 가장 큰 값보다 큰 값들
-- 8200보다 큰 모든 연봉

-- [연습5] REP 직군의 급여와 동일한 급여를 받는 직원들의 이름, 급여를 조회
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY = ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID LIKE '%REP')
ORDER BY 4;
-- 서브쿼리의 결과와 동일한 값들
-- 6000, 6100, 6200, 6400, 6500, 6800, 7000, 7200, 7300, 7400, 7500
-- 8000, 8400, 8600, 8800, 9000, 9500, 9600, 10000, 10500, 11000, 11500



-- 3) EXISTS
-- 서브 쿼리의 결과에 만족하는 행의 존재 여부

SELECT DEPARTMENT_NAME
FROM DEPARTMENTS
WHERE EXISTS (SELECT DEPARTMENT_ID
              FROM EMPLOYEES
              WHERE DEPARTMENT_ID=90);    
SELECT DEPARTMENT_NAME
FROM DEPARTMENTS
WHERE EXISTS (SELECT DEPARTMENT_ID
              FROM EMPLOYEES
              WHERE DEPARTMENT_ID=500);
              
-- [연습] 서브쿼리+조인 사용하기
-- 'Chen'이라는 직원이 존재하면 그 직원의 부서명, 이름, 성, 급여를 조회하시오
SELECT DEPARTMENT_NAME, FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES JOIN DEPARTMENTS
USING (DEPARTMENT_ID)
WHERE EXISTS (SELECT LAST_NAME
             FROM EMPLOYEES
             WHERE LAST_NAME = 'Chen')
AND LAST_NAME = 'Chen';


-- [연습]
SELECT FIRST_NAME, DEPARTMENT_ID, SALARY, NVL(COMMISSION_PCT, 0)
FROM EMPLOYEES
WHERE (SALARY, NVL(COMMISSION_PCT, -1))
      IN (SELECT SALARY, NVL(COMMISSION_PCT, -1)
          FROM EMPLOYEES
          WHERE DEPARTMENT_ID =80);
-- SALARY가 동일하거나 COMMISSION_PCT가 동일한 직원들 모두 조회




---------------------------------------
/*
[ 연습문제 ] 
1. 조인을 이용하여 사원ID가 100번인 사원의 부서번호와 부서이름을 출력하시오
2. INNER JOIN을 이용하여 사원이름과 함께 그 사원이 소속된 도시이름과 지역명을 출력하시오
3. INNER JOIN과 USING 연산자를 사용하여 10번 부서에 속하는 모든 담당 업무의 고유목록을 부서의 지역명을 포함하여 출력하시오.
4. JOIN을 사용하여 커미션을 받는 모든 사원의 이름, 부서ID, 지역명을 출력하시오
5. EQUI조인과 와일드카드를 사용하여 이름에 A가 포함된 모든 사원의 이름과 부서명을 출력하시오(단, 대소문자 구분 없음)
6. JOIN을 사용하여 Seattle에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오
7. SELF 조인을 사용하여 사원의 이름 및 사원번호를 관리자 이름 및 관리자 번호와 함께 조회
8. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 조회
** 9. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 조회. 단, 각 열의 별칭은 이름, 부서번호, 동료로 할 것.
10. SLEF JOIN을 사용하여 John Chen사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오
11. SELF JOIN을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오
12. 사원ID가 101인 사원과 담당업무가 같은 사원을 표시(사원이름과 담당)하시오.
13. 사원번호가 109인 사원보다 급여가 많은 사원을 표시(사원이름과 담당) 조회하시오.
14. 최소 급여를 받는 사원의 이름, 담당업무, 및 급여를 조회하시오(그룹함수 사용)
15. 평균 급여가 가장 적은 사원의 담당 업무를 찾아 담당업무와 평균급여를 조회하시오.
16. 담당 업무가 IT_PROG인 사원보다 급여가 적으면서 업무가 IT_PROG가 아닌 사원들을 조회(사원번호, 이름, 담당업무) 하시오
17. John Chen과 동일한 부서에 있는 사원의 이름과 입사일을 조회하시오
18. 급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해 오름차순으로 정렬하시오
19. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의를 작성하시오
20. ‘King’이 Manager인 사원의 이름과 급여를 조회하시오.
21. Finance부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오
22. 평균 급여보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여를 조회하시오
23. 평균 급여가 가장 적은 업무 조회하기
*/


--1. JOIN을 이용하여 사원ID가 100번인 사원의 부서번호와 부서이름을 출력하시오
SELECT e.DEPARTMENT_ID, d.DEPARTMENT_NAME
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE e.EMPLOYEE_ID=100;


-- 2. INNER JOIN을 이용하여 사원이름과 함께 그 사원이 소속된 도시이름과 지역명을 출력하시오
SELECT e.FIRST_NAME, l.CITY, r.REGION_NAME
FROM REGIONS r INNER JOIN COUNTRIES c
ON r.REGION_ID = c.REGION_ID
JOIN LOCATIONS l
ON c.COUNTRY_ID = l.COUNTRY_ID
JOIN DEPARTMENTS d
ON l.LOCATION_ID = d.LOCATION_ID
JOIN EMPLOYEES e
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID;


-- 3. INNER JOIN과 USING 연산자를 사용하여
-- 100번 부서에 속하는 모든 담당 업무의 고유목록을 부서의 지역명을 포함하여 출력하시오.
SELECT DEPARTMENT_ID, JOB_TITLE, REGION_NAME
FROM REGIONS r INNER JOIN COUNTRIES c 
USING (REGION_ID)
JOIN LOCATIONS l
USING (COUNTRY_ID)
JOIN DEPARTMENTS d
USING (LOCATION_ID)
JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
JOIN JOBS j
USING (JOB_ID)
WHERE DEPARTMENT_ID=100;


-- 4. JOIN을 사용하여 커미션을 받는 모든 사원의 이름, 부서ID, 지역명을 출력하시오
SELECT FIRST_NAME, DEPARTMENT_ID, REGION_NAME
FROM REGIONS r INNER JOIN COUNTRIES c 
USING (REGION_ID)
JOIN LOCATIONS l
USING (COUNTRY_ID)
JOIN DEPARTMENTS d
USING (LOCATION_ID)
JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
WHERE COMMISSION_PCT IS NOT NULL;


-- 5. EQUI조인과 와일드카드를 사용하여 이름에 A가 포함된 모든 사원의 이름과 부서명을 출력하시오(단, 대소문자 구분 없음)
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
USING (DEPARTMENT_ID)
WHERE FIRST_NAME LIKE '%A%'
OR FIRST_NAME LIKE '%a%';


-- 6. JOIN을 사용하여 Seattle에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오
SELECT FIRST_NAME, JOB_TITLE, DEPARTMENT_ID, DEPARTMENT_NAME, CITY
FROM LOCATIONS l INNER JOIN DEPARTMENTS d
USING (LOCATION_ID)
JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
JOIN JOBS j
USING (JOB_ID)
WHERE CITY = 'Seattle';


-- 7. SELF 조인을 사용하여 사원의 이름 및 사원번호를 관리자 이름 및 관리자 번호와 함께 조회
SELECT e2.FIRST_NAME, e2.EMPLOYEE_ID, e1.FIRST_NAME, e2.MANAGER_ID
FROM EMPLOYEES e1 INNER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID;


-- 8. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 조회
SELECT e2.FIRST_NAME, e2.EMPLOYEE_ID, e1.FIRST_NAME, e2.MANAGER_ID
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
ORDER BY 2;


-- 9. SELF JOIN을 사용하여 'Oliver' 사원의 부서명, 그 사원과 동일한 부서에서 근무하는  동료 사원의 이름을 조회
-- 단, 각 열의 별칭은 이름, 부서번호, 동료로 할 것.
SELECT e2.FIRST_NAME AS "이름", e2.DEPARTMENT_ID AS "부서번호",
e1.FIRST_NAME AS "동료"
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.DEPARTMENT_ID = e2.DEPARTMENT_ID
WHERE e2.FIRST_NAME = 'Oliver'
ORDER BY 1;


-- 10. SUB QUERY를 사용하여 John Chen사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE > (SELECT HIRE_DATE
                   FROM EMPLOYEES
                   WHERE FIRST_NAME = 'John' AND LAST_NAME ='Chen')
ORDER BY 2;


-- 11. SELF JOIN을 사용하여 관리자보다 먼저 입사한 모든 사원의
-- 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오
SELECT e2.FIRST_NAME AS "이름", e2.HIRE_DATE AS "입사일",
e1.FIRST_NAME AS "관리자", e1.HIRE_DATE AS "입사일"
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
WHERE e2.HIRE_DATE < e1.HIRE_DATE
ORDER BY 2;


-- 12. 사원ID가 101인 사원과 담당업무가 같은 사원을 표시(사원이름과 담당)하시오.
-- 단일행 쿼리
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID = (SELECT JOB_ID
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 101);


-- 13. 사원번호가 109인 사원보다 급여가 많은 사원을 표시(사원이름과 담당) 조회하시오.
-- 방법 1 -- 일반 쿼리 2개로 작업한 내용
SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 109;

SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > 9000;

-- 방법2 -- 서브쿼리로 작업한 내용
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 109);

-- 14. 최소 급여를 받는 사원의 이름, 담당업무 및 급여를 조회하시오(그룹함수 사용)
SELECT FIRST_NAME, JOB_TITLE, SALARY
FROM EMPLOYEES JOIN JOBS
USING (JOB_ID)
WHERE SALARY = ANY (SELECT MIN(SALARY)
                    FROM EMPLOYEES);

-- 15. 전체 평균 급여보다 더 적은 급여를 받는 부서에 대해 급여가 가장 적은 사원의 담당업무와 급여를 조회하시오.
SELECT FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);


-- 16. 담당 업무가 IT_PROG인 사원보다 급여가 적으면서 업무가 IT_PROG가 아닌 사원들을 조회(사원번호, 이름, 담당업무) 하시오
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY < ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'IT_PROG')
AND JOB_ID != 'IT_PROG';


-- 17. John Chen과 동일한 부서에 있는 사원의 이름과 입사일을 조회하시오
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                       FROM EMPLOYEES
                       WHERE FIRST_NAME = 'John' AND LAST_NAME = 'Chen');
                       

-- 18. 급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해 오름차순으로 정렬하시오
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEES)
ORDER BY SALARY DESC;


-- 19. 이름에 대문자 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의를 작성하시오
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ANY (SELECT DEPARTMENT_ID
                           FROM EMPLOYEES
                           WHERE FIRST_NAME LIKE '%K%');
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
                                        FROM EMPLOYEES
                                        WHERE FIRST_NAME LIKE '%K%');                           

-- 20. ‘King’이 Manager인 사원의 이름과 급여를 조회하시오.
SELECT e2.FIRST_NAME, e2.EMPLOYEE_ID, e1.FIRST_NAME, e2.MANAGER_ID
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
WHERE e1.LAST_NAME = 'King';


-- 21. Finance부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오
SELECT DEPARTMENT_NAME, DEPARTMENT_ID, FIRST_NAME, JOB_TITLE
FROM DEPARTMENTS d INNER JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
JOIN JOBS j
USING (JOB_ID)
WHERE DEPARTMENT_NAME = 'Finance';


-- 22. 평균 급여보다 많은 급여를 받고 이름에 M이 포함된 사원과
-- 같은 부서에서 근무하는 사원의 사원번호, 이름, 급여를 조회하시오
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEES)
AND FIRST_NAME LIKE '%M%';  


SELECT DEPARTMENT_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= AVG(SALARY)
AND FIRST_NAME LIKE '%M%'
AND FIRST_NAME LIKE '%m%';

SELECT COUNT(FIRST_NAME), AVG(SALARY)
FROM EMPLOYEES;


-- 23. 평균 급여가 가장 적은 업무 조회하기       
SELECT MIN(tmp.SAL)
FROM (SELECT AVG(SALARY) AS SAL
      FROM EMPLOYEES
      GROUP BY JOB_ID) tmp;

SELECT *
FROM (SELECT JOB_ID, AVG(SALARY) AS SAL
             FROM EMPLOYEES
             GROUP BY JOB_ID) tmp1
WHERE SAL = (SELECT MIN(tmp2.SAL)
             FROM (SELECT AVG(SALARY) AS SAL
                   FROM EMPLOYEES
                   GROUP BY JOB_ID) tmp2);
-- SELECT절
SELECT 
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Bruce') AS "Bruce의 성",
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Daniel') AS "Daniel의 성"
FROM DUAL;                   



SELECT *
FROM (SELECT JOB_ID, AVG(SALARY) AS "AVG SALARY"
      FROM EMPLOYEES
      GROUP BY JOB_ID) tbl
WHERE "AVG SALARY" = (SELECT MIN(SALARY)
                FROM (SELECT JOB_ID, AVG(SALARY) AS "SALARY"
                FROM EMPLOYEES
                GROUP BY JOB_ID
                ORDER BY 2));



------------------------------------------------------------------------------------------------------------
/*
-- DDL
    - CREATE, ALTER, DROP
    - 테이블명, 컬럼명은 키워드 사용 불가능
    - 제약조건 (CONTRAINTS)
        - 종류 : Primary Key, Foreign Key, Unique, Not Null, Check
        - 목적 : 데이터의 무결성을 위한 것
        - 특징 : Primary Key, Unique 제약조건은 자동으로 index가 생성되기 때문에 조회가 빨라진다.
    - DEFAULT
        - 데이터가 없을 때 삽입되는 기본값
        - 제약조건은 아니지만 데이터의 무결성을 보장하는 역할 담당

    
    
-- 오라클에서 사용하는 자료형
1) 문자열 : VARCHAR2(최대 글자수) -> 가변길이 문자열 (최대 4000BYTE / 한국어는 3배)
          : CHAR(n)               -> 고정길이 문자열 (메모리 낭비)
                <예시>
                VARCHAR2(10)      -> 'KOREA', 'AMERICA'
                CHAR(10)          -> 'KOREA     ', 'AMERICA   '
2) 숫자   : NUMBER(자리수)
          : NUMBER(자리수p, 소수자리s)
                 <예시>
                NUMBER(3)         -> 최대 999까지의 정수
                NUMBER            -> SHORT정도의 수준
                NUMBER(5, 2)      -> 5자리와 소수점 이하 둘째자리까지
3) 날짜   : DATE                  -> 연/월/일
          : TIMESTAMP

4) 대용량 : BLOB (Large of Byte)
          : CLOB (용량이 너무 커지므로 직접 하드디스크에 저장하는 경우는 거의 없음)

0) (Boolean 타입은 없음)



-- 오라클 키워드 조회하기 (DBA)
DBA만 가능한 명령이므로 SYSTEM 계정에서 접속시 1800여개 확인 가능 
SELECT * FROM V$RESERVED_WORDS;

-- 제약조건 확인하기
: 어느 테이블에 어떤 제약조건이 걸려있는지 확인하기
    - 우리가 만든 테이블의 제약명 정하기
        1. 따로 지정 : 테이블명_컬럼명_제약조건 !!!!!!!!!!!!!!!
        2. 자동 생성 : SYSTEM이 임의로 정한 SYS_~~
SELECT *
FROM USER_CONSTRAINTS;
*/




/* CREATE
-- 테이블 작성 + 제약조건
CREATE TABLE 테이블명 (
    열1이름 열1자료형,
    열2이름 열2자료형,
    ...,
    열3이름 열3자료형
);
*/


-- [예시]
-- 테이블 생성
CREATE TABLE FITNESS
(
    MEM_ID    VARCHAR2(5)  CONSTRAINTS FITNESS_ID_PK PRIMARY KEY,
    MEM_NAME  VARCHAR2(15) CONSTRAINTS FITNESS_NAME_NN NOT NULL,
    -- ID와 NAME은 키워드이므로 다른 컬럼명 사용하기
    HEIGHT    NUMBER(5, 2) DEFAULT 0,
    WEIGHT    NUMBER(5, 2) DEFAULT 0,
    JOIN_DATE DATE         DEFAULT SYSDATE
);

-- 테이블 삭제
DROP TABLE FITNESS;

-- 제약조건 확인
SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'FITNESS';
-- P는 Primary Key
-- C는 Check 또는 Not Null



/*
-- INSERT문

-- 방법1 
INSERT INTO 테이블명
VALUES (데이터1, 2, 3, 4, 5);
-- 모든 컬럼의 데이터를 다 넣을 때에는 VALUES 앞쪽의 괄호 생략 가능

-- 방법2
INSERT INTO 테이블명
(컬럼명 1,2,3,4,5)
VALUES
(데이터 1,2,3,4,5)

-- 방법3
INSERT INTO 테이블명
(컬럼명 1,2)
VALUES
(데이터 1,2)
-- DEFAULT 있는 컬럼에 데이터 넣지 않는 경우에는 컬럼명 명시 필수!!
*/

-- [예시]
INSERT INTO FITNESS
VALUES ('Hong', '홍길동', 185.5, 75, '23/04/26');

INSERT INTO FITNESS
(MEM_ID, MEM_NAME, HEIGHT, WEIGHT, JOIN_DATE)
VALUES
('Lim', '임꺽정', 180.88, 88, '23/04/25');

INSERT INTO FITNESS
(MEM_ID, MEM_NAME)
VALUES
('Son', '손오공');

COMMIT; -- 필수!!!! (COMMIT 또는 ROLLBACK)

SELECT *
FROM FITNESS;



-- [문제] 회원정보 저장을 위한 MEMBERS 테이블 생성하기
/*
SEQNO 숫자타입 PK
USERID 가변길이 10 UQ
USERNAME 가변길이 20 NN
BIRTHDAY 날짜타입 NN
GENDER 고정길이 1 CHECK '0', '1'
*/

-- 테이블 생성
CREATE TABLE MEMBERS
(
    SEQNO    NUMBER         CONSTRAINTS MEMBERS_SEQ_PK  PRIMARY KEY,
    USERID   VARCHAR2(10)   CONSTRAINTS MEMBERS_ID_UQ   UNIQUE,
    USERNAME VARCHAR2(20)   CONSTRAINTS MEMBERS_NAME_NN NOT NULL,
    BIRTHDAY DATE           CONSTRAINTS MEMBERS_BD_NN   NOT NULL,
    GENDER   CHAR(1)        CONSTRAINTS MEMBERS_GD_CK   CHECK (GENDER IN ('0', '1'))
);

-- 테이블 삭제
DROP TABLE MEMBERS;

-- 제약조건 조회
SELECT *
FROM MEMBERS;

-- 데이터 삽입
INSERT INTO MEMBERS
VALUES (1, 'SON', '손오공', '00/01/02', '1');

INSERT INTO MEMBERS
VALUES (2, 'KIM', '김영희', '95/05/01', '0');

-- 테이블 조회
SELECT *
FROM MEMBERS;

-- 저장 또는 날리기
COMMIT;

-- 데이터 삭제
DELETE MEMBERS
WHERE SEQNO = 1;
-- 삭제 성공시 '1'개 행 삭제되었습니다.
DELETE MEMBERS
WHERE SEQNO = 3;
-- 삭제 실패시 '0'개 행 삭제되었습니다.

-- 저장 또는 날리기
ROLLBACK;

-- 데이터 수정
UPDATE MEMBERS
SET USERNAME = '손영희'
WHERE SEQNO = 1;

-- 저장 또는 날리기
COMMIT;


--------------------------------------------------
/*
-- TCL 명령어
    - COMMIT
    - ROLLBACK
*/

--------------------------------------------------
/*
PK와 FK의 관계를 가진 테이블 생성하기
-- 1) 생성 : 무조건 부모부터 생성 후 -> 자식 테이블 생성
             REFERENCES 부모테이블명(PK컬럼명)
             ON DELETE CASCADING : 부모 테이블 삭제 불가하도록 설정
             
-- 2) 삭제 : 무조건 자식부터 삭제 후 -> 부모 테이블 삭제
*/

-- [예시] MEMBERS 테이블의 PK를 FK로 갖는 PURCHASE 자식테이블 생성하기
/*
SEQ_ID   : 일련번호 정수형 PK
ITEM     : 상품명 가변길이 50 NN
PRICE    : 가격 정수형 10자리 DF 100000
PDAY     : 구매일자 DF 현재날짜
QUANTITY : 숫자형 3자리 DF 1
SEQNO    : FK
*/

-- 테이블 생성
CREATE TABLE PURCHASE
(
    SEQ_ID   NUMBER       CONSTRAINTS PURHCASE_SEQID_PK PRIMARY KEY,
    ITEM     VARCHAR2(50) CONSTRAINTS PURHCASE_ITEM_NN NOT NULL,
    PRICE    NUMBER(10)   DEFAULT 100000,
    PDAY     DATE         DEFAULT SYSDATE,
    QUANTITY NUMBER(3)    DEFAULT 1,
    SEQNO    NUMBER       REFERENCES MEMBERS(SEQNO) ON DELETE CASCADE
);

-- 테이블 삭제
DROP TABLE PURCHASE;

-- 테이블 조회
SELECT *
FROM PURCHASE;

-- 데이터 추가

-- 1) 손영희가 물건 2개 구매
INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(11, '자바의 정석', 1, 40000);

INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(12, '파이썬', 1, 25000);

-- 2) 김영희가 물건 3개 구매
INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(13, '노트북', 2, 2570000);

INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO)
VALUES
(14, '키보드', 2);

INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(15, '모니터', 2, 380000);

-- 테이블 조회
SELECT *
FROM PURCHASE;

-- 일련번호, 구매인 이름, 아이템명, 가격 : INNER JOIN을 이용하여 조회하기
SELECT ROWNUM, USERNAME, ITEM, PRICE
FROM MEMBERS INNER JOIN PURCHASE
USING (SEQNO);




-- [문제] KPOP 아이돌 정보 & 소속사 정보 * 팬클럽 정보를 저장한 테이블 생성하기
-- 조무보 테이블 : 소속사 / 부모 테이블 : 아이돌 / 자식 테이블 : 팬클럽
-- 소속사의 FK가 아이돌의 PK이므로 & 아이돌의 FK가 팬클럽의 PK이므로

/*
<아이돌 테이블>
그룹명 이름 나이 생년월일 
<소속사 테이블>
회사명 대표 주소 그룹명
<팬클럽 테이블>
그룹명 팬클럽명 개설일자 회원수
*/

CREATE TABLE ENTERTAINMENT
(
    GROUP_NAME  VARCHAR2(50) CONSTRAINTS E_GN_PK PRIMARY KEY,
    COMP_NAME   VARCHAR2(50) CONSTRAINTS E_CN_NN NOT NULL,
    REP_NAME    VARCHAR2(50) CONSTRAINTS E_RN_NN NOT NULL,
    ADDRESS     VARCHAR2(50) CONSTRAINTS E_AD_NN NOT NULL
);

SELECT *
FROM ENTERTAINMENT;

DROP TABLE ENTERTAINMENT;

INSERT INTO ENTERTAINMENT
VALUES ('블랙핑크', 'YG', '양현석', '강남구 청담동');

INSERT INTO ENTERTAINMENT
VALUES ('레드벨벳', 'SM', '이수만', '강남구 삼성동');

COMMIT;



CREATE TABLE IDOL
(
    SEQ_NO      NUMBER       CONSTRAINTS I_SEQ_PK PRIMARY KEY,
    GROUP_NAME  VARCHAR2(50) REFERENCES ENTERTAINMENT(GROUP_NAME) ON DELETE CASCADE,
    SOLO_NAME   VARCHAR2(50) CONSTRAINTS I_SN_NN  NOT NULL,
    AGE         NUMBER(2)    CONSTRAINTS AGE      NOT NULL,
    COUNTRY     VARCHAR(50)  DEFAULT 'Korea',
    BIRTHDAY    DATE         DEFAULT '00/01/01'
);

SELECT *
FROM IDOL;

DROP TABLE IDOL;

INSERT INTO IDOL
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (1, '블랙핑크', '제니', 25, '95/01/01');

INSERT INTO IDOL
VALUES (2, '블랙핑크', '리사', 27, 'Vietnam', '93/01/01');

INSERT INTO IDOL
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (3, '레드벨벳', '아이린', 31, '89/01/01');

INSERT INTO IDOL
VALUES (4, '레드벨벳', '웬디', 28, 'America', '92/01/01' );

COMMIT;





CREATE TABLE FANCLUB
(
    SEQ_NO      NUMBER       CONSTRAINTS F_SEQ_PK PRIMARY KEY,
    GROUP_NAME  VARCHAR2(50) REFERENCES ENTERTAINMENT(GROUP_NAME) ON DELETE CASCADE,
    FAN_NAME    VARCHAR2(50) CONSTRAINTS F_FN_NN  NOT NULL,
    FAN_CNT     NUMBER(10)   DEFAULT 12345
);

SELECT *
FROM FANCLUB;

DROP TABLE FANCLUB;

INSERT INTO FANCLUB
(SEQ_NO, GROUP_NAME, FAN_NAME)
VALUES (1, '블랙핑크', 'BP');

INSERT INTO FANCLUB
VALUES (2, '블랙핑크', '핑크', 1800000);

INSERT INTO FANCLUB
VALUES (3, '레드벨벳', 'LEVEL', 98765);

COMMIT;



-- INNER JOIN을 이용하여 조회하기
SELECT ROWNUM, GROUP_NAME, SOLO_NAME, AGE, COMP_NAME, FAN_NAME, FAN_CNT
FROM IDOL INNER JOIN ENTERTAINMENT
USING (GROUP_NAME)
JOIN FANCLUB
USING (GROUP_NAME);

