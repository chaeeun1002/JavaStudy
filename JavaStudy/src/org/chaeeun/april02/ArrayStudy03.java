package org.chaeeun.april02;

//주사위를 50번 돌린 후, 1번 숫자가 나온 횟수부터, 6번 숫자가 나온 횟수를 출력

class Dice{
	Dice(){}
	int[] numbers = new int[6];//정수 6개가 들어가는 배열 생성
	void rolling50Times() {
		for(int i = 0; i < 50; i++) {
			int rnd = (int)(Math.random()*6)+1;//1부터 6까지의 난수
			switch(rnd) {
			case 1: numbers[0] = numbers[0]+1; break;
			case 2: numbers[1] = numbers[1]+1; break;
			case 3: numbers[2] = numbers[2]+1; break;
			case 4: numbers[3] = numbers[3]+1; break;
			case 5: numbers[4] = numbers[4]+1; break;
			case 6: numbers[5] = numbers[5]+1; break;
			}
		}//50번 반복
		System.out.println("1이 나온 횟수 : "+numbers[0]);
		System.out.println("2이 나온 횟수 : "+numbers[1]);
		System.out.println("3이 나온 횟수 : "+numbers[2]);
		System.out.println("4이 나온 횟수 : "+numbers[3]);
		System.out.println("5이 나온 횟수 : "+numbers[4]);
		System.out.println("6이 나온 횟수 : "+numbers[5]);
	}//주사위를 50번 굴리는 메서드
}

public class ArrayStudy03 {

	public static void main(String[] args) {
		Dice dice = new Dice();
		dice.rolling50Times();
	}

}
