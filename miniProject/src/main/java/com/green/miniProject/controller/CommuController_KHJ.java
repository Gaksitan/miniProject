package com.green.miniProject.controller;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.BoardTag;
import com.green.miniProject.domain.Like;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.Reply;
import com.green.miniProject.domain.Tag;
import com.green.miniProject.service.LikeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;

	@Autowired
	private LikeService service;

	// 리퀘스트 매핑 수정 => /commu 입력 시 이동되게! (송이)
	@RequestMapping("")
	public String root(Model model) {

		String id = "개인회원";

		if (id.equals("개인회원")) {

			model.addAttribute("list", dao.getAllWhenMember());
			System.out.println(model.addAttribute("list", dao.getAllWhenMember()));

		} else if (id.equals("기업회원")) {

			model.addAttribute("list", dao.getAllWhenCompany());
		}

		// 공지사항 리스트 불러오기
		List<Notice> noticeList = dao.getNoticeList();
		model.addAttribute("noticeList", noticeList);

		return "community_KHJ";
	}

	// 공지사항 상세페이지
	@RequestMapping("/communityNotice_MSI")
	public String communityNotice_MSI(@RequestParam("nno") String nno, Model model) {
		model.addAttribute("notice", dao.getNoticeDetail(nno));

		return "communityNotice_MSI";

	}

	@RequestMapping("/communityMemInsert_KHJ")
	public String communityMemInsert_KHJ() {

		return "communityMemInsert_KHJ";
	}

	@RequestMapping("/communityDetail_KHJ")
	public String communityDetail_KHJ(@RequestParam("bno") Long bno, Model model) {

		//String sBno = request.getParameter("bno");
		//System.out.println("sBno" + sBno);
		//long bno = Long.parseLong(sBno);

		List<BoardTag> boardDetail = dao.detailDao(bno);
		List<Tag> tagList = new ArrayList<>();

		for (BoardTag detail : boardDetail) {
			System.out.println("태그 : " + detail.getValue());
			String stag = detail.getValue();

			Tag tag = new Tag();
			tag.setValue(stag);
			tagList.add(tag);
		}

		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("tagList", tagList);
		// 해당 게시글에 달린 댓글 리스트 가져오기
		System.out.println("댓글조회하기 위해 넘어온 bno = " + bno);
		List<Reply> replyList = dao.getAllReplyList(bno);
		System.out.println("받아온 REPLY객체들" + replyList);
		
		model.addAttribute("replyList", replyList);
		
		return "communityDetail_KHJ";

	}

	@RequestMapping("/contentInsert")
	public String contentInsert(HttpServletRequest request, Model model) {

		String mid = "happy01";

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tagList = request.getParameter("tag");
		System.out.println(tagList);
		dao.insertContentWhenMem(mid, title, content);
		Long bno = dao.getBno(title, content);
		Gson gson = new Gson();
		Type tagListType = new TypeToken<List<Tag>>() {
		}.getType();
		System.out.println(tagListType);
		List<Tag> tags = gson.fromJson(tagList, tagListType);
		System.out.println(tags);
		for (Tag tag : tags) {
			String tagValue = tag.getValue();
			System.out.println(tagValue);
			dao.insertTagWhenMem(mid, tagValue, bno);
		}

		return "redirect:/commu/communityMyBoards_KHJ";

	}

	@RequestMapping("/communityMyBoards_KHJ")
	public String communityMyBoards_KHJ(Model model, HttpSession session) {

		String mid = "happy01"; // 세션에서 넘어온 아이디
		List<Board> list = dao.myList(mid);
		model.addAttribute("myList", list);

		return "communityMyBoards_KHJ";
	}

	@RequestMapping("/likeInsert.do")
	public void likeInsert(@RequestParam("id") String mid, @RequestParam("no") Long bno, Model model) {
		System.out.println(mid);
		service.insert(mid, bno); // board에도 좋아요 +1 되고, Like테이블에 정보가 insert 됨
		// System.out.println(service.insert(mid, bno));

	}

	@RequestMapping("/likeDelete.do")
	public void likeDelete(@RequestParam("id") String mid, @RequestParam("no") Long bno, Model model) {

		System.out.println(mid);
		service.delete(mid, bno); // board에 좋아요 -1 되고, Like 테이블에 정보가 사라짐
		// System.out.println(service.delete(mid, bno));

	}

	@RequestMapping("/replyInsert.do")
	public String replyInsert(@RequestParam("bno") Long bno, @RequestParam("mid") String mid, @RequestParam("reply") String reply, Model model) {
		System.out.println("bno = " + bno);
		System.out.println("mid = " + mid);
		System.out.println("reply = " + reply);
		dao.insertReply(mid, reply, bno);
		
		//return "redirect:/communityDetail_KHJ?bno=" + bno;
		return "redirect:/commu/communityDetail_KHJ?bno=" + bno;
	}
	
//	@RequestMapping("/getAllReplyList")
//	public String getAllReplyList(@RequestParam("bno") Long bno, Model model) {
//		System.out.println("댓글조회하기 위해 넘어온 bno = " + bno);
//		List<Reply> list = dao.getAllReplyList(bno);
//		System.out.println(list);
//		model.addAttribute("replyList", "list");
//		
//		return "communityDetail_KHJ"; //redirect해야하나?
//	}

}
