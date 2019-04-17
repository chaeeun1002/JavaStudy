package org.chaeeun.april17;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * 윈도우 클래스 작성
 * 
 * 윈도우에 포함될 컴포넌트 선언
 * 해당 컴포넌트에서 발생하는 이벤트를 찾는다.
 * 해당 이벤트를 처리하는 리스너를 찾는다.(이벤트이름 + Listener)
 * (예 : ActionEvent -> ActionListener)
 * 리스너를 윈도우에 설치한다.
 * 이벤트가 발생하는 컴포넌트에 리스너를 붙인다.
 * 리스너가 가지고 있는 콜백메서드를 오버라이드 한다.
 */

/*
 * 윈도우 종료 이벤트 처리
 * 
 * : 윈도우의 오른쪽 상단 부분의 엑스마트를 누르면 발생하는 이벤트가 뭐냐?
 *   -->WindowEvent
 *   
 *   WindowEvent를 처리하는 객체(리스너)가 뭐냐?
 *   -->이벤트이름 + Listener (Window + Listener) == WindowListener
 *   
 *  윈도우에 WindowListener를 설치한다. (상속하면 된다.)
 *  모든 리스너는 인터페이스이다. 인터페이스를 상속하려면 implements를 쓴다.
 *  
 *  인터페이스는 몸통이 없는 메서드(추상 메서드)를 가지고 있다.
 *  인터페이스를 상속한 경우는 반드시 인터페이스가 가지고 있는 모든 추상 메서드를 바꿔야 한다. -> 오버라이딩 한다.
 *  
 *  어떻게 오버라이딩 하냐? -> 클래스 안에 커서를 위치하고 eclipse 메뉴 중 
 *  Source -> Override를 선택하면 오버라이드 할 메서드가 보이고, 선택한 후 ok를 누름.
 *  
 *  윈도우의 오른쪽 위에 있는 엑스마크를 눌렀을 때 WindowEvent가 발생하고, 이 이벤트를 WindowListener가 감지한 후 
 *  WindowListener가 가지고 있는 메서드 중 WindowClosint메서드를 자동으로 호출한다.
 *  
 *  이 리스너를 이벤트가 발생하는 요소(이벤트 소스)에 붙인다.
 *  WindowEvent가 어디서 발생? Frame(윈도우)에서 발생한다. -> 따라서 WindowListener를 Frame에 붙인다.(메서드를 사용해서 붙인다.)
 */

public class Study01 extends Frame implements WindowListener{
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);//윈도우 종료
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Study01(String str) {
		super(str);
		this.setLayout(new FlowLayout());//배치관리자 선언
		//버튼이나 선택버튼이나 체크박스 등을 붙인다.
		this.addWindowListener(this);//WindowEvent동작(윈도우 종료)
		this.setSize(400,200);
		this.setLocation(250,250);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Study01("나의 윈도우");
	}

}
