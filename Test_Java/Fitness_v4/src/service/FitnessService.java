/* 
 * ���� ����
 * Service -> ServiceImpl -> UI -> Fitness -> Test
 */
package service;

import java.util.List;

import vo.Fitness;

public interface FitnessService {
//	public static final int MAX = 100; =============
	// arrayList�� ���� ������ �����Ƿ� 100�� ������ �ʿ� ����!!
	
	/**
	 * ȸ��������ü�� ���޹޾� Array�� ����
	 * @param fitness
	 * @return ���� �����ϸ� true, �����ϸ� false
	 */
	public boolean insert(Fitness fitness);
	
	/**
	 * ȸ���� PK������ ���޹޾� �˻��� ȸ������ ��ȯ
	 * @param id ȸ���� PK
	 * @return �˻��� ȸ����ü, �˻� ���� �� null
	 */
	public Fitness selectOne(String id);
	
	/**
	 * �����ϰ��� �ϴ� ȸ�������� ��ü�� �޾� ���� �ǽ�
	 * @param fitness �����ϰ��� �ϴ� ȸ����ü
	 * @return ���� ���� �� true, ���� �� false
	 */
	public boolean update(Fitness fitness);
	
	/**
	 * ȸ�� ���� ����
	 * @param id �����ϰ��� �ϴ� ȸ���� ID
	 * @return ���� ���� �� true, ���� �� false
	 */
	public boolean delete(String id);
	
	/**
	 * ��ü ȸ�� ���� ��ȸ
	 * @return ��� ȸ���� ������ ����� �迭
	 */
//	public Fitness[] selectAll(); ==================
	public List<Fitness> selectAll();
	
	/**
	 * ��ü ȸ�� ��
	 * @return ȸ����
	 */
//	public int getCount(); ================
	// size�� �� �� �����Ƿ� ����!!
}
