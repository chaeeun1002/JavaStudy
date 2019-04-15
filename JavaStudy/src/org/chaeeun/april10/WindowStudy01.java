package org.chaeeun.april10;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

class MyWin extends Frame{
	Button[] btns;//버튼
	Label[] lbl;//레이블 : 메세지 출력용 객체
	Checkbox ckb1,ckb2;//체크박스 --> 다중 선택 가능
	Checkbox radio1, radio2, radio3, radio4;//라디오버튼(체크박스 그룹로 만듬) --> 하나만 선택 가능
	CheckboxGroup cbg;//체크박스 그룹
	
	MyWin(String str){
		super(str);//윈도우의 제목
		
		//5개의 버튼 생성
		btns = new Button[5];
		for(int i = 0; i < btns.length; i++) {
			btns[i] = new Button("Button"+(i+1));
			btns[i].setForeground(Color.YELLOW);//버튼의 제목 폰트 색 지정
		}
		
		//5개의 레이블 생성
		lbl = new Label[5];
		
		lbl[0] = new Label("Input your name");
		lbl[0].setForeground(Color.BLUE);
		lbl[0].setBackground(Color.GRAY);
		
		lbl[1] = new Label("Input your password");
		lbl[1].setForeground(Color.BLUE);
		lbl[1].setBackground(Color.GRAY);
		
		lbl[2] = new Label("Push this button");
		lbl[2].setForeground(Color.BLUE);
		lbl[2].setBackground(Color.GRAY);
		
		lbl[3] = new Label("Please input your information");
		lbl[3].setForeground(Color.BLUE);
		lbl[3].setBackground(Color.GRAY);
		
		lbl[4] = new Label("Thanks~~");
		lbl[4].setForeground(Color.BLUE);
		lbl[4].setBackground(Color.GRAY);
		
		//2개의 체크박스 생성
		ckb1 = new Checkbox("Korea",true);//기본 선택
		ckb1.setBackground(Color.GRAY);
		
		ckb2 = new Checkbox("Japan");
		ckb2.setBackground(Color.GRAY);
		
		//4개의 라디오버튼 생성
		cbg = new CheckboxGroup();//체크박스를 그룹으로 묶는 객체
		radio1 = new Checkbox("Sales Part",cbg,true);
		radio1.setBackground(Color.GRAY);
		
		radio2 = new Checkbox("Manage Part",cbg,false);
		radio2.setBackground(Color.GRAY);
		
		radio3 = new Checkbox("IT Part",cbg,false);
		radio3.setBackground(Color.GRAY);
		
		radio4 = new Checkbox("Shipping Part",cbg,false);
		radio4.setBackground(Color.GRAY);
		
		//배치관리자 사용
		this.setLayout(new FlowLayout());//사용할 배치관리자 선언
		
		//윈도우에 레이블,버튼(컴포넌트) 붙이기 및 버튼 배경색 지정
		this.add(radio1);this.add(radio2);this.add(radio3);this.add(radio4);
		this.add(ckb1);	this.add(ckb2);
		this.add(lbl[0]); this.add(btns[0]); btns[0].setBackground(Color.GREEN);
		this.add(lbl[1]); this.add(btns[1]); btns[1].setBackground(Color.CYAN);
		this.add(lbl[2]); this.add(btns[2]); btns[2].setBackground(Color.LIGHT_GRAY);
		this.add(lbl[3]); this.add(btns[3]); btns[3].setBackground(Color.MAGENTA);
		this.add(lbl[4]); this.add(btns[4]); btns[4].setBackground(Color.ORANGE);
		
		this.setBackground(Color.GRAY);//윈도우 배경 색 지정
		this.setSize(300,200);
		this.setVisible(true);
		this.setResizable(false);//윈도우 사이즈 변경 금지
	}
}

public class WindowStudy01 {
	public static void main(String[] args) {
		MyWin mywin = new MyWin("나의 윈도우");
	}
}
