package org.chaeeun.april15;

class King{
	int gold = 100;
	void doIt() {
		System.out.println("나는 왕이다.");
	}
}

class Prince extends King{
	int gold = 101;
	void doShow() {
		System.out.println("나는 금을 가지고 있다.");
	}
	@Override
	void doIt() {
		System.out.println("나는 왕자이다.");
	}
}

public class PolymorphismStudy02 {

	public static void main(String[] args) {
		King king = new Prince();//다형성
		//데이터의 형태 : King, 데이터 : Prince
		king.doIt();
		//king.doshow(); --> 사용할 수 없음
		System.out.println(king.gold);
		
		/*
		 * 다형성의 특징 : 다형성으로 접근할 수 있는 메서드는 바꾼 메서드(오버라이딩한 메서드),
		 * 				   조상이 가지고 있는 메서드만 접근 가능.
		 * 				   다형성으로 접근할 수 있는 변수는 오직 조상의 변수만 접근 가능.
		 */
		
		Prince prince = new Prince();
		prince.doIt();//오버라이드 메서드
		prince.doShow();
		System.out.println(prince.gold);
	}

}
