package org.chaeeun.april10;

class One {
	int i;
	String name;

	One(int i) {
		this.i = i;
	}

	One(String name) {
		this.name = name;
	}
}

class Two extends One {
	Two(int i){
		super(i);
	}
	Two(String name){
		super(name);
	}
}

public class OneTwo {

	public static void main(String[] args) {
		Two two = new Two(4);
		Two two2 = new Two("가나다");
	}

}
