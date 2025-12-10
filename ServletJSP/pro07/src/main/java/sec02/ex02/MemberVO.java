package sec02.ex02;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	
}
