package org.chaeeun.may08;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//고객정보관리 시스템

public class CustomerSystem extends JPanel {
	
	JTextField txtName,txtId,txtAddr;
	JPasswordField txtPwd;
	JButton btnAdd,btnCancel;
	JLabel[] infos;
	
	JPanel[] panels;
	
	String[] info_str = {"이름","아이디","패스워드","주소"};
	
	void makeLabel() {
		infos = new JLabel[4];//배열 생성
		for(int i = 0; i < info_str.length; i++) {
			infos[i] = new JLabel(info_str[i]);
		}
	}
	
	void makeTextField() {
		txtName = new JTextField(20);
		txtId = new JTextField(20);
		txtPwd =  new JPasswordField(20);
		txtPwd.setEchoChar('*');
		txtAddr = new JTextField(30);
	}
	
	void makeButton() {
		btnAdd = new JButton("등 록");
		btnCancel = new JButton("취 소");
	}
	
	void makePanels() {
		panels = new JPanel[5];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(new Color(181,178,255));
		}
		panels[0].add(infos[0]);panels[0].add(txtName);
		panels[1].add(infos[1]);panels[1].add(txtId);
		panels[2].add(infos[2]);panels[2].add(txtPwd);
		panels[3].add(infos[3]);panels[3].add(txtAddr);
		panels[4].add(btnAdd);panels[4].add(btnCancel);
	}
	
	public CustomerSystem() {
		this.setLayout(new GridLayout(7,1));//7행 1열
		
		makeLabel();
		makeTextField();
		makeButton();
		makePanels();
		
		this.add(new JLabel(""));//1행에 비어있는 레이블을 붙임
		for(int i = 0; i < 4; i++) {
			this.add(panels[i]);
		}
		this.add(new JLabel(""));//6행에 비어있는 레이블을 붙임
		this.add(panels[4]);//7행에 버튼이 있는 패널을 붙임
	}
}
