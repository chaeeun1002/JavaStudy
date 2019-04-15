package org.chaeeun.april09;

//생성자가 생성자를 호출할 수 있다. (메서드가 메서드를 호출)
//단, 생성자가 생성자를 호출할 때에는 이름을 this로 바꿔야 한다.

class Banana{
	int price;//가격
	String origin;//원산지
	//가격만으로 생성
	Banana(int price){
		//this.price = price;
		this(price,"한국");//this 생성자
	}
	//원산지만으로 생성
	Banana(String origin){
		//this.origin = origin;
		this(origin,500);//this 생성자
	}
	//가격과 원산지로 생성
	Banana(int price, String origin){
		this.price = price;
		this.origin = origin;
	}
	//원산지와 가격으로 생성
	Banana(String origin, int price){
		this.origin = origin;
		this.price = price;
	}
}

//사과가 있습니다. 사과는 원산지와 가격을 가지고 있습니다.
class Apple{
	String origin;
	int price;
	Apple(int price){
		this(price,"한국");//this 생성자
	}
	Apple(String origin){
		this(origin,2000);// this 생성자
	}
	Apple(int price, String origin){
		this.price = price;
		this.origin = origin;
	}
	Apple(String origin, int price){
		this.origin = origin;
		this.price = price;
	}
}

//this 생성자를 이용한 객체 만들기 예제
//시계 클래스가 다음과 같을 때, new Clock();로 시계 객체를 만들면 기본적으로 
//12시 12분 12초의 값을 갖는 시계 객체가 만들어 지도록 생성자를 추가하세요.
class Clock{
	int hour;
	int minute;
	int second;
	Clock(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	Clock(){
		this(12,12,12);//this 생성자
	}
}

public class Study02 {

	public static void main(String[] args) {
		Clock clock = new Clock();
		System.out.println(clock.hour+"시"+clock.minute+"분"+clock.second+"초");
	}

}
