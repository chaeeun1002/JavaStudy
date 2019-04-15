package org.chaeeun.april05;

class Customer{
	Customer(int cash){
		this.cash = cash;
	}
	int cash;
	void buy(Product product) {
		cash = cash - product.price;
	}
}

class Product{
	Product(int price, String name){
		this.price = price;
		this.name = name;
	}
	int price;
	String name;
}

public class Study03 {

	public static void main(String[] args) {
		Customer cus = new Customer(10000);
		Product pro1 = new Product(100,"과자");
		Product pro2 = new Product(500,"연필");
		cus.buy(pro1);//과자 구매
		cus.buy(pro2);//연필 구매
		System.out.println("고객이 가지고 있는 현금 : "+cus.cash+"원");
	}

}
