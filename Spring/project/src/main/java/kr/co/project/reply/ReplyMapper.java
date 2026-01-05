package kr.co.project.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
	int insert(ReplyVO vo);
	int updateGno(int no);
	int updateOno(ReplyVO vo);
	int count(ReplyVO vo);
	List<ReplyVO> list(ReplyVO vo);
	ReplyVO detail(ReplyVO vo);
	int increaseReadcnt(int no);
	int update(ReplyVO vo);
	int delete(int no);
	int fileDelete(int no);
}
