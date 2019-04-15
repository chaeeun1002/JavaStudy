package org.chaeeun.april02;

//장바구니에 사과가 10개 있습니다. 사과 가격의 합을 계산합니다. 가격은 난수

class Basket{
	Apple[] apples = new Apple[10];
	Basket(){
		for(int i = 0; i < 10; i++) {
			apples[i] = new Apple();
		}
	}
	void getTotalPrice() {
		int total = 0;
		for(int j = 0; j < 10; j++) {
			total = total + apples[j].price;
		}
		System.out.println("사과 가격의 총합 = "+total);
	}
}

class Apple{
	int price;//가격 속성
	Apple(){
		price = (int)((Math.random()*91)+10);//10~100원
	}
}

public class ArrayStudy05 {

	public static void main(String[] args) {
		Basket basket = new Basket();
		basket.getTotalPrice();
	}

}
