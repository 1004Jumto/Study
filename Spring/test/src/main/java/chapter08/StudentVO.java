package chapter08;

import lombok.Data;

@Data
public class StudentVO {
	private int studno;
	private String name;
	private String id;
	private int grade;
	private String jumin;
	private String birthday;
	private String tel;
	private int height;
	private int weight;
	private int major1;
	private int major2;
	private int profno;
	private String major_name;
	
	private String searchType;
	private String searchWord;
	private int searchGrade;
	private int[] searchMajor;
}
