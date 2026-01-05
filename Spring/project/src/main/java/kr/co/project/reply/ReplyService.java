package kr.co.project.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface ReplyService {
	int insert(ReplyVO vo, MultipartFile file, HttpServletRequest request);
	int reply(ReplyVO vo, MultipartFile file, HttpServletRequest request);
	int update(ReplyVO vo, MultipartFile file, HttpServletRequest request);
	int delete(ReplyVO vo, HttpServletRequest request);
	Map<String, Object> list(ReplyVO vo);
	ReplyVO detail(ReplyVO vo, boolean isUpdate);
}
