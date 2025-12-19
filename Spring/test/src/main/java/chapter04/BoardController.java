package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardController {
	@Autowired		// BoardSerivce Bean을 주입받음
	private BoardService boardService;
	
	public void list() {
		boardService.list();
	}		
}
