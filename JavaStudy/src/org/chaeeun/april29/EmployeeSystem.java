package org.chaeeun.april29;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class EmployeeSystem extends Frame {
	
	Label[] labels;
	TextField[] text;
	Checkbox[] genders;
	CheckboxGroup group;
	Choice[] choices;
	Button[] btns;
	Panel[] panels;
	
	String[] label_title = {"사 번","이 름","부 서","성 별","주 소","입사일"};
	String[] btn_title = {"삽 입","삭 제","변 경","조 회","지우기","달 력"};
	String[] dpt_name = {"영업부","홍보부","개발부","기획부"};
	
	void makeLabel() {
		labels = new Label[6];
		for(int i = 0; i < labels.length; i++) {
			labels[i] = new Label(label_title[i]);
		}
	}
	
	void makeButton() {
		btns = new Button[6];
		for(int i = 0; i < btns.length; i++) {
			btns[i] = new Button(btn_title[i]);
		}
	}
	
	void makeTextField() {
		text = new TextField[3];
		for(int i = 0; i < text.length; i++) {
			text[i] = new TextField(20);
		}
	}
	
	void makeCheckBox() {
		group = new CheckboxGroup();
		genders = new Checkbox[2];
		genders[0] = new Checkbox("남자",group,true);
		genders[1] = new Checkbox("여자",group,false);
	}
	
	void makeChoice() {
		choices = new Choice[4];
		choices[0] = new Choice();
		for(int i = 0; i < dpt_name.length; i++) {
			choices[0].add(dpt_name[i]);
		}
		choices[1] = new Choice();
		for(int i = 2019; i >= 1980; i--) {
			choices[1].add(i+"");
		}
		choices[2] = new Choice();
		for(int i = 1; i <= 12; i++) {
			choices[2].add(i+"");
		}
		
	}
	
	public EmployeeSystem(String str) {
		super(str);
		this.setLayout(new GridLayout(9,1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
