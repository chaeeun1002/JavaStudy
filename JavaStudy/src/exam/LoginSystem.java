package exam;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

/*
 * 화면설계
 * North : 패널 (2행 1열) --> 레이블 2개, 텍스트필드 2개
 * South : 패널 --> 버튼 2개 (로그인 화면)
 * -->로그인 성공 시 윈도우 제목에 환영합니다 (계정이름)님.
 */

public class LoginSystem extends Panel {
	
	Font font;
	Label id_info,pwd_info;
	TextField id_txt, pwd_txt;
	Button login,cancel;
	Panel pan_id, pan_pwd;//아이디/패스워드 입력창 패널
	Panel pan_btn;//버튼을 담을 패널(south)
	Panel north;//윈도우 North 위치에 담을 패널
	
	TotalSystem total;
	
	public LoginSystem(TotalSystem total) {
//		super(str);
		
		font = new Font("굴림체",Font.BOLD,20);
		
		id_info = new Label("ID를 입력하세요");
		id_info.setFont(font);
		id_info.setAlignment(1);
		pwd_info = new Label("암호를 입력하세요");
		pwd_info.setFont(font);
		pwd_info.setAlignment(1);
		
		id_txt = new TextField(20);
		id_txt.setFont(font);
		pwd_txt = new TextField(20);
		pwd_txt.setFont(font);
		pwd_txt.setEchoCharacter('*');//입력되는 문자 대신 * 출력
		pwd_txt.addActionListener(new MyLoginEvent(this,total));
		
		pan_id = new Panel(new GridLayout(1,2));
		pan_id.add(id_info);
		pan_id.add(id_txt);
		
		pan_pwd = new Panel(new GridLayout(1,2));
		pan_pwd.add(pwd_info);
		pan_pwd.add(pwd_txt);
		
		north = new Panel(new GridLayout(2,1));
		north.add(pan_id);north.add(pan_pwd);
		
		this.total = total;
		
		login = new Button("로그인");
		login.setFont(font);
		login.setBackground(new Color(119,136,153));
		login.addActionListener(new MyLoginEvent(this,total));
		
		cancel = new Button("다시입력");
		cancel.setFont(font);
		cancel.setBackground(new Color(119,136,153));
		cancel.addActionListener(new MyLoginEvent(this,total));
		
		pan_btn = new Panel(new GridLayout(1,2));
		pan_btn.add(login);
		pan_btn.add(cancel);
		
		this.setLayout(new BorderLayout());
		
		this.add("North",north);
		this.add("South",pan_btn);
		
//		this.addWindowListener(new LoginSystemExit());
		
		this.setBackground(new Color(176,196,222));
		
//		this.setSize(400,300);
//		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		new LoginSystem("로그인 화면");
//	}

}