package org.chaeeun.april15;

//상속일 때, 다형성(Polymorphism)이 적용된다.
//

class Fruit{//과일클래스, 바나나와 사과의 조상
	int price;
	Fruit(int price){
		this.price = price;
	}
}

class Banana extends Fruit{
	Banana(int price){
		super(price);
	}
}

class Apple extends Fruit{
	Apple(int price){
		super(price);
	}
}

public class PolymorphismStudy01 {

	public static void main(String[] args) {
		Banana b = new Banana(1000);
		System.out.println(b.price);
		Apple a = new Apple(500);
		System.out.println(a.price);
		
		//다형성 : 조상형태의 변수에 자식의 인스턴스를 저장
		Fruit b2 = new Banana(1000);//다형성
		System.out.println(b2.price);
		Fruit a2 = new Apple(500);//다형성
		System.out.println(a2.price);
		
		Fruit[] fruits = new Fruit[4];
		fruits[0] = new Banana(1000);
		fruits[1] = new Apple(1500);
		fruits[2] = new Banana(2000);
		fruits[3] = new Apple(2500);
		for(int i = 0; i < fruits.length ; i++) {//가격출력
			//instanceof : 다형성이 적용된 변수에 저장된 인스턴스가 어떤 자식의 인스턴스인지를 찾는 연산자.
			if(fruits[i] instanceof Apple) {
				System.out.print("사과의 가격 : ");
			}else if(fruits[i] instanceof Banana) {
				System.out.print("바나나의 가격 : ");
			}
			System.out.println(fruits[i].price);
		}
	}

}
