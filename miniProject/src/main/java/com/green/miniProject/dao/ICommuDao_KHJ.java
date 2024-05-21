package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.BoardTag;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.Reply;


@Mapper
public interface ICommuDao_KHJ {
	
	public List<Board> getAllWhenMember();
	public List<Board> getAllWhenCompany();

	public List<BoardTag>detailDao(@Param("bno") long bno);
	public int insertContentWhenMem(@Param("mid") String mid, @Param("title") String title, @Param("content") String content);
	public Long getBno(@Param("title") String title, @Param("content") String content);
	public int insertTagWhenMem(@Param("mid") String mid, @Param("tag") String tag, @Param("bno")Long bno);
	public List<Board> myList(@Param("mid") String mid);
	// 좋아요 관련
	public int insertLikeMem(@Param("mid") String mid, @Param("bno")Long bno);
	public int deleteLikeMem(@Param("mid")String mid, @Param("bno")Long bno);
	public void plusLikeOnBoard(@Param("bno") Long bno);
	public void minusLikeOnBoard(@Param("bno") Long bno);
	
	// 댓글 관련
	public List<Reply> getAllReplyList(@Param("bno") long bno);
	public void insertReply(@Param("mid") String mid, @Param("reply")String reply, @Param("bno")Long bno);
	
	
	
	//공지사항 관련 메서드
	public List<Notice> getNoticeList(); 
	public Notice getNoticeDetail(String nno);

}
