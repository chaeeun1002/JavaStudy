package org.chaeeun.april02;

//빠징코 게임에 ★을 추가하고, 모양이 ◆와 ★인 경우 빙고가 되도록 수정합니다.
//(현재 네가지 모양이 일치하면 빙고, 모양이 ◆이거나 ★이면 빙고가 되도록 수정) 

class PazingkoExam01{
	PazingkoExam01(){}
	String[] shapes = {"◆","♠","♥","♣","★"};
	void rolling() {
		int rnd1 = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		int rnd2 = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		int rnd3 = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		int rnd4 = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		int rnd5 = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		System.out.println(shapes[rnd1]+","+shapes[rnd2]+","+shapes[rnd3]+","+shapes[rnd4]+","+shapes[rnd5]);
		if(((rnd1 == 0)||(rnd1 == 4))&&((rnd2 == 0)||(rnd2 == 4))&&((rnd3 == 0)||(rnd3 == 4))
		 &&((rnd4 == 0)||(rnd4 == 4))&&((rnd5 == 0)||(rnd5 == 4))) {
			System.out.println("빙고");
		}else{
			System.out.println("다음 기회에");
		}
	}
}

class PazingkoExam02{//Teacher
	PazingkoExam02(){}
	String[] shapes = {"◆","♠","♥","♣","★"};
	int[] nums = new int[5];
	boolean[] bingo = new boolean[5];
	void rolling() {
		nums[0] = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		nums[1] = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		nums[2] = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		nums[3] = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		nums[4] = (int)((Math.random()*5)+0);//0부터 4까지의 난수
		System.out.println(shapes[nums[0]]+","+shapes[nums[1]]+","+shapes[nums[2]]+","+shapes[nums[3]]+","+shapes[nums[4]]);
		for(int i = 0; i < 5; i++) {
			if(nums[i] == 0 || nums[i] == 4) {
				bingo[i] = true;
			}
		}
		if((bingo[0] == true)&&(bingo[1] == true)&&(bingo[2] == true)&&(bingo[3] == true)&&(bingo[4] == true)) {
			System.out.println("빙고");
		}else {
			System.out.println("다음 기회에");
		}
	}
}

public class ArrayExem01 {

	public static void main(String[] args) {
		PazingkoExam01 pazingko1 = new PazingkoExam01();
		PazingkoExam02 pazingko2 = new PazingkoExam02();
 		pazingko1.rolling();
 		pazingko2.rolling();
	}

}
