package org.chaeeun.april22;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//카드레이아웃을 사용
//과일 수는 6개 -> 패널 6개 생성
//버튼 4개 생성 (처음,이전,다음,마지막) -> 버튼을 넣을 패널 1개 생성
//1행2열로 화면 설계(왼쪽 : 상품 이미지, 오른쪽 : 상품 설명(3행1열))(한 화면에 패널 2개씩)
//총 생성할 패널 18개

class MyButton implements ActionListener{

	FruitShopping shopping;
	
	MyButton(FruitShopping shopping){
		this.shopping = shopping;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == shopping.first) {
			shopping.card.first(shopping.fruits);
		}else if(obj == shopping.prev) {
			shopping.card.previous(shopping.fruits);
		}else if(obj == shopping.next) {
			shopping.card.next(shopping.fruits);
		}else if(obj == shopping.last) {
			shopping.card.last(shopping.fruits);
		}
	}
	
}

public class FruitShopping extends Frame {
	
	Button first,prev,next,last;
	Panel buttons;//버튼을 담을 패널
	Panel fruits;//과일 소개를 담을 패널(카드레이아웃을 사용)
	Panel[] items_intro, items, desc;
	//items_intro : 과일 소개용 패널(1행 2열의 GridLayout사용)
	//items : 과일 이미지용 패널, items_intro 왼쪽에 배치
	//desc : 과일 소개글용 패널, items_intro 오른쪽에 배치
	CardLayout card;//fruits가 사용할 배치관리자
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		if(obj == first) {
//			card.first(fruits);
//		}else if(obj == prev) {
//			card.previous(fruits);
//		}else if(obj == next) {
//			card.next(fruits);
//		}else if(obj == last) {
//			card.last(fruits);
//		}
//	}

	void init() {//컴포넌트 생성
		card = new CardLayout();//배치관리자 생성
		
		fruits = new Panel(card);//패널을 생성하면서 배치관리자 설정
		
		items_intro = new Panel[6];
		items = new Panel[6];
		desc = new Panel[6];
		//items_intro,items,desc 모두 크기 6의 배열 생성
		
		for(int i = 0; i < items_intro.length; i++) {
			items_intro[i] = new Panel();//패널 생성
			items_intro[i].setLayout(new GridLayout(1,2));//1행 2열
			
			switch(i) {//이미지를 가지고 있는 패널 생성
			case 0:items[i] = new FruitImage("src\\chaeeun\\fruit\\grape.jpg");break;
			case 1:items[i] = new FruitImage("src\\chaeeun\\fruit\\kiwi.jpg");break;
			case 2:items[i] = new FruitImage("src\\chaeeun\\fruit\\lemon.jpg");break;
			case 3:items[i] = new FruitImage("src\\chaeeun\\fruit\\orange.jpg");break;
			case 4:items[i] = new FruitImage("src\\chaeeun\\fruit\\strawberry.jpg");break;
			case 5:items[i] = new FruitImage("src\\chaeeun\\fruit\\tangerine.jpg");break;
			}
			
			desc[i] = new Panel();//설명을 가지고 있는 패널 생성
			desc[i].setLayout(new GridLayout(3,1));//3행 1열
			
			items_intro[i].add(items[i]);//과일 이미지를 붙임
			items_intro[i].add(desc[i]);//과일 설명을 붙임
		}
		
		//첫번째 과일 설명
		desc[0].add(new Label("포도"));
		desc[0].add(new Label("폴리페놀을 다량 함유하고 있어"));
		desc[0].add(new Label("황산화 작용을 합니다."));
		
		//두번째 과일 설명
		desc[1].add(new Label("키위"));
		desc[1].add(new Label("비타민C가 풍부합니다."));
		desc[1].add(new Label("다이어트나 미용에 좋습니다."));
		
		//세번째 과일 설명
		desc[2].add(new Label("레몬"));
		desc[2].add(new Label("레몬에 포함된 구연산은 피로회복에 좋습니다."));
		desc[2].add(new Label("비타민 C도 풍부합니다."));
		
		//네번째 과일 설명
		desc[3].add(new Label("오렌지"));
		desc[3].add(new Label("비타민 C가 풍부합니다."));
		desc[3].add(new Label("생과일 주스로 마시면 좋습니다."));
		
		//다섯번째 과일 설명
		desc[4].add(new Label("딸기"));
		desc[4].add(new Label("비타민 C나 폴라보노이드를 다량"));
		desc[4].add(new Label("함유하고 있습니다."));
		
		//여섯번째 과일 설명
		desc[5].add(new Label("귤"));
		desc[5].add(new Label("시네피린을 함유하고 있어"));
		desc[5].add(new Label("감기 예방에 좋습니다."));
		
		fruits.add(items_intro[0],"grape");
		fruits.add(items_intro[1],"kiwi");
		fruits.add(items_intro[2],"lemon");
		fruits.add(items_intro[3],"orange");
		fruits.add(items_intro[4],"strawberry");
		fruits.add(items_intro[5],"tangerine");
		
		first = new Button("처음");
		first.addActionListener(new MyButton(this));
		prev = new Button("이전");
		prev.addActionListener(new MyButton(this));
		next = new Button("다음");
		next.addActionListener(new MyButton(this));
		last = new Button("마지막");
		last.addActionListener(new MyButton(this));
		
		buttons = new Panel();//버튼을 담을 패널 생성
		buttons.add(first);buttons.add(prev);
		buttons.add(next);buttons.add(last);
		
		
	}
	
	public FruitShopping(String str) {
		super(str);
		
		init();
		
		this.add("Center",fruits);
		this.add("South",buttons);
		
		this.addWindowListener(new FruitShoppingEnd());//윈도우 종료
		
		this.setSize(800,500);
		this.setLocation(200, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FruitShopping("과일 소개 ver1.0");
	}
	
}

class FruitImage extends Panel{
	Image img;
	FruitImage(String path){
		img = Toolkit.getDefaultToolkit().getImage(path);
	}
	@Override
	public void paint(Graphics g) {
//		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(), this);
	}
}

//WindowAdapter
//리스너 어댑터 클래스의 특징
//:리스너가 가지고 있는 콜백 메서드 중 특정 메서드만 사용 할 경우 사용됨.
// (-> 즉, 콜백 메서드를 하나만 가지고 있는 리스너는 어댑터 클래스가 필요 없음)
class FruitShoppingEnd extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}

//WindowListener 
//여러 개의 윈도우 화면에서 종료처리를 간편하게 하기위해 윈도우리스너클래스(종료)를 public으로 생성 후,
//모든 화면에서 이 클래스를 불러 종료처리를 할 수 있도록 설계.
class FruitShoppingExit implements WindowListener{
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
