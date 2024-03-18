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
		// 비어있는 arraylist만들기
		List<RealEstate> myList = new ArrayList<>();
		
		// 반복적으로 데이터를 조회하여 type을 확인
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
		// 수정하고자 하는 데이터를 주소로 찾기
		String address = realEstate.getAddress();
		RealEstate r = null;

		for (int i=0; i<list.size(); ++i) {
			r = list.get(i);
			if (r.getAddress().equals(address)) {
				if (r instanceof BuyingAndSelling) {
					int price = ((BuyingAndSelling)realEstate).getPrice();
					((BuyingAndSelling)r).setPrice(price);
					// r : 기존에 있던 데이터들 중 찾은 것
					// realEstate : 새롭게 바꾸고자 하는 도구 데이터
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
			// for (타입 변수명 : 배열 또는 컬렉션)
			if (r.getAddress().equals(address)) {
				realEstate = r;
				return realEstate; // 찾은 걸 담아서 반환
			}
		}
		return realEstate; // 못찾으면 null 반환
	}

}
