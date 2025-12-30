package chapter09;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	@Transactional	// 아래 insert메소드의 sql 실행이 하나의 트랜잭션으로 묶임
	public int insert(UserVO vo, MultipartFile profile) {
		if (!profile.isEmpty()) {
			// 원본 파일명
			String org = profile.getOriginalFilename();

			// 새로운 파일명 - OOO.확장자
			String ext = org.substring(org.lastIndexOf(".")); // 확장자
			String real = System.nanoTime() + ext; // 실제 저장될 파일명

			try {
				profile.transferTo(new File("D:/file_repo/" + real));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// vo에 set
			vo.setProfile_org(org);
			vo.setProfile_real(real);

		}
		
		int ret = mapper.insert(vo);
		
		// 취미 저장
		if(vo.getHobby() != null) {
			for(String hobby : vo.getHobby()) {
				Map<String, Object> map = new HashMap<>();
				map.put("userno", vo.getUserno());
				map.put("name", hobby);
				mapper.insertHobby(map);
			}
		}
		
		return ret;
	}

}
