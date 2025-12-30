package chapter07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDao;

	@Override
	public List<StudentVO> all(StudentVO vo) {
		// 비즈니스 로직
		List<StudentVO> list = studentDao.all(vo);
		return list;
	}

	@Override
	public StudentVO view(int studno) {
		return studentDao.view(studno);
	}

}
