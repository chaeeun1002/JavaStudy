package org.chaeeun.april16;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventStudy02 extends Frame implements WindowListener,ActionListener{

	Button btn;
	
	public EventStudy02(String title) {
		
		super(title);
		
		this.setLayout(new FlowLayout());
		btn = new Button("누르세요");
		btn.setForeground(Color.MAGENTA);
		btn.addActionListener(this);
		
		this.add(btn);
		
		this.addWindowListener(this);
		
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	//WindowListener
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Welcome To My Window.");
	}

	public static void main(String[] args) {
		new EventStudy02("버튼 이벤트 처리");
	}

}
