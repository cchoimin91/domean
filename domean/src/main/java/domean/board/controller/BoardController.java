package domean.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domean.board.model.BoardDTO;
import domean.board.service.BoardService;
import domean.common.FileVO;
import domean.common.SearchVO;
import domean.member.model.MemberDTO;

@RequestMapping(value="/member/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	/**
	 * 게시물 등록 폼으로 이동합니다.
	 * @return
	 */
	@RequestMapping(value = "/create" , method = RequestMethod.GET )
	public String boardWriteView() {
		return "board/boardForm";
	}
	
	
	
	/**
	 * 게시물 리스트 페이지
	 * @param searchVO
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String boardList(SearchVO searchVO, ModelMap modelMap, Authentication authentication, HttpServletRequest request) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		
		searchVO.PageCalculate(boardService.totalCountBoard(searchVO)); 
		List<BoardDTO> boardList = boardService.listBoard(searchVO);
		
		//modelMap.addAttribute("memberDTO", memberDTO);
		modelMap.addAttribute("searchVO", searchVO);
		modelMap.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	
	
	/**
	 * 게시물을 등록합니다.
	 * @param request
	 * @param modelMap
	 * @param boardDTO
	 * @param authentication
	 * @return 리스트페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String boardInsert(HttpServletRequest request, ModelMap modelMap, @ModelAttribute BoardDTO boardDTO, Authentication authentication) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();
		boardService.insertBoard(boardDTO, memberDTO.getMemberSeq());
		return "redirect:/member/board/list";
	
	}
	
	
	/**
	 * 게시물을 수정합니다.
	 * @param request
	 * @param boardDTO
	 * @param authentication
	 * @return 리스트페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public String boardUpdate(HttpServletRequest request, @ModelAttribute BoardDTO boardDTO, Authentication authentication) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();
		
		if(!memberDTO.getMemberSeq().equals(boardDTO.getBoardWriterSeq())) {
			return "etc/accessDenied";
		}
		
		boardService.updateBoard(boardDTO, memberDTO.getMemberSeq());

		return "redirect:/member/board/list";
	}
	
	
	
	/**
	 * 게시물 1건을 조회합니다.
	 * @param request
	 * @param modelMap
	 * @param boardDTO
	 * @param authentication
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/view/{boardSeq}", method = RequestMethod.GET)
	public String boardView(HttpServletRequest request, ModelMap modelMap, Authentication authentication, @PathVariable("boardSeq") String boardSeq) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		BoardDTO boardDTO = boardService.selectOneBoard(boardSeq);
		List<FileVO> fileList= boardService.selectAllBoardFile(boardSeq);
		
		modelMap.addAttribute("memberDTO",memberDTO);
		modelMap.addAttribute("fileList",fileList);		
		modelMap.addAttribute("boardDTO",boardDTO);
		
		return "board/boardView";
	}
	
	
	
	/**
	 * 수정 할 게시물의 데이터를 수정 폼으로 가져옵니다.
	 * @param request
	 * @param authentication
	 * @param boardSeq
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update/{boardSeq}", method = RequestMethod.GET)
	public String boardUpdateForm(HttpServletRequest request, Authentication authentication, @PathVariable("boardSeq") String boardSeq, ModelMap modelMap) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		BoardDTO boardDTO = boardService.selectOneBoard(boardSeq);
		
		if(!memberDTO.getMemberSeq().equals(boardDTO.getBoardWriterSeq())) {
			return "etc/accessDenied";
		}
		
		List<FileVO> fileList= boardService.selectAllBoardFile(boardSeq);
		
		modelMap.addAttribute("boardDTO", boardDTO);
		modelMap.addAttribute("fileList", fileList);
		
		return "board/boardUpdateForm";
	}
	
	
	
	/**
	 * 게시글을 삭제 합니다. 
	 * @param request
	 * @param boardSeq
	 * @param authentication
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/delete", method= RequestMethod.DELETE)
	public String boardDelete(HttpServletRequest request, HttpServletResponse response, Authentication authentication , @RequestParam String boardSeq) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		
		String url;
		
		BoardDTO boardDTO = boardService.selectOneBoard(boardSeq);
		
		if(!memberDTO.getMemberSeq().equals(boardDTO.getBoardWriterSeq())) {
			url= "etc/accessDenied";
		}else {
			boardService.deleteBoard(boardSeq);
			url ="/member/board/list";
		}
		
		return url;
		
	}
	

	
	
	/**
	 * 게시판에 더미데이터 넣기
	 * @param request
	 * @param modelMap
	 * @param boardDTO
	 * @param authentication
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertInfi", method = RequestMethod.GET)
	public String boardInsertDummy(HttpServletRequest request, ModelMap modelMap, @ModelAttribute BoardDTO boardDTO,
			Authentication authentication) throws Exception {
		
		boardService.insertBoardDummy();
		return "redirect:/member/board/list";
	
	}
	
	
	
}// CLASS END
