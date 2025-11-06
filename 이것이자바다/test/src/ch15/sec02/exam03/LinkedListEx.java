package ch15.sec02.exam03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		List<String> link = new LinkedList<>();

		// 시작과 끝 시간 저장
		long startT, endT;

		startT = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			arr.add(0, String.valueOf(i));
		endT = System.nanoTime();
		System.out.println("Arraylist: " + (endT - startT) + "ns");

		startT = System.nanoTime();
		for (int i = 0; i < 10000; i++)
			link.add(0, String.valueOf(i));
		endT = System.nanoTime();
		System.out.println("Linkedlist: " + (endT - startT) + "ns");

	}

}
