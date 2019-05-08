package org.chaeeun.may07;

import java.util.ArrayList;

public class ArrayListStudy01 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		//데이터를 저장할 때 add() 메서드를 사용한다.
		list.add("포도");
		list.add("딸기");
		list.add("사과");
		
		//Collection Framework는 데이터 타입 상관없이 저장 가능
		//list.add(1000);//Integer
		//list.add(3.14);//Float
		
		int num = list.size();// ArrayList의 길이, 즉, ArrayList에 저장된 데이터의 개수를 알려준다.
		
		for (int i = 0; i < num; i++) {
			String str = (String)list.get(i);// i번째 저장된 데이터를 알려준다.(return 메서드)(형변환)
			System.out.println(str);
		}
	}

}
