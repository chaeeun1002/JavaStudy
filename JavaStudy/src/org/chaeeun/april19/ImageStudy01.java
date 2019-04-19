package org.chaeeun.april19;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ImageStudy01 extends Frame implements WindowListener{
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
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
	
	class MyImage extends Panel{//이미지를 출력할 패널
		Image img;//Image클래스가 이미지를 담당한다.
		MyImage(String path){//경로를 가지는 생성자
			img = Toolkit.getDefaultToolkit().getImage(path);//객체 생성
		}
		//paint()메서드를 바꾼다.(오버라이드 한다.)		
		@Override
		public void paint(Graphics g) {
			//내가 가지고 있는 이미지를 불러와서 출력
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
	}
	public ImageStudy01(String str) {
		super(str);
		this.setLayout(new GridLayout(1,2));
		this.add(new MyImage("src\\chaeeun\\cat1.png"));
		this.add(new MyImage("src\\chaeeun\\cat2.jpg"));
		this.addWindowListener(this);
		this.setSize(400,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ImageStudy01("이미지 윈도우");
	}

}
