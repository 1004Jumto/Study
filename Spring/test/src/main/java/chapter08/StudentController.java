package chapter08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/student/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/student/index")
	public String index(Model model, StudentVO param) {
		List<StudentVO> list = studentService.all(param);
		model.addAttribute("list", list);
		return "student/index";
	}
	
	@GetMapping("/student/view")
	public String view(@RequestParam int studno, Model model) {
		model.addAttribute("vo", studentService.view(studno));
		return "student/view";
	}
}
