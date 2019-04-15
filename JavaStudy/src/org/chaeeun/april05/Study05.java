package org.chaeeun.april05;

//자바 초등학교가 있습니다. 이 초등학교에 개나리반과 진달래반이 있습니다.
//개나리반의 총 정원은 5명입니다. 진달래반의 총 정원은 10명 입니다.
//이 초등학교의 개나리반과 진달래반의 총 정원을 출력합니다.

class JavaElemetarySchool{
	JavaElemetarySchool(){
		gaenari = new ClassGaenari();
		jindalae = new ClassJindalae();
	}
	ClassGaenari gaenari;
	ClassJindalae jindalae;
}

class ClassGaenari{
	ClassGaenari(){
		student = 5;
	}
	int student;
}

class ClassJindalae{
	ClassJindalae(){
		student = 10;
	}
	int student;
}

public class Study05 {

	public static void main(String[] args) {
		JavaElemetarySchool java = new JavaElemetarySchool();
		System.out.println("자바초등학교의 총 정원 : "+(java.gaenari.student+java.jindalae.student)+"명");
	}

}
