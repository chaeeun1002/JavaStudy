package org.chaeeun.april16;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * 윈도우 종료 처리
 * 1. 윈도우의 X를 눌렀을 때 발생하는 이벤트를 찾는다. -> WindowEvent
 * 2. 해당 이벤트를 처리하는 리스너를 찾는다. -> WindowListener
 * 3. 해당 리스너를 클래스에 넣는다.(How? -> 상속한다.)
 *    --> 모든 리스너는 인터페이스이다. 따라서, implements로 상속한다.
 * 4. 리스너가 가지고 있는 추상 메서드를 반드시 오버라이딩한다.
 * 5. 콜백메서드를 우리가 원하는 방식으로 처리되도록 프로그램한다.
 *    --> 윈도우의 x를 눌렀을 대 자동으로 호출되는 콜백메서드 이름은? windowClosing()이다.
 *    --> 따라서, windowClosing()메서드 안에 프로그램 종료처리를 한다.
 * 6. 윈도우에 리스너를 붙인다.
 */

public class EventStudy01 extends Frame implements WindowListener{
	public EventStudy01(String title) {
		
		super(title);
		
		this.addWindowListener(this);//윈도우 리스너를 윈도우에 붙인다.
		//메서드의 괄호안에 무엇을 적어야 하나? --> 리스너가 있는 인스턴스
		//위의 경우에는 현재 클래스가 리스너를 상속했으므로, 현재 클래스가 리스너다.
		//따라서 this를 넣는다.
		
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);//프로그램 강제 종료
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	public static void main(String[] args) {
		new EventStudy01("윈도우 이벤트");
	}

}
