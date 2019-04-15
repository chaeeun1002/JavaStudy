package org.chaeeun.march21;

public class LeeYoungSoo {
	
	static int j_salary;
	static int f_salary;
	static int m_salary;
	
	static int start;
	static int end;
	
	public static void main(String[] args) {
		LeeYoungSoo.getj_salary();
		getf_salary();
		getm_salary();
		getSumAndAvg();
	}
	
	static int getSalary(int start, int end) {
		int rnd = (int)((Math.random()*(end-start+1))+start);
		return rnd;
	}
	
	static void getj_salary() {
		j_salary = getSalary(100, 300);
		System.out.println("1월의 월급 : " + j_salary);
	}
	
	static void getf_salary() {
		f_salary = getSalary(200, 300);
		System.out.println("2월의 월급 : " + f_salary);
	}
	
	static void getm_salary() {
		m_salary = getSalary(50, 150);
		System.out.println("3월의 월급 : " + m_salary);
	}
	
	static void getSumAndAvg() {
		int total = j_salary + f_salary + m_salary;
		int avg = total / 3;
		System.out.println("월급의 합 : " + total);
		System.out.println("월급의 평균 : " + avg);
	}
	
}
