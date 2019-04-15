package org.chaeeun.march22;

//미라상이 주사위를 굴려서 숫자가 나왔습니다.
//마리상이 주사위를 굴려서 숫자가 나왔습니다.
//오또상이 승패를 판단합니다.

public class MrOto {

	static void showResult(int dice1, int dice2) {
		if(dice1 > dice2) {
			System.out.println("미라상의 승리");
		}else if(dice2 > dice1) {
			System.out.println("마리상의 승리");
		}else {
			System.out.println("무승부");
		}
	}
	
	public static void main(String[] args) {
		Mira.playDice();
		Mari.playDice();
		showResult(Mira.dice, Mari.dice);
	}

}

class Mira {
	static int dice;
	static void playDice() {
		dice = (int)((Math.random()*6)+1);
		System.out.println("미라상 : " + dice);
	}
	
}

class Mari {
	static int dice;  
	static void playDice() {
		dice = (int)((Math.random()*6)+1);
		System.out.println("마리상 : " + dice);
	}
	
}