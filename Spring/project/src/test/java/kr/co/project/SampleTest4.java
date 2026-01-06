package kr.co.project;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import kr.co.project.member.MemberVO;
import kr.co.project.reply.ReplyMapper;
import kr.co.project.reply.ReplyService;
import kr.co.project.reply.ReplyVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {config.MvcConfig.class})
@WebAppConfiguration
public class SampleTest4 {

	@Autowired
	ReplyMapper mapper;
	
	@Test
	@DisplayName("게시판 목록 조회 테스트")
	public void list() {
		List<ReplyVO> list = mapper.list(new ReplyVO());
		list.stream().forEach(v -> System.out.println(v));
	}
	
	@Autowired
	ReplyService service;
	
	@Test
	@DisplayName("페이지네이션 테스트")
	public void listService() {
		Map<String, Object> map = service.list(new ReplyVO());
		System.out.println(map);
	}
	
	@Test
	@DisplayName("회원가입 테스트")
	@Transactional
	public void regist() {
		MemberVO vo = new MemberVO();
		vo.setEmail("test5@gmail.com");
		vo.setPwd("1234");
	}
}