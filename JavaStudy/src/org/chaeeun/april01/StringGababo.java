package org.chaeeun.april01;

//스즈끼가 가위,바위,보를 내밀었습니다.
//도레이가 가위,바위,보를 내밀었습니다.
//심판이 승패를 판단합니다.

class Suzuki{
	Suzuki(){}
	String result;
//	void doGababo() {
//		int rnd = (int)((Math.random()*3)+1);
//		if(rnd == 1) {
//			result = "가위";
//		}else if(rnd == 2) {
//			result = "바위";
//		}else {
//			result = "보";
//		}
//	}
	String returnGababo() {
		int rnd = (int)((Math.random()*3)+1);
		if(rnd == 1) {
			result = "가위";
		}else if(rnd == 2) {
			result = "바위";
		}else {
			result = "보";
		}
		return result;
	}
}

class Dorei{
	Dorei(){}
	String result;
//	void doGababo() {
//		int rnd = (int)((Math.random()*3)+1);
//		if(rnd == 1) {
//			result = "가위";
//		}else if(rnd == 2) {
//			result = "바위";
//		}else {
//			result = "보";
//		}
//	}
	String returnGababo() {
		int rnd = (int)((Math.random()*3)+1);
		if(rnd == 1) {
			result = "가위";
		}else if(rnd == 2) {
			result = "바위";
		}else {
			result = "보";
		}
		return result;
	}
}

class Simpan{
	Simpan(){}
	void Winner(String suzuki, String dorei) {
		if((suzuki.equals("가위")&&dorei.equals("바위"))||(suzuki.equals("바위")&&dorei.equals("보"))||
		   (suzuki.equals("보")&&dorei.equals("가위"))) {
			System.out.println("도레이의 승");
		}else if(suzuki.equals(dorei)) {
			System.out.println("무승부");
		}else {
			System.out.println("스즈키의 승");
		}
	}
}

public class StringGababo {

	public static void main(String[] args) {
		Suzuki suzuki = new Suzuki();
		Dorei dorei = new Dorei();
		Simpan simpan = new Simpan();
//		suzuki.doGababo();
//		dorei.doGababo();
		suzuki.returnGababo();
		dorei.returnGababo();
		simpan.Winner(suzuki.result, dorei.result);
	}

}
