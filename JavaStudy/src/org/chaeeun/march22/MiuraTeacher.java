package org.chaeeun.march22;

//나까무라상이 체육시험을 봤습니다.
//미술시험을 봤습니다.
//음악시험을 봤습니다.
//(시험 점수는 난수)
//미우라 담임선생님이 나까무라상의 점수 총합을 계산합니다.

public class MiuraTeacher {
	
	public static void main(String[] args) {
		Nakamura.do_pTest();
		Nakamura.do_aTest();
		Nakamura.do_mTest();
		getTotalScore(Nakamura.scoreP, Nakamura.scoreA, Nakamura.scoreM);
	}
	
	static void getTotalScore(int scoreP, int scoreA, int scoreM) {
		int total = scoreP + scoreA + scoreM;
		System.out.println("나카무라 점수의 총합 : " + total);
	}
	
}

class Nakamura{
	
	static int scoreP;
	static int scoreA;
	static int scoreM;
	
	static int getSalary(int start, int end) {
		int rnd = (int)((Math.random()*(end-start+1))+start);
		return rnd;
	}
	
	static void do_pTest() {
		scoreP = getSalary(0,100);
		System.out.println("체육 점수 : " + scoreP);
	}
	
	static void do_aTest() {
		scoreA = getSalary(0,100);
		System.out.println("미술 점수 : " + scoreA);
	}
	
	static void do_mTest() {
		scoreM = getSalary(0,100);
		System.out.println("음악 점수 : " + scoreM);
	}
	
}
