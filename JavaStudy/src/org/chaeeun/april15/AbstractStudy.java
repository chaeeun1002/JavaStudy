package org.chaeeun.april15;

//조상이 가진 메서드를 자식이 상속한 후 메서드를 바꾼다.-->메서드의 오버라이딩(overriding)

/* 
 * 추상클래스(abstract) : 조상이 가진 메서드를 직접 사용하는것이 아니고, 자식의 메서드를 사용한다.
 *						  이런 경우, 조상이 가진 메서드의 몸통을 삭제해도 된다.(추상 메서드 활용)
 *						  추상메서드를 하나라도 가지고 있는 클래스 또한 추상 클래스라고 한다.
 * 추상클래스의 목적    : 상속
 */

/*
 * 인터페이스(interface) : 추상메서드와 상수만 가질 수 있다.
 * 추상클래스(abstract)  : 추상메서드와 정상적인 메서드를 가질 수 있다.
 * 						   --> 인터페이스나 추상클래스 모두 상속이 목적.
 */

//상수 : 변수(처음의 값을 끝까지 가지고 있는 변수) --> 상수 앞에는 final을 붙인다.
// --> 상수는 일반적으로 변수이름을 대문자로 지정한다.

interface MyInterface{
	final int MONEY = 1000;
	abstract void doIt();
}

abstract class Shape{//조상 클래스(삼각형, 사각형) --> abstract : 추상클래스
	int size;
	abstract void doIt(int width, int height);//추상메서드(몸통이 x)
}

class Circle extends Shape{
	@Override //-->바꿔서 써라
	void doIt(int width, int height) {
		size = (int)((width * width) * 3.14);
	}
}

class Triangle extends Shape{//삼각형
	@Override
	void doIt(int width, int height) {//메서드의 오버라이딩
		size = (width * height)/2;
	}
}

class Rectangle extends Shape{//사각형
	@Override
	void doIt(int width, int height) {//메서드의 오버라이딩
		size = width * height;
	}
}

public class AbstractStudy {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.doIt(200, 100);
		System.out.println(r1.size);
		
		Triangle t1 = new Triangle();
		t1.doIt(200, 100);
		System.out.println(t1.size);
	}

}
