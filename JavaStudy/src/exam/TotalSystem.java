package exam;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SystemBackgroundImage extends Panel{
	final String PATH = "src\\exam\\umi.jpg";
	Image img;
	
	SystemBackgroundImage(){
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

public class TotalSystem extends Frame implements ActionListener{
	
	Font font,menuFont;
	CardLayout card;
	Panel total_panel;//cardlayout 사용(윈도우 Center에 들어감)
	Panel login_system;
	Panel fruit_shopping;
	Panel backgroundImage;
	Panel drinkMenu;
	Panel itemInfo;
	Panel empInfo;
	Panel chart;
	Panel image;
	
	MenuBar mb;
	Menu menu_logout,menu_fruit,menu_drink,menu_item,menu_home,menu_emp,menu_chart, menu_image;
	MenuItem item_logout,item_fruit,item_drink,item_item,item_home,item_emp,item_chart, item_image;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == item_logout) {
			//정말로 종료하시겠습니까?라는 다이얼로그를 출력
			//"예"를 선택한 경우에만 로그아웃 처리
			//다이얼로그 처리를 했다고 가정하고,
			this.card.show(total_panel, "login");
			menu_logout.setEnabled(false);
			menu_fruit.setEnabled(false);
			menu_drink.setEnabled(false);
			menu_item.setEnabled(false);
			menu_home.setEnabled(false);
			menu_emp.setEnabled(false);
			menu_chart.setEnabled(false);
			menu_image.setEnabled(false);
		}else if(obj == item_fruit) {
			this.card.show(total_panel, "fruit");
		}else if(obj == item_drink) {
			this.card.show(total_panel, "drink");
		}else if(obj == item_item) {
			this.card.show(total_panel, "item");
		}else if(obj == item_home) {
			this.card.show(total_panel, "background");
		}else if(obj == item_emp) {
			this.card.show(total_panel,"emp");
		}else if(obj == item_chart){
			this.card.show(total_panel,"chart");
		}else if(obj == item_image) {
			this.card.show(total_panel, "image");
		}
	}

	public TotalSystem(String str) {
		super(str);
		
		font = new Font("굴림체",Font.BOLD,20);
		card = new CardLayout();
		total_panel = new Panel(card);
		login_system = new LoginSystem(this);
		fruit_shopping = new FruitShopping(this);
		
		
		menuFont = new Font("굴림체",Font.PLAIN,14);
		
		//메뉴관련 작업//
		mb = new MenuBar();
		
		menu_logout = new Menu("로그아웃");
		menu_logout.setFont(menuFont);
		
		menu_fruit = new Menu("과일소개");
		menu_fruit.setFont(menuFont);
		
		menu_drink = new Menu("음료주문");
		menu_drink.setFont(menuFont);
		
		menu_item = new Menu("물품관리");
		menu_item.setFont(menuFont);
		
		menu_home = new Menu("홈으로");
		menu_home.setFont(menuFont);
		
		menu_emp = new Menu("사원관리");
		menu_emp.setFont(menuFont);
		
		menu_chart = new Menu("매출관리");
		menu_chart.setFont(menuFont);
		
		menu_image = new Menu("이미지");
		menu_image.setFont(menuFont);
		
		item_logout = new MenuItem("로그아웃");
		item_logout.setFont(menuFont);
		item_logout.addActionListener(this);
		
		item_fruit = new MenuItem("시스템 열기");
		item_fruit.setFont(menuFont);
		item_fruit.addActionListener(this);
		
		item_drink = new MenuItem("주문하기");
		item_drink.setFont(menuFont);
		item_drink.addActionListener(this);
		
		item_item = new MenuItem("물품관리");
		item_item.setFont(menuFont);
		item_item.addActionListener(this);
		
		item_home = new MenuItem("이 동");
		item_home.setFont(menuFont);
		item_home.addActionListener(this);
		
		item_emp = new MenuItem("사원관리");
		item_emp.setFont(menuFont);
		item_emp.addActionListener(this);
		
		item_chart = new MenuItem("매출관리");
		item_chart.setFont(menuFont);
		item_chart.addActionListener(this);
		
		item_image = new MenuItem("이미지");
		item_image.setFont(menuFont);
		item_image.addActionListener(this);
		
		menu_logout.setEnabled(false);//비활성화, 로그인 전이므로.
		menu_logout.add(item_logout);
		
		menu_fruit.setEnabled(false);
		menu_fruit.add(item_fruit);
		
		menu_drink.setEnabled(false);
		menu_drink.add(item_drink);
		
		menu_item.setEnabled(false);
		menu_item.add(item_item);
		
		menu_home.setEnabled(false);
		menu_home.add(item_home);
		
		menu_emp.setEnabled(false);
		menu_emp.add(item_emp);
		
		menu_chart.setEnabled(false);
		menu_chart.add(item_chart);
		
		menu_image.setEnabled(false);
		menu_image.add(item_image);
		
		mb.add(menu_logout);
		mb.add(menu_fruit);
		mb.add(menu_drink);
		mb.add(menu_item);
		mb.add(menu_home);
		mb.add(menu_emp);
		mb.add(menu_chart);
		mb.add(menu_image);
		
		this.setMenuBar(mb);
		
		backgroundImage = new SystemBackgroundImage();//배경이미지용 패널 생성
		
		drinkMenu = new DrinkMenuSystem();
		
		itemInfo = new ItemSystem(this);
		
		empInfo = new EmployeeSystem();
		
		chart = new BarChartSystem(); 
		
		image = new ImageSystem(this);
		
		total_panel.add(login_system,"login");
		total_panel.add(fruit_shopping,"fruit");
		total_panel.add(backgroundImage,"background");
		total_panel.add(drinkMenu,"drink");
		total_panel.add(itemInfo,"item");
		total_panel.add(empInfo,"emp");
		total_panel.add(chart,"chart");
		total_panel.add(image,"image");
		
		this.add("Center",total_panel);
		
		this.addWindowListener(new LoginSystemExit());
		
		this.setSize(800,500);
		this.setLocation(300,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TotalSystem("정보 관리 시스템");
	}

}
