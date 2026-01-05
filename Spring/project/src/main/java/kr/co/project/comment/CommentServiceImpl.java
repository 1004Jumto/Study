package kr.co.project.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper mapper;
	
	@Override
	public Map index(CommentVO vo) {
		int totalCount = mapper.count(vo); // 총 게시물 수
		// 총 페이지 수
		int totalPage = totalCount / 10;
		if (totalCount % 10 > 0) totalPage++;
		
		// 시작인덱스
		int startIdx = (vo.getPage() - 1) * 10;
		vo.setStartIdx(startIdx); // sql문에 파라미터로 넣어줌
		List<CommentVO> list = mapper.list(vo); // 목록
		
		// 페이징처리
		int endPage = (int)(Math.ceil(vo.getPage()/10.0) * 10); // 끝페이지
		int startPage = endPage - 9; // 시작페이지
		
		if (endPage > totalPage) endPage = totalPage;
		boolean prev = startPage > 1 ? true : false;
		boolean next = endPage < totalPage ? true : false;
				
		Map map = new HashMap();
		map.put("totalCount", totalCount);
		map.put("totalPage", totalPage);
		map.put("list", list); // 모델에 직접 넣어줘도 됨
		
		map.put("endPage", endPage);
		map.put("startPage", startPage);
		map.put("prev", prev);
		map.put("next", next );
		
		return map;

	}

	@Override
	public int insert(CommentVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public int delete(CommentVO vo) {
		return mapper.delete(vo.getNo());
	}

	@Override
	public List<CommentVO> all(CommentVO vo) {
		return mapper.all(vo);
	}

}
