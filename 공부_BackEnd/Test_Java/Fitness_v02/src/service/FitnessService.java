package service;

// 설계도 개념
// 무엇을 할 지 미리 정의해두는 것
// 메소드만 만들어두고, 메소드의 본체는 하나도 안만들어두는 것
// abstract와 마찬가지로 객체 생성 불가

public interface FitnessService {
	public boolean insert();
	public void read();
	public boolean update();
	public boolean delete();
	public void selectAll();
}
