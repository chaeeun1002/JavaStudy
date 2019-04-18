package org.chaeeun.april18;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CardLayoutStudy01 extends Frame implements WindowListener{
	
	Button first,prev,next,last;
	Panel buttons;//버튼을 붙일 패널
	Panel slide;//카드레이아웃을 사용할 패널
	Panel card1,card2,card3,card4,card5;//slide에 붙일 패널들
	CardLayout card;//카드레이아웃용 변수
	
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	public CardLayoutStudy01(String str) {
		super(str);
		this.setLayout(new BorderLayout());//배치관리자 설정
		//윈도우에 기본배치관리자는 보더레이아웃이므로, 보더레이아웃을 사용하는 경우 이부분을 생략해도 된다.
		//Panel의 기본배치관리자는 FlowLayout이므로, 플로우레이아웃을 사용한는 경우 패널에 배치관리자 설정을 생략.
		doIt();
		this.addWindowListener(this);
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	void doIt() {
		card = new CardLayout();//카드레이아웃 생성
		
		first = new Button("맨처음");
		prev = new Button("이전");
		next = new Button("다음");
		last = new Button("마지막");
		
		buttons = new Panel();//버튼을 담을 패널 생성
		
		//패널에 버튼을 붙임
		buttons.add(first);buttons.add(prev);buttons.add(next);buttons.add(last);
		
		slide = new Panel();//카드레이아웃을 사용할 패널 생성
		slide.setLayout(card);//패널의 배치관리자를 카드레이아웃으로 설정
		
		//지금 부터 slide에 들어갈 패널 다섯개 생성
		card1 = new Panel();card2 = new Panel();card3 = new Panel();
		card4 = new Panel();card5 = new Panel();
		
		//패널은 눈에 안보이므로 배경색을 지정해서 색을 보이게 한다.
		card1.setBackground(new Color(255,255,180));
		card2.setBackground(new Color(255,255,126));
		card3.setBackground(new Color(255,255,72));
		card4.setBackground(new Color(255,246,18));
		card5.setBackground(new Color(219,192,0));
		
		//카드레이아웃을 사용하는 패널에 card1부터 card5까지를 붙임
		//카드레이아웃에 컴포넌트를 붙일 때에는 이름을 지정해야 한다.
		slide.add(card1,"1");slide.add(card2,"2");slide.add(card3,"3");
		slide.add(card4,"4");slide.add(card5,"5");//두번째 인자가 이름
	}
	
	public static void main(String[] args) {
		new CardLayoutStudy01("카드 레이아웃 테스트 윈도우");
	}

}
