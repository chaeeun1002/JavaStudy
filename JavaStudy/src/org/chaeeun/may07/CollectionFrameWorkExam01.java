package org.chaeeun.may07;

import java.util.HashSet;
import java.util.Iterator;

public class CollectionFrameWorkExam01 {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		for(int i = 0; hs.size() < 25; i++) {
			int ran = ((int)(Math.random()*50))+1;
			hs.add(ran);
		}
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					System.out.print(it.next()+" ");
				}
				System.out.println();
			}
		}
	}

}
