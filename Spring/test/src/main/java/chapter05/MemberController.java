package chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	// url 매핑
	@GetMapping("/test.do")
	public String test() {
		System.out.println(getClass().getName());
		
		return "test";
 
	}
	
	@PostMapping("/test2.do")
	public void test2() {
		System.out.println("test 메소드2");
	}
	
	@RequestMapping("/request.do")
	public void request() {
		System.out.println("request");
	}
}
