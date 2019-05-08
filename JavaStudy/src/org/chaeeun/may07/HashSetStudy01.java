package org.chaeeun.may07;

import java.util.HashSet;

public class HashSetStudy01 {

	public static void main(String[] args) {
		HashSet hs = new HashSet();// HashSet 생성
		hs.add("하나");// HashSet에 “하나”를 저장
		hs.add("둘");// HashSet에 “둘”을 저장
		hs.add("셋");// HashSet에 “셋”을 저장
		hs.add("하나");// HashSet에 이미 “하나”라는 데이터가 있으므로, 저장되지 않는다.
		hs.add(3.141592);
		System.out.println(hs);// HashSet 출력. 저장순서가 유지되지 않는다.
	}

}
