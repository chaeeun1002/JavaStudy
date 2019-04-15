package org.chaeeun.april03;

import java.util.Arrays;
import java.util.Scanner;

//고객 정보 처리 시스템 클래스
class CustomerSystem{
	CustomerSystem(){
		
	}
	Customer[] customers;
	Scanner s = new Scanner(System.in);
	int nums;
	boolean flag;
	void init() {//시스템이 처음에 수행할 작업
		System.out.println("입력할 고객 수를 입력하세요.");
		nums = s.nextInt();//입력할 고객 수를 nums에 저장
		customers = new Customer[nums];//입력한 수 길이의 고객 배열 생성
		s.nextLine();//Enter처리
	}
	void input() {//시스템이 고객의 데이터를 입력 받는 작업
		for(int i = 0; i < nums; i++) {
			System.out.println("이름을 입력하세요.");
			String name = s.nextLine();
			System.out.println("주소를 입력하세요.");
			String addr = s.nextLine();
			System.out.println("나이를 입력하세요.");
			int age = s.nextInt();
			s.nextLine();//Enter처리
			System.out.println("성별을 입력하세요.");
			String gender = s.nextLine();
			customers[i] = new Customer(name,addr,age,gender);
			System.out.println((i+1)+"번째 고객이 등록되었습니다.");
		}
	}
	void printCheckName() {//시스템이 고객의 데이터를 출력 하는 작업
		System.out.println("고객의 이름을 입력하세요.");
		String name = s.nextLine();
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].name.equals(name)) {
				System.out.println("이름 : "+customers[i].name);
				System.out.println("주소 : "+customers[i].address);
				System.out.println("나이 : "+customers[i].age);
				System.out.println("성별 : "+customers[i].gender);
				flag = true;
			}
		}
		if(flag == false) {
			System.out.println("조건에 맞는 데이터가 없습니다.");
		}
	}
	void printCheckAge() {//도전과제 : 입력한 나이보다 같거나 큰 고객의 수를 출력합니다.
		System.out.println("고객의 나이를 입력하세요");
		int age = s.nextInt();
		int count = 0;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].age >= age) {
				count = count + 1;
			}
		}
		System.out.println(count+"명의 고객이 "+age+"보다 나이가 크거나 같습니다.");
	}
}

//고객 클래스
class Customer{
	Customer(String a, String b, int c, String d){
		name = a;
		address = b;
		age = c;
		gender = d;
	}
	String name;//이름
	String address;//주소
	int age;//나이
	String gender;//성별
}

public class ScannerStudy03 {

	public static void main(String[] args) {
		CustomerSystem cus = new CustomerSystem();
		cus.init();
		cus.input();
		//cus.printCheckName();
		cus.printCheckAge();
	}

}
