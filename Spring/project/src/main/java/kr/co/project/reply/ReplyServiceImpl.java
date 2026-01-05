package kr.co.project.reply;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public int insert(ReplyVO vo, MultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			// 파일명
			String org = file.getOriginalFilename();
			String ext = org.substring(org.lastIndexOf("."));
			String real = System.currentTimeMillis()+ext;
			// 파일저장
			String path = request.getRealPath("/upload/board/")+real;
			try {
				file.transferTo(new File(path));
			} catch (Exception e) {}
			vo.setFilename_org(org);
			vo.setFilename_real(real);
		}
		int r = mapper.insert(vo);
		if (r > 0) mapper.updateGno(vo.getNo());
		return r;
	}
	
	@Override
	public int update(ReplyVO vo, MultipartFile file, HttpServletRequest request) {
		if ("ok".equals(request.getParameter("fileDelete"))) {
			ReplyVO data = mapper.detail(vo);
			mapper.fileDelete(vo.getNo());
			File f = new File(request.getRealPath("/upload/board/")+data.getFilename_real());
			f.delete();
		}
		if (!file.isEmpty()) {
			// 파일명
			String org = file.getOriginalFilename();
			String ext = org.substring(org.lastIndexOf("."));
			String real = System.currentTimeMillis()+ext;
			// 파일저장
			String path = request.getRealPath("/upload/board/")+real;
			try {
				file.transferTo(new File(path));
			} catch (Exception e) {}
			vo.setFilename_org(org);
			vo.setFilename_real(real);
		}
		int r = mapper.update(vo);
		return r;
	}

	@Override
	public int delete(ReplyVO vo, HttpServletRequest request) {
		ReplyVO data = mapper.detail(vo);
		if (data.getFilename_real() != null && !"".equals(data.getFilename_real())) {
			File f = new File(request.getRealPath("/upload/board/")+data.getFilename_real());
			f.delete();
		}
		return mapper.delete(vo.getNo());
	}
	
	@Override
	public int reply(ReplyVO vo, MultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			// 파일명
			String org = file.getOriginalFilename();
			String ext = org.substring(org.lastIndexOf("."));
			String real = System.currentTimeMillis()+ext;
			// 파일저장
			String path = request.getRealPath("/upload/board/")+real;
			try {
				file.transferTo(new File(path));
			} catch (Exception e) {}
			vo.setFilename_org(org);
			vo.setFilename_real(real);
		}
		mapper.updateOno(vo);
		vo.setOno(vo.getOno()+1);
		vo.setNested(vo.getNested()+1);
		int r = mapper.insert(vo);
		return r;
	}

	@Override
	public Map<String, Object> list(ReplyVO param) {
		System.out.println("list 메서드 실행");
		int count = mapper.count(param); // 총개수
        // 총페이지수
        int totalPage = count / 10;
        if (count % 10 > 0) totalPage++;
        List<ReplyVO> list = mapper.list(param); // 목록
        
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        map.put("totalPage", totalPage);
        map.put("list", list);
        
        // 하단에 페이징처리
        int endPage = (int)(Math.ceil(param.getPage()/10.0)*10);
        int startPage = endPage - 9;
        if (endPage > totalPage) endPage = totalPage;
        boolean isPrev = startPage > 1;
        boolean isNext = endPage < totalPage;
        map.put("endPage", endPage);
        map.put("startPage", startPage);
        map.put("isPrev", isPrev);
		map.put("isNext", isNext);
		return map;
	}

	@Override
	public ReplyVO detail(ReplyVO vo, boolean isUpdate) {
		if (isUpdate) {
			mapper.increaseReadcnt(vo.getNo());
		}
		ReplyVO data = mapper.detail(vo);
		return data;
	}

}
