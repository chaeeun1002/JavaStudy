package org.chaeeun.april18;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;




public class CardLayoutStudy01 extends Frame implements WindowListener,ActionListener{
	
	Button first,prev,next,last;
	Panel buttons;//버튼을 붙일 패널
	Panel slide;//카드레이아웃을 사용할 패널
	Panel card1,card2,card3,card4,card5;//slide에 붙일 패널들
	CardLayout card;//카드레이아웃용 변수

	MenuBar mb;
	Menu menu;
	MenuItem game,order;
	
	@Override
	public void actionPerformed(ActionEvent e) {//버튼을 눌렀을 때 자동호출
		Object obj = e.getSource();
		//Object : Action이벤트는 버튼에서만 발생 하는 것이 아님. 
		//모든 객체를 리턴 받아야 하기 때문에 모든 객체의 조상클래스인 Object를 쓰거나 형변환이 필요.
		//형변환을 할 경우 Button obj = (Button)e.getSource();
		if(obj==first) {//첫번째 버튼을 누른 경우
			card.first(slide);
			//카드레이아웃의 first메서드가 slide에 붙어있는 패널 중 첫번째 패널로 이동한다.
		}else if(obj==prev) {//두번째 버튼을 누른경우
			card.previous(slide);
			//카드레이아웃의 next메서드가 slide에 붙어있는 패널 중 이전 패널로 이동한다.
		}else if(obj==next) {//세번째 버튼을 누른경우
			card.next(slide);
			//카드레이아웃의 previous메서드가 slide에 붙어있는 패널 중 다음 패널로 이동한다. 
		}else if(obj==last) {//네번째 버튼을 누른경우
			card.last(slide);
			//카드레이아웃의 last메서드가 slide에 붙어있는 패널 중 마지막 패널로 이동한다.
		}else if(obj==game) {
			//윈도우에 첫번째 패널(이름이 "1")이 나와야 한다.
			card.show(slide, "1");
		}else if(obj==order) {
			//윈도우에 두번째 패널(이름이 "2")이 나와야 한다.
			card.show(slide, "2");
		}
	}
	
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
		this.add("Center",slide);
		this.add("South",buttons);
		this.setMenuBar(mb);//메뉴바를 윈도우에 붙여준다.
		this.addWindowListener(this);
		this.setSize(500,400);
		this.setVisible(true);
	}
	
	void doIt() {
		card = new CardLayout();//카드레이아웃 생성
		
		first = new Button("맨처음");
		first.addActionListener(this);
		prev = new Button("이전");
		prev.addActionListener(this);
		next = new Button("다음");
		next.addActionListener(this);
		last = new Button("마지막");
		last.addActionListener(this);
		
		buttons = new Panel();//버튼을 담을 패널 생성
		
		//패널에 버튼을 붙임
		buttons.add(first);buttons.add(prev);buttons.add(next);buttons.add(last);
		
		slide = new Panel();//카드레이아웃을 사용할 패널 생성
		slide.setLayout(card);//패널의 배치관리자를 카드레이아웃으로 설정
		
		//지금 부터 slide에 들어갈 패널 다섯개 생성
		card1 = new GUIStudy01();//다형성
		card2 = new GaBaBo();//다형성
		card3 = new Panel();
		card4 = new Panel();
		card5 = new Panel();
		
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
		
		mb = new MenuBar();
		menu = new Menu("선택");
		game = new MenuItem("가위바위보게임");
		game.addActionListener(this);
		order = new MenuItem("음료수주문");
		order.addActionListener(this);
		
		menu.add(game);menu.add(order);//메뉴 아이템을 메뉴에 붙인다.
		mb.add(menu);//메뉴를 메뉴바에 붙인다.
	}
	
	public static void main(String[] args) {
		new CardLayoutStudy01("카드 레이아웃 테스트 윈도우");
	}

}
