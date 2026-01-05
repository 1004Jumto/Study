<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head> 
    <meta charset="utf-8">
    <title></title>
    <META name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no"> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/project/css/reset.css"/>
    <link rel="stylesheet" href="/project/css/contents.css"/>
    <script>
    function del() {
    	if (confirm('삭제하시겠습니까?')) {
    		location.href='delete.do?no=${vo.no}';
    	}
    }
    
    function getComment(page) {
		$.ajax({
			url: "/project/comment/list.do",
			data: {
				parent_no: ${vo.no},
				page: page
			},
			success: function(res) {
				$("#commentArea").html(res);
			}
		});
	}
	
	$(function() {
		getComment(1);
	});
	
	
	function goSave() {  
		console.log("${loginSess}");
		<c:if test="${empty loginSess}">
			alert('댓글은 로그인 후 작성 가능합니다.');
		</c:if>
		
		<c:if test="${!empty loginSess}">
		if ($("#content").val().trim() == '') {
			alert('댓글을 입력해 주세요');
			$("#content").focus();
			return false;
		}
		if (confirm('댓글을 저장하시겠습니까?')) {
    		$.ajax({
    			url: "/project/comment/insert.do",
    			data: {
    				parent_no: ${vo.no}, // sql거쳐 받아온 no도 있고, param에도 no가 있고 // ${param.no} 얘 써도 됨
    				content: $("#content").val(), // 컨트롤러의 커멘드객체(CommentVO vo) 안에 있는 필드명과 일치해야지
    				writer: ${loginSess.no}
    			},
    			success: function(res) {
    				if (res.trim() == "1") {
    					alert('댓글이 정상적으로 등록되었습니다.');
    					$("#content").val('');
    					getComment(1);
    				}
    			}
    		});
		}
		</c:if>
	}
	
	function commentDel(no) {
		if (confirm("댓글을 삭제하시겠습니까?")) {
			$.ajax ({
				url: '/project/comment/delete.do?no='+no,
				success: function(res) {
					if (res.trim() == "1") {
						alert('댓글이 정상적으로 삭제되었습니다.');
						getComment(1);
					}
				}
			});
		}
	}
    </script>
</head> 
<body>
    <div class="wrap">
        <div class="sub">
            <div class="size">
                <h3 class="sub_title">답변 게시판</h3>
                <div class="bbs">
                    <div class="view">
                        <div class="title">
                            <dl>
                                <dt>${vo.title }</dt>
                                <dd class="date">작성일 : <fmt:formatDate value="${vo.regdate }" pattern="YYYY-MM-dd HH:mm:ss"/> </dd>
                            </dl>
                        </div>
                        <div class="cont">${vo.content }</div>
                        <c:if test="${!empty vo.filename_org}">
                        <dl class="file">
                            <dt>첨부파일 </dt>
                            <dd>
                            <a href="<c:url value="/download.do"/>?uploadPath=/upload/board&filename_org=${URLEncoder.encode(vo.filename_org)}&filename_real=${vo.filename_real}" target="_blank">${vo.filename_org}</a></dd>
                        </dl>
                		</c:if>                    
                        <div class="btnSet clear">
                            <div class="fl_l">
                            	<a href="index.do" class="btn">목록</a>
                            	<a href="reply.do?no=${vo.no}" class="btn">답변</a>
                            	<c:if test="${!empty loginSess and loginSess.no == vo.writer}">
                            	<a href="edit.do?no=${vo.no}" class="btn">수정</a>
                            	<a href="javascript:del();" class="btn">삭제</a>
                            	</c:if>
                            </div>
                        </div>
                
                    </div>

                    <div>
                    <form method="post" name="frm" id="frm" action="" enctype="multipart/form-data" >
                        <table class="board_write">
                            <colgroup>
                                <col width="*" />
                                <col width="100px" />
                            </colgroup>
                            <tbody>
                            <tr>
                                <td>
                                    <textarea name="content" id="content" style="height:50px;"></textarea>
                                </td>
                                <td>
                                    <div class="btnSet"  style="text-align:right;">
                                        <a class="btn" href="javascript:goSave();">저장 </a>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        </form>

                        <div id="commentArea">
                        
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body> 
</html>