package org.chaeeun.april08;

class Terran{
	Terran(){}
}

class StudyOfArray{
	void doIt1() {
		String[] strs = new String[10];
		System.out.println(strs.length);
	}
	void doIt2() {
		int[] values = new int[10];
		System.out.println(values.length);
	}
	void doIt3() {
		Terran[] terran = new Terran[20];
		System.out.println(terran.length);
	}
}

public class Study01 {

	public static void main(String[] args) {
		StudyOfArray array = new StudyOfArray();
		array.doIt1();
		array.doIt2();
		array.doIt3();
	}

}
