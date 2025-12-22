package chapter07;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	
	@Autowired	// 타입 확인 후 같은 컨테이너 내에 있는 동일한 타입 객체 주입
	private SqlSessionTemplate sst;
	
	
}
