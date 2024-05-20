package com.green.miniProject.controller;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.BoardTag;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Tag;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import net.bytebuddy.description.type.TypeVariableToken;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;

	@RequestMapping("/")
	public String root(Model model) {

		String id = "개인회원";

		if (id.equals("개인회원")) {

			model.addAttribute("list", dao.getAllWhenMember());
			System.out.println(model.addAttribute("list", dao.getAllWhenMember()));

		} else if (id.equals("기업회원")) {

			model.addAttribute("list", dao.getAllWhenCompany());
		}

		return "community_KHJ";
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
