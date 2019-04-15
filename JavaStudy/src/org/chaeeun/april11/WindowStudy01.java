package org.chaeeun.april11;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;

class MyWindow extends Frame {
	Label[] lbls; 
	Choice[] choice; 
	List[] hobbys;
	TextField[] inputs;//데이터 입력용 컴포넌트
	TextArea area;//여러줄에 걸친 데이터 입력용 컴포넌트
	
	MyWindow(String title){
		
		super(title);
		
		lbls = new Label[5];	
		choice=new Choice[5];
		hobbys = new List[2];	
		inputs=new TextField[2];
		
		hobbys[0] = new List(3,false);//취미 선택용 리스트
		hobbys[0].setForeground(Color.BLUE);
		hobbys[0].setBackground(Color.YELLOW);
		//3:화면에 출력될 데이터갯수, false:다중선택 허용 안함
		
		hobbys[1] = new List(2,true);//특기 선택용 리스트
		hobbys[1].setForeground(Color.CYAN);
		hobbys[1].setBackground(Color.MAGENTA);
		//2:화면에 출력될 데이터갯수, true:다중선택 허용
		
		hobbys[0].add("노래하기"); 	hobbys[0].add("운동");
		hobbys[0].add("게임");		hobbys[0].add("여행");
		hobbys[1].add("게임");		hobbys[1].add("프로그램");
		hobbys[1].add("노래하기");	hobbys[1].add("청소하기");
		
		lbls[0]=new Label("생년을 선택하세요.");
		lbls[1]=new Label("월을 선택하세요.");
		lbls[2]=new Label("일을 선택하세요.");
		lbls[3]=new Label("ID를 입력하세요.");
		lbls[4]=new Label("암호를 입력하세요.");
		
		inputs[0] = new TextField("ID입력",20);
		//첫번째 인자:화면에 출력될 문자열, 두번째 인자: 최대길이
		
		inputs[1] = new TextField(20);//암호용
		inputs[1].setEchoChar('*');//입력문자 대신 출력 문자 설정
		//첫번째 인자:최대길이
		
		area = new TextArea("소개글을 입력하세요.",5,30);
		//첫번째 인자:화면에 출력될 문자열, 두번째 인자:행의 갯수,
		//세번째 인자:열의 갯수
		
		for(int i=0; i<choice.length; i++) {
			choice[i] = new Choice();
		}
		//첫번째 초이스에 연도를 넣는다. 1920년부터 2019년까지
		choice[0].add("년도를 선택하세요.");
		
		for(int i=2019; i>= 1920; i--) {
			choice[0].add(i+"");
		}//2019부터 1920까지의 숫자를 문자열로 바꿔서 초이스에 넣는다.
		
		//두번째 초이스에 월을 넣는다. 1부터 12까지
		choice[1].add("월을 선택하세요.");
		for(int i=1; i<=12; i++) {
			choice[1].add(i+"");
		}
		
		//세번째 초이스에 일을 넣는다. 1부터 28 혹은 30 혹은 31
		choice[2].add("일을 선택하세요.");
		for(int i=1; i<=30; i++) {
			choice[2].add(i+"");
		}
		
		choice[3].add("국적을 선택하세요.");
		choice[3].add("대한민국"); choice[3].add("일본");
		choice[3].add("중국"); choice[3].add("미국");
		choice[3].add("영국"); choice[3].add("대만");
		choice[4].add("거주지역을 선택하세요.");
		choice[4].add("서울시"); choice[4].add("인천시");
		choice[4].add("수원시"); choice[4].add("경기도");
		choice[4].add("충청도"); choice[4].add("강원도");
		
		//배치관리자 설정 FlowLayout으로 설정
		this.setLayout(new FlowLayout());
		
		this.add(lbls[3]);	this.add(inputs[0]);
		this.add(lbls[4]);	this.add(inputs[1]);
		this.add(area);
		this.add(hobbys[0]); this.add(hobbys[1]);
		this.add(lbls[0]); this.add(choice[0]);
		this.add(lbls[1]); this.add(choice[1]);
		this.add(lbls[2]); this.add(choice[2]);
		this.add(choice[3]); this.add(choice[4]);
		
		//윈도우 크기 설정
		this.setSize(400, 250);
		
		//윈도우 활성화
		this.setVisible(true);
		
	}//생성자
}

public class WindowStudy01 {

	public static void main(String[] args) {
		MyWindow mw = new MyWindow("생년월일 선택");
	}

}
