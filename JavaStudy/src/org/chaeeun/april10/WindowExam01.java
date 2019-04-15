package org.chaeeun.april10;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

class MyWin01 extends Frame{
	Label lbl1, lbl2;
	Checkbox cb1, cb2, cb3;
	Checkbox rb1, rb2, rb3;
	CheckboxGroup cbg;
	MyWin01(String str){
		super(str);
		
		Color lf = new Color(235,232,255);
		
		lbl1 = new Label("Setting OS");
		lbl1.setForeground(lf);
		lbl2 = new Label("Computer CPU ");
		lbl2.setForeground(lf);
		
		Color cf = new Color(217,214,255);
		
		cb1 = new Checkbox("Window 98",true);
		cb1.setForeground(cf);
		cb2 = new Checkbox("Window 2000");
		cb2.setForeground(cf);
		cb3 = new Checkbox("Window XP");
		cb3.setForeground(cf);
		
		cbg = new CheckboxGroup();
		rb1 = new Checkbox("Pentium 4",cbg,false);
		rb1.setForeground(cf);
		rb2 = new Checkbox("Athlon XP",cbg,false);
		rb2.setForeground(cf);
		rb3 = new Checkbox("Celeron",cbg,true);
		rb3.setForeground(cf);
		
		this.setLayout(new FlowLayout());
		
		this.add(lbl1); this.add(cb1); this.add(cb2); this.add(cb3);
		this.add(lbl2); this.add(rb1); this.add(rb2); this.add(rb3);
		
		Color c = new Color(165,102,255);
		
		this.setBackground(c);
		this.setSize(430,200);
		this.setVisible(true);
		this.setResizable(false);
		
	}
}

public class WindowExam01 {

	public static void main(String[] args) {
		MyWin01 mywin = new MyWin01("윈도우 예제1");
	}

}
