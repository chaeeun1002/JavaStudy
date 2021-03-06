package org.chaeeun.may07;

import java.util.HashSet;

public class HashSetStudy02 {

	public static void main(String[] args) {
		HashSet hs = new HashSet();// HashSet 생성
		for (int i = 0; hs.size() < 6; i++) {// HashSet에 저장된 서로다른 난수가 6개가 될 때 까지 반복
			int num = (int) (Math.random() * 45) + 1;// 1부터 45까지 난수 발생
			hs.add(num);// 발생한 난수를 저장한다. 중복된 수는 저장되지 않는다.
		}
		System.out.println(hs);// HashSet에 저장된 6개의 서로다른 난수를 화면에 출력한다.
	}

}
