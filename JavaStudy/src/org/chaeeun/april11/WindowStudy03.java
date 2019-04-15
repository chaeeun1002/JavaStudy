package org.chaeeun.april11;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

class FontWindow extends Frame{//폰트, 다이얼로그
	
	Label[] lbls;
	Font[] fonts;
	Dialog info;
	FileDialog open, save;
	
	FontWindow(String title){
		
		super(title);
		
		fonts = new Font[4];//폰트용 배열 생성
		//1인자 : 폰트의 종류, 2인자 : 보통체, 3인자 : 크기
		fonts[0] = new Font("Serif", Font.PLAIN, 20);
		fonts[1] = new Font("Serif", Font.ITALIC, 25);//이탤릭체
		fonts[2] = new Font("Serif", Font.BOLD, 30);//굵은체
		fonts[3] = new Font("Serif", Font.BOLD + Font.ITALIC, 35);//굵은체 + 이탤릭체
		
		lbls = new Label[4];
		lbls[0] = new Label("abc");
		lbls[0].setFont(fonts[0]);
		lbls[1] = new Label("abc");
		lbls[1].setFont(fonts[1]);
		lbls[2] = new Label("abc");
		lbls[2].setFont(fonts[2]);
		lbls[3] = new Label("abc");
		lbls[3].setFont(fonts[3]);
		
		//1인자 : 다이얼로그가 소속된 윈도우, 2인자 : 다이얼로그의 제목,
		//3인자 : 모달여부(모달이면 필수응답이 필요함을 의미, true이면 모달)
		//모달 : 모달여부가 true이면 다이얼로그 이외에 다른 화면을 터치할 수 없다.
		info = new Dialog(this,"알 림", false);
		info.setSize(140,90);//다이얼로그의 크기 설정
		info.setLocation(50,50);//다이얼로그가 출력되는 위치 설정
		info.setLayout(new FlowLayout());//다이얼로그의 배치관리자 설정
		
		//다이얼로그에 붙일 버튼 생성
		Button ok = new Button("ok");
		info.add(ok);
		info.setVisible(true);
		
		//1인자 : 다이얼로그가 소속된 윈도우, 2인자 : 다이얼로그의 제목
		//3인자 : 다이얼로그의 종류(LOAD,SAVE)
		open = new FileDialog(this, "파일 열기", FileDialog.LOAD);
		save = new FileDialog(this, "파일 저장", FileDialog.SAVE);
		
		open.show(); //메서드의 사선은 메서드가 구버전의 메서드임을 알리는 표시.
		save.show();
		
		this.setLayout(new FlowLayout());
		
		this.add(lbls[0]);
		this.add(lbls[1]);
		this.add(lbls[2]);
		this.add(lbls[3]);
		
		this.setSize(400,200);
		
		this.setVisible(true);
		
	}
	
}

public class WindowStudy03 {

	public static void main(String[] args) {
		FontWindow font = new FontWindow("폰트");
	}

}
