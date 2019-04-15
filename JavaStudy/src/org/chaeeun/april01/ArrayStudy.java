package org.chaeeun.april01;

class Cat{
	Cat(){}
}

class StudyOfArray{
	//문자열은 인스턴스다.
	String str1 = new String("대한민국");
	String str2 = "대한민국";
	//배열은 인스턴스다.
	//1.정수 5개를 가지고 있는 배열(1,2,3,4,5)
	int array1[] = new int[5];
	int array2[] = {1,2,3,4,5};
	
	String[] students = new String[23]; //문자열 23개를 가질 수 있는 배열
	
	void setString() {
		students[0] = "김수용"; students[1] = "조총희";
		students[2] = "이중근"; students[0] = "김도완";
	}
	
	//고양이 5마리가 들어가 있는 배열
	Cat[] cats1 = new Cat[5];//고양이 5마리가 들어갈 수 있는 배열
	Cat[] cats2 = {new Cat(), new Cat(), new Cat(), new Cat(), new Cat()};//고양이 5마리가 들어간 배열
	
	void setCats() {
		cats1[0] = new Cat();//첫번째 고양이
		cats1[1] = new Cat();
		cats1[2] = new Cat();
		cats1[3] = new Cat();
		cats1[4] = new Cat();
		
		for(int ind = 0; ind < 5; ind++) {
			cats1[ind] = new Cat();//0~4번째 고양이가 들어감
		}
	}
}

public class ArrayStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
