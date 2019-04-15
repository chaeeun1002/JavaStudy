package org.chaeeun.april01;

import java.util.Arrays;

class Demo{
	int[] test = {1,2,3,4,5};
	Demo(){}
	int[] doIt(int[] a) {
		a = test;
		return a;
	}
}
public class test {

	public static void main(String[] args) {
		Demo demo = new Demo();
		int test[] = demo.test;
		System.out.println(Arrays.toString(test));
		int test2[] = demo.doIt(new int[0]);
		System.out.println(Arrays.toString(test2));
	}

}
