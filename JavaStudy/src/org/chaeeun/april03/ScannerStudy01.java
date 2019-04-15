package org.chaeeun.april03;

import java.util.Scanner;

class InputFromConsole{
	InputFromConsole(){}
	Scanner s = new Scanner(System.in);
	void doIt() {
		System.out.println("이름을 입력하세요.");
		//콘솔에서 이름(문자열)을 입력한다.
		//스캐너가 문자열을 입력받는다. -> 입력받는 메서드를 사용한다.
		String name = s.nextLine();
		System.out.println("입력한 데이터 : "+name);
	}
}

public class ScannerStudy01 {

	public static void main(String[] args) {
		InputFromConsole console = new InputFromConsole();
		console.doIt();
	}

}
