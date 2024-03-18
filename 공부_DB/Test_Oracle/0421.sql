SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES;

-- 이름과 급여정보를 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES; // 107명


-- ALL | DISTINCT
-- DISTINCT 중복 배제 / ALL 중복 허용 (Default)
SELECT DEPARTMENT_ID
FROM EMPLOYEES; // 107명

SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES; // 12개
-- NULL을 포함하고 있음


-- 정렬 ORDER BY : 무조건 문장의 끝에 있어야 함!!!
-- 오름차순 정렬 ASC
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID ASC;
-- NULL을 가장 큰 값으로 간주

-- 내림차순 정렬 DESC
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID DESC;

-- 이름, 급여, 부서번호를 이름의 오름차순으로 조회
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY FIRST_NAME;



-- 별칭 ALIAS
-- AS 생략 가능하며, 공백문자 또는 특수문자 포함시 큰따옴표 필수
-- PRODUCT : 중간의 몇 개만 조회했다는 의미
SELECT FIRST_NAME "이름 ♥", SALARY AS "급 여", DEPARTMENT_ID AS 부서번호
FROM EMPLOYEES
ORDER BY FIRST_NAME;


-- 1) 산술연산자 + - * /
--	SELECT와 FROM 사이에 주로 쓰며 조건절에서는 사용하지 않음
-- [문제] 직원 급여의 5%를 보너스로 지급하려고 한다
-- 직원의 사원번호, 이름, 급여, 보너스, 합계
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, SALARY*0.05 AS BONUS, SALARY+SALARY*0.05 TOTAL
FROM EMPLOYEES;

-- 2) 문자열 결합 연산자
-- [문제] 직원 이름 뒤에 '님'자 붙이기
SELECT FIRST_NAME || '님' AS "이름"
FROM EMPLOYEES;
-- [문제] '이름 성'을 붙여서 조회
SELECT FIRST_NAME || ' ' || LAST_NAME AS "이름"
FROM EMPLOYEES;

-- 3) 비교연산자 = != > >= < <=
-- WHERE절 뒤 조건에 많이 붙여서 쓴다
-- [문제] 급여가 10000 이상인 사람들의
-- 사원번호, 이름, 급여, 직급을 급여가 많은 순서대로 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID
FROM EMPLOYEES
WHERE SALARY>=10000 -- 조건절 WHERE
ORDER BY SALARY DESC;
-- [문제] 부서번호가 80번인 사람들의
-- 사원번호, 이름, 급여, 부서번호 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID=80;

-- 4) 논리연산자 AND OR NOT
-- NOT은 단항연산자
-- [문제] 급여가 5000~10000 이상인 사람들의
-- 사원번호, 이름, 급여, 직급을 조회
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID
FROM EMPLOYEES
WHERE SALARY>=5000 AND SALARY<=10000;
-- [문제] 부서번호가 10과 50이 아닌 사람들의
-- 이름, 부서번호를 부서별로 조회
SELECT FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE NOT(DEPARTMENT_ID=10 OR DEPARTMENT_ID=50)
ORDER BY 2; -- 2번째 컬럼을 기준으로

-- 5) NULL 연산자 IS NULL / IS NOT NULL
-- [문제] 커미션이 있는/없는 사람들의
-- 이름, 급여, 커미션을 조회
SELECT FIRST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;
-- [문제] 매니저가 없는 직원의 이름, 직급 조회
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;
-- [문제] 이름, 급여, 커미션금액, 총액을 조회
-- 단, 총액을 구하기 위해서는 커미션이 NULL이 아니어야 함!
-- 서브쿼리가 아닌 단일쿼리 Query이므로 급여+커미션 금액으로 총액 구할 수 없음
SELECT FIRST_NAME, SALARY, SALARY*COMMISSION_PCT AS "커미션 금액",
SALARY+SALARY*COMMISSION_PCT AS "총액"
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

-- 6) SQL 연산자 BETWEEN AND / IN
-- AND --> 컬럼명 BETWEEN a AND b
-- OR ?--> 컬럼명 IN (값, 값,…) 
-- [문제] 급여가 10000~15000 이상인 사람들의
-- 이름, 급여를 급여의 내림차순으로 조회
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 10000 AND 15000
ORDER BY SALARY DESC;
-- [문제] 부서번호가 10과 50인 사람들의
-- 이름, 부서번호를 부서별로 조회
SELECT FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (10, 50)
ORDER BY 2; // 2번째 컬럼을 기준으로
-- [문제] 급여가 7000을 초과하고 이메일이 'SKING'인 사람의
-- 이름, 전화번호, 급여, 이메일을 조회
SELECT FIRST_NAME, PHONE_NUMBER, SALARY, EMAIL
FROM EMPLOYEES
WHERE SALARY >= 7000 AND EMAIL = 'SKING';
-- [문제] 07년도에 입사한 직원들의
-- 이름, 입사일을 입사일의 오름차순으로 조회
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '07/01/01' AND '07/12/31'
ORDER BY HIRE_DATE;
-- [문제] 07년도 이전에 입사한 직원들의
-- 이름, 입사일을 입사일의 오름차순으로 조회
SELECT FIRST_NAME, HIRE_DATE, HIRE_DATE+1
FROM EMPLOYEES
WHERE HIRE_DATE < '07/01/01'
ORDER BY HIRE_DATE;
-- 날짜의 경우 : 작은 따옴표로 처리 필수
-- 문자열처럼 생겼지만 산술/비교 연산 가능!!

-- 7) LIKE 연산자와 와일드 카드
-- 컬럼명 LIKE '와일드 카드가 포함된 문자열'
-- 와일드 카드의 종류 *(모든 컬럼) %(문자 0~무한개) _(문자 1개)
-- [문제] 이름이 'J'로 시작하는 직원의 이름 조회
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'J%';
-- [문제] 이름이 'n'로 끝나는 직원의 이름 조회
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%n';
-- [문제] 이름이 'n'로 끝나면서 이름의 길이가 5인 직원의 이름 조회
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '____n';
-- [문제] 07년도에 입사한 직원들의
-- 이름, 입사일을 입사일의 오름차순으로 조회
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '07%'
ORDER BY HIRE_DATE;
-- [문제] 01월에 입사한 직원들의
-- 이름, 입사일을 입사일의 오름차순으로 조회
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '___01___'
ORDER BY HIRE_DATE;
-- 단, %01%로 하면 연도/월/일의 구분이 안됨!!


----------------------------------------------------
-- [문제] 매니저가 103인 직원들의
-- 아이디, 이름, 부서, 매니저 번호를 조회
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, MANAGER_ID
FROM EMPLOYEES
WHERE MANAGER_ID = 103;


-- [문제] 어느 부서에도 속하지 않은 직원들의
-- 이름, 전화번호, 부서를 조회
SELECT FIRST_NAME, PHONE_NUMBER, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NULL;

-- [문제] 급여가 10000을 초과하면서 JOB_ID가 'SA_REP'인 직원들의
-- 이메일, 이름, 전화번호, JOB_ID를 조회
SELECT EMAIL, FIRST_NAME, PHONE_NUMBER, JOB_ID
FROM EMPLOYEES
WHERE SALARY>10000 AND JOB_ID = 'SA_REP';


-- [문제] 부서가 60이거나 이름이 A로 시작하는 직원들의
-- 이름, 급여, 부서를 조회
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID=60 OR FIRST_NAME LIKE 'A%';


-- [문제] 부서가 10이거나 50이거나 60번 부서인 직원들의
-- 이름, 급여, 부서를 조회
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (10,50,60);

-- [문제] 이름이 3글자인 직원의 모든 정보 조회
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '___';

-- [문제] 전체 직원들 중 직급이 'CLERK'인 직원 조회 (종류가 많음)
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID LIKE '%CLERK';











-----------------------------------
-- [연습문제 모음]
-----------------------------------

-- 매니저가 103인 직원의 정보(아이디, 이름, 부서, 매니저번호)를 조회하시오.

-- 어느 부서에도 속하지 않은 직원의 정보 (이름, 전화번호, 부서)를 조회하시오

-- 급여가 10000을 초과하면서 JOB_ID가 'SA_REP'인 사람의 이메일, 이름, 전화번호, JOB_ID 정보를 조회하시오

-- 부서가 60이거나 이름이 A로 시작하는 시작하는 직원의 정보(이름, 급여, 부서)를 조회하시오.

-- 부서가 10이거나 50이거나 60번 부서의 직원의 정보(이름, 급여, 부서)를 조회하시오

-- 이름이 3글자인 모든 사람의 정보를 조회하시오.

-- 전체 직원들중 직급이 'CLERK' 들을 조회 (종류가 많음)
