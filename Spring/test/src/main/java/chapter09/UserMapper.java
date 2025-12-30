package chapter09;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int insert(UserVO vo);
	int insertHobby(Map map);
}
