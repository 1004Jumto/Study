package chapter09;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	// 서비스에서 처리할 로직
	// - 사용자가 입력한 파라미터 전달
	// - 첨부파일 처리
	// - 파일명을 vo에 저장
	// - user테이블에 insert
	// - user데이터의 pk를 통해 hobby 테이블에 insert(반복문 사용)

	int insert(UserVO vo, MultipartFile profile);

}
