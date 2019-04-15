package org.chaeeun.april08;

//자바 초등학교가 있습니다. 이 초등학교에 개나리반과 진달래반이 있습니다.
//개나리반의 총 정원은 5명입니다. 진달래반의 총 정원은 10명 입니다.
//이 초등학교의 개나리반과 진달래반의 총 정원을 출력합니다.

//개나리반에 학생이 총 5명이 있습니다. 이 학생들은 모두 시험점수를 가지고 있습니다.
//시험점수는 난수로 합니다. 
//진달래반에 학생이 총 10명이 있습니다. 이 학생들은 모두 시험점수를 가지고 있습니다.
//시험점수는 난수로 합니다.
//개자리반의 학생의 총점과 평균을 출력합니다.
//진달래반의 학생의 총점과 평균을 출력합니다.
//(참고: 배열을 사용합니다. this 제어자를 사용합니다.)

class JavaElemetarySchool{
	JavaElemetarySchool(){
		gaenari = new ClassGaenari(5);
		jindalae = new ClassJindalae(10);
	}
	ClassGaenari gaenari;
	ClassJindalae jindalae;
	void showTotal() {
		int total = gaenari.numbers + jindalae.numbers;
		System.out.println("자바 초등학교의 총정원 : " + total + "명");
	}
}

class ClassGaenari{
	ClassGaenari(int numbers){
		this.numbers = numbers;
		st = new Student[numbers];//학생이 들어갈 배열 생성
		for(int i = 0; i < numbers; i++) {
			st[i] = new Student();//numbers만큼 학생 생성
		}
	}
	int numbers = 5;
	Student[] st;
}

class ClassJindalae{
	ClassJindalae(int numbers){
		this.numbers = numbers;
		st = new Student[numbers];//학생이 들어갈 배열 생성
		for(int i = 0; i < numbers; i++) {
			st[i] = new Student();//numbers만큼 학생 생성
		}
	}
	int numbers = 10;
	Student[] st;
}

class Student{
	Student(){}
}

public class SchoolExam {

	public static void main(String[] args) {
		JavaElemetarySchool school = new JavaElemetarySchool();
		school.showTotal();
	}

}
