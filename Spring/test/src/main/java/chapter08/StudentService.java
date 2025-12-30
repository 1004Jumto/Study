package chapter08;

import java.util.List;

public interface StudentService {
	List<StudentVO> all(StudentVO vo);
	StudentVO view(int studno);
}
