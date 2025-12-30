package chapter07;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

	@Autowired 
	private SqlSessionTemplate sst;
	
	// 목록조회
	public List<StudentVO> all(StudentVO vo) {
		return sst.selectList("student.all", vo);
	}
	
	// 한건조회
	public StudentVO view(int studno) {
		return sst.selectOne("student.view", studno);
	}
	
	public Map view2(Map map) {
		return sst.selectOne("student.view2", map);
	}
}
