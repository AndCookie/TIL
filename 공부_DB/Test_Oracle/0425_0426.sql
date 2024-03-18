/*
[��������]
1. 80�� �μ��� �޿� ���, �ְ�, ����, �ο����� ���Ͻÿ�.

2. �� �μ��� �޿��� ���, �ְ�, ����, �ο����� ���Ͻÿ�.

3. �� �μ��� ��� ����, ��ü ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����Ͻÿ�.
��, �μ���ȣ�� NULL�̸� ������� �ʴ´�.

-- ** 4. �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ, ������, �ο����� ����Ͻÿ�.

-- ** 5. ���� ������ �ϴ� ����� ���� 4�� �̻��� ������ �ο����� ����Ͻÿ�.
*/


-- 1. 80�� �μ��� �޿� ���, �ְ�, ����, �ο����� ���Ͻÿ�.
SELECT AVG(SALARY) AS "��� �޿�",
    MAX(SALARY) AS "�ְ� �޿�",
    MIN(SALARY) AS "���� �޿�",
    COUNT(SALARY) AS "�ο���"   
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80;
-- WHERE ��� GROUP BY ��� ����
-- GROUP BY DEPARTMENT_ID
-- HAVING DEPARTMENT_ID=80;


-- 2. �� �μ��� �޿��� ���, �ְ�, ����, �ο����� ���Ͻÿ�.
SELECT DEPARTMENT_ID,
    AVG(SALARY) AS "��� �޿�",
    MAX(SALARY) AS "�ְ� �޿�",
    MIN(SALARY) AS "���� �޿�",
    COUNT(SALARY) AS "�ο���"   
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY 1;


-- 3. �� �μ��� ��� ����, ��ü ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����Ͻÿ�.
-- ��, �μ���ȣ�� NULL�̸� ������� �ʴ´�.
SELECT DEPARTMENT_ID,
    AVG(SALARY)/12 AS "��� ����",
    SUM(SALARY)/12 AS "��ü ����",
    MIN(SALARY)/12 AS "���� ����",
    COUNT(SALARY)/12 AS "�ο���"   
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING DEPARTMENT_ID IS NOT NULL
ORDER BY 2 DESC;


-- 4. �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ, ������, �ο����� ����Ͻÿ�.
SELECT DEPARTMENT_ID AS "�μ���ȣ",
    JOB_ID AS "������",
    COUNT(JOB_ID) AS "�ο���"   
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY 1;
-- GROUP BY�� JOB_ID�� ���ٸ� ���� �߻�!!


-- 5. ���� ������ �ϴ� ����� ���� 4�� �̻��� ������ �ο����� ����Ͻÿ�.
SELECT 
    JOB_ID AS "������",
    COUNT(JOB_ID) AS "�ο���"   
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING COUNT(JOB_ID) >= 4
ORDER BY 2 DESC;







/* JOIN
- �� �̻��� ���̺�κ��� �����ؿ��� ��
- ���̺���� ���� PK�� FK�� ���踦 ���� ����
*/

-- [����] �̸�(E), �޿�(E), �μ���(D)

-------------------- 2889�� �� --------------------
------------------ 107��*27�μ� -------------------
-- CARTESIAN JOIN : ��� ����� ���� �� �����ִ� ����

-- ���1 -- dot.
SELECT EMPLOYEES.FIRST_NAME, EMPLOYEES.SALARY, DEPARTMENTS.DEPARTMENT_NAME
FROM EMPLOYEES, DEPARTMENTS;

-- ���2 -- ��Ī
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d -- as ���� �ȵ�!!
ORDER BY 1;


-------------------- 106�� �� --------------------
-- EQUI JOIN : PK�� FK�� ��Ī�Ǵ� ���� (����Ŭ ����)
-- ==> INNER JOIN�� ����� ������ ��ɾ �ٸ�
-- PK�� FK�� ���ƾ� ������ ��
-- FK�� NULL�� ��� ���ε��� ���� �� �ִ�

-- ���3 -- EQUI JOIN (����Ŭ ����)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d
WHERE d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;
-- 27 = NULL ������ 107���� �ƴ� 106���� ������ ��



-------------------- 106�� �� --------------------
-- INNER JOIN : PK�� FK�� ��Ī�Ǵ� ���� (ANSI ǥ��)
-- INNER Ű����� ���� ����
-- ON (PK=FK) �Ǵ� USING (�÷Ÿ�/��ȣ�����Ұ�)

-- ���4 -- INNER JOIN ~ ON (PK=FK)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;

-- ���5 -- INNER JOIN ~ USING (�÷���)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e JOIN DEPARTMENTS d
USING (DEPARTMENT_ID) -- ��ȣ ���� �Ұ�!!
ORDER BY 1;



-- [����] 2�� ���̺� �����ϱ�
-- �μ���(DEPARTMNET_NAME), ���ø�(CITY)�� ��ȸ�Ͻÿ�.
-- 1) ����Ŭ ���� / EQUI JOIN
SELECT d.DEPARTMENT_NAME, l.CITY
FROM DEPARTMENTS d, LOCATIONS l
WHERE d.LOCATION_ID = l.LOCATION_ID
ORDER BY 1;

-- 2) ANSI ǥ�� / INNER JOIN ~ ON
SELECT d.DEPARTMENT_NAME, l.CITY
FROM DEPARTMENTS d JOIN LOCATIONS l
ON d.LOCATION_ID = l.LOCATION_ID
ORDER BY 1;

-- 3) ANSI ǥ�� / INNER JOIN ~ USING
SELECT d.DEPARTMENT_NAME, l.CITY
FROM DEPARTMENTS d JOIN LOCATIONS l
USING (LOCATION_ID)
ORDER BY 1;


-- [����] 3�� ���̺� �����ϱ�
-- �μ���(DEPARTMNET_NAME), ���ø�(CITY), �����(COUNTRY_NAME)�� ��ȸ�Ͻÿ�.
-- 1) ����Ŭ ���� / EQUI JOIN
SELECT d.DEPARTMENT_NAME, l.CITY, c.COUNTRY_NAME
FROM DEPARTMENTS d, LOCATIONS l, COUNTRIES c
WHERE
    d.LOCATION_ID = l.LOCATION_ID
    AND
    c.COUNTRY_ID = l.COUNTRY_ID
ORDER BY 1;

-- 2) ANSI ǥ�� / INNER JOIN ~ ON
SELECT d.DEPARTMENT_NAME, l.CITY, c.COUNTRY_NAME
    FROM DEPARTMENTS d JOIN LOCATIONS l
    ON d.LOCATION_ID = l.LOCATION_ID
    JOIN COUNTRIES c    
    ON l.COUNTRY_ID = c.COUNTRY_ID
ORDER BY 1;

-- 3) ANSI ǥ�� / INNER JOIN ~ USING
SELECT d.DEPARTMENT_NAME, l.CITY, c.COUNTRY_NAME
    FROM DEPARTMENTS d JOIN LOCATIONS l
    USING (LOCATION_ID)
    JOIN COUNTRIES c    
    USING (COUNTRY_ID)
ORDER BY 1;




-- [����] 3�� ���̺� �����ϱ�
-- ������(E), �Ի���(E), �ټӿ���(����), �μ���(D), ���޸�(J), �޿�(E)�� ��ȸ�Ͻÿ�.

-- 1) ����Ŭ ���� / EQUI JOIN
SELECT e.FIRST_NAME, e.HIRE_DATE,
    CEIL((SYSDATE-e.HIRE_DATE)/365) AS "�ټӿ���",
    d.DEPARTMENT_NAME, j.JOB_TITLE, e.SALARY
FROM EMPLOYEES e, DEPARTMENTS d, JOBS j
WHERE
    e.DEPARTMENT_ID = d.DEPARTMENT_ID
    AND
    e.JOB_ID = j.JOB_ID
ORDER BY 1;
    
-- 2) ANSI ǥ�� / INNER JOIN ~ ON
SELECT FIRST_NAME, HIRE_DATE, -- ���̺�� ���� �����ϱ� ������ �ǵ����̸� �ٿ��ֱ�
    TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIRE_DATE, 'YYYY'))+1 AS "�ټӿ���",
    DEPARTMENT_NAME, JOB_TITLE, SALARY
    FROM EMPLOYEES e JOIN DEPARTMENTS d
    ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
    JOIN JOBS j
    ON e.JOB_ID = j.JOB_ID
ORDER BY 1;

-- 3) ANSI ǥ�� / INNER JOIN ~ USING
SELECT e.FIRST_NAME, e.HIRE_DATE,
    CEIL((SYSDATE-e.HIRE_DATE)/365) AS "�ټӿ���",
    d.DEPARTMENT_NAME, j.JOB_TITLE, e.SALARY
    FROM EMPLOYEES e JOIN JOBS j
    USING (JOB_ID)
    JOIN DEPARTMENTS d
    USING (DEPARTMENT_ID)
ORDER BY 1;





-------------------- 107�� �� --------------------
/* OUTER JOIN
-- FK�� ���� ���̺��� �����Ͱ� NULL�� ��, ��ȸ���� �ʴ� �����͸� ��ȸ�ϱ� ���� ���� ���
-- ������ ���ٴ� �������� ����
-- JOIN ������ ���� ���� ��쿡�� ����� ��ȯ�ް��� �� ��
-- ���� : LEFT OUTER, RIGHT OUTER, FULL OUTER
*/


----------------- LEFT OUTER JOIN -----------------
-- ���� ���� ���̺��� �����͸� ��������, ������ ���̺��� ���̴� ���
-- ���� ������ �ȸ´� ���, NULL�� ä��
-- �ڽ� ���̺��� "����"�� ���� �θ� ���̺��� "������"�� ����!!
-- �ڽ� ���̺��� NULL���� ���� �� ������, �θ� ���̺��� NULL�� ������ �ȵȴ�!!

-- ��� 1 -- EQUI JOIN (����Ŭ ����)
SELECT e.FIRST_NAME, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d
WHERE d.DEPARTMENT_ID(+) = e.DEPARTMENT_ID 
ORDER BY 1;
-- (PK)27 = (FK)NULL�� �����ϹǷ� 106���� �ƴ� 107���� ������ ��


-- ���2 -- LEFT OUTER JOIN ~ ON (PK=FK)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;

-- ���3 -- LEFT OUTER JOIN ~ USING (�÷���)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
USING (DEPARTMENT_ID) -- ��ȣ ���� �Ұ�!! + USING�� �÷����� ������ ��쿡�� ��� ����
ORDER BY 1;



----------------- RIGHT OUTER JOIN -----------------
-- ���� ������ ���̺��� �����͸� ��������, ���� ���̺��� ���̴� ���
-- ���� ������ �ȸ´� ���, NULL�� ä��
-- �ڽ� ���̺��� "������"�� ���� �θ� ���̺��� "����"�� ����!!
-- �ڽ� ���̺��� NULL���� ���� �� ������, �θ� ���̺��� NULL�� ������ �ȵȴ�!!

-- ��� 1 -- EQUI JOIN (����Ŭ ����)
SELECT e.FIRST_NAME, d.DEPARTMENT_NAME
FROM EMPLOYEES e, DEPARTMENTS d
WHERE d.DEPARTMENT_ID(+) = e.DEPARTMENT_ID 
ORDER BY 1;
-- (PK)27 = (FK)NULL�� �����ϹǷ� 106���� �ƴ� 107���� ������ ��

-- ���2 -- RIGHT OUTER JOIN ~ ON (PK=FK)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM DEPARTMENTS d RIGHT OUTER JOIN EMPLOYEES e
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 
ORDER BY 1;

-- ���3 -- RIGHT OUTER JOIN ~ USING (�÷���)
SELECT e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME
FROM DEPARTMENTS d RIGHT OUTER JOIN EMPLOYEES e
USING (DEPARTMENT_ID) -- ��ȣ ���� �Ұ�!! + USING�� �÷����� ������ ��쿡�� ��� ����
ORDER BY 1;




----------------- SELF JOIN -----------------
-- �ϳ��� ���̺� ���� PK, FK�� ��� �����ϴ� ���

-- 1) ����Ŭ ���� 
SELECT
    e2.EMPLOYEE_ID/*PK*/, e2.FIRST_NAME/*PK*/ AS "������",
    e2.MANAGER_ID /*FK*/, e1.FIRST_NAME /*PK*/ AS "MANAGER��"
FROM EMPLOYEES e1, EMPLOYEES e2
WHERE e1.EMPLOYEE_ID(+) = e2.MANAGER_ID
ORDER BY 3;
-- e1 : �ڽ����̺�μ� FK�� ���� ���� // NULL�� ���� �ʿ� +
-- e2 : �θ����̺�μ� PK�� ���� ����


-- 2) INNER JOIN ~ ON
SELECT
    e2.EMPLOYEE_ID/*PK*/, e2.FIRST_NAME/*PK*/ AS "������",
    e2.MANAGER_ID /*FK*/, e1.FIRST_NAME /*PK*/ AS "MANAGER��"
FROM EMPLOYEES e1 INNER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
ORDER BY 3;


-- 3) RIGHT OUTER JOIN ~ ON
SELECT
    e2.EMPLOYEE_ID/*PK*/, e2.FIRST_NAME/*PK*/ AS "������",
    e2.MANAGER_ID /*FK*/, e1.FIRST_NAME /*PK*/ AS "MANAGER��"
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
ORDER BY 3;


-- 4) JOIN ~ USING�� �Ұ���
-- ���� KEY�� �����Ƿ�




------------------- ���� ���� ---------------------
/*
�������� (Sub Query)
    -	Query ���� �ȿ� �Ǵٸ� Query ������ ���Ե� ����
    -	���������� ��������
1)	���� ���� :
    -	������ ����� ��ȸ�Ǵ� ����
    -	���������� ���� ����� �������� ����� ���� ���������� ����ȴ�. 
2)	���� ���� :
    -	�������� ���ʿ� ��ġ�� ����
    -	���������� ���� ����� ���� ������ �����̳� ����� ���ȴ�
    -	��κ� ���������� ���� ����ǰ� �� �� �� ����� ���������� ���޵Ǿ� �����
    -	������������ ORDER BY�� ��� �Ұ�
    -	���������� ��� ��ġ
	    where �� : �� 1���� ������ ��� �Ǵ� �÷� 1��¥�� ���
	    having �� : ������������ �׷��� �Լ��� ������� ��
	    from ��
	    select ��
	    insert ���� into ��
	    update ���� set ��
-	�پ��� ���������� ����
	-   1. ������ ��������
            : ���������� ����� �ϳ��� ���
	-   2. ���Ͽ�
	-   3. ������ ��������
            : ���������� ����� �ϳ� �̻��� ���
            : �����ڿ� �Բ� ��� (IN, ANY, ALL, EXISTS)
	-   4. ���߿�
*/

-------------------------------------------
-- WHERE������ ����ϴ� ��������

-- 13. �����ȣ�� 109�� ������� �޿��� ���� ����� ǥ��(����̸��� ���) ��ȸ�Ͻÿ�.
-- ��� 1 -- �Ϲ� ���� 2���� �۾��� ����
SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 109;

SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > 9000;

-- ���2 -- ������ ���������� �۾��� ����
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 109);

-- [�ǽ�] 162���� �޿��� ������ ������ �̸�, �޿�, �μ���ȣ�� ��ȸ�Ͻÿ�.
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 162);


------------------------------------------------------
-- FROM������ ����ϴ� ��������
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 50;

SELECT ROWNUM, tbl.*
FROM (SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
      FROM EMPLOYEES
      WHERE DEPARTMENT_ID = 50) tbl
WHERE SALARY > 3000
AND ROWNUM <= 10;
-- ROWNUM�� �������� ��ȣ�� �ο��Ǵٺ��� ������ 1���� �������Ƿ� ���� ���� �Ұ�!!
-- AND ROWNUM BETWEEN 11 AND 20;

SELECT *
FROM (
    SELECT ROWNUM AS rno, tbl.*
    FROM (SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
          FROM EMPLOYEES
          WHERE DEPARTMENT_ID = 50) tbl
    WHERE SALARY > 3000)
WHERE rno BETWEEN 11 AND 20;
-- ���̻� ���� �ο����� �����Ƿ� ���� ���� ����~~
-- ex) �Խ��� ��ũ�� ������ 2�� �� Ŭ���� 11~21�� �Խñ� ��ȸ ����


-- [����] FROM���� �������� ���
-- 03�� ������ �Ի��� �Ϸù�ȣ(ROWNUM)�� ������ ������, �޿�, �Ի���, �μ��� ��ȸ
SELECT temp.*
FROM (
    SELECT ROWNUM AS RNO, FIRST_NAME, SALARY, HIRE_DATE, DEPARTMENT_NAME
    FROM EMPLOYEES INNER JOIN DEPARTMENTS
    USING (DEPARTMENT_ID)
    ) temp
WHERE HIRE_DATE < '03/01/01';


-- [����] WHERE���� �������� ���
-- �̸��� 'Lisa'�� ����� �Ŵ������ ���� ��ȸ�Ͻÿ�
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
                     FROM EMPLOYEES
                     WHERE FIRST_NAME='Lisa');


-- [����] �ϳ��� ���� �ȿ� �������� �� �� => ������
-- ���� 'Greenberg' �Ǵ� 'Errazuriz'�� ������ �̸��� ���� ��ȸ�Ͻÿ�
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME = 'Greenberg' OR LAST_NAME = 'Errazuriz';

-- Greenberg ���� �޿��� �����鼭 ���� 'Errazuriz'�� ������ �Ŵ������� ��ȸ�Ͻÿ�
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE LAST_NAME='Greenberg')
AND EMPLOYEE_ID = (SELECT MANAGER_ID
                   FROM EMPLOYEES
                   WHERE LAST_NAME='Errazuriz');


-------------------------------------------------------------------------
-- SELECT������ ����ϴ� ��������
-- ���� ��ġ�� ���� �� ���

-- [����] Bruce�� Daniel�� ���� ��ȸ�Ͻÿ�
SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME IN ('Bruce', 'Daniel');

-- ����������
SELECT 
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Bruce') AS "Bruce�� ��",
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Daniel') AS "Daniel�� ��"
FROM DUAL;


-- [����] ��������
-- 'Valli'��� �̸��� ���� ������ �μ����� ��ȸ�Ͻÿ�.
SELECT DEPARTMENT_NAME AS "�μ���"
FROM DEPARTMENTS
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                       FROM EMPLOYEES
                       WHERE FIRST_NAME='Valli');

/*
-------------------------------------------------
������ �������� = ������ ��������
1) IN ������
2) ANY / ALL ������
3) EXISTS ������
_________________________________________________
*/

-- 1) IN ������
SELECT *
FROM EMPLOYEES
WHERE JOB_ID IN (SELECT JOB_ID
                 FROM EMPLOYEES
                 WHERE DEPARTMENT_ID = 30);
                 
                 
-- 2) ANY/ALL ������
-- ���������� ��ȸ�� ����� �ϳ� �̻� �����ϴ� ���� �ִ��� ��ȸ
-- > ANY, < ANY, = ANY (IN�� ����), !=ANY, >= ANY, <=ANY
-- ���������� ��ȸ�� ����� �����ϴ� ��� ���� ��ȸ
-- > ALL, < ALL, = ALL, !=ALL, >= ALL, <=ALL
-- �� �����ڿ� �Բ� ����Ѵ�!!!

-- [����1] ST_MAN ������ ���� ���� �޿����� ���� �޴� ������� �̸�, �޿��� ��ȸ
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2;
-- ���������� ��� �� ���� ū ������ ���� ����
-- 8200���� ���� ��� ����

-- [����2] ST_MAN ������ ���� ���� �޿����� �� ���� �޴� ������� �̸�, �޿��� ��ȸ
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2; 
-- ���������� ��� �� ���� ���� ������ ū ����
-- 5800���� ū ��� ����

-- [����3] ST_MAN ������ ���� ���� �޿����� �� ���� �޴� ������� �̸�, �޿��� ��ȸ
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < ALL (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2;
-- ���������� ��� �� ���� ���� ������ ���� ����
-- 5800���� ���� ��� ����

-- [����4] ST_MAN ������ ���� ���� �޿����� �� ���� �޴� ������� �̸�, �޿��� ��ȸ
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > ALL (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'ST_MAN')
ORDER BY 2;
-- ���������� ��� �� ���� ū ������ ū ����
-- 8200���� ū ��� ����

-- [����5] REP ������ �޿��� ������ �޿��� �޴� �������� �̸�, �޿��� ��ȸ
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY = ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID LIKE '%REP')
ORDER BY 4;
-- ���������� ����� ������ ����
-- 6000, 6100, 6200, 6400, 6500, 6800, 7000, 7200, 7300, 7400, 7500
-- 8000, 8400, 8600, 8800, 9000, 9500, 9600, 10000, 10500, 11000, 11500



-- 3) EXISTS
-- ���� ������ ����� �����ϴ� ���� ���� ����

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
              
-- [����] ��������+���� ����ϱ�
-- 'Chen'�̶�� ������ �����ϸ� �� ������ �μ���, �̸�, ��, �޿��� ��ȸ�Ͻÿ�
SELECT DEPARTMENT_NAME, FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES JOIN DEPARTMENTS
USING (DEPARTMENT_ID)
WHERE EXISTS (SELECT LAST_NAME
             FROM EMPLOYEES
             WHERE LAST_NAME = 'Chen')
AND LAST_NAME = 'Chen';


-- [����]
SELECT FIRST_NAME, DEPARTMENT_ID, SALARY, NVL(COMMISSION_PCT, 0)
FROM EMPLOYEES
WHERE (SALARY, NVL(COMMISSION_PCT, -1))
      IN (SELECT SALARY, NVL(COMMISSION_PCT, -1)
          FROM EMPLOYEES
          WHERE DEPARTMENT_ID =80);
-- SALARY�� �����ϰų� COMMISSION_PCT�� ������ ������ ��� ��ȸ




---------------------------------------
/*
[ �������� ] 
1. ������ �̿��Ͽ� ���ID�� 100���� ����� �μ���ȣ�� �μ��̸��� ����Ͻÿ�
2. INNER JOIN�� �̿��Ͽ� ����̸��� �Բ� �� ����� �Ҽӵ� �����̸��� �������� ����Ͻÿ�
3. INNER JOIN�� USING �����ڸ� ����Ͽ� 10�� �μ��� ���ϴ� ��� ��� ������ ��������� �μ��� �������� �����Ͽ� ����Ͻÿ�.
4. JOIN�� ����Ͽ� Ŀ�̼��� �޴� ��� ����� �̸�, �μ�ID, �������� ����Ͻÿ�
5. EQUI���ΰ� ���ϵ�ī�带 ����Ͽ� �̸��� A�� ���Ե� ��� ����� �̸��� �μ����� ����Ͻÿ�(��, ��ҹ��� ���� ����)
6. JOIN�� ����Ͽ� Seattle�� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ����� ����Ͻÿ�
7. SELF ������ ����Ͽ� ����� �̸� �� �����ȣ�� ������ �̸� �� ������ ��ȣ�� �Բ� ��ȸ
8. OUTER JOIN, SELF JOIN�� ����Ͽ� �����ڰ� ���� ����� �����Ͽ� �����ȣ�� �������� �������� �����Ͽ� ��ȸ
** 9. SELF JOIN�� ����Ͽ� ������ ����� �̸�, �μ���ȣ, ������ ����� ������ �μ����� �ٹ��ϴ� ����� ��ȸ. ��, �� ���� ��Ī�� �̸�, �μ���ȣ, ����� �� ��.
10. SLEF JOIN�� ����Ͽ� John Chen������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�
11. SELF JOIN�� ����Ͽ� �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ����Ͻÿ�
12. ���ID�� 101�� ����� �������� ���� ����� ǥ��(����̸��� ���)�Ͻÿ�.
13. �����ȣ�� 109�� ������� �޿��� ���� ����� ǥ��(����̸��� ���) ��ȸ�Ͻÿ�.
14. �ּ� �޿��� �޴� ����� �̸�, ������, �� �޿��� ��ȸ�Ͻÿ�(�׷��Լ� ���)
15. ��� �޿��� ���� ���� ����� ��� ������ ã�� �������� ��ձ޿��� ��ȸ�Ͻÿ�.
16. ��� ������ IT_PROG�� ������� �޿��� �����鼭 ������ IT_PROG�� �ƴ� ������� ��ȸ(�����ȣ, �̸�, ������) �Ͻÿ�
17. John Chen�� ������ �μ��� �ִ� ����� �̸��� �Ի����� ��ȸ�Ͻÿ�
18. �޿��� ��� �޿����� ���� ������� �����ȣ�� �̸��� ǥ���ϵ� ����� �޿��� ���� ������������ �����Ͻÿ�
19. �̸��� K�� ���Ե� ����� ���� �μ����� ���ϴ� ����� �����ȣ�� �̸��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�
20. ��King���� Manager�� ����� �̸��� �޿��� ��ȸ�Ͻÿ�.
21. Finance�μ��� ����� ���� �μ���ȣ, ����̸� �� ��� ������ ǥ���Ͻÿ�
22. ��� �޿����� ���� �޿��� �ް� �̸��� M�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ��ȸ�Ͻÿ�
23. ��� �޿��� ���� ���� ���� ��ȸ�ϱ�
*/


--1. JOIN�� �̿��Ͽ� ���ID�� 100���� ����� �μ���ȣ�� �μ��̸��� ����Ͻÿ�
SELECT e.DEPARTMENT_ID, d.DEPARTMENT_NAME
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE e.EMPLOYEE_ID=100;


-- 2. INNER JOIN�� �̿��Ͽ� ����̸��� �Բ� �� ����� �Ҽӵ� �����̸��� �������� ����Ͻÿ�
SELECT e.FIRST_NAME, l.CITY, r.REGION_NAME
FROM REGIONS r INNER JOIN COUNTRIES c
ON r.REGION_ID = c.REGION_ID
JOIN LOCATIONS l
ON c.COUNTRY_ID = l.COUNTRY_ID
JOIN DEPARTMENTS d
ON l.LOCATION_ID = d.LOCATION_ID
JOIN EMPLOYEES e
ON d.DEPARTMENT_ID = e.DEPARTMENT_ID;


-- 3. INNER JOIN�� USING �����ڸ� ����Ͽ�
-- 100�� �μ��� ���ϴ� ��� ��� ������ ��������� �μ��� �������� �����Ͽ� ����Ͻÿ�.
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


-- 4. JOIN�� ����Ͽ� Ŀ�̼��� �޴� ��� ����� �̸�, �μ�ID, �������� ����Ͻÿ�
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


-- 5. EQUI���ΰ� ���ϵ�ī�带 ����Ͽ� �̸��� A�� ���Ե� ��� ����� �̸��� �μ����� ����Ͻÿ�(��, ��ҹ��� ���� ����)
SELECT FIRST_NAME, DEPARTMENT_NAME
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
USING (DEPARTMENT_ID)
WHERE FIRST_NAME LIKE '%A%'
OR FIRST_NAME LIKE '%a%';


-- 6. JOIN�� ����Ͽ� Seattle�� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ����� ����Ͻÿ�
SELECT FIRST_NAME, JOB_TITLE, DEPARTMENT_ID, DEPARTMENT_NAME, CITY
FROM LOCATIONS l INNER JOIN DEPARTMENTS d
USING (LOCATION_ID)
JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
JOIN JOBS j
USING (JOB_ID)
WHERE CITY = 'Seattle';


-- 7. SELF ������ ����Ͽ� ����� �̸� �� �����ȣ�� ������ �̸� �� ������ ��ȣ�� �Բ� ��ȸ
SELECT e2.FIRST_NAME, e2.EMPLOYEE_ID, e1.FIRST_NAME, e2.MANAGER_ID
FROM EMPLOYEES e1 INNER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID;


-- 8. OUTER JOIN, SELF JOIN�� ����Ͽ� �����ڰ� ���� ����� �����Ͽ� �����ȣ�� �������� �������� �����Ͽ� ��ȸ
SELECT e2.FIRST_NAME, e2.EMPLOYEE_ID, e1.FIRST_NAME, e2.MANAGER_ID
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
ORDER BY 2;


-- 9. SELF JOIN�� ����Ͽ� 'Oliver' ����� �μ���, �� ����� ������ �μ����� �ٹ��ϴ�  ���� ����� �̸��� ��ȸ
-- ��, �� ���� ��Ī�� �̸�, �μ���ȣ, ����� �� ��.
SELECT e2.FIRST_NAME AS "�̸�", e2.DEPARTMENT_ID AS "�μ���ȣ",
e1.FIRST_NAME AS "����"
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.DEPARTMENT_ID = e2.DEPARTMENT_ID
WHERE e2.FIRST_NAME = 'Oliver'
ORDER BY 1;


-- 10. SUB QUERY�� ����Ͽ� John Chen������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE > (SELECT HIRE_DATE
                   FROM EMPLOYEES
                   WHERE FIRST_NAME = 'John' AND LAST_NAME ='Chen')
ORDER BY 2;


-- 11. SELF JOIN�� ����Ͽ� �����ں��� ���� �Ի��� ��� �����
-- �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ����Ͻÿ�
SELECT e2.FIRST_NAME AS "�̸�", e2.HIRE_DATE AS "�Ի���",
e1.FIRST_NAME AS "������", e1.HIRE_DATE AS "�Ի���"
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
WHERE e2.HIRE_DATE < e1.HIRE_DATE
ORDER BY 2;


-- 12. ���ID�� 101�� ����� �������� ���� ����� ǥ��(����̸��� ���)�Ͻÿ�.
-- ������ ����
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID = (SELECT JOB_ID
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 101);


-- 13. �����ȣ�� 109�� ������� �޿��� ���� ����� ǥ��(����̸��� ���) ��ȸ�Ͻÿ�.
-- ��� 1 -- �Ϲ� ���� 2���� �۾��� ����
SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 109;

SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > 9000;

-- ���2 -- ���������� �۾��� ����
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEES
                WHERE EMPLOYEE_ID = 109);

-- 14. �ּ� �޿��� �޴� ����� �̸�, ������ �� �޿��� ��ȸ�Ͻÿ�(�׷��Լ� ���)
SELECT FIRST_NAME, JOB_TITLE, SALARY
FROM EMPLOYEES JOIN JOBS
USING (JOB_ID)
WHERE SALARY = ANY (SELECT MIN(SALARY)
                    FROM EMPLOYEES);

-- 15. ��ü ��� �޿����� �� ���� �޿��� �޴� �μ��� ���� �޿��� ���� ���� ����� �������� �޿��� ��ȸ�Ͻÿ�.
SELECT FIRST_NAME, JOB_ID, SALARY
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);


-- 16. ��� ������ IT_PROG�� ������� �޿��� �����鼭 ������ IT_PROG�� �ƴ� ������� ��ȸ(�����ȣ, �̸�, ������) �Ͻÿ�
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SALARY < ANY (SELECT SALARY
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'IT_PROG')
AND JOB_ID != 'IT_PROG';


-- 17. John Chen�� ������ �μ��� �ִ� ����� �̸��� �Ի����� ��ȸ�Ͻÿ�
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                       FROM EMPLOYEES
                       WHERE FIRST_NAME = 'John' AND LAST_NAME = 'Chen');
                       

-- 18. �޿��� ��� �޿����� ���� ������� �����ȣ�� �̸��� ǥ���ϵ� ����� �޿��� ���� ������������ �����Ͻÿ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEES)
ORDER BY SALARY DESC;


-- 19. �̸��� �빮�� K�� ���Ե� ����� ���� �μ����� ���ϴ� ����� �����ȣ�� �̸��� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�
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

-- 20. ��King���� Manager�� ����� �̸��� �޿��� ��ȸ�Ͻÿ�.
SELECT e2.FIRST_NAME, e2.EMPLOYEE_ID, e1.FIRST_NAME, e2.MANAGER_ID
FROM EMPLOYEES e1 RIGHT OUTER JOIN EMPLOYEES e2
ON e1.EMPLOYEE_ID = e2.MANAGER_ID
WHERE e1.LAST_NAME = 'King';


-- 21. Finance�μ��� ����� ���� �μ���ȣ, ����̸� �� ��� ������ ǥ���Ͻÿ�
SELECT DEPARTMENT_NAME, DEPARTMENT_ID, FIRST_NAME, JOB_TITLE
FROM DEPARTMENTS d INNER JOIN EMPLOYEES e
USING (DEPARTMENT_ID)
JOIN JOBS j
USING (JOB_ID)
WHERE DEPARTMENT_NAME = 'Finance';


-- 22. ��� �޿����� ���� �޿��� �ް� �̸��� M�� ���Ե� �����
-- ���� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ��ȸ�Ͻÿ�
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


-- 23. ��� �޿��� ���� ���� ���� ��ȸ�ϱ�       
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
-- SELECT��
SELECT 
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Bruce') AS "Bruce�� ��",
    (SELECT LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME = 'Daniel') AS "Daniel�� ��"
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
    - ���̺��, �÷����� Ű���� ��� �Ұ���
    - �������� (CONTRAINTS)
        - ���� : Primary Key, Foreign Key, Unique, Not Null, Check
        - ���� : �������� ���Ἲ�� ���� ��
        - Ư¡ : Primary Key, Unique ���������� �ڵ����� index�� �����Ǳ� ������ ��ȸ�� ��������.
    - DEFAULT
        - �����Ͱ� ���� �� ���ԵǴ� �⺻��
        - ���������� �ƴ����� �������� ���Ἲ�� �����ϴ� ���� ���

    
    
-- ����Ŭ���� ����ϴ� �ڷ���
1) ���ڿ� : VARCHAR2(�ִ� ���ڼ�) -> �������� ���ڿ� (�ִ� 4000BYTE / �ѱ���� 3��)
          : CHAR(n)               -> �������� ���ڿ� (�޸� ����)
                <����>
                VARCHAR2(10)      -> 'KOREA', 'AMERICA'
                CHAR(10)          -> 'KOREA     ', 'AMERICA   '
2) ����   : NUMBER(�ڸ���)
          : NUMBER(�ڸ���p, �Ҽ��ڸ�s)
                 <����>
                NUMBER(3)         -> �ִ� 999������ ����
                NUMBER            -> SHORT������ ����
                NUMBER(5, 2)      -> 5�ڸ��� �Ҽ��� ���� ��°�ڸ�����
3) ��¥   : DATE                  -> ��/��/��
          : TIMESTAMP

4) ��뷮 : BLOB (Large of Byte)
          : CLOB (�뷮�� �ʹ� Ŀ���Ƿ� ���� �ϵ��ũ�� �����ϴ� ���� ���� ����)

0) (Boolean Ÿ���� ����)



-- ����Ŭ Ű���� ��ȸ�ϱ� (DBA)
DBA�� ������ ����̹Ƿ� SYSTEM �������� ���ӽ� 1800���� Ȯ�� ���� 
SELECT * FROM V$RESERVED_WORDS;

-- �������� Ȯ���ϱ�
: ��� ���̺� � ���������� �ɷ��ִ��� Ȯ���ϱ�
    - �츮�� ���� ���̺��� ����� ���ϱ�
        1. ���� ���� : ���̺��_�÷���_�������� !!!!!!!!!!!!!!!
        2. �ڵ� ���� : SYSTEM�� ���Ƿ� ���� SYS_~~
SELECT *
FROM USER_CONSTRAINTS;
*/




/* CREATE
-- ���̺� �ۼ� + ��������
CREATE TABLE ���̺�� (
    ��1�̸� ��1�ڷ���,
    ��2�̸� ��2�ڷ���,
    ...,
    ��3�̸� ��3�ڷ���
);
*/


-- [����]
-- ���̺� ����
CREATE TABLE FITNESS
(
    MEM_ID    VARCHAR2(5)  CONSTRAINTS FITNESS_ID_PK PRIMARY KEY,
    MEM_NAME  VARCHAR2(15) CONSTRAINTS FITNESS_NAME_NN NOT NULL,
    -- ID�� NAME�� Ű�����̹Ƿ� �ٸ� �÷��� ����ϱ�
    HEIGHT    NUMBER(5, 2) DEFAULT 0,
    WEIGHT    NUMBER(5, 2) DEFAULT 0,
    JOIN_DATE DATE         DEFAULT SYSDATE
);

-- ���̺� ����
DROP TABLE FITNESS;

-- �������� Ȯ��
SELECT *
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'FITNESS';
-- P�� Primary Key
-- C�� Check �Ǵ� Not Null



/*
-- INSERT��

-- ���1 
INSERT INTO ���̺��
VALUES (������1, 2, 3, 4, 5);
-- ��� �÷��� �����͸� �� ���� ������ VALUES ������ ��ȣ ���� ����

-- ���2
INSERT INTO ���̺��
(�÷��� 1,2,3,4,5)
VALUES
(������ 1,2,3,4,5)

-- ���3
INSERT INTO ���̺��
(�÷��� 1,2)
VALUES
(������ 1,2)
-- DEFAULT �ִ� �÷��� ������ ���� �ʴ� ��쿡�� �÷��� ��� �ʼ�!!
*/

-- [����]
INSERT INTO FITNESS
VALUES ('Hong', 'ȫ�浿', 185.5, 75, '23/04/26');

INSERT INTO FITNESS
(MEM_ID, MEM_NAME, HEIGHT, WEIGHT, JOIN_DATE)
VALUES
('Lim', '�Ӳ���', 180.88, 88, '23/04/25');

INSERT INTO FITNESS
(MEM_ID, MEM_NAME)
VALUES
('Son', '�տ���');

COMMIT; -- �ʼ�!!!! (COMMIT �Ǵ� ROLLBACK)

SELECT *
FROM FITNESS;



-- [����] ȸ������ ������ ���� MEMBERS ���̺� �����ϱ�
/*
SEQNO ����Ÿ�� PK
USERID �������� 10 UQ
USERNAME �������� 20 NN
BIRTHDAY ��¥Ÿ�� NN
GENDER �������� 1 CHECK '0', '1'
*/

-- ���̺� ����
CREATE TABLE MEMBERS
(
    SEQNO    NUMBER         CONSTRAINTS MEMBERS_SEQ_PK  PRIMARY KEY,
    USERID   VARCHAR2(10)   CONSTRAINTS MEMBERS_ID_UQ   UNIQUE,
    USERNAME VARCHAR2(20)   CONSTRAINTS MEMBERS_NAME_NN NOT NULL,
    BIRTHDAY DATE           CONSTRAINTS MEMBERS_BD_NN   NOT NULL,
    GENDER   CHAR(1)        CONSTRAINTS MEMBERS_GD_CK   CHECK (GENDER IN ('0', '1'))
);

-- ���̺� ����
DROP TABLE MEMBERS;

-- �������� ��ȸ
SELECT *
FROM MEMBERS;

-- ������ ����
INSERT INTO MEMBERS
VALUES (1, 'SON', '�տ���', '00/01/02', '1');

INSERT INTO MEMBERS
VALUES (2, 'KIM', '�迵��', '95/05/01', '0');

-- ���̺� ��ȸ
SELECT *
FROM MEMBERS;

-- ���� �Ǵ� ������
COMMIT;

-- ������ ����
DELETE MEMBERS
WHERE SEQNO = 1;
-- ���� ������ '1'�� �� �����Ǿ����ϴ�.
DELETE MEMBERS
WHERE SEQNO = 3;
-- ���� ���н� '0'�� �� �����Ǿ����ϴ�.

-- ���� �Ǵ� ������
ROLLBACK;

-- ������ ����
UPDATE MEMBERS
SET USERNAME = '�տ���'
WHERE SEQNO = 1;

-- ���� �Ǵ� ������
COMMIT;


--------------------------------------------------
/*
-- TCL ��ɾ�
    - COMMIT
    - ROLLBACK
*/

--------------------------------------------------
/*
PK�� FK�� ���踦 ���� ���̺� �����ϱ�
-- 1) ���� : ������ �θ���� ���� �� -> �ڽ� ���̺� ����
             REFERENCES �θ����̺��(PK�÷���)
             ON DELETE CASCADING : �θ� ���̺� ���� �Ұ��ϵ��� ����
             
-- 2) ���� : ������ �ڽĺ��� ���� �� -> �θ� ���̺� ����
*/

-- [����] MEMBERS ���̺��� PK�� FK�� ���� PURCHASE �ڽ����̺� �����ϱ�
/*
SEQ_ID   : �Ϸù�ȣ ������ PK
ITEM     : ��ǰ�� �������� 50 NN
PRICE    : ���� ������ 10�ڸ� DF 100000
PDAY     : �������� DF ���糯¥
QUANTITY : ������ 3�ڸ� DF 1
SEQNO    : FK
*/

-- ���̺� ����
CREATE TABLE PURCHASE
(
    SEQ_ID   NUMBER       CONSTRAINTS PURHCASE_SEQID_PK PRIMARY KEY,
    ITEM     VARCHAR2(50) CONSTRAINTS PURHCASE_ITEM_NN NOT NULL,
    PRICE    NUMBER(10)   DEFAULT 100000,
    PDAY     DATE         DEFAULT SYSDATE,
    QUANTITY NUMBER(3)    DEFAULT 1,
    SEQNO    NUMBER       REFERENCES MEMBERS(SEQNO) ON DELETE CASCADE
);

-- ���̺� ����
DROP TABLE PURCHASE;

-- ���̺� ��ȸ
SELECT *
FROM PURCHASE;

-- ������ �߰�

-- 1) �տ��� ���� 2�� ����
INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(11, '�ڹ��� ����', 1, 40000);

INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(12, '���̽�', 1, 25000);

-- 2) �迵�� ���� 3�� ����
INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(13, '��Ʈ��', 2, 2570000);

INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO)
VALUES
(14, 'Ű����', 2);

INSERT INTO PURCHASE
(SEQ_ID, ITEM, SEQNO, PRICE)
VALUES
(15, '�����', 2, 380000);

-- ���̺� ��ȸ
SELECT *
FROM PURCHASE;

-- �Ϸù�ȣ, ������ �̸�, �����۸�, ���� : INNER JOIN�� �̿��Ͽ� ��ȸ�ϱ�
SELECT ROWNUM, USERNAME, ITEM, PRICE
FROM MEMBERS INNER JOIN PURCHASE
USING (SEQNO);




-- [����] KPOP ���̵� ���� & �Ҽӻ� ���� * ��Ŭ�� ������ ������ ���̺� �����ϱ�
-- ������ ���̺� : �Ҽӻ� / �θ� ���̺� : ���̵� / �ڽ� ���̺� : ��Ŭ��
-- �Ҽӻ��� FK�� ���̵��� PK�̹Ƿ� & ���̵��� FK�� ��Ŭ���� PK�̹Ƿ�

/*
<���̵� ���̺�>
�׷�� �̸� ���� ������� 
<�Ҽӻ� ���̺�>
ȸ��� ��ǥ �ּ� �׷��
<��Ŭ�� ���̺�>
�׷�� ��Ŭ���� �������� ȸ����
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
VALUES ('����ũ', 'YG', '������', '������ û�㵿');

INSERT INTO ENTERTAINMENT
VALUES ('���座��', 'SM', '�̼���', '������ �Ｚ��');

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
VALUES (1, '����ũ', '����', 25, '95/01/01');

INSERT INTO IDOL
VALUES (2, '����ũ', '����', 27, 'Vietnam', '93/01/01');

INSERT INTO IDOL
(SEQ_NO, GROUP_NAME, SOLO_NAME, AGE, BIRTHDAY)
VALUES (3, '���座��', '���̸�', 31, '89/01/01');

INSERT INTO IDOL
VALUES (4, '���座��', '����', 28, 'America', '92/01/01' );

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
VALUES (1, '����ũ', 'BP');

INSERT INTO FANCLUB
VALUES (2, '����ũ', '��ũ', 1800000);

INSERT INTO FANCLUB
VALUES (3, '���座��', 'LEVEL', 98765);

COMMIT;



-- INNER JOIN�� �̿��Ͽ� ��ȸ�ϱ�
SELECT ROWNUM, GROUP_NAME, SOLO_NAME, AGE, COMP_NAME, FAN_NAME, FAN_CNT
FROM IDOL INNER JOIN ENTERTAINMENT
USING (GROUP_NAME)
JOIN FANCLUB
USING (GROUP_NAME);

