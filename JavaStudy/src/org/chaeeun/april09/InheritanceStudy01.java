package org.chaeeun.april09;

//상속(inheritance)
//자바에서의 상속 : 상속의 대상과 동일해진다.
class GrandParent{
	int money = 200000;
}

class Parent extends GrandParent{
	Parent(){}
	int money = 100000;
	void whoAmI() {
		System.out.println("나는 부모다");
	}
	void canDrive() {
		System.out.println("나는 운전할 수 있다.");
	}
	void showGrandParentMoney() {
		System.out.println(super.money);
	}
}

class Child extends Parent{//extends : 상속문법 (Parent를 상속받으면서 자동으로 GrandParent까지 상속받음)
	int money = 50000;//Parent가 가지고 있는 변수와 동일한 이름의 변수
	Child(){}
	void showMoney() {
		//Child가 가지고 있는 money
		System.out.println(this.money);
		//Parent가 가지고 있는 money
		System.out.println(super.money);//super 제어자 : 부모의 속성임을 의미(상속받은 변수)
		//GrandParent가 가지고 있는 money
		super.showGrandParentMoney();//Parent가 가지고 있는 GrandParent의 money를 보는 메서드를 호출
	}
}//Child가 Parent를 상속함으로써 Parent가 가지고 있는 변수, 메서드를 동일하게 가진다.

public class InheritanceStudy01 {//상속
	
	public static void main(String[] args) {
		Child child = new Child();
		child.canDrive();
		child.whoAmI();
		child.showMoney();
	}

}
