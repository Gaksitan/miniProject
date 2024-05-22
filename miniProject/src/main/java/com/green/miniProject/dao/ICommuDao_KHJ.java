package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.BoardTag;
import com.green.miniProject.domain.Like;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.Reply;
import com.green.miniProject.domain.ReplyDetail;


@Mapper
public interface ICommuDao_KHJ {
	//커뮤니티 메인화면 관련
	public List<Board> getAllWhenMember();
	public List<Board> getAllWhenCompany();
	public ReplyDetail replyCount(@Param("bno") long bno);
	
	//게시글 등록 관련
	public List<BoardTag>tagListWhenMem(@Param("bno") long bno);
	public List<BoardTag>tagListWhenCom(@Param("bno")long bno);
	public int insertContentWhenMem(@Param("mid") String mid, @Param("title") String title, @Param("content") String content);
	public int insertContentWhenCom(@Param("title") String title, @Param("content") String content, @Param("cmid") String cmid);
	public Long getBno(@Param("title") String title, @Param("content") String content);
	public int insertTagWhenMem(@Param("mid") String mid, @Param("tag") String tag, @Param("bno")Long bno);
	public int insertTagWhenCom(@Param("cmid") String cmid, @Param("tag") String tag, @Param("bno")Long bno);
	public List<Board> myListMem(@Param("mid") String mid);
	public List<Board> myListCom(@Param("cmid") String cmid);
	
	// 좋아요 관련
	public int insertLikeMem(@Param("mid") String mid, @Param("bno")Long bno);
	public int deleteLikeMem(@Param("mid")String mid, @Param("bno")Long bno);
	public int insertLikeCom(@Param("cmid") String cmid, @Param("bno")Long bno);
	public int deleteLikeCom(@Param("cmid")String cmid, @Param("bno")Long bno);
	public void plusLikeOnBoard(@Param("bno") Long bno);
	public void minusLikeOnBoard(@Param("bno") Long bno);
	public int getLikeMem(@Param("mid") String mid, @Param("bno")Long bno);
	public int getLikeCom(@Param("cmid") String cmid, @Param("bno")Long bno);
	
	// 댓글 관련
	public List<Reply> getAllReplyList(@Param("bno") long bno);
	public void insertReplyWhenMem(@Param("mid") String mid, @Param("reply")String reply, @Param("bno")Long bno);
	public void insertReplyWhenCom(@Param("reply")String reply, @Param("cmid") String cmid, @Param("bno")Long bno);
	
	
	//공지사항 관련 메서드
	public List<Notice> getNoticeList(); 
	public Notice getNoticeDetail(String nno);

}
