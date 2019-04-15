package org.chaeeun.april02;

//로또 번호 생성기(서로 다른 난수 6개 출력)

//1단계 : 1부터 45숫자가 있는 공을 만든다.
//2단계 : 이 공을 서로 섞는다.(예:500번)
//3단계 : 섞인 공 중에서 6개를 꺼낸다.

class LottoGenerator{
	LottoGenerator(){}
	int[] ball = new int[45];
	void getBall() {//1단계 메서드
		for(int i = 0; i < 45; i++) {
			ball[i] = i+1;
		}
	}
	void shakeBall() {//2단계 메서드
		//난수번째 공(0~44)과 첫번째 공을 바꾼다. 이 작업을 500번 반복한다.
		for(int i = 0; i < 500; i++) {
			int rnd = (int)((Math.random()*45)+0);//(0~44)
			int temp = ball[0];//첫번째 공의 번호를 임시 저장소로 옮긴다.
			ball[0] = ball[rnd];//난수번째의 공의 번호를 첫번째 공으로 옮긴다.
			ball[rnd] = temp;//임시 저장소의 번호를 난수번째의 공으로 옮긴다.
		}//500회 반복
	}
	void choiceBall() {//3단계 메서드
		//앞에서 6개를 출력
		System.out.println("로또 번호 6개");
		for(int i = 0; i < 6; i++) {
			System.out.println(ball[i] + " ");
		}
		System.out.println();//줄바꿈
	}
}

public class ArrayStudy04 {

	public static void main(String[] args) {
		LottoGenerator lotto = new LottoGenerator();
		lotto.getBall();
		lotto.shakeBall();
		lotto.choiceBall();
	}

}
