package org.chaeeun.april08;

public class Study02 {

	public static void main(String[] args) {
		int[] datas = new int[3];//1차원 배열
		datas[0] = 1; datas[1] = 2; datas[2] = 3;
		System.out.println(datas.length);//datas배열의 길이
		
		String[] strs = new String[5];//1차원 배열
		strs[0] = "대한민국"; strs[1] = "우리나라"; strs[2] = "KOREA";
		strs[3] = "KOR"; strs[4] = "korea";
		System.out.println(strs.length);//strs배열의 길이
		
		int[][] values = new int[3][4];//3행 4열의 2차원 배열
		values[0][0] = 1; //1행 1열에 1을 저장
		values[0][1] = 2; //1행 2열에 2를 저장
		System.out.println(values.length); // 3 : 행의 길이
		System.out.println(values[0].length);// 4 : 0행의 열의 길이
		
		String[][] strings = new String[5][3];//5행 3열의 2차원 배열
		strings[0][0] = "KOREA"; //1행 1열에 KOREA를 저장
		System.out.println(strings.length);// 5 : 행의 길이
	}

}
