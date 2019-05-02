package exam;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class GraphPanel extends Panel{
	private int total_jan, total_feb, total_mar, total_apr, total_may, total_jun;
	
	public void setTotal_jan(int total_jan) {
		this.total_jan = total_jan;
	}
	public void setTotal_feb(int total_feb) {
		this.total_feb = total_feb;
	}
	public void setTotal_mar(int total_mar) {
		this.total_mar = total_mar;
	}
	public void setTotal_apr(int total_apr) {
		this.total_apr = total_apr;
	}
	public void setTotal_may(int total_may) {
		this.total_may = total_may;
	}
	public void setTotal_jun(int total_jun) {
		this.total_jun = total_jun;
	}
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		//그려질 영역을 지운다.(0,0)에서 패널의 가로길이, 패널의 세로길이
		
		//그래프 안내선 그림.
		g.drawLine(50, 250, 650, 250);//수평선을 그린다.

		for(int cnt = 1; cnt < 11; cnt++) {
			g.drawString(cnt*10+"", 25, 255-20*cnt);
			g.drawLine(50, 250-20*cnt, 650, 250-20*cnt);
		}//10점부터 100점까지 점수와 수평선을 그린다.(10회 반복)
		
		g.drawLine(50, 20, 50, 250);//수직선을 그린다.
		g.drawString("1월", 100, 270);
		g.drawString("2월", 200, 270);
		g.drawString("3월", 300, 270);
		g.drawString("4월", 400, 270);
		g.drawString("5월", 500, 270);
		g.drawString("6월", 600, 270);
		g.setColor(Color.RED);
		if(total_jan > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(110, 250-total_jan*2, 10, total_jan*2);
		}
		if(total_feb > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(210, 250-total_feb*2, 10, total_feb*2);
		}
		if(total_mar > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(310, 250-total_mar*2, 10, total_mar*2);
		}
		if(total_apr > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(410, 250-total_apr*2, 10, total_apr*2);
		}
		if(total_may > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(510, 250-total_may*2, 10, total_may*2);
		}
		if(total_jun > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(610, 250-total_jun*2, 10, total_jun*2);
		}
	}
	
}

public class BarChartSystem extends Panel implements ActionListener{
	Button btn; Label[] labels; TextField[] textFields;
	Panel[] panel;
	String[] labels_title = {"1월의 매출","2월의 매출","3월의 매출"};
	GraphPanel graphPanel;
	@Override
	public void actionPerformed(ActionEvent e) {
		int jan = 0;int feb = 0;int mar = 0;int apr = 0;int may = 0; int jun = 0;
//		if(!textFields[0].getText().equals("")) {//값이 입력되지 않은 경우
//			jan = Integer.parseInt(textFields[0].getText());
//		}
//		
//		if(!textFields[1].getText().equals("")) {//값이 입력되지 않은 경우
//			feb = Integer.parseInt(textFields[1].getText());
//		}
//		
//		if(!textFields[2].getText().equals("")) {//값이 입력되지 않은 경우
//			mar = Integer.parseInt(textFields[2].getText());
//		}
		CRUDprocess crud = new CRUDprocess();
		Outputs output = crud.selectOutputs();
		graphPanel.setTotal_jan(output.getJan());
		graphPanel.setTotal_feb(output.getFeb());
		graphPanel.setTotal_mar(output.getMar());
		graphPanel.setTotal_apr(output.getApr());
		graphPanel.setTotal_may(output.getMay());
		graphPanel.setTotal_jun(output.getJun());
		graphPanel.repaint();
	}

	void makeLabel() {
		labels = new Label[3];
		for(int i = 0; i < labels.length; i++) {
			labels[i] = new Label(labels_title[i]);
		}
	}
	
	void makeTextfield(){
		textFields = new TextField[3];
		for(int i = 0; i < textFields.length; i++) {
			textFields[i] = new TextField(5);
		}
	}
	
	public BarChartSystem() {
//		super(str);
		
		this.setLayout(new BorderLayout());
		
		makeLabel();
		makeTextfield();
		
		btn = new Button("그리기");
		btn.addActionListener(this);
		
		graphPanel = new GraphPanel();
		
		panel = new Panel[2];
		panel[0] = new GraphPanel();
		panel[1] = new Panel();
		
		for(int i = 0; i < labels.length; i++) {
			panel[1].add(labels[i]);
			panel[1].add(textFields[i]);
		}
		panel[1].add(btn);
		panel[1].setBackground(Color.ORANGE);
		
		this.add("Center",graphPanel);
		this.add("South",panel[1]);
		
		this.setSize(500,400);
//		this.addWindowListener(new LoginSystemExit());
		this.setVisible(true);
	}
//	public static void main(String[] args) {
//		new BarChartSystem("막대그래프");
//	}

}
