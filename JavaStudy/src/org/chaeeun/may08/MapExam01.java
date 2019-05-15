package org.chaeeun.may08;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam01 {

	public static void main(String[] args) {
		HashMap<String,Double> student = new HashMap<String,Double>();
		student.put("이동욱", 170.1);
		student.put("김치곤", 178.6);
		student.put("김형욱", 180.3);
		student.put("오미경", 160.8);
		student.put("심정연", 158.7);
		
		Set stdSet = student.entrySet();
		Iterator itNameandHeight = stdSet.iterator();
		
		while(itNameandHeight.hasNext()) {
			Map.Entry key = (Map.Entry) itNameandHeight.next();
			System.out.println("이름 : " + key.getKey() + ", 신장 : " + key.getValue());
		}
		
		Collection name = student.keySet();
		Iterator itName = name.iterator();
		
		System.out.print("학생 명단 :");
		while(itName.hasNext()) {
			System.out.print(itName.next()+" ");
		}
		
		System.out.println();
		
		Collection height = student.values();
		Iterator itHeight = height.iterator();
		
		double sumHeight = 0;
		double avgHeight = 0;
		
		while(itHeight.hasNext()) {
			sumHeight = sumHeight + (double)itHeight.next();
		}
		System.out.println("신장의 합 : "+sumHeight);
		avgHeight = sumHeight / 5;
		System.out.println("평균 신장 : "+avgHeight);
	}

}
