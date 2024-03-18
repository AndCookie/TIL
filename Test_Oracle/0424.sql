/*2023�� 4�� 24�� (��)*/

/* ���տ�����
-- 1) ������ (Union, Union All)
-- 2) ������ (Intersection)
-- 3) ������ (Minus)
*/

-- Ư�� �����ȣ�� ���� ������ �����ȣ�� �̸��� ��ȸ (3��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158);

-- �̸��� 'A'�� �����ϴ� ������ �����ȣ�� �̸��� ��ȸ (10��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- ������ (2��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
INTERSECT
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- ������ (1��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
MINUS
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- ������ (8��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
MINUS
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158);

-- ������ (11��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%';

-- ������ + �ߺ� ������ ���� (13��)
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION ALL
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;


-- ����
-- 1) �÷��� ������ �ٸ� ���
-- "query block has incorrect number of result columns"
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;

-- 2) �÷� ������ ������ Ÿ���� �ٸ� ���
-- "expression must have same datatype as corresponding expression"
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;

-- 3) �÷� ������ Ÿ���� ���� ���
-- ������ �ƴϹǷ� ���� ��µǾ����� ���ϴ� �����Ͱ� �ƴ�
-- ù ��° ������ �������� ��µ�
SELECT EMPLOYEE_ID, FIRST_NAME, EMAIL
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(145, 147, 158)
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'
ORDER BY FIRST_NAME;





/* �Լ� (Function)
    : select�� ���� ���ǹ��� �Բ� ����Ͽ� ����� �����ϰ� ��ȸ ����
�Լ��� ���
    - �� ���ڵ忡 ���� Ư�� ������ �����ϰ� �Ѵ�
    - ������ ����� ��ȯ
�Լ��� ����
    - ������ �Լ� : �� ���ڵ��� ����� �����ϴ� �Լ�
    - �׷��� �Լ� : ���ڵ带 ��� ����� �����ϴ� �Լ�
*/


/*  ������ �Լ�
-- 1) ���ڿ� �Լ�
    - lower (���ڿ�)                           : �ҹ��ڷ� ����
    - upper (���ڿ�)                           : �빮�ڷ� ����
    - initcap (���ڿ�)                         : ù ���ڴ� �빮��, �������� �ҹ���
    - concat (���ڿ�1, ���ڿ�2)                : �� ���� ���ڿ� ���� (�������ڴ� ������ 2��)
    - substr (���ڿ�, ������ġ)                : Ư�� ���ڿ� ���� ��� �κй��ڿ� ��ȯ
    - substr (���ڿ�, ��� ������ġ, �������) : ���� ������ġ���� n���� �κй��ڿ� ��ȯ
    - substr (���ڿ�, ���� ������ġ, �������) : ���� ������ġ���� n���� �κй��ڿ� ��ȯ
    - length (���ڿ�)                          : ���ڿ��� ���� ��ȯ
    - instr (���ڿ�, ����)                     : ������ ��ġ�� ��ȯ (������ 0 ��ȯ)
    - replace (��ü���ڿ�, ã�����ڿ�, �ٲܹ��ڿ�)
-- 2) ���� �Լ�
    - abs (����)           : ������ ���밪
    - ceil (����)          : �ø�
    - floor (����)         : ����
    - round (����, �ڸ���) : ������ �ڸ��� ��ġ���� �ݿø�
    - trunc (����, �ڸ���) : ������ �ڸ��� ��ġ���� ����
    - mod (����1, ����2)   : ����1�� ����2�� ���� ������
    - power (����1, ����2) : ����1�� ����2�� ��ŭ ���� ��
    - sign (����)          : ���ڰ� �����̸� -1, 0�̸� 0, ����̸� +1�� ��ȯ
-- 3) ��¥ �Լ�
    - ��¥ ���� ��               : SYSDATE(���� �ý��� ��¥), SYSTIMESTAMP(���� �ý��� ��¥�� �ð�)
    - TO_DATE                    : ���ڿ� -> ��¥�� ��ȯ
    - +/-                        : �� ���� ��� // ����/���� ���� ���� (����/������ �Ұ�)
    - ADD_MONTHS (����, +/-n����)   : �� ���� ���
    - MONTHS_BETWEEN (��¥1, ��¥2) : �޼� ���
    - LAST_DAY (��¥)            : Ư�� ��¥�� ���� ���� ������ ��¥ ��ȯ
    - NEXT_DAY (��¥, '����')    : Ư�� ��¥�� �������� ���ƿ��� ���� ������ ��¥�� ��ȯ
-- 4) ��ȯ �Լ�
    - TO_DATE (���ڿ�)           : ��¥�� ��ȯ������ ������ ���ڿ��� -> ��¥ Ÿ������ ��ȯ
    - TO_NUMBER (���ڿ�)         : ���ڷ� ��ȯ������ ������ ���ڿ��� -> ���� Ÿ������ ��ȯ
    - TO_CHAR (��¥, '����')     : ��¥�� ���� �����͸� ���˿� ���� -> ���ڿ��� ��ȯ
-- 5) NULL �Լ�
    - nvl (�÷�, ������)         : Ư�� �÷� �� NULL ���� ���� �����ͷ� ��ȯ
    - nvl2 (�÷�, ������1, ������2) : NULL�� �ƴϸ� ������1, NULL�̸� ������2�� ��ȯ
-- 6) ��Ÿ �Լ�
    - DECODE (exp1, cond1, result1,
                    cond2, result2,
                    cond3, result3,
                    default)
                                 : switch~case�� ����
                                 : ����1�� ����1/2/3�� �ش��ϸ� result1/2/3�� ���
    - CASE WHEN ���ǽ�1 THEN ��1
           WHEN ���ǽ�2 THEN ��2 (�޸� ����!!)
           ...
           ELSE ����Ʈ��
      END
                                 : if���� ����
 
*/



-- LOWER
SELECT LOWER(FIRST_NAME)
FROM EMPLOYEES;
-- ��¥ ���̺� DUMMY TABLE (DUAL)�� �̿��� ��ȸ
-- SELECT�� �־�� ȭ�鿡 ����� �� �ְ�
-- FROM�� �־�� ���� ����� �Ǵ� ǥ�� �����ȴ�.
SELECT LOWER('World Cup 2002')
FROM DUAL;

-- UPPER
SELECT UPPER(FIRST_NAME)
FROM EMPLOYEES;

-- INITCAP
SELECT INITCAP('THE SOAP')
FROM DUAL;

-- SUBSTR : INDEX�� 1���� ������ (!!!����!!!)
SELECT SUBSTR('THE SOAP', 5) AS RESULT
FROM DUAL;

-- SUBSTR : INDEX�� 1���� ������ (!!!����!!!)
SELECT SUBSTR('THE SOAP', 5, 2) AS RESULT
FROM DUAL;

-- LENGTH
SELECT LENGTH('THE SOAP')
FROM DUAL; -- 8

-- INSTR
SELECT INSTR('THE SOAP', 'S')
FROM DUAL; -- 5
SELECT INSTR('����Ŭ ������', '��')
FROM DUAL; -- 2
SELECT INSTR('����Ŭ ������', '��')
FROM DUAL; -- 0


-- WHERE������ ���
-- �Լ��� ������� ���� ���
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES;
-- �Լ��� ����� ���
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE SUBSTR(FIRST_NAME, -1, 1) = 'n';
-- �� ���� �� �ڸ��� �ҹ��� n�� ���
SELECT EMPLOYEE_ID, FIRST_NAME
FROM EMPLOYEES
WHERE SUBSTR(FIRST_NAME, -2, 2) = 'en';
-- �� ���� �� �ڸ��� �ҹ��� en�� ���

-- [����] �Ի����� 03���� ���� ��ȸ : LIKE ���� SUBSTR����
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE SUBSTR(HIRE_DATE, 1, 2) = '03';

-- [����] �Ի����� 01���� ���� ��ȸ : LIKE vs SUBSTR
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
-- "invalid number of arguments" : �������ڴ� �� ���� ����!
SELECT
    CONCAT(EMPLOYEE_ID, ':', FIRST_NAME)
FROM EMPLOYEES;
-- ���� CONCAT
SELECT
    CONCAT(EMPLOYEE_ID, CONCAT(':', FIRST_NAME))
FROM EMPLOYEES;

-- REPLACE
SELECT FIRST_NAME, REPLACE(HIRE_DATE, '/', '-')
FROM EMPLOYEES;

SELECT FIRST_NAME, REPLACE(PHONE_NUMBER, '.', ' ')
FROM EMPLOYEES;





-- ABS ���밪
SELECT ABS(-15.3) FROM DUAL;

-- CEIL �ø�? (ū �������� ����)
SELECT CEIL(15.3), CEIL(-15.3) FROM DUAL;

-- FLOOR ����? (���� �������� ����)
SELECT FLOOR(15.7), FLOOR(-15.7) FROM DUAL;

-- ROUND ���� �ݿø�
-- ������ ���/���� ��� ����
-- �ڸ��� ������ �Ҽ��� '��'�ڸ� (-1�� �����ڸ� / -2�� �����ڸ�)
SELECT ROUND(15.193, 0), ROUND(15.193, 1), ROUND(15.193, 2) FROM DUAL;
SELECT ROUND(-15.193, 0), ROUND(-15.193, 1), ROUND(-15.193, 2) FROM DUAL;
SELECT ROUND(15.193, -1), ROUND(15.193, -2), ROUND(-15.193, -1), ROUND(-15.193, -2) FROM DUAL;

-- TRUNC ���� ����
-- ������ ���/���� ��� ����
-- �ڸ��� ������ �Ҽ��� '��'�ڸ� (-1�� �����ڸ� / -2�� �����ڸ�)
SELECT TRUNC(15.193, 0), TRUNC(15.193, 1), TRUNC(15.193, 2) FROM DUAL;
SELECT TRUNC(-15.193, 0), TRUNC(-15.193, 1), TRUNC(-15.193, 2) FROM DUAL;
SELECT TRUNC(15.193, -1), TRUNC(15.193, -2), TRUNC(-15.193, -1), TRUNC(-15.193, -2) FROM DUAL;

-- MOD(������), POWER(����), SIGN(���� ����)
SELECT MOD(10, 3) FROM DUAL;
SELECT POWER(10, 3) FROM DUAL;
SELECT SIGN(10) FROM DUAL;
SELECT SIGN(0) FROM DUAL;
SELECT SIGN(-10) FROM DUAL;





------------------------------------------------------------
-- ��¥ ������
------------------------------------------------------------
-- ��¥ ���� �� : SYSDATE(���� �ý��� ��¥), SYSTIMESTAMP(���� �ý��� ��¥�� �ð�)
SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- TO_DATE : ���ڿ� -> ��¥�� ��ȯ
SELECT TO_DATE('23/01/01'), '23/01/01' FROM DUAL;

-- 2023��1��1��0��0��0�ʺ����� �ð� ���
SELECT SYSDATE-TO_DATE('23/01/01') FROM DUAL;
-- 12��35�� -> 0.52��
-- 114��°!!! -> 113.52
SELECT CEIL(SYSDATE-TO_DATE('23/01/01')) FROM DUAL;

-- �¾ ��¥������ �ð� ���
SELECT SYSDATE-TO_DATE('97/11/15') FROM DUAL;
-- 9292��° ��� �ִ�



-- �� ���� ��� : ����/���� ���� ���� (����/������ �Ұ�)
SELECT SYSDATE+1 FROM DUAL; -- ������
SELECT SYSDATE-1 FROM DUAL; -- ����
SELECT SYSDATE*2 FROM DUAL; -- ERR

-- �� ���� ��� ADD_MONTHS
SELECT ADD_MONTHS(SYSDATE, 10) FROM DUAL; -- ���� ��
SELECT ADD_MONTHS(SYSDATE, -10) FROM DUAL; -- ���� ��

-- [����] ���� ��¥�� �������� �ٹ��ϼ��� �޼��� ���
SELECT FIRST_NAME, CEIL(SYSDATE-HIRE_DATE) AS �ٹ��ϼ�,
CEIL((SYSDATE-HIRE_DATE)/30) AS "�ٹ��޼� �뷫",
CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS "�ٹ��޼� ��Ȯ"
FROM EMPLOYEES
ORDER BY 2 DESC;
-- 271.23�� = 271���� + 0.23���� = 271���� + 30��*0.23���� = 271���� + 6.9��

-- LAST_DAY : Ư�� ���� ������ ���� ���� ������ ��ȯ
SELECT LAST_DAY(SYSDATE) FROM DUAL;
SELECT LAST_DAY(TO_DATE('2020/02/01')) FROM DUAL;

-- NEXT_DAY : Ư�� ��¥ �������� ���� ���� ���� ������ ��¥�� ��ȯ
SELECT SYSDATE, NEXT_DAY(SYSDATE, '������') FROM DUAL;

-- [����] ������ �ݿ����� �� ���ΰ���?
SELECT SYSDATE, NEXT_DAY(NEXT_DAY(SYSDATE, '�ݿ���'), '�ݿ���') FROM DUAL;
SELECT SYSDATE, NEXT_DAY(SYSDATE+7, '�ݿ���') FROM DUAL;




-- TO_NUMBER (���ڿ�->����)
SELECT '123.5', TO_NUMBER('123.5') FROM DUAL;

-- TO_CHAR (��¥,����->���ڿ�)
SELECT
    SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS "���� ��¥",
    TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI') AS "���� �ð� (�߿�!)",
    TO_CHAR(SYSDATE, 'YEAR-MONTH-DDD')
    -- �ѱ��� MON/MONTH �ǹ� ����
    -- DDD�� 1��1�Ϻ��� 114�� ����ߴٴ� �ǹ�
FROM DUAL;

-- TO_CHAR (��¥,����->���ڿ�)
SELECT TO_CHAR(123450, 'L999,999.00') FROM DUAL;

-- [����] �̸�, �޿�, �Ի����� ��ȸ
-- �޿� : �տ� �޷� ��ȣ, õ�ڸ����� �޸�, �Ҽ��� ���� 3�ڸ�
-- �Ի��� : ��4�ڸ�/��2�ڸ�/��2�ڸ� (����)
SELECT
    FIRST_NAME, TO_CHAR(SALARY, '$999,999.000') AS �޿�,
    TO_CHAR(HIRE_DATE, 'YYYY/MM/DD (DY)') AS �Ի���
FROM EMPLOYEES
ORDER BY 2 DESC;





-- NVL
SELECT FIRST_NAME, SALARY, COMMISSION_PCT, NVL(COMMISSION_PCT, 0)
FROM EMPLOYEES;
-- NVL2 : Ŀ�̼��� �ִ� ����� �޿�*Ŀ�̼�, ���� ����� 0
SELECT FIRST_NAME, SALARY, COMMISSION_PCT,
NVL2(COMMISSION_PCT, SALARY*COMMISSION_PCT, 0) AS "Ŀ�̼� �ݾ�"
FROM EMPLOYEES;
-- [����] �μ��� ������ �μ���ȣ, �μ��� ������ 0
SELECT FIRST_NAME, NVL(DEPARTMENT_ID, 0)
FROM EMPLOYEES
ORDER BY FIRST_NAME;

-- [����] �μ��� ������ �μ���ȣ, �μ��� ������ "�ӽ�" <TO_CHAR �̿�!>
SELECT FIRST_NAME, NVL(TO_CHAR(DEPARTMENT_ID), '�ӽ�') AS "�μ���ȣ"
FROM EMPLOYEES
ORDER BY FIRST_NAME;
-- �����ʹ� ��������ǥ, ALIAS�� ū����ǥ!

-- [����] �̸�, �μ���ȣ, �����ȣ, ������ ������ "ȸ��"
SELECT FIRST_NAME, DEPARTMENT_ID, NVL(TO_CHAR(MANAGER_ID), 'ȸ��') AS "�����ȣ"
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





/* [����] P.174 Q1
�̸��� �ټ� ���� �̻�, ���� ���� �̸��� �������� ��� ���� ����ϱ�.
MASKING_EMPNO������ ��� ��ȣ �� ���ڸ� �� ���ڸ��� * ��ȣ�� ���.
MASKING_ENAME������ ��� �̸��� ù ���ڸ� �����ְ� ������ ���ڼ���ŭ *��ȣ�� ���.
*/
SELECT FIRST_NAME, SUBSTR(FIRST_NAME, 1, 2)
CONCAT(CONCAT(SUBSTR(FIRST_NAME, 1, 2)), '***')
FROM EMPLOYEES
WHERE LENGTH(FIRST_NAME) = 5;


/* [����] P.174 Q2
������� �� ��� �ٹ��� ���� 21.5��.
�Ϸ� �ٹ� �ð��� 8�ð����� ������ ��, ������� �Ϸ� �޿�(DAY_PAY)�� �ñ�(TIME_PAY)�� ����Ͽ� ��� ����ϱ�.
��, �Ϸ� �޿��� �Ҽ��� �� ��° �ڸ����� ������, �ñ��� �� ��° �Ҽ������� �ݿø�.
*/
SELECT EMPLOYEE_ID, FIRST_NAME,
    SALARY,
    TRUNC(SALARY/12/21.5, 3) AS DAY_PAY,
    ROUND(SALARY/12/21.5/8, 2) AS TIME_PAY
FROM EMPLOYEES;



/* [����] P.175 Q3
�Ի��� ���� 3������ ���� �� ù �����Ͽ� �������� �ȴ�.
������� �������� �Ǵ� ��¥�� YYYY-MM-DD �������� ����Ͻÿ�.
��, �߰� ������ ���� ����� �߰� ������ N/A�� ����Ͻÿ�.
*/
SELECT EMPLOYEE_ID, FIRST_NAME,
    TO_CHAR(HIRE_DATE, 'YYYY/MM/DD') AS �Ի���,
    TO_CHAR(NEXT_DAY(ADD_MONTHS(HIRE_DATE, 3), '������'), 'YYYY/MM/DD (DY)') AS "������ �߷���",
    NVL(TO_CHAR(COMMISSION_PCT), 'N/A') AS "Ŀ�̼�"
FROM EMPLOYEES;


/* [����] P.175 Q4
�����ʰ� ���� ����� �������� SQL���� �ۼ��Ͻÿ�.
��� ������� ������� ���� �Ŵ��� ��ȣ�� ������ ���� ������ �������� ��ȯ�Ͽ� CHG_MGR���� ����Ͻÿ�.
- ���� ����� �����ȣ�� �������� ���� ��� : 0000
- ���� ����� �����ȣ �� �� �ڸ��� 75�� ��� : 5555
- ���� ����� �����ȣ �� �� �ڸ��� 76�� ��� : 6666
- ���� ����� �����ȣ �� �� �ڸ��� 77�� ��� : 7777
- ���� ����� �����ȣ �� �� �ڸ��� 78�� ��� : 8888
- �� �� ���� ��� �����ȣ�� ��� : ���� ���� ����� �����ȣ �״�� ���
*/






/*
������ �Լ� (�׷��� �Լ�)
- ����
    ���� ����� ���� �� �׷�ȭ ��Ų ��鿡 �Լ��� ����
- ����
    COUNT (�÷���)
    MIN (�÷���)
    MAX (�÷���)
    AVG (�÷���)
    SUM (�÷���)
    STDDEV ()
    VAR ()
*/

/*
- GROUP BY
    : Ư�� �÷��� �������� �׷�ȭ�Ͽ� ��� ��ȸ
    : ������ -> WHERE���� �Ұ��ϹǷ� HAVING ���
*/


SELECT COUNT(FIRST_NAME)
FROM EMPLOYEES; -- 107

SELECT COUNT(COMMISSION_PCT)
FROM EMPLOYEES; -- 35
-- NULL���� ��� ����

SELECT COUNT(*)
FROM EMPLOYEES;
-- ���ڵ� ���� ���ϴ� ���

SELECT COUNT(FIRST_NAME), MIN(SALARY), MAX(SALARY), AVG(SALARY)
FROM EMPLOYEES;




-- GROUP BY
-- WHERE���� �Բ� ��� �Ұ�!!!
-- HAVING�� �̿��ϱ�

-- [����] �� �μ��� ���� ���� �ִ�/�ּ� �޿� ��ȸ�ϱ�
-- ��, �ο����� 1���̰ų� NULL�� ���� ����
SELECT DEPARTMENT_ID, COUNT(*), MIN(SALARY), MAX(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING (COUNT(*)!=1 AND DEPARTMENT_ID IS NOT NULL)
ORDER BY DEPARTMENT_ID;

-- [����] �̸��� ���� ���� ��ȸ
-- �׷��� �Լ��� ���� �÷��� ���� ��ȸ �Ұ�
SELECT FIRST_NAME, COUNT(*)
FROM EMPLOYEES
GROUP BY FIRST_NAME;

-- [����] ���� ������ �Ի��� ���� ���� ��ȸ
-- TO_CHAR �̿�
SELECT TO_CHAR(HIRE_DATE, 'YYYY') AS "�Ի� ����", COUNT(*)
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE, 'YYYY')
ORDER BY 1;
-- SUBSTR �̿�
SELECT SUBSTR(HIRE_DATE, 1, 2) AS "�Ի� ����", COUNT(*)
FROM EMPLOYEES
GROUP BY SUBSTR(HIRE_DATE, 1, 2)
ORDER BY 1;





-----------------------------------
-- [�������� ����]
-----------------------------------
-- Ư�� �����ȣ 145, 147, 158�� ���� ������ �����ȣ�� �̸��� ��ȸ (3��)
-- �̸��� 'A'�� �����ϴ� ������ �����ȣ�� �̸��� ��ȸ (10��)
-- ** �ҹ���ȭ�� �̸� ��ȸ
-- ** �̸��� �� �� �� �ڸ��� �ҹ��� n�� ��� (SUBSTR ���)
-- �̸��� �� �� �� �ڸ��� �ҹ��� en�� ���
-- �Ի����� 03���� ���� ��ȸ (LIKE�� SUBSTR ��� ���)
-- ** �Ի����� 01���� ���� ��ȸ
-- ** �����ȣ:�̸� ���� ��ȸ (CONCAT ���)
-- ** �Ի����� 00-00-00�� ���·� ��ȸ (REPLACE ���)
-- ��ȭ��ȣ�� 000 0000 0000�� ���·� ��ȸ
-- ���� �ý��� ��¥ ��ȸ
-- ���� �ý��� ��¥�� �ð� ��ȸ
-- ** 2023��1��1��0��0��0�ʺ����� �ð� ��� ��ȸ
-- ** �¾ ��¥���� �ϼ� ��� ��ȸ
------------------------------------------------------------
-- 9299.896�� = 9300��°!!!
------------------------------------------------------------
-- ���� �ý��� ��¥ �������� 10���� ������ ��¥ ��ȸ
-- ** ���� ��¥�� �������� �ٹ��ϼ��� �޼��� ���
-- ** 2020��2��1�� �������� ���ƿ��� ���� �ݿ����� �� ������ ��ȸ
-- ** ������ �ݿ����� �� ������ ��ȸ
-- ** [����] �̸�, �޿�, �Ի����� ��ȸ (��, �Ի��� : ��4�ڸ�/��2�ڸ�/��2�ڸ� (����)
-- //  �޿� : �տ� �޷� ��ȣ, õ�ڸ����� �޸�, �Ҽ��� ���� 3�ڸ�)
-- �̸�, �޿�, Ŀ�̼��ۼ�Ʈ, Ŀ�̼� ���� ����� 0���� ǥ���� �� �� 4�� ��ȸ
-- ** Ŀ�̼��� �ִ� ����� �޿�*Ŀ�̼�, ���� ����� 0���� ��ȸ
-- �̸��� �μ� ��ȸ (�μ��� ������ �μ���ȣ, ������ 0���� ��ȸ)
-- ** �̸��� �μ� ��ȸ (�μ��� ������ �μ���ȣ, ������ "�ӽ�"�� ��ȸ)
-- �̸�, �μ���ȣ, �����ȣ ��ȸ (������ ������ "ȸ��"���� ��ȸ)
/* [����] P.174 Q1
�̸��� �ټ� ���� �̻�, ���� ���� �̸��� �������� ��� ���� ����ϱ�.
MASKING_EMPNO������ ��� ��ȣ �� ���ڸ� �� ���ڸ��� * ��ȣ�� ���.
MASKING_ENAME������ ��� �̸��� ù ���ڸ� �����ְ� ������ ���ڼ���ŭ *��ȣ�� ���.
/* [����] P.174 Q2
������� �� ��� �ٹ��� ���� 21.5��.
�Ϸ� �ٹ� �ð��� 8�ð����� ������ ��, ������� �Ϸ� �޿�(DAY_PAY)�� �ñ�(TIME_PAY)�� ����Ͽ� ��� ����ϱ�.
��, �Ϸ� �޿��� �Ҽ��� �� ��° �ڸ����� ������, �ñ��� �� ��° �Ҽ������� �ݿø�.
/* [����] P.175 Q3
�Ի��� ���� 3������ ���� �� ù �����Ͽ� �������� �ȴ�.
������� �������� �Ǵ� ��¥�� YYYY-MM-DD �������� ����Ͻÿ�.
��, �߰� ������ ���� ����� �߰� ������ N/A�� ����Ͻÿ�.
/* [����] P.175 Q4
�����ʰ� ���� ����� �������� SQL���� �ۼ��Ͻÿ�.
��� ������� ������� ���� �Ŵ��� ��ȣ�� ������ ���� ������ �������� ��ȯ�Ͽ� CHG_MGR���� ����Ͻÿ�.
- ���� ����� �����ȣ�� �������� ���� ��� : 0000
- ���� ����� �����ȣ �� �� �ڸ��� 75�� ��� : 5555
- ���� ����� �����ȣ �� �� �ڸ��� 76�� ��� : 6666
- ���� ����� �����ȣ �� �� �ڸ��� 77�� ��� : 7777
- ���� ����� �����ȣ �� �� �ڸ��� 78�� ��� : 8888
- �� �� ���� ��� �����ȣ�� ��� : ���� ���� ����� �����ȣ �״�� ���
*/
-- ** �� �μ��� ���� ���� �ִ�/�ּ� �޿� ��ȸ�ϱ� (��, �ο����� 1���̰ų� NULL�� ���� ����)
-- ** ���� ������ �Ի��� ���� ���� ��ȸ (TO_CHAR �̿� & SUBSTR �̿�)








