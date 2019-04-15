package org.chaeeun.april03;

import java.util.Scanner;

//1~100까지의 숫자 중에 컴퓨터가 가지고 있는 숫자를 맞추는 게임
//지금까지 입력한 숫자를 보여줌
//기회는 6번

class LuckyNumber{
	Scanner scan = new Scanner(System.in);
	int lucky;//행운의 숫자용 변수
	int[] usedNumbers;//입력한 숫자용 배열
	LuckyNumber(){
		lucky = (int)((Math.random()*100)+1);//1부터 100까지의 난수
		usedNumbers = new int[6];
	}
	void play() {
		System.out.println("행운의 번호를 맞추세요.");
		System.out.println("기회는 6번 입니다.");
		int count = 1;//시도한 횟수용 변수
		do {
			System.out.println(count+"번째 시도입니다.");
			System.out.println("1부터 100중에서 숫자를 입력하세요.");
			int input = scan.nextInt();//입력한 숫자를 보관
			usedNumbers[count-1] = input;//입력한 숫자를 배열에 보관
			if(input == lucky) {
				System.out.println("축하합니다."+count+"번째에"+" 승리하셨습니다.");
				break;//반복 종료
			}else {
				if(lucky > input) {//입력한 수가 행운의 수보다 작은 경우
					System.out.println("행운의 숫자는 입력한 값보다 큽니다.");
				}else {//입력한 수가 행운의 수보다 큰 경우
					System.out.println("행운의 숫자는 입력한 값보다 작습니다.");
				}
				System.out.println("**지금까지 입력한 수**");
				for(int i = 0; i < count; i++) {
					System.out.print(usedNumbers[i]+" ");
				}
				System.out.println();
				System.out.println("**********************");
			}
			if(count == 6) {
				System.out.println("횟수가 초과되었습니다.");
				break;//반복 종료
			}
			count++;//횟수 증가
		}while(true);//무한 반복
	}
	void play2() {
		System.out.println("행운의 번호를 맞추세요.");
		System.out.println("기회는 6번입니다.");
		for(int count = 0; count < 6; count++) {
			if(count < 6) {
				System.out.println((count+1)+"번째 시도입니다.");
				System.out.println("1부터 100중에서 숫자를 입력하세요.");
				int input = scan.nextInt();
				usedNumbers[count] = input;
				if(input == lucky) {
					System.out.println("축하합니다. "+(count+1)+"번째에 승리하셨습니다.");
					break;
				}else {
					if(lucky > input) {
						System.out.println("행운의 숫자는 입력한 값보다 큽니다.");
					}else {
						System.out.println("행운의 숫자는 입력한 값보다 작습니다.");
					}
					System.out.println("**지금까지 입력한 수**");
					for(int i = 0; i < count; i++) {
						System.out.print(usedNumbers[i]+" ");
					}
					System.out.println();
					System.out.println("**********************");
				}
			}
		}
		System.out.println("횟수가 초과되었습니다.");
	}
}

public class ScannerStudy04 {

	public static void main(String[] args) {
		LuckyNumber game = new LuckyNumber();
		game.play2();
	}

}
