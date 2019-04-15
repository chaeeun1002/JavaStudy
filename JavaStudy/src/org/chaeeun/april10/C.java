package org.chaeeun.april10;

//Object 클래스 : 자바의 모든 클래스의 최고 조상

class A {
	A() {
		super();//자바의 모든 클래스는 자동상속으로 만들어진다.(Object 클래스 자동 상속)
		System.out.println("나는 A입니다.");
	}// A 클래스의 생성자
}

class B extends A {
	B() {
		//상속관계에서 조상의 생성자를 호출하는 프로그램을 해야한다.
		//그런데, 조상의 생성자 호출 프로그램을 생략하면 자동으로 프로그램(호출) 된다.(상속관계 유지를 위해)
		//생성자가 생성자를 호출할 때 생성자 이름을 this라고 한다.(this 생성자)
		//생성자가 조상의 생성자를 호출할 때 생성자 이름을 super라고 한다.
		super();//조상의 생성자
		System.out.println("나는 B입니다.");
	}
}

public class C extends B {
	public static void main(String[] args) {
		B baby = new B();
	}
}