package org.chaeeun.march21;

//이영수가 1월의 월급을 받았습니다.
//2월의 월급을 받았습니다. 3월의 월급을 받았습니다.
//이영수가 자신의 월급의 합과 평균을 계산합니다.
//(월급은 난수(100부터 300))

public class RandomStudy {

	public static void main(String[] args) {
		//0부터 10까지의 난수
		int rnd = (int)(Math.random() * 10)+1;
		System.out.println(rnd);
		
		//0부터 100까지의 난수
		int score = (int)(Math.random() * 100)+0;
		System.out.println("당신의 점수는 =" + score);
		
		//1부터 3까지의 난수
		int gababo = (int)(Math.random() * 3)+1;
		System.out.println(gababo);
	}

}
