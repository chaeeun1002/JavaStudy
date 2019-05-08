package org.chaeeun.may07;

import java.util.ArrayList;

public class ArrayListStudy03 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("포도");// 데이터를 저장할 때 add() 메서드를 사용한다.
		list.add("딸기");
		list.add("사과");
		list.add("포도");
		int index1 = list.indexOf("포도");// 첫번째 “포도”의 위치, 즉 0을 알려준다.
		int index2 = list.lastIndexOf("포도");// 마지막 “포도”의 위치, 즉 3을 알려준다.
		System.out.println("첫번째 포도의 위치 : " + index1);
		System.out.println("두번째 포도의 위치 : " + index2);
	}

}
