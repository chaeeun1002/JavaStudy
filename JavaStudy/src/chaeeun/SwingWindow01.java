package chaeeun;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class SwingWindow01 extends JFrame {
	JButton btn1; JCheckBox ck1,ck2;
	ImageIcon b1,b1d,b1p,b2,b2d,b2p,b3,b3d,b3p;
	//컴포넌트에 들어갈 이미지 객체(ImageIcon)
	public SwingWindow01(String str) {
		super(str);
		
		b1 = new ImageIcon("src\\chaeeun\\img\\1.gif");
		b1d = new ImageIcon("src\\chaeeun\\img\\11.gif");
		b1p = new ImageIcon("src\\chaeeun\\img\\111.gif");
		
		b2 = new ImageIcon("src\\chaeeun\\img\\2.gif");
		b2d = new ImageIcon("src\\chaeeun\\img\\22.gif");
		b2p = new ImageIcon("src\\chaeeun\\img\\222.gif");
		
		b3 = new ImageIcon("src\\chaeeun\\img\\3.gif");
		b3d = new ImageIcon("src\\chaeeun\\img\\33.gif");
		b3p = new ImageIcon("src\\chaeeun\\img\\333.gif");
		
		btn1 = new JButton();//버튼 생성
		
		btn1.setIcon(b1);//버튼에 이미지 설정
		btn1.setPressedIcon(b1d);//버튼을 눌렀을 때 이미지 설정
		btn1.setRolloverIcon(b1p);//버튼에 마우스가 위치했을때 이미지 설정
		
		this.add("Center",btn1);
		
		ck1 = new JCheckBox("체크박스1");
		ck1.setIcon(b2);
		ck1.setPressedIcon(b2d);
		ck1.setRolloverIcon(b2p);
		
		ck2 = new JCheckBox("체크박스2");
		ck2.setIcon(b3);
		ck2.setPressedIcon(b3d);
		ck2.setRolloverIcon(b3p);
		
		this.add("West", ck1);
		
		this.add("East", ck2);
		
		//스윙 윈도우 배경색 지정
		this.getContentPane().setBackground(new Color(255,216,216));
		
		this.setSize(500,400);
		this.setVisible(true);
		
		//스윙 윈도우 종료이벤트
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingWindow01("스윙 윈도우");
	}

}
