package org.chaeeun.march29;

//자바 주식회사가 있습니다. 이곳에 사장이 있습니다.
//이곳에 미리상과 마리상이 있습니다.
//미리상의 월급과 마리상의 월급은 각각 난수로 정합니다.
//사장이 미리상의 월급과 마리상의 월급의 합을 계산합니다.

public class CompanyMain {

	public static void main(String[] args) {
		JavaCompany java = new JavaCompany();
		java.mari.getSalary();
		java.miri.getSalary();
		java.boss.getTotal(java.miri, java.mari);
	}

}

class JavaCompany{
	JavaCompany(){}
	Boss boss = new Boss();
	Miri miri = new Miri();
	Mari mari = new Mari();
}

class Boss{
	Boss(){}
	void getTotal(Miri miri, Mari mari) {
		int total = miri.salary + mari.salary;
		System.out.println("미리상과 마리상의 월급의 합 : " + total);
	}
}

class Miri{
	Miri(){}
	int salary;
	void getSalary(){
		salary = (int)((Math.random()*201)+100);
	}
}

class Mari{
	Mari(){}
	int salary;
	void getSalary() {
		salary = (int)((Math.random()*201)+100);
	}
}