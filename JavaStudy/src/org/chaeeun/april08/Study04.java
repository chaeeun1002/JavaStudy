package org.chaeeun.april08;

//가산기가 있습니다.
//이 가산기가 덧셈을 수행합니다. 

//자바의 특징 : 메서드의 오버로딩(over loading) -> 동일한 메서드의 이름을 허용. 
//단, 메서드의 매개변수의 갯수가 달라야 한다.(or)
//단, 매개변수의 갯수가 같아도 매개변수의 데이터 타입이 달라야한다.
//단, 메서드의 리턴타입(void, return)은 영향을 미치지 않는다.
//오버로딩의 장점 : 메서드의 작성자나 사용자가 편리하다.

class Adder{//가산기
	Adder(){}
	void add(int a, int b) {System.out.println(a + b);}
	void add(int a, long b) {System.out.println(a + b);}
	void add(long a, int b) {System.out.println(a + b);}
	void add(long a, long b) {System.out.println(a + b);}
}

public class Study04 {

	public static void main(String[] args) {
		Adder adder = new Adder();
		adder.add(10, 10);
		adder.add(10, 10L);
		adder.add(10L, 10);
		adder.add(10L, 10L);
	}

}
