package org.chaeeun.april09;

//생성자도 메서드
//생성자도 오버로딩을 사용할 수 있다.

class CustomerInfo{
	String name;
	int age;
	String address;
	int annual_salary;
	char gender;
	String cell_phone;
	String home_phone;
	String office_phone;
	
	//필수정보 : 이름, 주소, 휴대전화번호
	CustomerInfo(String name, String addr, String cell){
		this.name = name;
		this.address = addr;
		this.cell_phone = cell;
	}
	//필수정보 외에 성별 추가
	CustomerInfo(String name, String addr, char g, String cell){
		this.name = name;
		this.address = addr;
		this.gender = g;
		this.cell_phone = cell;
	}
	//필수정보 외에 연봉과 집전화번호 추가
	CustomerInfo(String name, String addr, String cell, int anSalary, String home){
		this.name = name;
		this.address = addr;
		this.cell_phone = cell;
		this.annual_salary = anSalary;
		this.home_phone = home;
	}
	//필수정보 외에 나이와 연봉 추가
	CustomerInfo(String name, String addr, String cell, int age, int anSalary){
		this.name = name;
		this.address = addr;
		this.cell_phone = cell;
		this.age = age;
		this.annual_salary= anSalary;
	}
	//필수정보 외에 나이와 연봉과 집전화번호 추가
	CustomerInfo(String name, String addr, String cell, int age, int anSalary, String home){
		this.name = name;
		this.address = addr;
		this.cell_phone = cell;
		this.age = age;
		this.annual_salary = anSalary;
		this.home_phone = home;
	}
}

public class Study01 {

	public static void main(String[] args) {
		
	}

}
