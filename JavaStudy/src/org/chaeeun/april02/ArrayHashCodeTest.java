package org.chaeeun.april02;

public class ArrayHashCodeTest {

	public static void main(String[] args) {
		String[] test1 = {"a","a",new String("a")};
		System.out.println("a의 주소 : "+System.identityHashCode(test1[0]));
		System.out.println("a의 주소 : "+System.identityHashCode(test1[1]));
		System.out.println("new String a의 주소 : "+System.identityHashCode(test1[2]));
		System.out.println("test1 배열의 주소 : "+System.identityHashCode(test1));//배열은 데이터의 주소값을 데이터로 가지고 있다.
		
		//System.identityHashCode : OS(System)에서 가지는 데이터의 고유 메모리 주소(해쉬값) 확인
		//HashCode : 자바에서 가지는 메모리 주소(해쉬값) 확인
		
//		System.out.println("--------------------------------");
//		
//		String[] test2 = {"a",new String("b"), "c"};
//		System.out.println("a의 주소 : "+test2[0].hashCode());
//		System.out.println("new String b의 주소 : "+test2[1].hashCode());
//		System.out.println("c의 주소 : "+test2[2].hashCode());
//		System.out.println("test2 배열의 주소 : "+test2.hashCode());
//		
//		System.out.println("--------------------------------");
//		
//		String test3 = "a";
//		String test4 = new String("a");
//		System.out.println("a의 주소 : "+test3.hashCode());
//		System.out.println("new String a의 주소 : "+test4.hashCode());
	}

}
