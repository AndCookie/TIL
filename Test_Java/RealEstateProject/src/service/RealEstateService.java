package service;

import java.util.List;

import vo.RealEstate;

public interface RealEstateService {
	// 1. ���
	public boolean insert(RealEstate realEstate);
	// ���� Ŭ������ �޾ƾ� ��/��/���� �� ���� Ÿ���� �� ���� �� ����
	// abstract Ŭ������ ����� --> ��ü ���� �Ұ�
	
	// 2. �˻� (�Ÿ�/����/���� �߿� �ϳ��� Ÿ�Ը� ��ȯ)
	public List<RealEstate> selectByType(String Type);
	
	// 3. ����
	public boolean update(RealEstate realEstate);
	
	// 4. ����
	public boolean delete(String address);
	
	
	// 5. ��ü ���
	public List<RealEstate> selectAll ();

	// 6. �ּҷ� �˻�
	public RealEstate selectByAddress(String address);
	
}
