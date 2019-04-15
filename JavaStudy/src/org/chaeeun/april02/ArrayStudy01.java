package org.chaeeun.april02;

class Pazingko{
	Pazingko(){}
	String[] shapes = {"◆","♠","♥","♣"};
	void rolling() {
		int r1 = (int)((Math.random()*4)+0);//0부터 3까지의 난수
		int r2 = (int)((Math.random()*4)+0);//0부터 3까지의 난수
		int r3 = (int)((Math.random()*4)+0);//0부터 3까지의 난수
		int r4 = (int)((Math.random()*4)+0);//0부터 3까지의 난수
		System.out.println(shapes[r1]+","+shapes[r2]+","+shapes[r3]+","+shapes[r4]);
		if((r1 == 0)&&(r2 == 0)&&(r3 == 0)&&(r4 == 0)) {
			System.out.println("빙고");
		}else{
			System.out.println("다음 기회에");
		}
	}
}

public class ArrayStudy01 {

	public static void main(String[] args) {
		Pazingko pa = new Pazingko();
		pa.rolling();
	}

}
