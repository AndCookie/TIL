-- 1. �������� 5������ ���ÿ�. (5��)
-- Primary Key, Foreign Key, UNIQUE, NOT NULL, CHECK

-- 2. �⺻Ű�� ������ �ִ� �⺻ �������� 2 ������ �����ΰ�? (5��)
-- NOT NULL, UNIQUE

-- 3. �θ����̺��� �ڽ����̺� ���� ���踦 �α� ���ؼ� ����ϴ� ���������� �����ΰ�? (5 ��)
-- FOREIGN KEY


-- 4. HR ������ �⺻ ���� ���̺� �̿��Ͽ� ���ú� ��� ���� ������ ���� ����Ͻÿ�. (10��)
SELECT CITY AS ���ø�, COUNT(CITY) AS �ο���
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
USING(DEPARTMENT_ID)
JOIN LOCATIONS l
USING(LOCATION_ID)
GROUP BY CITY;


-- 5. ���α׷� ���� ��¥�� �������� �Ի����� 16�� �̸��� ������� �̸�, ��, �Ի����� �Ի��� �������� ���������Ͽ� ����Ͻÿ�. (5��)
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE SYSDATE-HIRE_DATE < 16*365
ORDER BY 3;


-- 6. ������� �̸��� ��, �޿�, �μ���ȣ �� �ڽ� �μ��� ��� �޿��� ��ȸ�Ͻÿ�. (��ձ޿��� �Ҽ��� 2�ڸ����� ���, õ�ڸ� �޸�) (10��)
SELECT FIRST_NAME, LAST_NAME, SALARY, DEPARTMENT_ID AS �μ���ȣ, tbl."�μ� ��� �޿�"
FROM EMPLOYEES INNER JOIN (SELECT DEPARTMENT_ID, TO_CHAR(AVG(SALARY), '99,999.00') AS "�μ� ��� �޿�" FROM EMPLOYEES GROUP BY DEPARTMENT_ID) tbl
USING(DEPARTMENT_ID);


-- 7. �����ȣ, ���� �Ⱓ, �������� ��µǵ��� �Ͻÿ�. JOB_HISTORY, JOBS ���̺� ��� (5��)
SELECT EMPLOYEE_ID AS �����ȣ, JOB_TITLE AS ������
FROM JOBS j INNER JOIN JOB_HISTORY h
USING(JOB_ID);

SELECT JOB_ID, CONCAT(CONCAT(CONCAT(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), '��'), MOD(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), 10)), '����') AS "������"
FROM JOB_HISTORY;




SELECT EMPLOYEE_ID AS �����ȣ, JOB_TITLE AS ������, tbl."�����Ⱓ"
FROM JOBS j RIGHT OUTER JOIN EMPLOYEES e
USING (JOB_ID)
LEFT OUTER JOIN
(SELECT JOB_ID, CONCAT(CONCAT(CONCAT(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), '��'), MOD(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), 10)), '����') AS "�����Ⱓ"
FROM JOB_HISTORY) tbl
USING (JOB_ID);


SELECT EMPLOYEE_ID AS �����ȣ, JOB_TITLE AS ������, tbl."�����Ⱓ"
FROM (SELECT JOB_ID, CONCAT(CONCAT(CONCAT(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), '��'), MOD(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), 10)), '����') AS "�����Ⱓ"
FROM JOB_HISTORY) tbl INNER JOIN EMPLOYEES e
USING(EMPLOYEE_ID)
JOIN JOBS j
ON (j.JOB_ID = e.JOB_ID);



SELECT EMPLOYEE_ID, JOB_TITLE
FROM JOB_HISTORY h INNER JOIN JOBS j
USING(JOB_ID);






SELECT EMPLOYEE_ID, (END_DATE-START_DATE), h.JOB_TITLE
FROM JOB_HISTORY h INNER JOIN EMPLOYEES e
USING(EMPLOYEE_ID)
JOIN JOBS j
ON (j.JOB_ID = e.JOB_ID);


SELECT EMPLOYEE_ID, JOB_TITLE, tbl."������"
FROM EMPLOYEES e RIGHT OUTER JOIN (SELECT JOB_ID, CONCAT(CONCAT(CONCAT(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), '��'), MOD(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), 10)), '����') AS "������"
FROM JOB_HISTORY) tbl
USING (JOB_ID)
LEFT OUTER JOIN JOBS j
USING (JOB_ID);


SELECT CONCAT(CONCAT(CEIL(MONTHS_BETWEEN(END_DATE, START_DATE)/12), '��'), ((ROUND(MONTHS_BETWEEN(END_DATE, START_DATE)/12, 2)-(CEIL(MONTHS_BETWEEN(END_DATE, START_DATE)/12))
FROM JOB_HISTORY;

SELECT ((MONTHS_BETWEEN(END_DATE, START_DATE)/12)-FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12))*30
FROM JOB_HISTORY;

SELECT EMPLOYEE_ID, END_DATE-START_DATE
FROM JOB_HISTORY;

SELECT JOB_ID, CONCAT(CONCAT(CONCAT(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), '��'), MOD(FLOOR(MONTHS_BETWEEN(END_DATE, START_DATE)/12), 10)), '����') AS "������"
FROM JOB_HISTORY;


-- 8. 2023�� 7�� 19���� �������̶�� ���� �� ���� ��¥�κ��� ���� ���Ҵ��� ����ϴ� SQL������ �ۼ��Ͻÿ�. (5��)
SELECT CEIL(TO_DATE('2023/07/19')-SYSDATE) AS "���� �ϼ�"
FROM DUAL;

-- 9. �� �μ��� ��� �ٹ����� �Ʒ��� ���� ��ȸ�Ͻÿ�. (10��)
SELECT DEPARTMENT_NAME AS �μ���, FLOOR(AVG(SYSDATE-HIRE_DATE)) AS "��� �ٹ���"
FROM EMPLOYEES e INNER JOIN DEPARTMENTS d
USING (DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME
ORDER BY 2 DESC;


-- 10. Employees ���̺����� �Ŵ����� ���� ������� ����� ��ձ޿�, �ִ�޿�, �ּұ޿��� �׸��� ���� ����Ͻÿ�.
-- ��, �Ŵ�����ȣ�� ���� ����� 0������ ����ϰ�, �Ҽ��� ���� �ø��Ͻÿ�.(10��)
SELECT NVL(MANAGER_ID, 0) AS �Ŵ�����ȣ, CEIL(AVG(SALARY)) AS ��ձ޿�, MAX(SALARY) AS �ְ��޿�, MIN(SALARY) AS �����޿�
FROM EMPLOYEES
GROUP BY MANAGER_ID
ORDER BY 1;


-- �� ������ ������ ����ϴ� ���� ������ ��������� �����ϴ� ���̺��̴�. �־��� ������ ���̺��� �������� �����Ͻÿ�. (���̺��� �����ϸ鼭 ���������� �ο��� ��.)

-- 11. ���̺���: Categories (��ǰ ī�װ���) (10��)
CREATE TABLE Categories
(
    CATEGORY_ID    CHAR(7)          PRIMARY KEY CHECK(CATEGORY_ID IN ('WR_PROD', 'PA_PROD', 'AR_PROD', 'ME_PROD', 'ET_PROD')),
    CATEGORY_NAME  VARCHAR2(30)      UNIQUE CHECK(CATEGORY_NAME IN ('�ʱⱸ', '���̷�', '�̼���ǰ', '������ǰ', '��Ÿ')),
    CATEGORY_DESC  VARCHAR2(3000)    DEFAULT 'None'
);

DROP TABLE Categories;

-- 12. ���̺���: Products (��ǰ) (5��)
CREATE TABLE Products
(
    PROD_ID         NUMBER          PRIMARY KEY,
    PROD_NAME       VARCHAR2(30)     NOT NULL,
    COUNTRY         VARCHAR2(50)     NOT NULL,
    MANUFACTURES    VARCHAR2(50)     NOT NULL,
    MAKING_DATE     DATE,
    CATEGORY_ID     CHAR(7)         REFERENCES Categories(CATEGORY_ID)
);
DROP TABLE Products;

-- 13. ������ : Products_seq (��ǰ ���̺��� ������ ��ü : 100���� �����Ͽ� 50�� �����ϵ��� ����) (5��)
CREATE SEQUENCE Products_seq
    INCREMENT BY 50
    START WITH 100;

DROP SEQUENCE Products_seq;

-- 14. ���̺���: Stock (���) (5��)
CREATE TABLE Stocks
(
    STOCK_ID        NUMBER          PRIMARY KEY,
    PROD_ID         NUMBER          REFERENCES Products(PROD_ID) ON DELETE CASCADE,
    RECEIVE_DATE    DATE,
    FORWARD_DATE    DATE            DEFAULT SYSDATE,
    UNIT_PRICE      NUMBER(10, 2)   DEFAULT 0,
    TOTAL_STOCK     NUMBER(7)       DEFAULT 0
);
DROP TABLE Stocks;


-- 15. ������ : Stock_seq (��� ���̺��� ������ ��ü) (5��)
CREATE SEQUENCE Stock_seq;
DROP SEQUENCE Stock_seq;