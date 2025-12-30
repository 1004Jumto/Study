package chapter08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public List<StudentVO> all(StudentVO vo) {
		// 비즈니스 로직
		List<StudentVO> list = studentMapper.all(vo);
		return list;
	}

	@Override
	public StudentVO view(int studno) {
		return studentMapper.view(studno);
	}

}
