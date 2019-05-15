package chaeeun;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

//1단계. 상품설계 : 청바지, 시계, 운동화
//2단계. 추상화 : 공통점을 찾아 공통의 조상으로 설계.

class Item{
	int price;
	String maker;
}

class SportShoes extends Item{
	SportShoes(int price, String maker){
		this.price = price;
		this.maker = maker;
	}
}

class Watch extends Item{
	Watch(int price, String maker){
		this.price = price;
		this.maker = maker;
	}
}

class Jean extends Item{
	Jean(int price, String maker){
		this.price = price;
		this.maker = maker;
	}
}

public class ListStudy01 {

	public static void main(String[] args) {
		LinkedList<Item> cart = new LinkedList<Item>();
		//<> : Generic(형식매개변수), List에 한정된 데이터만을 넣고자 할 때에, <>안에 해당하는 데이터의 타입 및 객체이름을 지정한다.
		SportShoes ss1 = new SportShoes(80000,"나이키");
		SportShoes ss2 = new SportShoes(50000,"아디다스");
		Watch w1 = new Watch(100000,"스와치");
		Watch w2 = new Watch(150000,"세이코");
		cart.add(ss1);
		cart.add(w1);
		
//		int numberOfItems = cart.size();//컬렉션프레임워크에 저장된 데이터 갯수
//		int total = 0;
//		for(int i = 0; i < numberOfItems; i++) {
//			total = total + cart.get(i).price;
//			//get 메서드의 문제 --> 하나의 데이터를 찾기위해 처음부터 순차적으로 검색을 해서 찾음.
//			//					--> 데이터의 수가 많아질수록 효율이 떨어짐(속도저하) == Iterator 사용.
//		}
//		System.out.println("장바구니의 상품 가격 총 합 : "+total);
		
		//Iterator
		Iterator it = cart.iterator();
		int total = 0;
		int numOfShoes = 0;//장바구니에 담긴 운동화 갯수
		int numOfWatch = 0;//장바구니에 담긴 시계 갯수
		int numOfJean = 0;//장바구니에 담긴 청바지 갯수
		while(it.hasNext()) {
			Item something = (Item)it.next();
			total = total + something.price;
			if(something instanceof SportShoes) {//something에 있는 물건이 운동화인지 판별
				numOfShoes = numOfShoes + 1;
			}else if(something instanceof Watch) {//something에 있는 물건이 시계인지 판별
				numOfWatch = numOfWatch + 1;
			}else {//something에 있는 물건이 청바지인지 판별
				numOfJean++;
			}
		}
		System.out.println("장바구니의 운동화의 갯수 : "+numOfShoes);
		System.out.println("장바구니의 시계의 갯수 : "+numOfWatch);
		System.out.println("장바구니의 청바지의 갯수 : "+numOfJean);
		System.out.println("장바구니의 상품 가격 총 합 : "+total);
		
		
		//////////////////////////set/////////////////////////////
		HashSet cart2 = new HashSet();
		cart2.add(ss1);
		cart2.add(ss1);
		System.out.println("Set이 저장한 아이템 갯수 : "+cart2.size());
	}

}
