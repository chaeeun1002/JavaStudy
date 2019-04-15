package org.chaeeun.april11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;

class MenuWindow extends Frame{
	
	MenuBar mb;//메뉴가 위치할 바
	Menu menu;//메뉴바에 위치할 메뉴
	Menu etc;//메뉴 밑의 메뉴
	MenuItem[] items;//메뉴에 위치할 메뉴아이템
	CheckboxMenuItem check_item1;//체크할 수 있는 메뉴아이템
	CheckboxMenuItem check_item2;
	Button[] btns;
	Font font;
	
	//Center에 들어갈 패널(사원관리)
	Panel panel;
	Label[] infos; //안내메세지용 레이블
	TextField[] inputs;//입력용 텍스트필드
	Choice depart;//부서이름 선택용 초이스
	String[] depart_name = {"개발부","총무부","홍보부","영업부","배송부","관리부"};
	Button[] buttons;//버튼용 배열
	
	void makePanel() {
		
		infos = new Label[3];//레이블3개용 배열생성
		infos[0]=new Label("사번을 입력하세요.");
		infos[1]=new Label("이름을 입력하세요.");
		infos[2]=new Label("부서를 선택하세요.");
		
		inputs = new TextField[2];//테스트필드 2개용 배열생성
		inputs[0]=new TextField(10);
		inputs[1]=new TextField(20);
		
		depart=new Choice();//초이스 생성
		for(int i=0; i<depart_name.length; i++) {
			depart.add(depart_name[i]);
		}//모든 부서명을 초이스 추가
		
		buttons = new Button[4];//버튼4개용 배열 생성
		buttons[0]=new Button("삽 입"); buttons[1]=new Button("삭 제");
		buttons[2]=new Button("수 정"); buttons[3]=new Button("조 회");
		
	}
	
	void addPanel() {
		//1행
		panel.add(new Label());panel.add(new Label());panel.add(new Label());panel.add(new Label());
		//2행
		panel.add(new Label());
		panel.add(infos[0]);	
		panel.add(inputs[0]);
		panel.add(new Label()); 
		//3행
		panel.add(new Label());
		panel.add(infos[1]);	
		panel.add(inputs[1]);
		panel.add(new Label()); 
		//4행
		panel.add(new Label());
		panel.add(infos[2]);	
		panel.add(depart);
		panel.add(new Label());
		//5행
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(buttons[3]);
	}
	
	MenuWindow(String str){
		
		super(str);
		
		panel = new Panel();//패널 생성
		panel.setLayout(new GridLayout(5,4));//패널의 배치관리자 설정
		
		makePanel();
		addPanel();
		
		font = new Font("Serif", Font.BOLD, 30);
		
		btns = new Button[5];
		btns[0] = new Button("첫번째 버튼");btns[0].setFont(font);
		btns[1] = new Button("두번째 버튼");btns[1].setFont(font);
		btns[2] = new Button("세번째 버튼");btns[2].setFont(font);
		btns[3] = new Button("네번째 버튼");btns[3].setFont(font);
		btns[4] = new Button("다섯번째 버튼");btns[4].setFont(font);
		
		mb = new MenuBar();
		
		menu = new Menu("파 일");
		
		etc = new Menu("기 타");
		
		items = new MenuItem[6];//6개의 메뉴아이템을 위한 배열 생성
		//menu의 메뉴아이템
		items[0] = new MenuItem("새파일");
		items[1] = new MenuItem("불러오기");
		items[2] = new MenuItem("저장하기");
		
		//etc의 메뉴아이템
		items[3] = new MenuItem("서브 메뉴1");
		items[4] = new MenuItem("서브 메뉴2");
		items[5] = new MenuItem("서브 메뉴3");
		
		check_item1 = new CheckboxMenuItem("체크메뉴1");
		check_item2 = new CheckboxMenuItem("체크메뉴2");
	
		//menu에 메뉴아이템을 붙인다.
		menu.add(items[0]);menu.add(items[1]);menu.add(items[2]);
		
		menu.addSeparator();//구분선 추가
		
		//menu에 etc를 붙인다.
		menu.add(etc);
		
		//etc에 메뉴아이템을 붙인다.
		etc.add(items[3]);etc.add(items[4]);etc.add(items[5]);
		
		menu.addSeparator();//구분선 추가

		//menu에 check_item1,2를 붙인다.
		menu.add(check_item1); menu.add(check_item2);
		
		//메뉴바에 메뉴를 붙인다
		mb.add(menu);
		
		this.setMenuBar(mb);
		
		this.setLayout(new BorderLayout());
		
		this.add("North",btns[0]);//윈도우 위에 첫번째 버튼을 붙임
		this.add("East",btns[1]);//윈도우 오른쪽에 두번째 버튼을 붙임
		this.add("West",btns[2]);//윈도우 왼쪽에 세번째 버튼을 붙임
		this.add("Center",panel);//윈도우 중앙에 네번째 버튼을 붙임
		this.add("South",btns[4]);//윈도우 아래에 다섯번째 버튼을 붙임
		
		this.setSize(800,400);
		
		this.setVisible(true);
	
	}
	
}

public class WindowStudy04 {

	public static void main(String[] args) {
		MenuWindow mw = new MenuWindow("메뉴 생성 화면");
	}

}
