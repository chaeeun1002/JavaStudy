package org.chaeeun.april16;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

//조원이 만든 윈도우를 메인 윈도우에 붙이는 방법
/*
 * 1. 윈도우를 패널로 바꾼다.(Panel을 상속한다.)
 * 2. 패널은 윈도우가 아니므로 제목처리를 할 수 없다.
 * 3. 패널은 윈도우가 아니므로 사이즈 설정을 할 수 없다.
 * 4. 패널은 윈도우가 아니므로 윈도우 활성화를 사용할 수 없다.
 * 5. Main 메서드도 불필요.
 */

public class GUI_Member1 extends Panel{//Frame이 아닌 Panel상속 
	
	Button btn1, btn2;
	Label label;
	
	public GUI_Member1() {
		
		//super(title); --> Panel은 제목처리가 안됨.
		
		btn1 = new Button("OK");
		btn2 = new Button("CANCEL");
		label = new Label("환영합니다.");
		label.setAlignment(1);//가운데정렬
		
		this.setLayout(new GridLayout(3,1));
		
		this.add(btn1);
		this.add(btn2);
		this.add(label);
		
//		this.setSize(300,200);
//		
//		this.setVisible(true);
		
	}

}
