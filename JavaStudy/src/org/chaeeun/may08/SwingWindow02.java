package org.chaeeun.may08;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class SystemBackgroundImage extends JPanel{
	final String PATH = "src\\chaeeun\\umi.jpg";
	Image img;
	
	SystemBackgroundImage(){
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}

public class SwingWindow02 extends JFrame {
	JMenuBar mb; 
	JMenu logout, fruit, drink, item, home, emp, sales, image; 
	JMenuItem logout_item, fruit_item, drink_item, item_item, home_item, emp_item, sales_item, image_item;

	Font menuFont;
	
	JTabbedPane tabs;
	JPanel pan2,pan3;
	
	CustomerSystem cus_system;
	PcRoomSystem pc_system;
	FruitShopping fruit_system;
	CustomerSystem_ex cus_system_ex;
	
	public SwingWindow02(String str) {
		super(str);
		
		//this.getContentPane().setBackground(new Color(255,193,158));
		
		menuFont = new Font("굴림체",Font.PLAIN,14);
		
		logout = new JMenu("로그아웃");
		logout_item = new JMenuItem("로그아웃");
		logout.add(logout_item);
		logout.setFont(menuFont);
		logout_item.setFont(menuFont);
		logout.setEnabled(false);//비활성화
		
		fruit = new JMenu("과일소개");
		fruit_item = new JMenuItem("과일소개");
		fruit.add(fruit_item);
		fruit.setFont(menuFont);
		fruit_item.setFont(menuFont);
		fruit.setEnabled(false);
		
		drink = new JMenu("음료주문");
		drink_item = new JMenuItem("음료주문");
		drink.add(drink_item);
		drink.setFont(menuFont);
		drink_item.setFont(menuFont);
		drink.setEnabled(false);
		
		item = new JMenu("물품관리");
		item_item = new JMenuItem("물품관리");
		item.add(item_item);
		item.setFont(menuFont);
		item_item.setFont(menuFont);
		item.setEnabled(false);
		
		home = new JMenu("메인화면");
		home_item = new JMenuItem("메인화면");
		home.add(home_item);
		home.setFont(menuFont);
		home_item.setFont(menuFont);
		home.setEnabled(false);
		
		emp = new JMenu("사원관리");
		emp_item = new JMenuItem("사원관리");
		emp.add(emp_item);
		emp.setFont(menuFont);
		emp_item.setFont(menuFont);
		emp.setEnabled(false);
		
		sales = new JMenu("매출관리");
		sales_item = new JMenuItem("매출관리");
		sales.add(sales_item);
		sales.setFont(menuFont);
		sales_item.setFont(menuFont);
		sales.setEnabled(false);
		
		image = new JMenu("이미지");
		image_item = new JMenuItem("이미지");
		image.add(image_item);
		image.setFont(menuFont);
		image_item.setFont(menuFont);
		image.setEnabled(false);
		
		mb = new JMenuBar();
		mb.add(logout);
		mb.add(fruit);
		mb.add(drink);
		mb.add(item);
		mb.add(home);
		mb.add(emp);
		mb.add(sales);
		mb.add(image);
		
		this.setJMenuBar(mb);
		
		/////////////////////////////탭 패널 구성///////////////////////////////////
		tabs = new JTabbedPane();
		cus_system = new CustomerSystem(); cus_system.setBackground(new Color(181,178,255));
		pc_system = new PcRoomSystem(); pc_system.setBackground(new Color(255,167,167));
		fruit_system = new FruitShopping(this); fruit_system.setBackground(new Color(250,237,125));
		cus_system_ex = new CustomerSystem_ex(this);
		
		tabs.addTab("고객정보관리", cus_system);
		tabs.addTab("피시방관리", pc_system);
		tabs.addTab("과일소개", fruit_system);
		tabs.addTab("고객정보관리2", cus_system_ex);
		
		this.add("Center",tabs);
		
		this.setBounds(200,200,800,500);//200,200위치에 가로 800, 세로 500 크기의 위도우 출력
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingWindow02("메뉴 스윙 윈도우");
	}

}
