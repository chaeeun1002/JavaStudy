package org.chaeeun.april12;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class DptInfo extends Panel{//부서관리화면
	
	Label[] lbl;//레이블 배열
	TextField[] inputs;//텍스트필드 배열
	Choice deNum;//초이스
	String[] depart_number = {"1001","2001","3001","4001","5001","6001"};
	Button[] btns;//버튼 배열
	
	public DptInfo(){//매개변수가 없는 생성자로 변경(윈도우가 아닌 패널이기 때문에)
		
		//super(name);
		
		this.setLayout(new GridLayout(7,4));
		
		Font lfont = new Font("돋움",Font.BOLD,15);
		Color lColor = new Color(102,75,0);
		
		lbl = new Label[7];//4개의 레이블 생성
		lbl[2] = new Label("부서 번호 입력");
		lbl[2].setAlignment(1);
		lbl[2].setFont(lfont);
		lbl[2].setForeground(lColor);
		lbl[3] = new Label("부서 이름 입력");
		lbl[3].setAlignment(1);
		lbl[3].setFont(lfont);
		lbl[3].setForeground(lColor);
		lbl[4] = new Label("부서 번호 선택");
		lbl[4].setAlignment(1);
		lbl[4].setFont(lfont);
		lbl[4].setForeground(lColor);
		lbl[5] = new Label("Copyright YGMAIN Corp.");
		lbl[5].setAlignment(2);
		lbl[6] = new Label("All Rights Reserved.");
		
		inputs = new TextField[2];//2개의 텍스트필드 생성
		inputs[0] = new TextField(20);
		inputs[1] = new TextField(20);
		
		deNum = new Choice();//부서번호 선택 Choice 생성
		for(int i = 0; i < depart_number.length; i++) {
			deNum.add(depart_number[i]);
		}//Choice에 부서번호 배열 삽입
		
		Color bColor = new Color(255,228,0);
		
		btns = new Button[2];//2개의 버튼 생성
		btns[0] = new Button("등 록");
		btns[0].setBackground(bColor);
		btns[0].setFont(lfont);
		btns[0].setForeground(lColor);
		btns[1] = new Button("취 소");
		btns[1].setBackground(bColor);
		btns[1].setFont(lfont);
		btns[1].setForeground(lColor);
		
		//1행
		this.add(new Label());
		this.add(new Label());
		this.add(new Label());
		this.add(new Label());
		//2행
		this.add(new Label());
		this.add(lbl[2]);
		this.add(inputs[0]);
		this.add(new Label());
		//3행
		this.add(new Label());
		this.add(lbl[3]);
		this.add(inputs[1]);
		this.add(new Label());
		//4행
		this.add(new Label());
		this.add(lbl[4]);
		this.add(deNum);
		this.add(new Label());
		//5행
		this.add(new Label());
		this.add(btns[0]);
		this.add(btns[1]);
		this.add(new Label());
		//6행
		this.add(new Label());
		this.add(lbl[5]);
		this.add(lbl[6]);
		this.add(new Label());
		//7행
		this.add(new Label());
		this.add(new Label());
		this.add(new Label());
		this.add(new Label());
		
		
		Color backColor = new Color(250,244,192);
		
		this.setBackground(backColor);
		
		//this.setSize(700, 250);
		
		//this.setVisible(true);
		
	}

}

