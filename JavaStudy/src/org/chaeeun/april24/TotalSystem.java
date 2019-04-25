package org.chaeeun.april24;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;

public class TotalSystem extends Frame {
	
	Font font;
	CardLayout card;
	Panel total_panel;//cardlayout 사용(윈도우 Center에 들어감)
	Panel login_system;
	Panel fruit_shopping;
	
	LoginSystem login;
	
	public TotalSystem(String str) {
		super(str);
		
		this.login = login;
		
		font = new Font("굴림체",Font.BOLD,20);
		card = new CardLayout();
		total_panel = new Panel(card);
		login_system = new LoginSystem(this);
		fruit_shopping = new FruitShopping(this,login);
		
		total_panel.add(login_system,"login");
		total_panel.add(fruit_shopping,"fruit");
		
		this.add("Center",total_panel);
		
		this.addWindowListener(new LoginSystemExit());
		
		this.setSize(800,500);
		this.setLocation(300,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TotalSystem("시스템");
	}

}
