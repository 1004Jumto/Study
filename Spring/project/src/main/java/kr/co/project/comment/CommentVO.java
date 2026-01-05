package kr.co.project.comment;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentVO {
	private int no;
	private int parent_no;
	private String content;
	private Timestamp regdate;
	private int writer;
	private String writer_name;
	
	private int startIdx;
	private int page;
}
