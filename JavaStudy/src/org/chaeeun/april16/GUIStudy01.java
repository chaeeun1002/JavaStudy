package org.chaeeun.april16;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUIStudy01 extends Frame implements WindowListener, ActionListener, ItemListener {

	Button btn;
	Label label1,label2,label3,label4;
	Choice year,month,date;
	Choice gu,dong;
	Choice com,dept;
	
	String[] gu_str = {"송파구","강동구","강남구","강서구"};
	//이차원배열을 사용하면 간편.
	String[] dongOfSongpa = {"석촌동","가락동","삼전동","방이동","송파동"};
	String[] dongOfGangdong = {"명일동","고덕동","상일동","길동","천호동"};
	String[] dongOfGangnam = {"역삼동","개포동","청담동","삼성동","논현동"};
	String[] dongOfGangsu = {"염창동","등촌동","화곡동","가양동","마곡동"};
	
	String[] com_name = {"자바 상사","코세아 상사","JSL 상사","오라클 상사"};
	String[][] dept_name = {
								{"자바영업부","자바경영부","자바개발부","자바총무부"},
								{"코세아영업부","코세아경영부","코세아개발부","코세아총무부"},
								{"JSL영업부","JSL경영부","JSL개발부","JSL총무부"},
								{"오라클영업부","오라클경영부","오라클개발부","오라클총무부"}
							};

	public GUIStudy01(String title) {
		
		super(title);
		
		this.setLayout(new FlowLayout());
		btn = new Button("누르세요");
		btn.setForeground(Color.magenta);
		btn.addActionListener(this);
		
		label1 = new Label("                                             ");
		label2 = new Label("                                                                        ");
		label3 = new Label("                                                                        ");
		label4 = new Label("                                                                        ");
		
		//초이스를 채우는 작업은 별도의 메서드에서 한다.
		year = new Choice();
		month = new Choice();
		date = new Choice();
		date.add("---");
		
		year.addItemListener(this);
		month.addItemListener(this);
		date.addItemListener(this);
		
		doChoice();
		
		gu = new Choice();
		dong = new Choice();
		dong.add("-----------------");
		
		doChoiceAddr();
		
		gu.addItemListener(this);
		dong.addItemListener(this);
		
		com = new Choice();
		dept = new Choice();
		dept.add("-----------------");
		
		doChoiceComAndDept();
		
		com.addItemListener(this);
		dept.addItemListener(this);
		
		this.add(btn);
		this.add(label1);
		this.add(year);this.add(month);this.add(date);
		this.add(label2);
		this.add(gu);this.add(dong);
		this.add(label3);
		this.add(com);this.add(dept);
		this.add(label4);
		
		
		this.addWindowListener(this);
		
		this.setSize(450,200);
		this.setVisible(true);
		
	}
	
	void doChoiceComAndDept() {
		for(int i = 0; i < com_name.length; i++) {
			com.add(com_name[i]);
		}
	}
	
	void doChoiceAddr() {
		for(int i = 0; i < gu_str.length; i++) {
			gu.add(gu_str[i]);
		}
	}
	
	void doChoice() {
		for(int i = 2019;i >= 1930; i--) {//2019년 부터 1930년까지
			year.add(i+"");//i를 문자열로 바꿔줌
		}
		for(int i = 1; i <= 12; i++) {//1월부터 12월까지
			month.add(i+"");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 눌렀을 때, 자동으로 호출되는 메서드
		//자동으로 호출되는 메서드를 콜백(call back)메서드라 한다.
		label1.setText("방문해 주셔서 감사합니다.");
		//레이블에 문자열을 출력하는 메서드
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//연도를 눌러도 여기로 온다.
		//월을 눌러도 여기로 온다.
		//일을 눌러도 여기로 온다.
		if(e.getSource() == year) {//연도를 누른 경우
			
		}else if(e.getSource() == month){//월을 누른 경우
			//선택한 월을 찾아서, 월에 따라 date를 넣는다.
			//getSelectedItem()메서드는 선택한 초이스의 데이터를 찾는다.
			String m = month.getSelectedItem();
			int month_int = Integer.parseInt(m);
			//date에 기존에 들어가 있는 데이터를 싹 지운 후 채워야 한다.
			date.removeAll();//들어가 있는 데이터를 지우는 메서드
			switch(month_int) {
			case 2://date에 28일을 채운다.
				for(int i = 1; i <= 28; i++) {
					date.add(i+"");
				}
				break;
			case 4://date에 30일을 채운다.
			case 6:
			case 9:
			case 11:
				for(int i = 1; i <= 30; i++) {
					date.add(i+"");
				}
				break;
			default ://date에 31일을 채운다.
				for(int i = 1; i <= 31; i++) {
					date.add(i+"");
				}
			}
			
		}else if(e.getSource() == date) {//일을 누른 경우
			//result에 선택한 년,월,일을 출력한다.
			String y = year.getSelectedItem();
			String m = month.getSelectedItem();
			String d = date.getSelectedItem();
			String birth = "당신의 생년월일은 "+y+"년"+m+"월"+d+"일입니다.";
			label2.setText(birth);
		}//이 메서드에서 할일 : 월에 따라서 날짜를 각각 date에 넣는다.
		else if(e.getSource() == gu) {
			if(gu.getSelectedItem().equals("송파구")) {
				dong.removeAll();
				for(int i = 0; i < dongOfSongpa.length; i++) {
					dong.add(dongOfSongpa[i]);
				}
			}else if(gu.getSelectedItem().equals("강동구")) {
				dong.removeAll();
				for(int i = 0; i < dongOfGangdong.length; i++) {
					dong.add(dongOfGangdong[i]);
				}
			}else if(gu.getSelectedItem().equals("강남구")) {
				dong.removeAll();
				for(int i = 0; i < dongOfGangnam.length; i++) {
					dong.add(dongOfGangnam[i]);
				}
			}else {
				dong.removeAll();
				for(int i = 0; i < dongOfGangsu.length; i++) {
					dong.add(dongOfGangsu[i]);
				}
			}
		}else if(e.getSource() == dong) {
			String guName = gu.getSelectedItem();
			String dongName = dong.getSelectedItem();
			String address = "선택하신 주소는 "+guName+" "+dongName+" 입니다.";
			label3.setText(address);
		}
		else if(e.getSource() == com) {
			dept.removeAll();
			int index = com.getSelectedIndex();
			for(int i = 0; i < dept_name[index].length; i++) {
				dept.add(dept_name[index][i]);
			}
		}else if(e.getSource() == dept){
			String comName = com.getSelectedItem();
			String deptName = dept.getSelectedItem();
			String comAndDept = comName + "의 " + deptName + " 소속입니다.";
			label4.setText(comAndDept);
		}
	}

	public static void main(String[] args) {
		new GUIStudy01("문자열 이벤트");
	}

}
