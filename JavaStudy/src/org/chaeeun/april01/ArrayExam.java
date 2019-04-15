package org.chaeeun.april01;

//꽃가게가 있습니다. 이 가게에 꽃이 5개가 있습니다.
//꽃에는 가격이 있습니다. 가격은 난수(1~10)

class FlowerShop{
	Flower[] flower = new Flower[5];
	FlowerShop(){
		for(int i = 0; i < 5; i++) {
			flower[i] = new Flower();
		}
		for(int j = 0; j < 5; j++) {
			System.out.println(flower[j].price);
		}
	}
}

class Flower{
	int price;
	Flower(){
		price = (int)((Math.random()*10)+1);
	}
}

public class ArrayExam {

	public static void main(String[] args) {
		FlowerShop shop = new FlowerShop();
	}

}
