/*2023년 4월 24일 (월)*/

/* 집합연산자
-- 1) 합집합 (Union, Union All)
-- 2) 교집합 (Intersection)
-- 3) 차집합 (Minus)
*/

-- 특정 사원번호를 가진 직원의 사원번호와 이름을 조회 (3명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158);

-- 이름이 'A'로 시작하는 직원의 사원번호와 이름을 조회 (10명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- 교집합 (2명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
INTERSECT
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- 차집합 (1명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
MINUS
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- 차집합 (8명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
MINUS
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158);

-- 합집합 (11명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- 합집합 + 중복 데이터 포함 (13명)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION ALL
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;


-- 오류
-- 1) 컬럼의 개수가 다른 경우
-- "query block has incorrect number of result columns"
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;

-- 2) 컬럼 개수는 같지만 타입이 다른 경우
-- "expression must have same datatype as corresponding expression"
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;

-- 3) 컬럼 개수와 타입이 같은 경우
-- 에러는 아니므로 정상 출력되었지만 원하는 데이터가 아님
-- 첫 번째 집합을 기준으로 출력됨
SELECT EMPLOYEE_ID, FIRST_NAME, EMAIL
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;





/* 함수 (Function)
    : select와 같은 질의문과 함께 사용하여 결과를 강력하게 조회 가능
함수의 기능
    - 각 레코드에 대한 특정 연산을 가능하게 한다
    - 데이터 결과를 변환
함수의 종류
    - 단일행 함수 : 각 레코드의 기능을 수행하는 함수
    - 그룹행 함수 : 레코드를 묶어서 기능을 수행하는 함수
*/


/*  단일행 함수
-- 1) 문자열 함수
    - lower (문자열)                           : 소문자로 변경
    - upper (문자열)                           : 대문자로 변경
    - initcap (문자열)                         : 첫 글자는 대문자, 나머지는 소문자
    - concat (문자열1, 문자열2)                : 두 개의 문자열 결합 (전달인자는 무조건 2개)
    - substr (문자열, 시작위치)                : 특정 문자열 뒤의 모든 부분문자열 반환
    - substr (문자열, 양수 시작위치, 추출길이) : 앞의 시작위치부터 n개의 부분문자열 반환
    - substr (문자열, 음수 시작위치, 추출길이) : 뒤의 시작위치부터 n개의 부분문자열 반환
    - length (문자열)                          : 문자열의 길이 반환
    - instr (문자열, 문자)                     : 문자의 위치값 반환 (없으면 0 반환)
    - replace (전체문자열, 찾을문자열, 바꿀문자열)
-- 2) 숫자 함수
    - abs (숫자)           : 숫자의 절대값
    - ceil (숫자)          : 올림
    - floor (숫자)         : 버림
    - round (숫자, 자릿수) : 지정한 자릿수 위치에서 반올림
    - trunc (숫자, 자릿수) : 지정한 자릿수 위치에서 절삭
    - mod (숫자1, 숫자2)   : 숫자1을 숫자2로 나눈 나머지
    - power (숫자1, 숫자2) : 숫자1을 숫자2번 만큼 곱한 값
    - sign (숫자)          : 숫자가 음수이면 -1, 0이면 0, 양수이면 +1을 반환
-- 3) 날짜 함수
    - 날짜 관련 값               : SYSDATE(현재 시스템 날짜), SYSTIMESTAMP(현재 시스템 날짜와 시간)
    - TO_DATE                    : 문자열 -> 날짜로 변환
    - +/-                        : 일 단위 계산 // 덧셈/뺄셈 연산 가능 (곱셈/나눗셈 불가)
    - ADD_MONTHS (기준, +/-n개월)   : 월 단위 계산
    - MONTHS_BETWEEN (날짜1, 날짜2) : 달수 계산
    - LAST_DAY (날짜)            : 특정 날짜가 속한 달의 마지막 날짜 반환
    - NEXT_DAY (날짜, '요일')    : 특정 날짜를 기준으로 돌아오는 지정 요일의 날짜를 반환
-- 4) 변환 함수
    - TO_DATE (문자열)           : 날짜로 변환가능한 형태의 문자열을 -> 날짜 타입으로 변환
    - TO_NUMBER (문자열)         : 숫자로 변환가능한 형태의 문자열을 -> 숫자 타입으로 변환
    - TO_CHAR (날짜, '포맷')     : 날짜나 숫자 데이터를 포맷에 맞춰 -> 문자열로 변환
-- 5) NULL 함수
    - nvl (컬럼, 데이터)         : 특정 컬럼 내 NULL 값을 지정 데이터로 변환
    - nvl2 (컬럼, 데이터1, 데이터2) : NULL이 아니면 데이터1, NULL이면 데이터2로 변환
-- 6) 기타 함수
    - DECODE (exp1, cond1, result1,
                    cond2, result2,
                    cond3, result3,
                    default)
                                 : switch~case와 유사
                                 : 수식1이 조건1/2/3에 해당하면 result1/2/3을 출력
    - CASE WHEN 조건식1 THEN 값1
           WHEN 조건식2 THEN 값2 (콤마 없음!!)
           ...
           ELSE 디폴트값
      END
                                 : if문과 유사
 
*/



-- LOWER
SELECT LOWER(FIRST_NAME)
FROM EMPLOYEES;
-- 가짜 테이블 DUMMY TABLE (DUAL)을 이용한 조회
-- SELECT가 있어야 화면에 출력할 수 있고
-- FROM이 있어야 추출 대상이 되는 표가 지정된다.
SELECT LOWER('World Cup 2002')
FROM DUAL;

-- UPPER
SELECT UPPER(FIRST_NAME)
FROM EMPLOYEES;

-- INITCAP
SELECT INITCAP('THE SOAP')
FROM DUAL;

-- SUBSTR : INDEX가 1부터 시작함 (!!!주의!!!)
SELECT SUBSTR('THE SOAP', 5) AS RESULT
FROM DUAL;

-- SUBSTR : INDEX가 1부터 시작함 (!!!주의!!!)
SELECT SUBSTR('THE SOAP', 5, 2) AS RESULT
FROM DUAL;

-- LENGTH
SELECT LENGTH('THE SOAP')
FROM DUAL; -- 8

-- INSTR
SELECT INSTR('THE SOAP', 'S')
FROM DUAL; -- 5
SELECT INSTR('오라클 마스터', '라')
FROM DUAL; -- 2
SELECT INSTR('오라클 마스터', '매')
FROM DUAL; -- 0


-- WHERE절에서 사용
-- 함수를 사용하지 않은 경우
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES;
-- 함수를 사용한 경우
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE SUBSTR(FIRST_NAME, -1, 1) = 'n';
-- 맨 뒤의 한 자리가 소문자 n인 경우
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE SUBSTR(FIRST_NAME, -2, 2) = 'en';
-- 맨 뒤의 두 자리가 소문자 en인 경우

-- [연습] 입사일이 03년인 직원 조회 : LIKE 말고 SUBSTR으로
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE SUBSTR(HIRE_DATE, 1, 2) = '03';

-- [연습] 입사일이 01월인 직원 조회 : LIKE vs SUBSTR
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '%/01/%';

SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE SUBSTR(HIRE_DATE, 4, 2) = '01';

-- CONCAT
SELECT
    CONCAT('I have', ' a dream')
FROM DUAL;
-- "invalid number of arguments" : 전달인자는 두 개만 가능!
SELECT
    CONCAT(EMPLOYEE_ID, ':', FIRST_NAME)
FROM EMPLOYEES;
-- 이중 CONCAT
SELECT
    CONCAT(EMPLOYEE_ID, CONCAT(':', FIRST_NAME))
FROM EMPLOYEES;

-- REPLACE
SELECT FIRST_NAME, REPLACE(HIRE_DATE, '/', '-')
FROM EMPLOYEES;

SELECT FIRST_NAME, REPLACE(PHONE_NUMBER, '.', ' ')
FROM EMPLOYEES;





-- ABS 절대값
SELECT ABS(-15.3) FROM DUAL;

-- CEIL 올림? (큰 방향으로 진행)
SELECT CEIL(15.3), CEIL(-15.3) FROM DUAL;

-- FLOOR 버림? (작은 방향으로 진행)
SELECT FLOOR(15.7), FLOOR(-15.7) FROM DUAL;

-- ROUND 지정 반올림
-- 숫자의 양수/음수 결과 동일
-- 자릿수 음수는 소수점 '앞'자리 (-1는 일의자리 / -2는 십의자리)
SELECT ROUND(15.193, 0), ROUND(15.193, 1), ROUND(15.193, 2) FROM DUAL;
SELECT ROUND(-15.193, 0), ROUND(-15.193, 1), ROUND(-15.193, 2) FROM DUAL;
SELECT ROUND(15.193, -1), ROUND(15.193, -2), ROUND(-15.193, -1), ROUND(-15.193, -2) FROM DUAL;

-- TRUNC 지정 절삭
-- 숫자의 양수/음수 결과 동일
-- 자릿수 음수는 소수점 '앞'자리 (-1는 일의자리 / -2는 십의자리)
SELECT TRUNC(15.193, 0), TRUNC(15.193, 1), TRUNC(15.193, 2) FROM DUAL;
SELECT TRUNC(-15.193, 0), TRUNC(-15.193, 1), TRUNC(-15.193, 2) FROM DUAL;
SELECT TRUNC(15.193, -1), TRUNC(15.193, -2), TRUNC(-15.193, -1), TRUNC(-15.193, -2) FROM DUAL;

-- MOD(나머지), POWER(제곱), SIGN(음양 구분)
SELECT MOD(10, 3) FROM DUAL;
SELECT POWER(10, 3) FROM DUAL;
SELECT SIGN(10) FROM DUAL;
SELECT SIGN(0) FROM DUAL;
SELECT SIGN(-10) FROM DUAL;





------------------------------------------------------------
-- 날짜 데이터
------------------------------------------------------------
-- 날짜 관련 값 : SYSDATE(현재 시스템 날짜), SYSTIMESTAMP(현재 시스템 날짜와 시간)
SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- TO_DATE : 문자열 -> 날짜로 변환
SELECT TO_DATE('23/01/01'), '23/01/01' FROM DUAL;

-- 2023년1월1일0시0분0초부터의 시간 경과
SELECT SYSDATE-TO_DATE('23/01/01') FROM DUAL;
-- 12시35분 -> 0.52일
-- 114일째!!! -> 113.52
SELECT CEIL(SYSDATE-TO_DATE('23/01/01')) FROM DUAL;

-- 태어난 날짜부터의 시간 경과
SELECT SYSDATE-TO_DATE('97/11/15') FROM DUAL;
-- 9292일째 살고 있다



-- 일 단위 계산 : 덧셈/뺄셈 연산 가능 (곱셈/나눗셈 불가)
SELECT SYSDATE+1 FROM DUAL; -- 다음날
SELECT SYSDATE-1 FROM DUAL; -- 전날
SELECT SYSDATE*2 FROM DUAL; -- ERR

-- 월 단위 계산 ADD_MONTHS
SELECT ADD_MONTHS(SYSDATE, 10) FROM DUAL; -- 열달 후
SELECT ADD_MONTHS(SYSDATE, -10) FROM DUAL; -- 열달 전

-- [연습] 오늘 날짜를 기준으로 근무일수와 달수를 계산
SELECT FIRST_NAME, CEIL(SYSDATE-HIRE_DATE) AS 근무일수,
CEIL((SYSDATE-HIRE_DATE)/30) AS "근무달수 대략",
CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "근무달수 정확"
FROM EMPLOYEES
ORDER BY 2 DESC;
-- 271.23달 = 271개월 + 0.23개월 = 271개월 + 30일*0.23개월 = 271개월 + 6.9일

-- LAST_DAY : 특정 달의 마지막 날이 무슨 날인지 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;
SELECT LAST_DAY(TO_DATE('2020/02/01')) FROM DUAL;

-- NEXT_DAY : 특정 날짜 기준으로 가장 빠른 지정 요일의 날짜를 반환
SELECT SYSDATE, NEXT_DAY(SYSDATE, '월요일') FROM DUAL;

-- [연습] 다음주 금요일이 몇 일인가요?
SELECT SYSDATE, NEXT_DAY(NEXT_DAY(SYSDATE, '금요일'), '금요일') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE+7, '금요일') FROM DUAL;




-- TO_NUMBER (문자열->숫자)
SELECT '123.5', TO_NUMBER('123.5') FROM DUAL;

-- TO_CHAR (날짜,숫자->문자열)
SELECT
    SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS "현재 날짜",
    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI') AS "현재 시간 (중요!)",
    TO_CHAR(SYSDATE, 'YEAR-MONTH-DDD')
    -- 한글은 MON/MONTH 의미 없음
    -- DDD는 1월1일부터 114일 경과했다는 의미
FROM DUAL;

-- TO_CHAR (날짜,숫자->문자열)
SELECT TO_CHAR(123450, 'L999,999.00') FROM DUAL;

-- [연습] 이름, 급여, 입사일을 조회
-- 급여 : 앞에 달러 기호, 천자리마다 콤마, 소수점 이하 3자리
-- 입사일 : 연4자리/월2자리/일2자리 (요일)
SELECT
    FIRST_NAME, TO_CHAR(SALARY, '$999,999.000') AS 급여,
    TO_CHAR(HIRE_DATE, 'YYYY/MM/DD (DY)') AS 입사일
FROM EMPLOYEES
ORDER BY 2 DESC;





-- NVL
SELECT FIRST_NAME, SALARY, COMMISSION_PCT, NVL(COMMISSION_PCT, 0)
FROM EMPLOYEES;
-- NVL2 : 커미션이 있는 사람은 급여*커미션, 없는 사람은 0
SELECT FIRST_NAME, SALARY, COMMISSION_PCT,
NVL2(COMMISSION_PCT, SALARY*COMMISSION_PCT, 0) AS "커미션 금액"
FROM EMPLOYEES;
-- [연습] 부서가 있으면 부서번호, 부서가 없으면 0
SELECT FIRST_NAME, NVL(DEPARTMENT_ID, 0)
FROM EMPLOYEES
ORDER BY FIRST_NAME;

-- [연습] 부서가 있으면 부서번호, 부서가 없으면 "임시" <TO_CHAR 이용!>
SELECT FIRST_NAME, NVL(TO_CHAR(DEPARTMENT_ID), '임시') AS "부서번호"
FROM EMPLOYEES
ORDER BY FIRST_NAME;
-- 데이터는 작은따옴표, ALIAS는 큰따옴표!

-- [연습] 이름, 부서번호, 팀장번호, 팀장이 없으면 "회장"
SELECT FIRST_NAME, DEPARTMENT_ID, NVL(TO_CHAR(MANAGER_ID), '회장') AS "팀장번호"
FROM EMPLOYEES
ORDER BY EMPLOYEE_ID;




-- DECODE
SELECT FIRST_NAME,
    DECODE(DEPARTMENT_ID, 10, 'Administration',
                          20, 'Marketing',
                          30, 'Purchasing',
                          40, 'Human Resources',
                          50, 'Shipping') AS DEPT_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN(10,20,30,40,50);


-- CASE-WHEN
SELECT FIRST_NAME,
    CASE WHEN DEPARTMENT_ID = 10 THEN 'Administration'
         WHEN DEPARTMENT_ID = 20 THEN 'Marketing'
         WHEN DEPARTMENT_ID = 30 THEN 'Purchasing'
         WHEN DEPARTMENT_ID = 40 THEN 'Human Resources'
         WHEN DEPARTMENT_ID = 50 THEN 'Shipping'
         ELSE 'Default'
    END AS DEPT_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN(10,20,30,40,50);
-- CASE-WHEN
SELECT FIRST_NAME,
    CASE DEPARTMENT_ID
         WHEN 10 THEN 'Administration'
         WHEN 20 THEN 'Marketing'
         WHEN 30 THEN 'Purchasing'
         WHEN 40 THEN 'Human Resources'
         WHEN 50 THEN 'Shipping'
         ELSE 'Default'
    END AS DEPT_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN(10,20,30,40,50);





/* [연습] P.174 Q1
이름이 다섯 글자 이상, 여섯 글자 미만인 직원들의 사원 정보 출력하기.
MASKING_EMPNO열에는 사원 번호 앞 두자리 외 뒷자리를 * 기호로 출력.
MASKING_ENAME열에는 사원 이름의 첫 글자만 보여주고 나머지 글자수만큼 *기호로 출력.
*/
SELECT FIRST_NAME, SUBSTR(FIRST_NAME, 1, 2)
CONCAT(CONCAT(SUBSTR(FIRST_NAME, 1, 2)), '***')
FROM EMPLOYEES
WHERE LENGTH(FIRST_NAME) = 5;


/* [연습] P.174 Q2
사원들의 월 평균 근무일 수는 21.5일.
하루 근무 시간을 8시간으로 보았을 때, 사원들의 하루 급여(DAY_PAY)와 시급(TIME_PAY)을 계산하여 결과 출력하기.
단, 하루 급여는 소수점 세 번째 자리에서 버리고, 시급은 두 번째 소수점에서 반올림.
*/
SELECT EMPLOYEE_ID, FIRST_NAME,
    SALARY,
    TRUNC(SALARY/12/21.5, 3) AS DAY_PAY,
    ROUND(SALARY/12/21.5/8, 2) AS TIME_PAY
FROM EMPLOYEES;



/* [연습] P.175 Q3
입사일 기준 3개월이 지난 후 첫 월요일에 정직원이 된다.
사원들이 정직원이 되는 날짜를 YYYY-MM-DD 형식으로 출력하시오.
단, 추가 수당이 없는 사원의 추가 수당은 N/A로 출력하시오.
*/
SELECT EMPLOYEE_ID, FIRST_NAME,
    TO_CHAR(HIRE_DATE, 'YYYY/MM/DD') AS 입사일,
    TO_CHAR(NEXT_DAY(ADD_MONTHS(HIRE_DATE, 3), '월요일'), 'YYYY/MM/DD (DY)') AS "정직원 발령일",
    NVL(TO_CHAR(COMMISSION_PCT), 'N/A') AS "커미션"
FROM EMPLOYEES;


/* [연습] P.175 Q4
오른쪽과 같은 결과가 나오도록 SQL문을 작성하시오.
모든 사원들을 대상으로 직속 매니저 번호를 다음과 같은 조건을 기준으로 변환하여 CHG_MGR열에 출력하시오.
- 직속 상관의 사원번호가 존재하지 않을 경우 : 0000
- 직속 상관의 사원번호 앞 두 자리가 75인 경우 : 5555
- 직속 상관의 사원번호 앞 두 자리가 76인 경우 : 6666
- 직속 상관의 사원번호 앞 두 자리가 77인 경우 : 7777
- 직속 상관의 사원번호 앞 두 자리가 78인 경우 : 8888
- 그 외 직속 상관 사원번호의 경우 : 본래 직속 상관의 사원번호 그대로 출력
*/






/*
다중행 함수 (그룹행 함수)
- 정의
    여러 행들이 있을 때 그룹화 시킨 행들에 함수를 적용
- 종류
    COUNT (컬럼명)
    MIN (컬럼명)
    MAX (컬럼명)
    AVG (컬럼명)
    SUM (컬럼명)
    STDDEV ()
    VAR ()
*/

/*
- GROUP BY
    : 특정 컬럼을 기준으로 그룹화하여 결과 조회
    : 조건절 -> WHERE절은 불가하므로 HAVING 사용
*/


SELECT COUNT(FIRST_NAME)
FROM EMPLOYEES; -- 107

SELECT COUNT(COMMISSION_PCT)
FROM EMPLOYEES; -- 35
-- NULL값은 계산 제외

SELECT COUNT(*)
FROM EMPLOYEES;
-- 레코드 개수 구하는 방법

SELECT COUNT(FIRST_NAME), MIN(SALARY), MAX(SALARY), AVG(SALARY)
FROM EMPLOYEES;




-- GROUP BY
-- WHERE절과 함께 사용 불가!!!
-- HAVING절 이용하기

-- [연습] 각 부서별 직원 수와 최대/최소 급여 조회하기
-- 단, 인원수가 1명이거나 NULL인 것은 제외
SELECT DEPARTMENT_ID, COUNT(*), MIN(SALARY), MAX(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING (COUNT(*)!=1 AND DEPARTMENT_ID IS NOT NULL)
ORDER BY DEPARTMENT_ID;

-- [오류] 이름별 직원 수를 조회
-- 그룹행 함수와 단일 컬럼은 같이 조회 불가
SELECT FIRST_NAME, COUNT(*)
FROM EMPLOYEES
GROUP BY FIRST_NAME;

-- [연습] 같은 연도에 입사한 직원 수를 조회
-- TO_CHAR 이용
SELECT TO_CHAR(HIRE_DATE, 'YYYY') AS "입사 연도", COUNT(*)
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE, 'YYYY')
ORDER BY 1;
-- SUBSTR 이용
SELECT SUBSTR(HIRE_DATE, 1, 2) AS "입사 연도", COUNT(*)
FROM EMPLOYEES
GROUP BY SUBSTR(HIRE_DATE, 1, 2)
ORDER BY 1;





-----------------------------------
-- [연습문제 모음]
-----------------------------------
-- 특정 사원번호 145, 147, 158를 가진 직원의 사원번호와 이름을 조회 (3명)
-- 이름이 'A'로 시작하는 직원의 사원번호와 이름을 조회 (10명)
-- ** 소문자화된 이름 조회
-- ** 이름의 맨 뒤 한 자리가 소문자 n인 경우 (SUBSTR 사용)
-- 이름의 맨 뒤 두 자리가 소문자 en인 경우
-- 입사일이 03년인 직원 조회 (LIKE와 SUBSTR 모두 사용)
-- ** 입사일이 01월인 직원 조회
-- ** 사원번호:이름 으로 조회 (CONCAT 사용)
-- ** 입사일을 00-00-00의 형태로 조회 (REPLACE 사용)
-- 전화번호를 000 0000 0000의 형태로 조회
-- 현재 시스템 날짜 조회
-- 현재 시스템 날짜와 시간 조회
-- ** 2023년1월1일0시0분0초부터의 시간 경과 조회
-- ** 태어날 날짜부터 일수 경과 조회
------------------------------------------------------------
-- 9299.896일 = 9300일째!!!
------------------------------------------------------------
-- 현재 시스템 날짜 기준으로 10개월 전후의 날짜 조회
-- ** 오늘 날짜를 기준으로 근무일수와 달수를 계산
-- ** 2020년2월1일 기준으로 돌아오는 주의 금요일이 몇 일인지 조회
-- ** 다음주 금요일은 몇 일인지 조회
-- ** [연습] 이름, 급여, 입사일을 조회 (단, 입사일 : 연4자리/월2자리/일2자리 (요일)
-- //  급여 : 앞에 달러 기호, 천자리마다 콤마, 소수점 이하 3자리)
-- 이름, 급여, 커미션퍼센트, 커미션 없는 사람은 0으로 표시한 것 총 4개 조회
-- ** 커미션이 있는 사람은 급여*커미션, 없는 사람은 0으로 조회
-- 이름과 부서 조회 (부서가 있으면 부서번호, 없으면 0으로 조회)
-- ** 이름과 부서 조회 (부서가 있으면 부서번호, 없으면 "임시"로 조회)
-- 이름, 부서번호, 팀장번호 조회 (팀장이 없으면 "회장"으로 조회)
/* [연습] P.174 Q1
이름이 다섯 글자 이상, 여섯 글자 미만인 직원들의 사원 정보 출력하기.
MASKING_EMPNO열에는 사원 번호 앞 두자리 외 뒷자리를 * 기호로 출력.
MASKING_ENAME열에는 사원 이름의 첫 글자만 보여주고 나머지 글자수만큼 *기호로 출력.
/* [연습] P.174 Q2
사원들의 월 평균 근무일 수는 21.5일.
하루 근무 시간을 8시간으로 보았을 때, 사원들의 하루 급여(DAY_PAY)와 시급(TIME_PAY)을 계산하여 결과 출력하기.
단, 하루 급여는 소수점 세 번째 자리에서 버리고, 시급은 두 번째 소수점에서 반올림.
/* [연습] P.175 Q3
입사일 기준 3개월이 지난 후 첫 월요일에 정직원이 된다.
사원들이 정직원이 되는 날짜를 YYYY-MM-DD 형식으로 출력하시오.
단, 추가 수당이 없는 사원의 추가 수당은 N/A로 출력하시오.
/* [연습] P.175 Q4
오른쪽과 같은 결과가 나오도록 SQL문을 작성하시오.
모든 사원들을 대상으로 직속 매니저 번호를 다음과 같은 조건을 기준으로 변환하여 CHG_MGR열에 출력하시오.
- 직속 상관의 사원번호가 존재하지 않을 경우 : 0000
- 직속 상관의 사원번호 앞 두 자리가 75인 경우 : 5555
- 직속 상관의 사원번호 앞 두 자리가 76인 경우 : 6666
- 직속 상관의 사원번호 앞 두 자리가 77인 경우 : 7777
- 직속 상관의 사원번호 앞 두 자리가 78인 경우 : 8888
- 그 외 직속 상관 사원번호의 경우 : 본래 직속 상관의 사원번호 그대로 출력
*/
-- ** 각 부서별 직원 수와 최대/최소 급여 조회하기 (단, 인원수가 1명이거나 NULL인 것은 제외)
-- ** 같은 연도에 입사한 직원 수를 조회 (TO_CHAR 이용 & SUBSTR 이용)








