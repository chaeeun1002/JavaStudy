package org.chaeeun.april08;

class Bus{
	int maxPersons;//버스의 정원, 속성변수 (instance veriable)
	//this 제어자 : 지역변수 이름과 속성변수 이름이 동일한 경우  
	//속성변수를 지칭하고자 할 때, 속성변수 앞에 this를 붙인다.
	//의미 : 현재의 instance를 지칭
	Bus(int maxPersons){//생성자를 통해서 버스의 정원을 설정
		this.maxPersons = maxPersons;
	}
	int total;
	void doIt() {
		int total = 100;
		this.total = total + 50;
	}
}

public class Study03 {

}
