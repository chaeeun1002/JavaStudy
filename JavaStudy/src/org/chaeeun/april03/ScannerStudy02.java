package org.chaeeun.april03;

import java.util.Scanner;

//Scanner 클래스의 사용
//Scanner 클래스의 임무 : 입력의 방향을 바꾼다. 예) 콘솔을 통한 입력, 파일을 통한 입력

public class ScannerStudy02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = s.nextLine();
		System.out.println("주소를 입력하세요.");
		String addr = s.nextLine();
		System.out.println("나이를 입력하세요.");
		int age = s.nextInt();
		String data = "입력한 이름:"+name;
		data = data + ",입력한 주소:"+addr;
		data = data + ",입력한 나이:"+age;
		System.out.println(data);
	}

}
