package org.chaeeun.april09;

//갤럭시 스토어가 있습니다.
//이 스토어에 갤럭시10이 5개 있습니다. (가격은 알아서)
//갤럭시 노트10이 10개 있습니다.
//손님이 갤럭시10 1개와 갤럭시 노트10 2개를 구매했습니다.
//구매 후의 손님의 용돈을 출력합니다.
//(메서드의 오버로딩, this 제어자를 사용합니다.)

class GalaxyStore{
	GalaxyStore(){
		gt = new GalaxyTen[5];
		for(int i = 0; i < gt.length; i++) {
			gt[i] = new GalaxyTen();
		}
		gnt = new GalaxyNoteTen[10];
		for(int j = 0; j < gnt.length; j++) {
			gnt[j] = new GalaxyNoteTen();
		}
	}
	GalaxyTen [] gt;
	GalaxyNoteTen[] gnt;
}

class GalaxyTen{
	int price;
	GalaxyTen(){
		price = 800000;
	}
}

class GalaxyNoteTen{
	int price;
	GalaxyNoteTen(){
		price = 1200000;
	}
}

class Customer{
	int pocketMoney;
	Customer(int pocketMoney){
		this.pocketMoney = pocketMoney;
	}
	void buyGalaxy(GalaxyTen gt) {
		pocketMoney = pocketMoney - gt.price;
	}
	void buyGalaxy(GalaxyNoteTen gnt) {
		pocketMoney = pocketMoney - gnt.price;
	}
}

public class GalaxyExam {

	public static void main(String[] args) {
		GalaxyStore gs = new GalaxyStore();
		Customer cs = new Customer(7000000);//칠백만원을 가지고 있는 고객
		cs.buyGalaxy(gs.gt[0]);//갤럭시10 1개 구매
		for(int i = 0; i < 2; i++) {//갤러기 노트10 5개 구매
			cs.buyGalaxy(gs.gnt[i]);
		}
		System.out.println("용돈 잔액 : "+cs.pocketMoney+"원");
	}

}
