package service;

import vo.Fitness;

public interface FitnessService {
	
	public static final int MAX = 100; // ����� ���� �� -> IMPL���ٰ� �����
	
	/*
	 * Fitness ȸ�� ���� ��ü�� ���޹޾� Array�迭�� ����
	 * @param fitness
	 * @return boolean : ���� �����ϸ� true, �����ϸ� false
	 */
	public boolean insert(Fitness fitness);
	// thorws Exception : ó������ Exception�� ó���ϵ��� �ϱ�!!
	
	/*
	 * Primary Key�� id�� ���޹޾� ȸ�� ���� Fitness�� ��ȯ
	 * @param id : ȸ���� PK
	 * @return fitness : �˻��� ȸ�� ��ü, �˻� ���н� null ��ȯ
	 */
	public Fitness selectOne(String id);
	
	/*
	 * �����ϰ��� �ϴ� ȸ�������� ��ü�� �޾� ���� �ǽ�
	 * @param fitness : �����ϰ��� �ϴ� ȸ�� ��ü
	 * @return boolean :���� ������ true, ���н� false
	 */
	public boolean update(Fitness fitness);
	
	/*
	 * ȸ�� ���� ����
	 * �����ϰ��� �ϴ� ȸ�������� ��ü�� �޾� ȸ������ ���� �ǽ�
	 * @param id : �����ϰ��� �ϴ� ȸ���� ID
	 * @return boolean : ���� ������ true, ���н� false
	 * 
	 */
	public boolean delete(String id);
	
	/*
	 * ��ü ȸ�� ���� ��ȸ
	 * @param
	 * @return : fitnessŸ���� ��� ȸ�� �������� �迭 ��ȯ
	 */
	public Fitness[] selectAll();
	
	
	// ��ü ȸ������ �˱� ���� �޼ҵ�
	public int getCount();
	
	
}
