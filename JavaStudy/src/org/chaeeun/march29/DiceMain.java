package org.chaeeun.march29;

public class DiceMain {

	public static void main(String[] args) {
		Skuki skuki = new Skuki();
		Youngsu ys = new Youngsu();
		Youngho yh = new Youngho();
		ys.doDice();
		yh.doDice();
		skuki.winner(yh, ys);
	}

}

class Youngsu{
	Youngsu(){}
	int dice = 0;
	void doDice() {
		dice = (int)((Math.random()*6)+1);
	}
}

class Youngho{
	Youngho(){}
	int dice = 0;
	void doDice() {
		dice = (int)((Math.random()*6)+1);
	}
}

class Skuki{
	Skuki(){}
//	void winner(int dice1, int dice2) {
//		if(dice1 > dice2) {
//			System.out.println("영수 승");
//		}else if(dice2 > dice1) {
//			System.out.println("영호 승");
//		}else {
//			System.out.println("무승부");
//		}
//	}
	void winner(Youngho ho, Youngsu su) {
		if(ho.dice > su.dice) {
			System.out.println("영호 승");
		}else if(su.dice > ho.dice) {
			System.out.println("영수 승");
		}else {
			System.out.println("영수 승");
		}
	}
}