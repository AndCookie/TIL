SELECT * FROM COUNTRIES;
SELECT * FROM REGIONS;
SELECT * FROM DEPARTMENTS;
SELECT * FROM EMPLOYEES;

-- �̸��� �޿������� ��ȸ
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES; // 107��


-- ALL | DISTINCT
-- DISTINCT �ߺ� ���� / ALL �ߺ� ��� (Default)
SELECT DEPARTMENT_ID
FROM EMPLOYEES; // 107��

SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES; // 12��
-- NULL�� �����ϰ� ����


-- ���� ORDER BY : ������ ������ ���� �־�� ��!!!
-- �������� ���� ASC
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID ASC;
-- NULL�� ���� ū ������ ����

-- �������� ���� DESC
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID DESC;

-- �̸�, �޿�, �μ���ȣ�� �̸��� ������������ ��ȸ
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY FIRST_NAME;



-- ��Ī ALIAS
-- AS ���� �����ϸ�, ���鹮�� �Ǵ� Ư������ ���Խ� ū����ǥ �ʼ�
-- PRODUCT : �߰��� �� ���� ��ȸ�ߴٴ� �ǹ�
SELECT FIRST_NAME "�̸� ��", SALARY AS "�� ��", DEPARTMENT_ID AS �μ���ȣ
FROM EMPLOYEES
ORDER BY FIRST_NAME;


-- 1) ��������� + - * /
--	SELECT�� FROM ���̿� �ַ� ���� ������������ ������� ����
-- [����] ���� �޿��� 5%�� ���ʽ��� �����Ϸ��� �Ѵ�
-- ������ �����ȣ, �̸�, �޿�, ���ʽ�, �հ�
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, SALARY*0.05 AS BONUS, SALARY+SALARY*0.05 TOTAL
FROM EMPLOYEES;

-- 2) ���ڿ� ���� ������
-- [����] ���� �̸� �ڿ� '��'�� ���̱�
SELECT FIRST_NAME || '��' AS "�̸�"
FROM EMPLOYEES;
-- [����] '�̸� ��'�� �ٿ��� ��ȸ
SELECT FIRST_NAME || ' ' || LAST_NAME AS "�̸�"
FROM EMPLOYEES;

-- 3) �񱳿����� = != > >= < <=
-- WHERE�� �� ���ǿ� ���� �ٿ��� ����
-- [����] �޿��� 10000 �̻��� �������
-- �����ȣ, �̸�, �޿�, ������ �޿��� ���� ������� ��ȸ
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID
FROM EMPLOYEES
WHERE SALARY>=10000 -- ������ WHERE
ORDER BY SALARY DESC;
-- [����] �μ���ȣ�� 80���� �������
-- �����ȣ, �̸�, �޿�, �μ���ȣ ��ȸ
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID=80;

-- 4) �������� AND OR NOT
-- NOT�� ���׿�����
-- [����] �޿��� 5000~10000 �̻��� �������
-- �����ȣ, �̸�, �޿�, ������ ��ȸ
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, JOB_ID
FROM EMPLOYEES
WHERE SALARY>=5000 AND SALARY<=10000;
-- [����] �μ���ȣ�� 10�� 50�� �ƴ� �������
-- �̸�, �μ���ȣ�� �μ����� ��ȸ
SELECT FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE NOT(DEPARTMENT_ID=10 OR DEPARTMENT_ID=50)
ORDER BY 2; -- 2��° �÷��� ��������

-- 5) NULL ������ IS NULL / IS NOT NULL
-- [����] Ŀ�̼��� �ִ�/���� �������
-- �̸�, �޿�, Ŀ�̼��� ��ȸ
SELECT FIRST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;
-- [����] �Ŵ����� ���� ������ �̸�, ���� ��ȸ
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;
-- [����] �̸�, �޿�, Ŀ�̼Ǳݾ�, �Ѿ��� ��ȸ
-- ��, �Ѿ��� ���ϱ� ���ؼ��� Ŀ�̼��� NULL�� �ƴϾ�� ��!
-- ���������� �ƴ� �������� Query�̹Ƿ� �޿�+Ŀ�̼� �ݾ����� �Ѿ� ���� �� ����
SELECT FIRST_NAME, SALARY, SALARY*COMMISSION_PCT AS "Ŀ�̼� �ݾ�",
SALARY+SALARY*COMMISSION_PCT AS "�Ѿ�"
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

-- 6) SQL ������ BETWEEN AND / IN
-- AND --> �÷��� BETWEEN a AND b
-- OR ?--> �÷��� IN (��, ��,��) 
-- [����] �޿��� 10000~15000 �̻��� �������
-- �̸�, �޿��� �޿��� ������������ ��ȸ
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 10000 AND 15000
ORDER BY SALARY DESC;
-- [����] �μ���ȣ�� 10�� 50�� �������
-- �̸�, �μ���ȣ�� �μ����� ��ȸ
SELECT FIRST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (10, 50)
ORDER BY 2; // 2��° �÷��� ��������
-- [����] �޿��� 7000�� �ʰ��ϰ� �̸����� 'SKING'�� �����
-- �̸�, ��ȭ��ȣ, �޿�, �̸����� ��ȸ
SELECT FIRST_NAME, PHONE_NUMBER, SALARY, EMAIL
FROM EMPLOYEES
WHERE SALARY >= 7000 AND EMAIL = 'SKING';
-- [����] 07�⵵�� �Ի��� ��������
-- �̸�, �Ի����� �Ի����� ������������ ��ȸ
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '07/01/01' AND '07/12/31'
ORDER BY HIRE_DATE;
-- [����] 07�⵵ ������ �Ի��� ��������
-- �̸�, �Ի����� �Ի����� ������������ ��ȸ
SELECT FIRST_NAME, HIRE_DATE, HIRE_DATE+1
FROM EMPLOYEES
WHERE HIRE_DATE < '07/01/01'
ORDER BY HIRE_DATE;
-- ��¥�� ��� : ���� ����ǥ�� ó�� �ʼ�
-- ���ڿ�ó�� �������� ���/�� ���� ����!!

-- 7) LIKE �����ڿ� ���ϵ� ī��
-- �÷��� LIKE '���ϵ� ī�尡 ���Ե� ���ڿ�'
-- ���ϵ� ī���� ���� *(��� �÷�) %(���� 0~���Ѱ�) _(���� 1��)
-- [����] �̸��� 'J'�� �����ϴ� ������ �̸� ��ȸ
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'J%';
-- [����] �̸��� 'n'�� ������ ������ �̸� ��ȸ
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%n';
-- [����] �̸��� 'n'�� �����鼭 �̸��� ���̰� 5�� ������ �̸� ��ȸ
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '____n';
-- [����] 07�⵵�� �Ի��� ��������
-- �̸�, �Ի����� �Ի����� ������������ ��ȸ
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '07%'
ORDER BY HIRE_DATE;
-- [����] 01���� �Ի��� ��������
-- �̸�, �Ի����� �Ի����� ������������ ��ȸ
SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '___01___'
ORDER BY HIRE_DATE;
-- ��, %01%�� �ϸ� ����/��/���� ������ �ȵ�!!


----------------------------------------------------
-- [����] �Ŵ����� 103�� ��������
-- ���̵�, �̸�, �μ�, �Ŵ��� ��ȣ�� ��ȸ
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, MANAGER_ID
FROM EMPLOYEES
WHERE MANAGER_ID = 103;


-- [����] ��� �μ����� ������ ���� ��������
-- �̸�, ��ȭ��ȣ, �μ��� ��ȸ
SELECT FIRST_NAME, PHONE_NUMBER, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NULL;

-- [����] �޿��� 10000�� �ʰ��ϸ鼭 JOB_ID�� 'SA_REP'�� ��������
-- �̸���, �̸�, ��ȭ��ȣ, JOB_ID�� ��ȸ
SELECT EMAIL, FIRST_NAME, PHONE_NUMBER, JOB_ID
FROM EMPLOYEES
WHERE SALARY>10000 AND JOB_ID = 'SA_REP';


-- [����] �μ��� 60�̰ų� �̸��� A�� �����ϴ� ��������
-- �̸�, �޿�, �μ��� ��ȸ
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID=60 OR FIRST_NAME LIKE 'A%';


-- [����] �μ��� 10�̰ų� 50�̰ų� 60�� �μ��� ��������
-- �̸�, �޿�, �μ��� ��ȸ
SELECT FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (10,50,60);

-- [����] �̸��� 3������ ������ ��� ���� ��ȸ
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '___';

-- [����] ��ü ������ �� ������ 'CLERK'�� ���� ��ȸ (������ ����)
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID LIKE '%CLERK';











-----------------------------------
-- [�������� ����]
-----------------------------------

-- �Ŵ����� 103�� ������ ����(���̵�, �̸�, �μ�, �Ŵ�����ȣ)�� ��ȸ�Ͻÿ�.

-- ��� �μ����� ������ ���� ������ ���� (�̸�, ��ȭ��ȣ, �μ�)�� ��ȸ�Ͻÿ�

-- �޿��� 10000�� �ʰ��ϸ鼭 JOB_ID�� 'SA_REP'�� ����� �̸���, �̸�, ��ȭ��ȣ, JOB_ID ������ ��ȸ�Ͻÿ�

-- �μ��� 60�̰ų� �̸��� A�� �����ϴ� �����ϴ� ������ ����(�̸�, �޿�, �μ�)�� ��ȸ�Ͻÿ�.

-- �μ��� 10�̰ų� 50�̰ų� 60�� �μ��� ������ ����(�̸�, �޿�, �μ�)�� ��ȸ�Ͻÿ�

-- �̸��� 3������ ��� ����� ������ ��ȸ�Ͻÿ�.

-- ��ü �������� ������ 'CLERK' ���� ��ȸ (������ ����)
