package org.chaeeun.april10;

import java.awt.Frame;

class MyWindow extends Frame{
	MyWindow(String str){
		super(str);
		this.setSize(300,500);//window의 가로,세로 길이 설정
		this.setVisible(true);//window 활성화
	}
}

public class WindowOfInheritance {

	public static void main(String[] args) {
		MyWindow mw = new MyWindow("윈도우");
	}

}
