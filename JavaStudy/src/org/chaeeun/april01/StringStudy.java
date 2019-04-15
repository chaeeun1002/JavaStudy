package org.chaeeun.april01;

class ExamplesOfStringMethod{
	ExamplesOfStringMethod(){}
	void doit() {
		/* substring */
		String str = "대한민국만세";
		String result = str.substring(2,4);//str문자열의 2번째부터 4번째 이전까지의 문자열을 잘라서 result 변수에 넣음.
		System.out.println(result);
		String result2 = str.substring(2);
		System.out.println(result2);//str문자열의 2번째부터 끝까지의 문자열을 잘라서 result 변수에 넣음.
		
		/* trim */
		String str2 = " Republic Of Korea ";//문자열의 앞,뒤로 공백이 있음.
		System.out.println(str2.trim());//문자열의 앞,뒤의 공백을 없앰.(쓸데없는 공백만 제거)
		
		/* startWith */
		String str3 = "대한민국";
		System.out.println(str3.startsWith("대"));//해당 문자열이 "대"로 시작하는지 판단해서 true or false로 리턴 및 출력
		
		/* matches */
		String str4 = "대한민국국민";
		System.out.println(str4.matches("대한민국국민"));//해당 문자열이 "대한민국"과 동일한 문자인지 판단해서 true or false로 리턴 및 출력
		
		/* length */
		String str5 = "abcdef";
		System.out.println(str5.length());//문자열의 길이를 출력해줌
	}
}

public class StringStudy {

	public static void main(String[] args) {
		ExamplesOfStringMethod exam = new ExamplesOfStringMethod();
		exam.doit();
	}

}
