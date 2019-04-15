package org.chaeeun.march22;

//도레이 상이 1월,2월,3월의 월급을 받았습니다.(월급은 난수)
//기무라 과장이 도레이상의 월급의 합을 계산합니다.
//와다나베 사장이 도레이 상의 월급의 평균을 계산합니다.

public class WatanabeBoss {

	static void getAvgSalary(int sal_total) {
		int avg = sal_total / 3;
		System.out.println("도레이 상의 월급 평균 : " + avg);
	}
	
	public static void main(String[] args) {
		Doreyi.getSalary_J();
		Doreyi.getSalary_F();
		Doreyi.getSalary_M();
		
		KimuraChief.getTotalSalary(Doreyi.salary_j, Doreyi.salary_f, Doreyi.salary_m);
		
		WatanabeBoss.getAvgSalary(Doreyi.salary_j+Doreyi.salary_f+Doreyi.salary_m);
	}

}

class KimuraChief {
	
	static void getTotalSalary(int sal_j, int sal_f, int sal_m) {
		int total = sal_j + sal_f + sal_m;
		System.out.println("도레이 상의 월급 총합 : " + total);
	}
	
}

class Doreyi {
	
	static int salary_j;
	static int salary_f;
	static int salary_m;
	
	static int getSalary(int start, int end) {
		int rnd = (int)((Math.random()*(end-start+1))+start);
		return rnd;
	}
	
	static void getSalary_J() {
		salary_j = getSalary(100,300);
		System.out.println("1월 월급 : " + salary_j);
	}
	
	static void getSalary_F() {
		salary_f = getSalary(100,300);
		System.out.println("2월 월급 : " + salary_f);
	}
	
	static void getSalary_M() {
		salary_m = getSalary(100,300);
		System.out.println("3월 월급 : " + salary_m);
	}
	
}