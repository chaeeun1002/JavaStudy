package org.chaeeun.april01;

//이야기 생성 게임을 설계합니다.
//(예 : 홍길동이 길거리에서 노래를 불렀다.);

class MakingStory{
	MakingStory(){}
	String who,when,where,what,todo;
	//누가,언제,어디서,무엇을,했다
	String who() {
		String who1 = "정명준이";
		String who2 = "정종현이";
		String who3 = "홍기정이";
		String result = "";
		int rnd = (int)((Math.random()*3)+1);
		switch(rnd) {
		case 1: result = who1; break;
		case 2: result = who2; break;
		case 3: result = who3; break;
		}
		return result;
	}
	String when() {
		String when1 = " 어제";
		String when2 = " 지난주 일요일에";
		String when3 = " 오늘";
		String result = "";
		int rnd = (int)((Math.random()*3)+1);
		switch(rnd) {
		case 1: result = when1; break;
		case 2: result = when2; break;
		case 3: result = when3; break;
		}
		return result;
	}
	String where() {
		String where1 = " 길거리에서";
		String where2 = " 카페에서";
		String where3 = " 노래방에서";
		String result = "";
		int rnd = (int)((Math.random()*3)+1);
		switch(rnd) {
		case 1: result = where1; break;
		case 2: result = where2; break;
		case 3: result = where3; break;
		}
		return result;
	}
	String what() {
		String what1 = " 술을";
		String what2 = " 담배를";
		String what3 = " 행패를";
		String result = "";
		int rnd = (int)((Math.random()*3)+1);
		switch(rnd) {
		case 1: result = what1; break;
		case 2: result = what2; break;
		case 3: result = what3; break;
		}
		return result;
	}
	String todo() {
		String todo1 = " 마셨다.";
		String todo2 = " 피웠다.";
		String todo3 = " 부렸다.";
		String result = "";
		int rnd = (int)((Math.random()*3)+1);
		switch(rnd) {
		case 1: result = todo1; break;
		case 2: result = todo2; break;
		case 3: result = todo3; break;
		}
		return result;
	}
}

public class StoryGame {
	
	public static void main(String[] args) {
		MakingStory ms = new MakingStory();
		String who = ms.who();
		System.out.print(who);
		String when = ms.when();
		System.out.print(when);
		String where = ms.where();
		System.out.print(where);
		String what = ms.what();
		System.out.print(what);
		String todo = ms.todo();
		System.out.println(todo);
	}

}
