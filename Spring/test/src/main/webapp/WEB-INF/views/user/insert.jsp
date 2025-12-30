<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <form method="post" action="insert" enctype="multipart/form-data"> 
        아이디 : <input type="text" name="id" value="" tabindex="1" required autofocus><br>
        비밀번호 : <input type="password" tabindex="3" name="password" placeholder="비밀번호를 입력해 주세요"><br>
        성별 :   <input type="radio" tabindex="2" name="gender" value=1 id="gender1" checked><label for="gender1">남자 </label>
                <input type="radio" name="gender" value=2 id="gender2"><label for="gender2">여자</label><br>
        취미 :   <input type="checkbox" name="hobby" value="게임">게임 
                <input type="checkbox" name="hobby" value="영화">영화 
                <input type="checkbox" name="hobby" value="독서" checked>독서 
                <input type="checkbox" name="hobby" value="낚시">낚시<br>
        나이 : <input type="number" name="age"><br>
        생일 : <input type="date" name="birth"><br>
        프로필사진 : <input type="file" name="profile" multiple><br>
        자기소개 : <textarea name="introduce">안녕하세요</textarea><br>
        지역 : 
        <select name="local">
            <option value=1>서울</option>
            <option value=2 selected>부산</option>
            <option value=3>제주</option>
        </select>
        
        <br>
        <hr>
        
        <input type="hidden" name="member_no" value="1">
        <input type="submit"  value="제출">
        <input type="submit" value="회원가입">
        <input type="reset" value="초기화">
        <input type="button" value="임시저장" onclick="alert('임시저장되었습니다.')">
        <!--  <button>버튼</button>-->
    </form>
    <script type="text/javascript">
    	let msg = '${msg}';
    	if (msg) alert(msg);
    </script>
</body>
</html>