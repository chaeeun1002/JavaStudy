package org.chaeeun.may07;

import java.util.ArrayList;

public class ArrayListStudy02 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		//데이터를 저장할 때 add() 메서드를 사용한다.
		list.add("포도");
		list.add("딸기");
		list.add("사과");
		
		//세번째 위치에 “키위”를 삽입한다.
		list.add(2, "키위");
		
		//첫번째 데이터를 “포도”에서 “오렌지”로 변경한다.
		list.set(0, "오렌지");
		
		//두번째 데이터를 삭제한다.
		list.remove(1);
		
		//“키위”라는 데이터를 삭제한다.
		list.remove("키위");
		
		int num = list.size();//ArrayList의 길이, 즉, ArrayList에 저장된 데이터의 개수를 알려준다.
		
		for(int i = 0; i < num; i++) {
			String str = (String)list.get(i);//i번째 저장된 데이터를 알려준다.
			System.out.println(str);
		}
	}

}
