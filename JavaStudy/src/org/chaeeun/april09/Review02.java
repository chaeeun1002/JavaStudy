package org.chaeeun.april09;

//메서드의 오버로딩(overloading)
//메서드의 이름을 동일하게 작성할 수 있다.
//단, 메서드의 매개변수 갯수가 다르거나 데이터 타입이 달라야 한다.

//자바 영화관이 있습니다. 이 영화관에 러브레터영화 티켓이 5장있습니다. 티켓의 가격은 만원입니다.
//쉘위댄스영화 티켓이 10장 있습니다. 티켓의 가격은 만이천원입니다.
//영화광이 러브레터 티켓과 쉘위댄스 티켓을 구매합니다.
//(메서드의 오버로딩과 this 제어자를 적용해서 설계합니다.)

class MovieHolic{//영화광
	int pocketMoney;//용돈
	MovieHolic(int pocketMoney){
		this.pocketMoney = pocketMoney;
	}
	void buyTicket(LoveLetterTicket llt) {
		pocketMoney = pocketMoney - llt.price;
	}
	void buyTicket(ShallWeDanceTicket swdt) {
		pocketMoney = pocketMoney - swdt.price;
	}
}

class JavaCinema{
	JavaCinema(){
		llt = new LoveLetterTicket[5];
		for(int i = 0; i < llt.length; i++) {
			llt[i] = new LoveLetterTicket();
		}
		swdt = new ShallWeDanceTicket[10];
		for(int j = 0; j < swdt.length; j++) {
			swdt[j] = new ShallWeDanceTicket();
		}
	}
	LoveLetterTicket[] llt;
	ShallWeDanceTicket[] swdt;
}

class LoveLetterTicket{
	LoveLetterTicket(){
		price = 10000;
	}
	int price;
}

class ShallWeDanceTicket{
	ShallWeDanceTicket(){
		price = 12000;
	}
	int price;
}

public class Review02 {//메서드 오버로딩 개념 복습
	
	public static void main(String[] args) {
		MovieHolic mh = new MovieHolic(50000);//오만원 소유 영화광
		JavaCinema jc = new JavaCinema();//자바영화관
		mh.buyTicket(jc.llt[0]);//러브레터 티켓 중 첫번째 티켓 구매
		mh.buyTicket(jc.swdt[0]);//쉘위댄스 티켓 중 첫번째 티켓 구매
		System.out.println("용돈 잔액 = "+mh.pocketMoney+"원");
	}

}
