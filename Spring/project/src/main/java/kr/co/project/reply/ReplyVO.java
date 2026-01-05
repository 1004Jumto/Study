package kr.co.project.reply;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	private int readcnt;
	private int gno;
	private int ono;
	private int nested;
	private int writer;
	
	private String writer_name;
	
	// 첨부파일
	private String filename_real;
	private String filename_org;
	
	// 사용자로부터 전송되어지는 값(검색, 페이징, 필터링(조건))
	private String searchType;
	private String searchWord;
	private int page; // 사용자가 요청한 페이지 번호
	private int startIdx; // limit 앞에 들어갈 시작인덱스값
	
	private int comment_count; // 댓글 수
	
	public ReplyVO() {
		this.page = 1;
	}
	
	public int getStartIdx() {
		return (page-1) * 10;
	}
}
