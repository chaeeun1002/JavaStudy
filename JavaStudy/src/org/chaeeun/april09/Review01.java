package org.chaeeun.april09;

public class Review01 {//2차원 배열 개념 복습

	public static void main(String[] args) {
		int[][] values = new int[3][4];//3행 4열의 배열
		values[0][0] = 1;//values배열의 1행1열에 1저장
		values[0][1] = 2;//values배열의 1행2열에 2저장
		
		//초기값을 갖는 배열
		int[][] score = {{90,85,100},{95,90,80}};//2행 3열의 int값을 갖는 배열
		
		String[][] dongs = {{"강북1구","강북2구","강북3구"},{"강남1구","강남2구","강남3구"}};//2행 3열의 문자열을 갖는 배열
		
		//1차원 배열의 길이 : 열의 갯수 -> 배열의 변수이름.length
		String[] gus = {"강서구","강북구","강동구","서대문구"};
		System.out.println(gus.length);
		
		//2차원 배열의 길이 : 행의 갯수, 열의 갯수
		//2차원 배열의 길이 : 배열의 변수이름.length -> 행의 갯수
		//dongs.length -> 행의 갯수
		System.out.println(dongs.length);//행의 갯수
		System.out.println(dongs[0].length);//1행의 열의 갯수
		System.out.println(dongs[1].length);//2행의 열의 갯수
	}

}
