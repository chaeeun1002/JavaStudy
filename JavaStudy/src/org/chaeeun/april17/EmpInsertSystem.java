package org.chaeeun.april17;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//사원관리시스템화면
//배치관리자 : GridLayout(8,1)
//컴포넌트 : Panel(8), Label(7), TextField(3), Choice(2), Checkbox(6), CheckboxGroup(1), Button(2)

public class EmpInsertSystem extends Frame implements WindowListener,ActionListener{
	
	Panel[] panel; Label[] label; TextField[] text;
	Choice[] choices; Checkbox[] check; CheckboxGroup group; Button[] btn;
	
	String[] label_name = {"사번","이름","부서명","직급","월급","성별","취미"};
	
	String[] dept_name = {"경영부","인사부","영업부","개발부","연구소"};
	
	String[] grade_name = {"사원","대리","주임","과장","부장","팀장"};
	
	String[] gender_hobby = {"남","여","게임","여행","독서","영화","노래","운동"};
	
	Label str1;
	
	@Override
	public void windowOpened(WindowEvent e) {

	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {

	}
	@Override
	public void windowIconified(WindowEvent e) {

	}
	@Override
	public void windowDeiconified(WindowEvent e) {

	}
	@Override
	public void windowActivated(WindowEvent e) {

	}
	@Override
	public void windowDeactivated(WindowEvent e) {

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 눌렀을 경우, 자동으로 호출되는 메서드
		//버튼이 두 개 이므로, 어떤 버튼을 눌렀는지 찾아야한다.
		if(e.getSource() == btn[0]) {
			String id = text[0].getText();//사번의 내용을 읽어서 id에 넣는다.
			String name = text[1].getText();
			String salary = text[2].getText();
			String info = "사번: "+id+",이름: "+name+",월급: "+salary ;
			str1 = new Label(info);
		}else if(e.getSource() == btn[1]) {
			text[0].setText("");
			text[1].setText("");
			text[2].setText("");
		}
	}
	EmpInsertSystem(String str){
		super(str);
		this.setLayout(new GridLayout(9,1));
		
		panel = new Panel[9];
		for(int i = 0; i < panel.length; i++) {
			panel[i] = new Panel();//패널 생성
			panel[i].setLayout(new FlowLayout());//패널 배치관리자 설정
			this.add(panel[i]);
		}
		
		label = new Label[7];
		for(int i = 0; i < label.length; i++) {
				label[i] = new Label(label_name[i]);
				panel[i].add(label[i]);
		}
		
		text = new TextField[3];
		for(int i = 0; i < text.length; i++) {
			text[i] = new TextField(25);
		}
		
		choices = new Choice[2];
		for(int i = 0; i < choices.length; i++) {
			choices[i] = new Choice();
			switch(i) {
			case 0://부서명을 넣는다.
				for(int j = 0; j < dept_name.length; j++) {
					choices[i].add(dept_name[j]);
				}
				break;
			case 1://직급을 넣는다.
				for(int k = 0; k < grade_name.length; k++) {
					choices[i].add(grade_name[k]);
				}
				break;
			}
		}
		
		check = new Checkbox[8];
		group = new CheckboxGroup();
		for(int i = 0; i < check.length; i++) {
			if(i >= 2) {
				check[i] = new Checkbox(gender_hobby[i]);
			}else {
				check[i] = new Checkbox(gender_hobby[i],group,false);
			}
		}
		
		
		btn = new Button[2];
		btn[0] = new Button("등 록");
		btn[0].addActionListener(this);
		btn[1] = new Button("취 소");
		btn[1].addActionListener(this);
		
		panel[0].add(text[0]);
		panel[1].add(text[1]);
		panel[2].add(choices[0]);
		panel[3].add(choices[1]);
		panel[4].add(text[2]);
		panel[5].add(check[0]);panel[5].add(check[1]);
		panel[6].add(check[2]);panel[6].add(check[3]);panel[6].add(check[4]);
		panel[6].add(check[5]);panel[6].add(check[6]);panel[6].add(check[7]);
		panel[7].add(btn[0]);panel[7].add(btn[1]);
		panel[8].add(str1);
		
		Color backColor = new Color(255,200,144);
		
		this.addWindowListener(this);
		this.setBackground(backColor);
		this.setSize(400,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new EmpInsertSystem("사원관리 시스템 ver1.0");
	}

}
