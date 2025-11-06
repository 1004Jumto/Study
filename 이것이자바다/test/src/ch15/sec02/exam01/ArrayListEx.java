package ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ArrayListEx {

	public static void main(String[] args) {

//		List<Board> list = new ArrayList<>();
		List<Board> list = new Vector<>();
		
		// 객체 추가
		list.add(new Board("title1", "content1", "author1"));
		list.add(new Board("title2", "content2", "author2"));
		list.add(new Board("title3", "content3", "author3"));
		list.add(new Board("title4", "content4", "author4"));
		list.add(new Board("title5", "content5", "author5"));
		
		// 객체 수
		System.out.println("list.size = " + list.size());
		
		// 특정 인덱스 저장된 값 
		Board b = list.get(2);
		System.out.println("list[2] = " + b.getSubject() + " " + b.getContent() + " " + b.getWriter());
		
		// 특정 인덱스 저장된 값 삭제
		list.remove(0);
		list.remove(3);
		
		// 모든 객체 가져오기
		System.out.println(list);
		for(Board bd : list) {
			System.out.println(bd.getSubject());
		
		}
	}

}
