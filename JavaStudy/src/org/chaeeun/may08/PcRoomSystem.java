package org.chaeeun.may08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//피시방관리 시스템

public class PcRoomSystem extends JPanel {
	
	JRadioButton[] radios;
	String[] radio_str = {"비회원","회원","골드회원"};
	ButtonGroup radioGroup;//라디오버튼을 그룹으로 묶어야 단일 선택이 된다.
	
	JCheckBox[] checks;
	String[] check_str = {"음료수","라면","과자","아이스크림"};
	
	JComboBox combo;
	JList list;
	String[] coupon = {"1,000원 쿠폰","5,000원 쿠폰","10,000원 쿠폰","30,000원 쿠폰","50,000원 쿠폰","100,000원 쿠폰"};
	
	JPanel centerPanel, eastPanel, p1, p2;
	
	public PcRoomSystem() {
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255,167,167));
		eastPanel = new JPanel();
		eastPanel.setBackground(new Color(255,167,167));
		p1 = new JPanel();
		p1.setBackground(new Color(255,167,167));
		p2 = new JPanel();
		p2.setBackground(new Color(255,167,167));
		
		centerPanel.setLayout(new BorderLayout());
		
		p1.setBorder(new TitledBorder(new EtchedBorder(),"회원 및 사용시간",TitledBorder.LEFT,
										TitledBorder.TOP,new Font("굴림",Font.PLAIN,12),Color.BLACK));//p1패널에 경계선 추가
		
		//////////////////////////////p1에 컴포넌트 추가//////////////////////////////////
		radios = new JRadioButton[3];//배열생성
		radioGroup = new ButtonGroup();
		for(int i = 0; i < radios.length; i++) {
			radios[i] = new JRadioButton(radio_str[i]);//버튼생성
			radios[i].setBackground(new Color(255,167,167));
			radioGroup.add(radios[i]);//라디오버튼을 그룹에 붙임
			p1.add(radios[i]);//p1패널에 라디오버튼을 붙임
		}
		
		combo = new JComboBox();//콤보박스 생성(AWT:초이스)
		combo.addItem("사용시간 선택");
		for(int i = 1; i <= 48; i++) {
			combo.addItem(i+" 시간");
		}
		p1.add(combo);//p1패널에 콤보박스를 붙임
		//////////////////////////////p1에 컴포넌트 추가//////////////////////////////////
		
		p2.setBorder(new TitledBorder(new EtchedBorder(),"먹을거리",TitledBorder.LEFT,
										TitledBorder.TOP,new Font("굴림",Font.PLAIN,12),Color.BLACK));//p2패널에 경계선 추가
		
		//////////////////////////////p2에 컴포넌트 추가//////////////////////////////////
		checks = new JCheckBox[check_str.length];//배열생성
		for(int i = 0; i < checks.length; i++) {
			checks[i] = new JCheckBox(check_str[i]);//체크박스 생성
			checks[i].setBackground(new Color(255,167,167));
			p2.add(checks[i]);//p2패널에 체크박스를 붙임
		}
		//////////////////////////////p2에 컴포넌트 추가//////////////////////////////////
		
		eastPanel.setBorder(new TitledBorder(new EtchedBorder(),"사용시간 쿠폰",TitledBorder.LEFT,
							  TitledBorder.TOP,new Font("굴림",Font.PLAIN,12),Color.BLACK));//eastPanel패널에 경계선 추가
		
		///////////////////////////eastPanel에 컴포넌트 추가//////////////////////////////
		list = new JList(coupon);//리스트를 생성하면서 리스트 내용설정
		list.setBackground(new Color(255,167,167));
		list.setVisibleRowCount(2);
		JScrollPane scroll = new JScrollPane(list);
		eastPanel.add(scroll);
		///////////////////////////eastPanel에 컴포넌트 추가//////////////////////////////
		
		centerPanel.add("North",p1);//p1을 centerPanel의 위에 붙임
		centerPanel.add("Center",p2);//p2를 centerPanel의 중앙에 붙임
		this.add(centerPanel);
		this.add(eastPanel);
	}
}
