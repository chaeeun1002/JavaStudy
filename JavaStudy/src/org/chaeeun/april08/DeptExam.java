package org.chaeeun.april08;

//자바 백화점이 있습니다. 이 백화점에 가전매장과 의류매장이 있습니다.
//가전매장에는 TV와 냉장고가 있습니다. TV와 냉장고의 가격은 난수로 합니다.
//의류매장에는 청바지와 T셔츠가 있습니다. 청바지와 T셔츠의 가격은 난수로 합니다.
//백화점의 각 매장안에 있는 상품의 가격을 출력합니다.

//손님이 있습니다. 손님은 용돈이 있습니다.
//이 손님이 백화점의 가전매장안의 TV를 구매했습니다.
//이 손님이 백화점의 가전매장안의 냉장고를 구매했습니다.
//이 손님이 백화점의 의류매장안의 청바지를 구매했습니다.
//이 손님의 구매 총액을 출력합니다.
//(참고: this 제어자를 사용합니다.)

//가전매장에 점장이 있습니다. 의류 매장에 점장이 있습니다.
//가전매장의 점장이 가전매장의 매출액을 출력합니다.
//의류매장의 점장이 의류매장의 매출액을 출력합니다.

class JavaDepartmentStore{//백화점
	//백화점에 가전매장과 의류매장이 있다.
	JavaDepartmentStore(){
		elec = new ElectronicStore();
		clothes = new ClothesStore();
	}
	ElectronicStore elec;
	ClothesStore clothes;
}

class ElecManager{//가전매장 매니저
	ElecManager(){}
	int output;//매출액 변수
	void showOutput() {//가전매장의 매출액 출력
		System.out.println("가전매장의 매출액 : "+output+"만원");
	}
}

class ElectronicStore{//가전매장
	ElectronicStore(){
		tv = new TV();
		refri = new Refrigerator();
	}
	TV tv;
	Refrigerator refri;
	void showPrice() {
		System.out.println("TV의 가격 : "+tv.price+"만원");
		System.out.println("냉장고의 가격 : "+refri.price+"만원");
	}
}

class TV{
	TV(){
		price = (int)((Math.random()*201)+100);//100부터 200까지의 난수
	}
	int price;
}

class Refrigerator{
	Refrigerator(){
		price = (int)((Math.random()*301)+200);
	}
	int price;
}

class ClothesManager{//의류매장 매니저
	ClothesManager(){}
	int output;
	void showOutput() {
		System.out.println("의류매장의 매출액 : "+output+"만원");

	}
}

class ClothesStore{//의류매장
	ClothesStore(){
		jeans = new Jeans();
		tshirt = new Tshirt();
	}
	Jeans jeans;
	Tshirt tshirt;
	void showPrice() {
		System.out.println("청바지의 가격 : "+jeans.price+"만원");
		System.out.println("티셔츠의 가격 : "+tshirt.price+"만원");
	}
}

class Jeans{
	Jeans(){
		price = (int)((Math.random()*11)+10);
	}
	int price;
}

class Tshirt{
	Tshirt(){
		price = (int)((Math.random()*11)+10);
	}
	int price;
}

class Guest{//손님
	Guest(int money){
		money = this.money;
	}
	int money;
	int buyTotal;
	void buyTV(TV tv) {
		if(money >= tv.price) {
			money = money - tv.price;
			buyTotal = buyTotal + tv.price;
		}else {
			System.out.println("돈이 부족");
		}
	
	}
	void buyRefri(Refrigerator refri) {
		if(money >= refri.price) {
			money = money - refri.price;
			buyTotal = buyTotal + refri.price;
		}else {
			System.out.println("돈이 부족");
		}
	}
	void buyJean(Jeans jeans) {
		if(money >= jeans.price) {
			money = money - jeans.price;
			buyTotal = buyTotal + jeans.price;
		}else {
			System.out.println("돈이 부족");
		}
	}
	void showBuyTotal() {
		System.out.println("총 구매 금액 : " + buyTotal + "만원");
	}
}

public class DeptExam {

	public static void main(String[] args) {
		JavaDepartmentStore dept = new JavaDepartmentStore();
		//dept.elec --> 백화점 안의 가전매장
		//dept.clothes --> 백화점 안의 의류매장
		//dept.elec.refri --> 백화점 안의 가전매장 안의 냉장고
		//dept.clothes.tshirt --> 백화점 안의 의류매장 안의 티셔츠
		dept.clothes.showPrice();
		dept.elec.showPrice();
		Guest guest = new Guest(400);
		guest.buyTV(dept.elec.tv);
		guest.buyRefri(dept.elec.refri);
		guest.buyJean(dept.clothes.jeans);
		guest.showBuyTotal();
	}

}
