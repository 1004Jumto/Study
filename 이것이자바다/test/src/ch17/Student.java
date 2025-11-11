package ch17;

import lombok.Data;

@Data
public class Student {
	private int num;
	private String name;
	
	
	public Student(int num, String name) {
		this.name = name;
		this.num = num;		
	}
}
