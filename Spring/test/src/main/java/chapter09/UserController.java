package chapter09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 모든 필드에 자동 주입, 파라미터 받는 생성자
public class UserController {

	// autoWired 쓰는 대신에 RequiredArgsContructor을 많이 사용함
	private final UserService userService;

	@GetMapping("/user/insert")
	public String insert() {
		return "user/insert";
	}

	@PostMapping("/user/insert")
	public String insert(UserVO vo, 
			@RequestParam("profile") MultipartFile profile,
			HttpServletRequest req,
			HttpServletResponse res,
			Model model,
			RedirectAttributes ra) {
		System.out.println("UserVO: " + vo);

		int ret = userService.insert(vo, profile);

		if(ret > 0) {
//			model.addAttribute("msg", "회원가입되었습니다");
//			model.addAttribute("cmd", "move");
//			model.addAttribute("url", "insert");
			ra.addFlashAttribute("msg", "회원가입되었습니다");
			ra.addFlashAttribute("success", "insert");
		}else {
//			model.addAttribute("msg", "회원가입 오류");
//			model.addAttribute("cmd", "back");
			ra.addFlashAttribute("msg", "회원가입 오류");
			ra.addFlashAttribute("fail", "back");
		}
		
		return "redirect:insert"; // 일단 지금은 등록페이지로 리다이렉트
	}
}
