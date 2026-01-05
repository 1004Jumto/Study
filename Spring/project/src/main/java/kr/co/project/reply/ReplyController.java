package kr.co.project.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.project.member.MemberVO;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService service;

	@GetMapping("/reply/index.do")
	public String index(Model model, ReplyVO vo) {
		model.addAttribute("map", service.list(vo));
		return "reply/index";
	}

	@GetMapping("/reply/write.do")
	public String write() {
		return "reply/write";
	}

	@PostMapping("/reply/insert.do")
	public String insert(Model model, HttpServletRequest request, ReplyVO vo, MultipartFile file) {
		HttpSession sess = request.getSession();
		MemberVO login = (MemberVO) sess.getAttribute("loginSess");
		vo.setWriter(login.getNo());
		int r = service.insert(vo, file, request);
		if (r > 0) {
			model.addAttribute("cmd", "move");
			model.addAttribute("msg", "정상적으로 저장되었습니다.");
			model.addAttribute("url", "index.do");
		} else {
			model.addAttribute("cmd", "back");
			model.addAttribute("msg", "등록 오류");
		}
		return "common/return";
	}

	@GetMapping("/reply/view.do")
	public String view(Model model, ReplyVO vo) {
		model.addAttribute("vo", service.detail(vo, true));
		return "reply/view";
	}

	@GetMapping("/reply/edit.do")
	public String edit(Model model, ReplyVO vo) {
		model.addAttribute("vo", service.detail(vo, false));
		return "reply/edit";
	}

	@PostMapping("/reply/update.do")
	public String update(Model model, HttpServletRequest request, ReplyVO vo, MultipartFile file) {
		int r = service.update(vo, file, request);
		if (r > 0) {
			model.addAttribute("cmd", "move");
			model.addAttribute("msg", "정상적으로 수정되었습니다.");
			model.addAttribute("url", "index.do");
		} else {
			model.addAttribute("cmd", "back");
			model.addAttribute("msg", "등록 오류");
		}
		return "common/return";
	}

	@GetMapping("/reply/reply.do")
	public String reply(Model model, ReplyVO vo) {
		model.addAttribute("vo", service.detail(vo, false));
		return "reply/reply";
	}

	@PostMapping("/reply/reply.do")
	public String replyProcess(Model model, HttpServletRequest request, ReplyVO vo, MultipartFile file) {
		HttpSession sess = request.getSession();
		MemberVO login = (MemberVO) sess.getAttribute("loginSess");
		vo.setWriter(login.getNo());
		int r = service.reply(vo, file, request);
		if (r > 0) {
			model.addAttribute("cmd", "move");
			model.addAttribute("msg", "정상적으로 등록되었습니다.");
			model.addAttribute("url", "index.do");
		} else {
			model.addAttribute("cmd", "back");
			model.addAttribute("msg", "등록 오류");
		}
		return "common/return";
	}

	@GetMapping("/reply/delete.do")
	public String delete(Model model, HttpServletRequest request, ReplyVO vo, MultipartFile file) {
		int r = service.delete(vo, request);
		if (r > 0) {
			model.addAttribute("cmd", "move");
			model.addAttribute("msg", "정상적으로 삭제되었습니다.");
			model.addAttribute("url", "index.do");
		} else {
			model.addAttribute("cmd", "back");
			model.addAttribute("msg", "등록 오류");
		}
		return "common/return";
	}
}
