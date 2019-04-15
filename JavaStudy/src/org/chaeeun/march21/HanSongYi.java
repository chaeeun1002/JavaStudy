package org.chaeeun.march21;

//* 도전과제 *
//한송이 학생이 있습니다.
//체육시험을 봤습니다. 미술시험을 봤습니다.
//음악시험을 봤습니다.
//한송이 학생이 시험점수의 합과 평균을 계산합니다.
//(시험점수는 난수(0부터100))

public class HanSongYi {

	static int scoreP;
	static int scoreA;
	static int scoreM;
	
	public static void main(String[] args) {
		HanSongYi.getScoreA();
		HanSongYi.getScoreP();
		HanSongYi.getScoreM();
		HanSongYi.getScoreSumAndAvg();
	}

	static int getScore() {
		int score = (int)((Math.random()*101)+0);
		return score;
	}
	
	static void getScoreP() {
		scoreP = getScore();
		System.out.println("체육 점수 : " + scoreP);
	}
	
	static void getScoreA() {
		scoreA = getScore();
		System.out.println("미술 점수 : " + scoreA);
	}
	
	static void getScoreM() {
		scoreM = getScore();
		System.out.println("음악 점수 : " + scoreM);
	}
	
	static void getScoreSumAndAvg() {
		int total = scoreP + scoreA + scoreM;
		int avg = total / 3;
		System.out.println("총점 : " + total);
		System.out.println("평균 점수 : " + avg);
	}
	
}
