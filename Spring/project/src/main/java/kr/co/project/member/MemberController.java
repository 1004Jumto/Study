package kr.co.project.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	// 로그인 페이지
	@GetMapping("/member/login")
	public void login() {
		
	}
	
	// 로그인 처리
	@PostMapping("/member/login")
	public String login(HttpSession session, MemberVO vo, Model model) {
		String retPage = ""; 
		MemberVO memberVO = memberService.login(vo);
		if(memberVO == null) {
			model.addAttribute("msg", "아이디 혹은 비밀번호가 올바르지 않습니다");
			model.addAttribute("cmd", "back");
			
			retPage = "common/return";
		} else {
			session.setAttribute("loginSess", memberVO);

			retPage = "redirect:/reply/index.do";
		}
		
		return retPage;
	}
	
	// 회원가입 페이지
	@GetMapping("/member/join")
	public void join() {
		
	}
	
	// 회원가입 처리
	@PostMapping("/member/join")
	public String join(MemberVO vo, Model model) {
		boolean ret = memberService.join(vo);
		String retPage = "common/return";
		
		if(ret) {
			// 성공
			model.addAttribute("msg", "회원가입되었습니다");
			model.addAttribute("cmd", "move");
			model.addAttribute("url", "/project/member/login");
		} else {
			// 실패
			model.addAttribute("msg", "오류가 발생했습니다");
			model.addAttribute("cmd", "back");
		}
		
		return retPage;
	}
	
	// 이메일 체크
	@GetMapping("/member/emailCheck")
	@ResponseBody
	public int emailCheck(@RequestParam String email) {
		int ret = memberService.checkEmail(email);
		
		return ret;
	}
}
