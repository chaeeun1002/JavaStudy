package org.chaeeun.april05;

class Hongildong{
	Hongildong(){
		w = new Wallet(1000);
		money = 1000;
	}
	Wallet w;
	int money;
	void buy(Item item) {
		money = money - item.price;
	}
	void buyToWallet(Item item) {
		w.money = w.money - item.price;
	}
}

class Wallet{
	Wallet(int money){
		this.money = money;
	}
	int money;
}

class Item{
	Item(int price){
		this.price = price;
	}
	int price;
}

public class Study02 {

	public static void main(String[] args) {
		Hongildong hong = new Hongildong();
		Item item = new Item(100);
		Item item2 = new Item(500);
		hong.buy(item);
		hong.buy(item2);
		System.out.println("홍길동의 돈 : "+hong.money);
		System.out.println("지갑안의 돈 : "+hong.w.money);
		hong.buyToWallet(item2);
		System.out.println("홍길동의 돈 : "+hong.money);
		System.out.println("지갑안의 돈 : "+hong.w.money);
	}

}
