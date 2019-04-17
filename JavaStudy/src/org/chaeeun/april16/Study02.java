package org.chaeeun.april16;

//상속은 1차적으로 클래스를 설계한 후 상속이 가능한지 찾아서 상속관계를 구성한다.
//추상화 : 클래스들의 공통점을 찾아서 공통의 조상으로 만드는 작업.
//(추상클래스 목적-->상속)(추상메서드 목적-->오버라이드)
//인터페이스 : 추상메서드와 상수만 보유할 수 있다. 

//상속을 하면 다형성이 적용이 된다.
//다형성 : 조상형태의 변수에 자식의 인스턴스를 넣는 것.

//구하라가 있습니다. 노래를 잘 부릅니다.
//하라구가 있습니다. 노래를 잘 못합니다.
//공통점 : 노래를 한다.

interface Person{//인터페이스
	abstract void Sing();//추상메서드
	
}

/////////////////////////////JAVA 접근 제한자/////////////////////////////////
//public 은닉    : 모든 접근을 허용
//default 은닉   : 같은 패키지(폴더)에 있는 객체와 상속관계의 객체들만 허용
//protected 은닉 : 같은 패키지(폴더)에 있는 객체들만 허용
//private 은닉   : 현재 객체 내에서만 허용

class Guhara implements Person{
	Guhara(){}
	@Override
	public void Sing() {
		System.out.println("노래를 잘한다.");
	}
}

class Haragu implements Person{
	Haragu(){}
	@Override
	public void Sing() {
		System.out.println("노래를 잘 못한다.");
	}
}

public class Study02 {

	public static void main(String[] args) {
		Guhara guhara = new Guhara();
		Haragu haragu = new Haragu();

		//다형성
		Person p1 = new Guhara();
		Person p2 = new Haragu();
		
		//다형성2
		Person[] p = new Person[2];
		p[0] = new Guhara();
		p[1] = new Haragu();
		p[0].Sing();
		p[1].Sing();
	}

}
