package org.chaeeun.april18;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GaBaBo extends Panel implements WindowListener,ActionListener{
	
	Checkbox[] checks;
	CheckboxGroup group;
	Button ok;
	Label winner;
	Panel[] panels;
	
	String[] gababo = {"가위","바위","보"};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//컴퓨터가 내민 가위,바위,보는 난수로 설정한다.
		int com = (int)((Math.random()*3));//0:가위1:바위2:보
		if(checks[0].getState()) {//가위를 누른 경우
			switch(com) {
			case 0: winner.setText("무승부입니다.");break;
			case 1: winner.setText("컴퓨터 : 바위, 컴퓨터의 승리입니다.");break;
			case 2: winner.setText("컴퓨터 : 보, 당신의 승리입니다.");break;
			}
		}else if(checks[1].getState()) {//바위를 누른 경우
			switch(com) {
			case 0: winner.setText("컴퓨터 : 가위, 당신의 승리입니다.");break;
			case 1: winner.setText("무승부입니다.");break;
			case 2: winner.setText("컴퓨터 : 보, 컴퓨터의 승리입니다.");break;
			}
		}else if(checks[2].getState()){//보를 누른 경우
			switch(com) {
			case 0: winner.setText("컴퓨터 : 가위, 컴퓨터의 승리입니다.");break;
			case 1: winner.setText("컴퓨터 : 바위, 당신의 승리입니다.");break;
			case 2: winner.setText("무승부입니다.");break;
			}
		}
	}

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

	void doIt() {
		panels = new Panel[3];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();
			panels[i].setLayout(new FlowLayout());
		}
		
		group = new CheckboxGroup();
		
		checks = new Checkbox[3];
		for(int i = 0; i < checks.length; i++) {
			checks[i] = new Checkbox(gababo[i],group,false);
		}
		
		ok = new Button("결과 보기");
		ok.addActionListener(this);
		
		winner = new Label("                                                                      ");
		winner.setAlignment(1);
		
		panels[0].add(checks[0]);panels[0].add(checks[1]);panels[0].add(checks[2]);
		
		panels[1].add(winner);
		
		panels[2].add(ok);
	}
	
	public GaBaBo() {
		
		this.setLayout(new GridLayout(3,1));
		doIt();
		for(int i = 0; i < 3; i++) {
			this.add(panels[i]);
		}
//		this.addWindowListener(this);
//		this.setSize(500,200);
//		this.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new GaBaBo("가위바위보");
//	}

}
