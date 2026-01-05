package kr.co.project.comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
	
	Map index(CommentVO vo);
	int insert(CommentVO vo);
	int delete(CommentVO vo);
	List<CommentVO> all(CommentVO vo);
}