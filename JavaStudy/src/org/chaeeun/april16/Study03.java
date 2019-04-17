package org.chaeeun.april16;

/*
 * 다형성의 특징
 * 1. 다형성으로 접근할 수 있는 메서드
 * 	  -> 오버라이드한 메서드
 *    -> 부모가 가지고 있는 메서드
 * 2. 다형성으로 접근할 수 있는 변수
 *    -> 오로지 부모의 변수만 가능
 */

class King{
	int gold = 100;
	void show() {
		System.out.println("나는 왕이다.");
	}
	void doIt() {
		System.out.println("우리 왕국에 방문을 환영합니다.");
	}
}

class Son extends King{
	int gold = 200;
	void Sing() {
		System.out.println("노래를 합니다.");
	}
	@Override
	//오버라이드 한 메서드는 상속된 메서드의 내용만 바뀌기 때문에 Son이 가지고 있는 메서드는 여전히 3개이다.
	void show() {
		System.out.println("나는 아들이다.");
	}
}

public class Study03 {

	public static void main(String[] args) {
		//다형성으로 접근 가능한 메서드 : 상속한 클래스(부모)가 가지고 있는 메서드 or 오버라이드한 메서드
		//다형성으로 사용 가능한 변수   : 상속한 클래스(부모)의 변수만 사용 가능(자식의 변수는 사용 x)
		King king = new Son();//다형성
		king.doIt();//King의 메서드 
		king.show();//Son이 바꾼(오버라이드) 메서드
	  //king.sing(); --> 다형성으로는 자식만 가지고 있는 메서드는 사용 불가
		System.out.println(king.gold);//King의 gold
	}

}
