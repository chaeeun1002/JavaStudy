package org.chaeeun.april03;

import java.util.Scanner;

//콘솔 어플리케이션의 기본 --> 무한반복

class Console{
	Console(){}
	Customer2[] customers;
	int nums; boolean flag;
	void menu() {
		System.out.println("*******************************************");
		System.out.println("**       고객 관리 시스템 ver 1.0        **");
		System.out.println("*******************************************");
		System.out.println("**                                       **");
		System.out.println("**            1. 고객 등록               **");
		System.out.println("**          2. 고객 이름 조회            **");
		System.out.println("**          3. 고객 나이 조회            **");
		System.out.println("**          4. 고객 주소 조회            **");
		System.out.println("**           5. 시스템 종료              **");
		System.out.println("**                                       **");
		System.out.println("*******************************************");
		System.out.println("원하는 번호를 입력하세요.");
	}
	Scanner scan = new Scanner(System.in);
	void checkMenu() {
		while(true) {//무한반복
			menu();
			int check = scan.nextInt();
			switch(check) {
			case 1: init();input(); break;
			case 2: printCheckName(); break;
			case 3: printCheckAge(); break;
			case 4: printCheckAddr(); break;
			case 5: System.out.println("이용해 주셔서 감사합니다.");
					System.exit(0);
					break;
			default : System.out.println("잘못된 메뉴번호 입니다.");
			}
		}
	}
	void init() {//시스템이 처음에 수행할 작업
		System.out.println("입력할 고객 수를 입력하세요.");
		nums = scan.nextInt();//입력할 고객 수를 nums에 저장
		customers = new Customer2[nums];//입력한 수 길이의 고객 배열 생성
		scan.nextLine();//Enter처리
	}
	void input() {//시스템이 고객의 데이터를 입력 받는 작업
		for(int i = 0; i < nums; i++) {
			System.out.println("이름을 입력하세요.");
			String name = scan.nextLine();
			System.out.println("주소를 입력하세요.");
			String addr = scan.nextLine();
			System.out.println("나이를 입력하세요.");
			int age = scan.nextInt();
			scan.nextLine();//Enter처리
			System.out.println("성별을 입력하세요.");
			String gender = scan.nextLine();
			customers[i] = new Customer2(name,addr,age,gender);
			System.out.println((i+1)+"번째 고객이 등록되었습니다.");
		}
	}
	void printCheckName() {//시스템이 고객의 데이터를 출력 하는 작업
		System.out.println("고객의 이름을 입력하세요.");
		//콘솔에서 문자열을 입력받는 메서드 nextLine(), next()
		//nextLine() 엔터까지 입력, next() 엔터를 제외하고 입력
		String name = scan.next();
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
		int age = scan.nextInt();
		int count = 0;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].age >= age) {
				count = count + 1;
			}
		}
		System.out.println(count+"명의 고객이 "+age+"보다 나이가 크거나 같습니다.");
	}
	void printCheckAddr() {
		System.out.println("고객의 주소를 입력하세요");
		String addr = scan.next();
		int count = 0;
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].address.equals(addr)) {
				count = count + 1;
			}
		}
		System.out.println(count+"명의 고객과 주소가 일치합니다.");
	}
}

class Customer2{
	Customer2(String a, String b, int c, String d){
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

public class ConsoleApplication {

	public static void main(String[] args) {
		Console con = new Console();
		con.checkMenu();
	}

}
