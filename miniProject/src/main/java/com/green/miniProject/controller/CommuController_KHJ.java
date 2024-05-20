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
import com.green.miniProject.domain.BoardTag;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.Tag;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;
	
	
	//리퀘스트 매핑 수정 => /commu 입력 시 이동되게! (송이)
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
		model.addAttribute("noticeList",noticeList);
		
		
		
		return "community_KHJ";
	}

	
	//공지사항 상세페이지
	@RequestMapping("/communityNotice_MSI")
	public String communityNotice_MSI(@RequestParam("nno") String nno, Model model) {
		model.addAttribute("notice",dao.getNoticeDetail(nno));
		
		return "communityNotice_MSI";
		
	}
	
	
	@RequestMapping("/communityMemInsert_KHJ")
	public String communityMemInsert_KHJ() {

		return "communityMemInsert_KHJ";
	}

	@RequestMapping("/communityDetail_KHJ")
	public String communityDetail_KHJ(HttpServletRequest request, Model model) {

		String sBno = request.getParameter("bno");
		long bno = Long.parseLong(sBno);
		List<BoardTag> boardDetail = dao.detailDao(bno);
		List<Tag> tagList = new ArrayList<>();
		
		for (BoardTag detail : boardDetail) {
			System.out.println("BoardDetail의 데이터" + detail.getValue());
			String stag = detail.getValue();
			
			Tag tag = new Tag();
			tag.setValue(stag);
			tagList.add(tag);
		}
		
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("tagList", tagList);
		
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

			
			

		
		
//				Gson gson = new Gson();
//				Type tagListType = new TypeToken<List<Tag>>() {
//				}.getType();
//				System.out.println(tagListType);
//				List<Tag> tags = gson.fromJson(tagList, tagListType);
//				System.out.println(tags);
//				for (Tag tag : tags) {
//					String tagValue = tag.getValue();
//					System.out.println(tagValue);
//					dao.insertTagWhenMem(mid, tagValue, bno);
//				

			

		return "redirect:/commu/communityMyBoards_KHJ";

	}

	@RequestMapping("/communityMyBoards_KHJ")
	public String communityMyBoards_KHJ(Model model, HttpSession session) {

		String mid = "happy01";
		// Board list = dao.myList(mid);
		// model.addAttribute("myList", list);

		return "communityMyBoards_KHJ";
	}


}
