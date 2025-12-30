package chapter08;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
	List<StudentVO> all(StudentVO vo); // id가 all
	StudentVO view(int studno);
}
