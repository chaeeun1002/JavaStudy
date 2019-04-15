package org.chaeeun.april09;

import java.awt.Frame;

class LeaderClass extends Frame{//Frame : 윈도우 객체
	LeaderClass(){
		//윈도우의 가로,세로길이 설정
		this.setSize(500,500);
		//윈도우 활성화
		this.setVisible(true);
	}
}

class MemberClass extends LeaderClass{
	MemberClass(){}
}

public class InheritanceStudy02 {

	public static void main(String[] args) {
		MemberClass member = new MemberClass();
	}

}
