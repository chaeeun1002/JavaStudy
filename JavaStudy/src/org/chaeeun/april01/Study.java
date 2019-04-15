package org.chaeeun.april01;

class Apple{
	int price;
	Apple(int a){
		price = a;
	}
}

public class Study {

	public static void main(String[] args) {
		Apple apple = new Apple(34500);
		Apple apple2 = new Apple(5000);
		
		//String
		String str1 = new String("대한민국");//str1과 같이 new를 이용해서 생성하면 메모리가 계속 생성된다.
		String str2 = "대한민국";//str2와 같이 바로 문자열을 선언하면 메모리 공간이 없으면 새로 생성, 있으면 기존의 공간을 사용한다.
		//위의 방식으로 String 데이터를 생성하는 편이 메모리 공간을 효율적으로 활용할 수 있음.
		String str3 = new String("대한민국");
		String str4 = "대한민국";
		
		if(str1 == str2) {//==비교는 문자열의 내용이 아닌 메모리의 주소가 같은지를 비교하는 연산자.
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(str1.equals(str2)) {//.equals 문자열의 내용이 같은지를 비교하는 메서드
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if("대한민국".equals(str1)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		//str1과 str2,str3,str4는 다르다
		//str2와 str1,str3은 다르다. str2와 str4는 같다.
		//str3과 str1,str2,str4는 다르다.
		//str4와 str1,str3은 다르다. str4와 str2는 같다.
		
	}

}

