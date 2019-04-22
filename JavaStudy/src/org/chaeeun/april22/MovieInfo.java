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

//카드레이아웃
//영화 수 5개 
//버튼 4개 생성
//1행 2열로 화면 설계
//총 생성할 패널 15개

public class MovieInfo extends Frame {
	
	Button first,prev,next,last;
	Panel buttons;
	Panel movies;
	Panel[] items_intro, items, desc;
	CardLayout card;
	
	void doIt() {
		card = new CardLayout();
		
		movies = new Panel(card);
		
		items_intro = new Panel[5];
		items = new Panel[5];
		desc = new Panel[5];
		
		for(int i = 0; i < items_intro.length; i++) {
			items_intro[i] = new Panel();
			items_intro[i].setLayout(new GridLayout(1,2));
			
			switch(i) {
			case 0:items[i] = new MovieImage("src\\chaeeun\\movie\\movie1.jpg");break;
			case 1:items[i] = new MovieImage("src\\chaeeun\\movie\\movie2.jpg");break;
			case 2:items[i] = new MovieImage("src\\chaeeun\\movie\\movie3.jpg");break;
			case 3:items[i] = new MovieImage("src\\chaeeun\\movie\\movie4.jpg");break;
			case 4:items[i] = new MovieImage("src\\chaeeun\\movie\\movie5.jpg");break;
			}
			
			desc[i] = new Panel();
			desc[i].setLayout(new GridLayout(3,1));
			
			items_intro[i].add(items[i]);
			items_intro[i].add(desc[i]);
		}
		
		//첫번째 영화 설명
		desc[0].add(new Label("6년째 연애중"));
		desc[0].add(new Label("드라마, 멜로/로맨스"));
		desc[0].add(new Label("2008.02.05. 개봉"));
		desc[0].setBackground(new Color(255,167,167));
		
		//두번째 영화 설명
		desc[1].add(new Label("7급 공무원"));
		desc[1].add(new Label("액션, 코미디"));
		desc[1].add(new Label(" 2009.04.22. 개봉"));
		desc[1].setBackground(new Color(255,193,168));
		
		//세번째 영화 설명
		desc[2].add(new Label("33"));
		desc[2].add(new Label("드라마"));
		desc[2].add(new Label("2016.04.07. 개봉"));
		desc[2].setBackground(new Color(255,224,140));
		
		//네번째 영화 설명
		desc[3].add(new Label("13시간"));
		desc[3].add(new Label("액션, 드라마, 스릴러"));
		desc[3].add(new Label("2016.03.03. 개봉"));
		desc[3].setBackground(new Color(206,242,121));
		
		//다섯번째 영화 설명
		desc[4].add(new Label("7번방의 선물"));
		desc[4].add(new Label("코미디"));
		desc[4].add(new Label(" 2013.01.23. 개봉"));
		desc[4].setBackground(new Color(183,240,177));
		
		movies.add(items_intro[0],"movie1");
		movies.add(items_intro[1],"movie2");
		movies.add(items_intro[2],"movie3");
		movies.add(items_intro[3],"movie4");
		movies.add(items_intro[4],"movie5");
		
		first = new Button("처음");
		first.addActionListener(new MyButtonAction(this));
		prev = new Button("이전");
		prev.addActionListener(new MyButtonAction(this));
		next = new Button("다음");
		next.addActionListener(new MyButtonAction(this));
		last = new Button("마지막");
		last.addActionListener(new MyButtonAction(this));
		
		buttons = new Panel();
		buttons.add(first);buttons.add(prev);
		buttons.add(next);buttons.add(last);
	}
	
	public MovieInfo(String title) {
		super(title);
		
		doIt();
		
		this.add("Center",movies);
		this.add("South",buttons);
		
		this.addWindowListener(new MyWindowExit());
		
		this.setSize(700,500);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MovieInfo("영화 소개 ver1.0");
	}

}

class MyButtonAction implements ActionListener{
	MovieInfo mi;
	MyButtonAction(MovieInfo mi){
		this.mi = mi;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == mi.first) {
			mi.card.first(mi.movies);
		}else if(obj == mi.prev) {
			mi.card.previous(mi.movies);
		}else if(obj == mi.next) {
			mi.card.next(mi.movies);
		}else if(obj == mi.last) {
			mi.card.last(mi.movies);
		}
	}
	
}

class MovieImage extends Panel{
	Image img;
	MovieImage(String path){
		img = Toolkit.getDefaultToolkit().getImage(path);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}

class MyWindowExit extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}
