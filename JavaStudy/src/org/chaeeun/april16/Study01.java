package org.chaeeun.april16;

import java.awt.Frame;
import java.awt.GridLayout;

public class Study01 extends Frame{
	
	GUI_Member1 member1;//첫번째 조원이 만든 패널 선언
	
	public Study01(String str) {
		super(str);
		
		member1 = new GUI_Member1(); //첫번째 조원이 만든 패널 생성
		
		//배치관리자 설정, FlowLayout, BorderLayout, GridLayout
		this.setLayout(new GridLayout(1,4));
		
		this.add(member1); 
	
		//윈도우의 크기 설정
		this.setSize(600,400);
		//윈도우 활성화
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Study01("정보관리시스템 ver1.0");
	}

}
