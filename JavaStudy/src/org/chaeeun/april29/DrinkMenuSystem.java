package org.chaeeun.april29;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class DrinkMenuSystem extends Panel implements WindowListener,ActionListener{
	
	Panel [] panels;
	Checkbox[] drinks;
	Choice[] numbers;
	Button[] btns;
	Label total;
	
	String[] drink_name = {"우유","아메리카노","카페라떼","모카라떼","녹차"};
	
	//음료수 기준 가격 설정
	final int MILK_PRICE = 1000;//우유의 기준값 설정
	final int AMERICANO_PRICE = 1500;//아메리카노의 기준값 설정
	final int CAFFELATTE_PRICE = 2500;//카페라떼의 기준값 설정
	final int MOCHALATTE_PRICE = 3000;
	final int GREENTEA_PRICE = 3500;
	
	int total_price = 0;//총 음료 가격을 위한 변수
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 눌렀을 때 자동으로 호출되는 메서드(콜백 메서드)
		if(e.getSource() == btns[0]) {//계산하기
			total_price = 0;
			//어떤 음료를 선택했는지를 찾는다.
			if(drinks[0].getState()) {//우유 선택
				String m = numbers[0].getSelectedItem();//갯수 구하기
				total_price = total_price + (MILK_PRICE * Integer.parseInt(m));
			}
			if(drinks[1].getState()) {//아메리카노 선택
				String a = numbers[1].getSelectedItem();
				total_price = total_price + (AMERICANO_PRICE * Integer.parseInt(a));
			}
			if(drinks[2].getState()) {//카페라떼 선택
				String l = numbers[2].getSelectedItem();
				total_price = total_price + (CAFFELATTE_PRICE * Integer.parseInt(l));
			}
			if(drinks[3].getState()) {//카페라떼 선택
				String l = numbers[3].getSelectedItem();
				total_price = total_price + (MOCHALATTE_PRICE * Integer.parseInt(l));
			}
			if(drinks[4].getState()) {//카페라떼 선택
				String l = numbers[4].getSelectedItem();
				total_price = total_price + (GREENTEA_PRICE * Integer.parseInt(l));
			}
			total.setText("총합계 : "+total_price+""+"원");
			panels[5].add(total);
		}else if(e.getSource() == btns[1]) {//다시하기
			//total_price를 0으로 설정
			total_price = 0;
			//음료수 체크박스를 해재
			drinks[0].setState(false);//체크박스가 해제된다.
			drinks[1].setState(false);
			drinks[2].setState(false);
			drinks[3].setState(false);
			drinks[4].setState(false);
			//음료수 개수 초이스를 처음상태로 초기화
			numbers[0].select(0);//첫번째 항목
			numbers[1].select(0);
			numbers[2].select(0);
			numbers[3].select(0);
			numbers[4].select(0);
			total.setText("총합계 : "+total_price+""+"원");
		}
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

	void doIt() {//모든 컴포넌트 생성 작업
		
		panels = new Panel[7];
		for(int i = 0; i < panels.length; i++) {//패널 7개 생성
			panels[i] = new Panel();
			panels[i].setLayout(new FlowLayout());//배치관리자 설정
			switch(i) {
			case 0: panels[i].setBackground(new Color(200,255,255));break;
			case 1: panels[i].setBackground(new Color(164,255,255));break;
			case 2: panels[i].setBackground(new Color(128,245,255));break;
			case 3: panels[i].setBackground(new Color(92,209,229));break;
			case 4: panels[i].setBackground(new Color(56,173,193));break;
			case 5: panels[i].setBackground(new Color(20,137,157));break;
			case 6: panels[i].setBackground(new Color(0,101,121));break;
			}
		}
		
		drinks = new Checkbox[5];
		for(int i = 0; i < drinks.length; i++) {
			drinks[i] = new Checkbox(drink_name[i]);
		}
		
		numbers = new Choice[5];
		for(int i = 0; i < numbers.length; i++) {//초이스 5개 생성
			numbers[i] = new Choice();
			for(int j = 1; j <= 10; j++) {//초이스의 갯수를 채움
				numbers[i].add(j+"");
			}
		}
		
		btns = new Button[2];
		btns[0] = new Button("계산하기");
		btns[0].addActionListener(this);
		btns[1] = new Button("다시하기");
		btns[1].addActionListener(this);
		
		total = new Label("                                    ");
		total.setAlignment(1);
		
		for(int i = 0; i <= 4; i++) {//첫번째 패널부터 다섯번째 패널까지 체크박스,초이스 붙임
			panels[i].add(drinks[i]);
			panels[i].add(numbers[i]);
		}
		panels[5].add(total);//여섯번째 패널에 레이블을 붙임
		panels[6].add(btns[0]);panels[6].add(btns[1]);//일곱번째 패널에 버튼 2개를 붙임
	}
	
	public DrinkMenuSystem() {
		
		this.setLayout(new GridLayout(7,1));
		
		doIt();//컴포넌트 생성
		
		for(int i = 0; i < panels.length; i++) {
			this.add(panels[i]);
		}
		
		//this.addWindowListener(this);
		
//		this.setSize(300,400);
//		
//		this.setVisible(true);
		
	}
	
//	public static void main(String[] args) {
//		new GUIStudy01("음료 주문 시스템");
//	}

}
