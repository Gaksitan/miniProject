package com.green.miniProject.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.BoardReply;
import com.green.miniProject.domain.BoardTag;

import com.green.miniProject.domain.Like;

import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.Reply;
import com.green.miniProject.domain.ReplyDetail;
import com.green.miniProject.domain.Tag;
import com.green.miniProject.domain.TagBoard;
import com.green.miniProject.domain.tagCom;
import com.green.miniProject.domain.tagMem;
import com.green.miniProject.repository.BoardPagingRepository;
import com.green.miniProject.service.BoardPaingService_KHJ;
import com.green.miniProject.service.LikeService;

import com.green.miniProject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;

	@Autowired
	private LikeService service;

	@Autowired
	private UserService userService;

	@Autowired
	private BoardPaingService_KHJ boardPagingService;

	// 리퀘스트 매핑 수정 => /commu 입력 시 이동되게! (송이)

//	@RequestMapping("/mainPagingMem")
//	public String communityPaging(Model model, @RequestParam(value="page", defaultValue="1") int page, @RequestParam("mid") String mid) {
//		
//		Page<com.green.miniProject.entity.Board> paging = boardPagingService.getList(page);
//		  model.addAttribute("commuList", paging.getContent());
//	      model.addAttribute("totalPages", paging.getTotalPages());
//	      model.addAttribute("hasNext", paging.hasNext());
//	      model.addAttribute("hasPrevious", paging.hasPrevious());
//		
//		
//	}
//	

	@RequestMapping("")
	public String root(Model model, HttpSession session, @RequestParam(value = "page", defaultValue = "1") int page) {

		String mid = (String) session.getAttribute("mid");

		Company company = (Company) session.getAttribute("company");
		String cno = null;

		if (company != null) {
			cno = company.getCno();
		}

		if (mid != null) {
			// 페이징된 데이터 가져오기
			Page<com.green.miniProject.entity.Board> paging = boardPagingService.getListForMember(page);
			List<com.green.miniProject.entity.Board> commuList = paging.getContent();

			// 댓글 정보 가져오기
			List<ReplyDetail> replyDetails = new ArrayList<>();
			for (com.green.miniProject.entity.Board board : commuList) {
				Long bno = board.getBno();
				replyDetails.add(dao.replyCount(bno));
			}

			try {
				ObjectMapper mapper = new ObjectMapper();
				String replyDetailsJson = mapper.writeValueAsString(replyDetails);
				System.out.println(replyDetailsJson);
				model.addAttribute("replyDetailsJson", replyDetailsJson);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 모델에 페이징 데이터와 관련 정보를 추가
			model.addAttribute("commuList", commuList);
			model.addAttribute("totalPages", paging.getTotalPages());
			model.addAttribute("hasNext", paging.hasNext());
			model.addAttribute("hasPrevious", paging.hasPrevious());
			model.addAttribute("currentPage", paging.getNumber() + 1);
			model.addAttribute("replyDetails", replyDetails);

		} else if (cno != null) {
			// 페이징된 데이터 가져오기
			Page<com.green.miniProject.entity.Board> paging = boardPagingService.getListForCompany(page);
			List<com.green.miniProject.entity.Board> commuList = paging.getContent();

			// 댓글 정보 가져오기
			List<ReplyDetail> replyDetails = new ArrayList<>();
			for (com.green.miniProject.entity.Board board : commuList) {
				Long bno = board.getBno();
				replyDetails.add(dao.replyCount(bno));
			}

			try {
				ObjectMapper mapper = new ObjectMapper();
				String replyDetailsJson = mapper.writeValueAsString(replyDetails);
				System.out.println(replyDetailsJson);
				model.addAttribute("replyDetailsJson", replyDetailsJson);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 모델에 페이징 데이터와 관련 정보를 추가
			model.addAttribute("commuList", commuList);
			model.addAttribute("totalPages", paging.getTotalPages());
			model.addAttribute("hasNext", paging.hasNext());
			model.addAttribute("hasPrevious", paging.hasPrevious());
			model.addAttribute("currentPage", paging.getNumber() + 1);
			model.addAttribute("replyDetails", replyDetails);
		}

//		if (mid != null) {
//
//			List<Board> list = dao.getAllWhenMember();
//			List<ReplyDetail> replyDetails = new ArrayList<>();
//
//			for (Board board : list) {
//				Long bno = board.getBno();
//				replyDetails.add(dao.replyCount(bno));
//
//			}
//
//			try {
//				ObjectMapper mapper = new ObjectMapper();
//				String replyDetailsJson = mapper.writeValueAsString(replyDetails);
//				System.out.println(replyDetailsJson);
//				model.addAttribute("replyDetailsJson", replyDetailsJson);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			List<Board> filteredList = list.stream().filter(board -> board.getMid() != null)
//                    .collect(Collectors.toList());
//
//			//페이지
//			Page<com.green.miniProject.entity.Board> paging = boardPagingService.getList(page);
//			  model.addAttribute("commuList", filteredList);
//		      model.addAttribute("totalPages", paging.getTotalPages());
//		      model.addAttribute("hasNext", paging.hasNext());
//		      model.addAttribute("hasPrevious", paging.hasPrevious());
//		      model.addAttribute("currentPage", paging.getNumber() + 1);
//			
//			// System.out.println(replyDetails);
//			//model.addAttribute("list", list);
//			model.addAttribute("replyDetails", replyDetails);
//			// System.out.println(model.addAttribute("list", dao.getAllWhenMember()));
//
//		} else if (cno != null) {
//
//			List<Board> list = dao.getAllWhenCompany();
//			List<ReplyDetail> replyDetails = new ArrayList<>();
//
//			for (Board board : list) {
//				Long bno = board.getBno();
//				replyDetails.add(dao.replyCount(bno));
//				System.out.println(replyDetails);
//			}
//			
//			List<Board> filteredList = list.stream().filter(board -> board.getCmid() != null)
//                    .collect(Collectors.toList());
//			
//			
//			//페이지
//			Page<com.green.miniProject.entity.Board> paging = boardPagingService.getList(page);
//			  model.addAttribute("commuList", filteredList);
//		      model.addAttribute("totalPages", paging.getTotalPages());
//		      model.addAttribute("hasNext", paging.hasNext());
//		      model.addAttribute("hasPrevious", paging.hasPrevious());
//			
//
//			//model.addAttribute("list", list);
//			model.addAttribute("replyDetails", replyDetails);
//
//		}

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

	// 차단계정은 게시물 작성할수없게 수정하였음

	@RequestMapping("/communityMemInsert_KHJ")
	public String communityMemInsert_KHJ(HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {

		HttpSession session = request.getSession();

		String mid = (String) session.getAttribute("mid");

		Company company = (Company) session.getAttribute("company");
		String cno = null;

		if (company != null) {
			cno = company.getCno();
		}

		if (userService.isUserBlacklisted(mid) || userService.isUserBlacklisted(cno)) {
			redirectAttributes.addFlashAttribute("errorMessage", "차단된 해당 ID는 게시글을 작성할 수 없습니다.");
			return "redirect:/commu";
		}

		return "communityMemInsert_KHJ";
	}

	@RequestMapping("/communityDetail_KHJ")
	public String communityDetail_KHJ(@RequestParam("bno") Long bno, Model model, HttpSession session) {

		String mid = (String) session.getAttribute("mid");

		CompanyManager cm = (CompanyManager) session.getAttribute("companyManager");
		String cmid = null;

		if (cm != null) {

			cmid = cm.getCmid();
			System.out.println("cmid = " + cmid);
		}

		if (mid != null) {
			// 해당 게시물의 태그 가져오기(개인회원)
			List<BoardTag> boardDetail = dao.tagListWhenMem(bno);
			List<tagMem> tagListMem = new ArrayList<>();

			for (BoardTag detail : boardDetail) {
				System.out.println("태그 : " + detail.getValue());
				String stag = detail.getValue();

				tagMem tag = new tagMem();
				tag.setValue(stag);
				tagListMem.add(tag);
				model.addAttribute("boardDetail", boardDetail);
				model.addAttribute("tagList", tagListMem);
			}

			// 해당 게시글의 좋아요 여부 가져오기(개인회원)

			boolean result = service.getLikeListMem(mid, bno);

			if (result == true) {

				model.addAttribute("likeyesno", true);

			} else {

				model.addAttribute("likeyesno", false);

			}

		} else if (cmid != null) {
			// 해당 게시물의 태그 가져오기(기업회원)
			List<BoardTag> boardDetail = dao.tagListWhenCom(bno);
			List<tagCom> tagListCom = new ArrayList<>();

			for (BoardTag detail : boardDetail) {
				System.out.println("태그 : " + detail.getValue());
				String stag = detail.getValue();

				tagCom tag = new tagCom();
				tag.setValue(stag);
				tagListCom.add(tag);
				model.addAttribute("boardDetail", boardDetail);
				model.addAttribute("tagList", tagListCom);
			}

			// 해당 게시글의 좋아요 여부 가져오기(기업회원)

			boolean result = service.getLikeListCom(cmid, bno);

			if (result == true) {

				model.addAttribute("likeyesno", true);

			} else {

				model.addAttribute("likeyesno", false);

			}

		}

		// 해당 게시글에 달린 댓글 리스트 가져오기(bno로 구분되기 때문에 기업/개인 구분없음)
		System.out.println("댓글조회하기 위해 넘어온 bno = " + bno);
		List<Reply> replyList = dao.getAllReplyList(bno);
		System.out.println("받아온 REPLY객체들" + replyList);

		model.addAttribute("replyList", replyList);

		return "communityDetail_KHJ";

	}

	@RequestMapping("/contentInsert")
	public String contentInsert(HttpServletRequest request, Model model, HttpSession session) {

		String mid = (String) session.getAttribute("mid");

		CompanyManager cm = (CompanyManager) session.getAttribute("companyManager");
		String cmid = null;

		if (cm != null) {

			cmid = cm.getCmid();
			System.out.println("cmid = " + cmid);
		}

		if (mid != null) {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String tagList = request.getParameter("tag");
			System.out.println(tagList);
			dao.insertContentWhenMem(mid, title, content);
			Long bno = dao.getBno(title, content);
			Gson gson = new Gson();
			Type tagListType = new TypeToken<List<tagMem>>() {
			}.getType();
			System.out.println(tagListType);
			List<tagMem> tags = gson.fromJson(tagList, tagListType);
			System.out.println(tags);
			for (tagMem tag : tags) {
				String tagValue = tag.getValue();
				System.out.println(tagValue);
				dao.insertTagWhenMem(mid, tagValue, bno);
			}

		} else if (cmid != null) {
			System.out.println("cmid = " + cmid);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String tagList = request.getParameter("tag");

			dao.insertContentWhenCom(title, content, cmid);
			Long bno = dao.getBno(title, content);
			Gson gson = new Gson();
			Type tagListType = new TypeToken<List<tagCom>>() {
			}.getType();
			System.out.println(tagListType);
			List<tagCom> tags = gson.fromJson(tagList, tagListType);
			System.out.println(tags);
			for (tagCom tag : tags) {
				String tagValue = tag.getValue();
				System.out.println(tagValue);
				dao.insertTagWhenCom(cmid, tagValue, bno);
			}
			System.out.println("isnert 완료?");
		}
		return "redirect:/commu/communityMyBoards_KHJ";

	}

	@RequestMapping("/communityMyBoards_KHJ")
	public String communityMyBoards_KHJ(Model model, HttpSession session) {

		String mid = (String) session.getAttribute("mid");

		CompanyManager cm = (CompanyManager) session.getAttribute("companyManager");
		// System.out.println("내 게시물 조회용 cm" + cm);
		String cmid = null;

		if (cm != null) {

			cmid = cm.getCmid();
			System.out.println("cmid =" + cmid);
		}

		if (mid != null) {

			List<Board> listmem = dao.myListMem(mid);
			System.out.println("개인일때 가져온 내가 작성한 게시물 리스트" + listmem);
			List<BoardReply> replyList = dao.myReplyListMem(mid);
			List<TagBoard> meTagList = dao.toMeListMem(mid);
			List<Board> listILike = dao.getListILikeMem(mid);
			model.addAttribute("myList", listmem);
			model.addAttribute("replyList", replyList);
			model.addAttribute("taggedList", meTagList);
			model.addAttribute("likeList", listILike);

		} else if (mid == null) {
			// System.out.println("cmid = " + cmid);
			List<Board> listcom = dao.myListCom(cmid);
			System.out.println("인사매니저일때 가져온 내가 작성한 게시물 리스트" + listcom);

			List<BoardReply> replyList = dao.myReplyListCom(cmid);
			List<TagBoard> meTagList = dao.toMeListCom(cmid);
			List<Board> listILike = dao.getListILikeCom(cmid);
			model.addAttribute("myList", listcom);
			model.addAttribute("replyList", replyList);
			model.addAttribute("taggedList", meTagList);
			model.addAttribute("likeList", listILike);

		}

		return "communityMyBoards_KHJ";
	}

	@RequestMapping("/likeInsertMem")
	public void likeInsertMem(@RequestParam("id") String mid, @RequestParam("no") Long bno, Model model) {
		System.out.println(mid);
		service.insertMem(mid, bno); // board에도 좋아요 +1 되고, Like테이블에 정보가 insert 됨
		// System.out.println(service.insert(mid, bno));

	}

	@RequestMapping("/likeInsertCom")
	public void likeInsertCom(@RequestParam("id") String cmid, @RequestParam("no") Long bno, Model model) {
		System.out.println("likeInsertCom으로 들어온 cmid" + cmid);
		service.insertCom(cmid, bno); // board에도 좋아요 +1 되고, Like테이블에 정보가 insert 됨
		// System.out.println(service.insert(mid, bno));

	}

	@RequestMapping("/likeDeleteMem")
	public void likeDeleteMem(@RequestParam("id") String mid, @RequestParam("no") Long bno, Model model) {

		System.out.println(mid);
		service.deleteMem(mid, bno); // board에 좋아요 -1 되고, Like 테이블에 정보가 사라짐
		// System.out.println(service.delete(mid, bno));

	}

	@RequestMapping("/likeDeleteCom")
	public void likeDeleteCom(@RequestParam("id") String cmid, @RequestParam("no") Long bno, Model model) {

		System.out.println(cmid);
		service.deleteCom(cmid, bno); // board에 좋아요 -1 되고, Like 테이블에 정보가 사라짐
		// System.out.println(service.delete(mid, bno));

	}

	@RequestMapping("/replyInsert.do")
	public String replyInsert(@RequestParam("bno") Long bno, @RequestParam("reply") String reply, Model model,
			HttpSession session) {

		String mid = (String) session.getAttribute("mid");
		System.out.println("댓글달기 mid = " + mid);
		CompanyManager cm = (CompanyManager) session.getAttribute("companyManager");
		System.out.println("댓글달기 cm = " + cm);
		String cmid = null;

		if (cm != null) {

			cmid = cm.getCmid();
			System.out.println("cmid =" + cmid);
		}

		if (mid != null) {

			System.out.println("bno = " + bno);
			System.out.println("reply = " + reply);

			dao.insertReplyWhenMem(mid, reply, bno);

		} else if (mid == null) {
			System.out.println("댓글 달기위한 cmid..." + cmid);
			System.out.println("bno = " + bno);
			System.out.println("reply = " + reply);

			dao.insertReplyWhenCom(reply, cmid, bno);
			System.out.println("인사매니저 댓글달기 성공");
		}

		// return "redirect:/communityDetail_KHJ?bno=" + bno;

		return "redirect:/commu/communityDetail_KHJ?bno=" + bno;
	}

	@RequestMapping("/deleteReply")
	public String deleteReply(@RequestParam("reno") Long reno,@RequestParam("bno") Long bno, Model model, HttpSession session) {
		System.out.println("deleteReply 접속");
		String mid = (String) session.getAttribute("mid");
		CompanyManager cm = (CompanyManager) session.getAttribute("companyManager");
		String cmid = null;

		if (cm != null) {

			cmid = cm.getCmid();
			System.out.println("cmid =" + cmid);
		}

		if (mid != null) {
			
			dao.deleteReplyMem(reno, mid);

		} else if (mid == null) {
			dao.deleteReplyCom(reno, cmid);
		}

		return "redirect:/commu/communityDetail_KHJ?bno=" + bno;
	}
}
