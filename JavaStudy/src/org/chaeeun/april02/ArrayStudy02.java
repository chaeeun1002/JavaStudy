package org.chaeeun.april02;

class Player{
	Player(){}
	String[] yut = {"●●●●●","○○○○○"};
	String[] mal = {"모","도","개","걸","윷"};
	void playing() {
		int yut1 = 1-((int)(Math.random()*10)/5);//5:5비교(예:/6의 경우에는 6:4비교)
		int yut2 = 1-((int)(Math.random()*10)/5);
		int yut3 = 1-((int)(Math.random()*10)/5);
		int yut4 = 1-((int)(Math.random()*10)/5);
		int total = yut1+yut2+yut3+yut4;
		System.out.println(yut[yut1]+","+yut[yut2]);
		System.out.println(yut[yut3]+","+yut[yut4]);
		System.out.println("결과 : " + mal[total]);
	}
}

public class ArrayStudy02 {

	public static void main(String[] args) {
		Player player = new Player();
		player.playing();
	}

}
