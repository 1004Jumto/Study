package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Statement stmt;
	private Connection con;
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String user = "testuser";
	private String pwd = "test1234";
	
	private void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			connDB();
			String query = "SELECT * FROM t_member";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setEmail(email);
				vo.setName(name);
				vo.setPwd(pwd);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
}
