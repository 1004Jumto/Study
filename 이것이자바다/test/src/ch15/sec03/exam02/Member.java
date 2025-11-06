package ch15.sec03.exam02;

import lombok.Data;

@Data
public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.age = age;
		this.name = name;
	}
}
