package exam;

import java.awt.Frame;

public class BarChartSystem extends Frame {
	public BarChartSystem(String str) {
		super(str);
		this.setSize(500,400);
		this.addWindowListener(new LoginSystemExit());
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new BarChartSystem("막대그래프");
	}

}
