package org.chaeeun.april05;

//자바 백화점이 있습니다. 이 백화점에 가전매장과 의류매장이 있습니다.
//가전매장에는 TV와 냉장고가 있습니다. TV와 냉장고의 가격은 난수로 합니다.
//의류매장에는 청바지와 T셔츠가 있습니다. 청바지와 T셔츠의 가격은 난수로 합니다.
//백화점의 각 매장안에 있는 상품의 가격을 출력합니다.

class JavaDepartmentStore{
	JavaDepartmentStore(){
		elec = new ElectronicStore();
		clothes = new ClothesStore();
	}
	ElectronicStore elec;
	ClothesStore clothes;
	void printPrice() {
		
	}
}

class ElectronicStore{
	ElectronicStore(){
		tv = new TV();
		refri = new Refrigerator();
	}
	TV tv;
	Refrigerator refri;
}

class TV{
	TV(){
		price = (int)((Math.random()*101)+100);//100부터 200까지의 난수
	}
	int price;
}

class Refrigerator{
	Refrigerator(){
		price = (int)((Math.random()*101)+100);
	}
	int price;
}

class ClothesStore{
	ClothesStore(){
		jeans = new Jeans();
		tshirt = new Tshirt();
	}
	Jeans jeans;
	Tshirt tshirt;
}

class Jeans{
	Jeans(){
		price = (int)((Math.random()*101)+100);
	}
	int price;
}

class Tshirt{
	Tshirt(){
		price = (int)((Math.random()*101)+100);
	}
	int price;
}

public class Study04 {

	public static void main(String[] args) {
		JavaDepartmentStore java = new JavaDepartmentStore();
		System.out.println("가전매장의 TV의 가격 : "+java.elec.tv.price+"원");
		System.out.println("가전매장의 냉장고의 가격 : "+java.elec.refri.price+"원");
		System.out.println("의류매장의 청바지의 가격 : "+java.clothes.jeans.price+"원");
		System.out.println("의류매장의 티셔츠의 가격 : "+java.clothes.tshirt.price+"원");
	}

}
