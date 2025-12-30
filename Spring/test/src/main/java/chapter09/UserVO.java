package chapter09;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserVO {
	private int userno;
	private String id;
	private String password;
	private int gender;
	private int age;
	private String birth;
	private String profile_org;
	private String profile_real;
	private String introduce;
	private int local;
	private Timestamp registdate;	
	private String[] hobby;
}
