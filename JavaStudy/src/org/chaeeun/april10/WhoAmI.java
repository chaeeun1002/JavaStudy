package org.chaeeun.april10;

class IamKing {
	String name;

	IamKing(String name) {
		this.name = name;
	}
}

class IamSon extends IamKing {
	IamSon(String name){
		super(name);//상속관계에서는 부모의 생성자가 어떤 형태로 생성되어 있는지 파악 해야 한다.
		//super 생성자는 자식 생성자의 첫번째 줄에 있어야 한다.
		//-->상속관계에서는 자식 생성자를 생성할 때 무조건 조상 생성자를 생성 후 생성해야 한다.
	}
}

public class WhoAmI {
	public static void main(String[] args) {
		IamSon me = new IamSon("장수왕");
	}
}
