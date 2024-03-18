package service;

import java.util.ArrayList;
import java.util.List;

import vo.BuyingAndSelling;
import vo.Charter;
import vo.MonthlyRent;
import vo.RealEstate;

public class RealEstateServiceImpl implements RealEstateService {
	List<RealEstate> list = new ArrayList<>();


	@Override
	public boolean insert(RealEstate realEstate) {
		return list.add(realEstate);
	}

	@Override
	public List<RealEstate> selectByType(String Type) {
		// ����ִ� arraylist�����
		List<RealEstate> myList = new ArrayList<>();
		
		// �ݺ������� �����͸� ��ȸ�Ͽ� type�� Ȯ��
		for (int i=0; i<list.size(); ++i) {
			switch (Type) {
			case "BuyingAndSelling" :
				if(list.get(i) instanceof BuyingAndSelling)
					myList.add(list.get(i));
				break;
			case "Charter" :
				if(list.get(i) instanceof Charter)
					myList.add(list.get(i));
				break;
			case "MonthlyRent" :
				if(list.get(i) instanceof MonthlyRent)
					myList.add(list.get(i));			
				break;
			}
		}
		
		return myList;
		// change
	}

		
		
		
	@Override
	public boolean update(RealEstate realEstate) {
		// �����ϰ��� �ϴ� �����͸� �ּҷ� ã��
		String address = realEstate.getAddress();
		RealEstate r = null;

		for (int i=0; i<list.size(); ++i) {
			r = list.get(i);
			if (r.getAddress().equals(address)) {
				if (r instanceof BuyingAndSelling) {
					int price = ((BuyingAndSelling)realEstate).getPrice();
					((BuyingAndSelling)r).setPrice(price);
					// r : ������ �ִ� �����͵� �� ã�� ��
					// realEstate : ���Ӱ� �ٲٰ��� �ϴ� ���� ������
				} else if (r instanceof Charter) {
					int price = ((Charter)realEstate).getDepositMoney();
					((Charter)r).setDepositMoney(price);
				} else if (r instanceof MonthlyRent) {
					int price = ((MonthlyRent)realEstate).getMonthlyRent();
					((MonthlyRent)r).setMonthlyRent(price);
				}
				return true;
			}
		} // end for
		return false;

	}

	@Override
	public boolean delete(String address) {
		for (int i=0; i<list.size(); ++i) {
			if (list.get(i).getAddress().equals(address)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<RealEstate> selectAll() {
		return list;
	}

	@Override
	public RealEstate selectByAddress(String address) {
		RealEstate realEstate = null;
		for (RealEstate r : list) {
			// for (Ÿ�� ������ : �迭 �Ǵ� �÷���)
			if (r.getAddress().equals(address)) {
				realEstate = r;
				return realEstate; // ã�� �� ��Ƽ� ��ȯ
			}
		}
		return realEstate; // ��ã���� null ��ȯ
	}

}
