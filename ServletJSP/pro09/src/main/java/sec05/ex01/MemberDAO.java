package sec05.ex01;

import java.sql.Connection;
import java.sql.Date; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	 
	public MemberDAO() {
		
		try 
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
//			connDB();
			con = dataFactory.getConnection();
			
			String query = "SELECT * FROM t_member";
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
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
		
			pstmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addMember(MemberVO vo) {
		try {
			con = dataFactory.getConnection();
			
			String query = "INSERT INTO t_member";
			query += "(id, pwd, name, email)";
			query += " VALUES(?, ?, ?, ?)";
					
			pstmt = con.prepareStatement(query);

			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			
			String query = "DELETE FROM t_member WHERE id=?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close(); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO vo) {
		boolean result = false;
		
		String id = vo.getId();
		String pwd = vo.getPwd();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "SELECT DECODE(count(*), 1, 'true', 'false') as result "
							+ "FROM t_member "
							+ "WHERE id=? and pwd=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result=" + result);
							
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
