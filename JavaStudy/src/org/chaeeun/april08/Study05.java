package org.chaeeun.april08;

//테란이 있다. 테란은 질럿과 저그, 또다른 테란을 공격할 수 있다.
//질럿이 있다. 질럿은 테란과 저그, 또다른 질럿을 공격할 수 있다.
//저그가 있다. 저그는 테란과 질럿, 또다른 저그를 공격할 수 있다.
//=======================도전과제===========================
//메딕을 설계합니다.
//메딕을 테런과 질럿과 저그를 치료할 수 있습니다.
//치료하면 에너지가 10씩 환원이 됩니다.(오버로딩 적용)

class Medic{
	Medic(){}
	void help(Teran teran) {
		teran.energy = teran.energy + 10;
	}
	void help(Zilet zilet) {
		zilet.energy = zilet.energy + 10;
	}
	void help(Zerg zerg) {
		zerg.energy = zerg.energy + 10;
	}
}

class Teran{
	int energy = 100;
	Teran(){}
	void attack(Zilet zilet) {//질럿을 공격
		zilet.energy = zilet.energy - 10;
	}
	void attack(Zerg zerg) {//저그를 공격
		zerg.energy = zerg.energy - 10;
	}
	void attack(Teran teran) {//테란을 공격
		teran.energy = teran.energy - 10;
	}
}

class Zilet{
	int energy = 100;
	Zilet(){}
	void attack(Zilet zilet) {//질럿을 공격
		zilet.energy = zilet.energy - 10;
	}
	void attack(Zerg zerg) {//저그를 공격
		zerg.energy = zerg.energy - 10;
	}
	void attack(Teran teran) {//테란을 공격
		teran.energy = teran.energy - 10;
	}
}

class Zerg{
	int energy = 100;
	Zerg(){}
	void attack(Zilet zilet) {//질럿을 공격
		zilet.energy = zilet.energy - 10;
	}
	void attack(Zerg zerg) {//저그를 공격
		zerg.energy = zerg.energy - 10;
	}
	void attack(Teran teran) {//테란을 공격
		teran.energy = teran.energy - 10;
	}
}

public class Study05 {

	public static void main(String[] args) {
		Teran teran = new Teran();
		Teran teran2 = new Teran();
		Zilet zilet = new Zilet();
		Zerg zerg = new Zerg();
		Medic medic = new Medic();
		teran.attack(teran2);
		teran.attack(zerg);
		teran.attack(zilet);
		medic.help(teran2);
		medic.help(zerg);
		medic.help(zilet);
	}

}
