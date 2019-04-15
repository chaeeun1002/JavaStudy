package org.chaeeun.april10;

class Hana {
	int i;
	int j;
	double k;

	Hana(int i, int j) {
		this.i = i;
		this.j = j;
	}

	Hana(double k) {
		this.k = k;
	}
}

class Dool extends Hana {
	Dool(int i, int j){
		super(i,j);
	}
	Dool(double k){
		super(k);
	}
}

class Set extends Dool {
	Set(int i, int j){
		super(i,j);
	}
	Set(double k){
		super(k);
	}
}

public class HanaDoolSet {

	public static void main(String[] args) {
		Set set = new Set(4,5);
		Set set2 = new Set(3.14);
	}

}
