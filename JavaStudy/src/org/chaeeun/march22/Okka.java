package org.chaeeun.march22;

//가루상이 가위,바위,보 중 하나를 내밀었습니다.
//루미상이 가위,바위,보 중 하나를 내밀었습니다.
//오까상이 승패를 판단합니다.

//가위 : 1, 바위 : 2, 보 : 3

public class Okka {
	
	static void resultGababo(int gababo1, int gababo2) {
		if((gababo1 == 1 && gababo2 == 3)||(gababo1 == 2 && gababo2 == 1)||(gababo1 == 3 && gababo2 == 2)) {
			System.out.println("가루상의 승리");
		}else if((gababo2 == 1 && gababo1 == 3)||(gababo2 == 2 && gababo1 == 1)||(gababo2 == 3 && gababo1 == 2)) {
			System.out.println("루미상의 승리");
		}else {
			System.out.println("무승부");
		}
	}
	
	public static void main(String[] args) {
		Karu.playGababo();
		Rumi.playGababo();
		resultGababo(Karu.gababo, Rumi.gababo);
	}

}

class Karu {
	static int gababo;
	
	static void playGababo() {
		gababo = (int)((Math.random()*3)+1);
		if(gababo == 1) {
			System.out.println("가루상 : 가위");
		}else if(gababo == 2) {
			System.out.println("가루상 : 바위");
		}else {
			System.out.println("가루상 : 보");
		}
	}
	
}

class Rumi {
	static int gababo;
	
	static void playGababo() {
		gababo = (int)((Math.random()*3)+1);
		if(gababo == 1) {
			System.out.println("루미상 : 가위");
		}else if(gababo == 2) {
			System.out.println("루미상 : 바위");
		}else {
			System.out.println("루미상 : 보");
		}
	}
	
}