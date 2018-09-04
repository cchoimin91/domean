package domean.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domean.board.dao.BoardDAO;
import domean.board.model.BoardDTO;
import domean.board.service.BoardService;
import domean.common.FileVO;
import domean.common.SearchVO;
import domean.member.model.MemberDTO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	/**
	 * 게시물 등록 폼으로 이동합니다.
	 * @return
	 */
	@RequestMapping(value = "member/board/insert" , method = RequestMethod.GET )
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
	@RequestMapping(value = "member/board/list")
	public String boardList(SearchVO searchVO, ModelMap modelMap, Authentication authentication, HttpServletRequest request) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		
		searchVO.PageCalculate(boardService.totalCountBoard(searchVO)); 
		List<BoardDTO> boardList = boardService.listBoard(searchVO);
		
		modelMap.addAttribute("memberDTO", memberDTO);
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
	@RequestMapping(value = "member/board/insert", method = RequestMethod.POST)
	public String boardInsert(HttpServletRequest request, ModelMap modelMap, @ModelAttribute BoardDTO boardDTO, Authentication authentication) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();
		boardService.insertBoard(boardDTO, memberDTO.getMemberSeq());
		return "redirect:/member/board/list";
	
	}
	
	
	
	/**
	 * 게시물 1건 조회
	 * @param request
	 * @param modelMap
	 * @param boardDTO
	 * @param authentication
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "member/board/view/{boardSeq}", method = RequestMethod.GET)
	public String boardView(HttpServletRequest request, ModelMap modelMap, Authentication authentication, @PathVariable("boardSeq") String boardSeq) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		BoardDTO boardDTO = boardService.selectOneBoard(boardSeq);
		List<FileVO> fileList= boardService.selectAllBoardFile(boardSeq);
		
		modelMap.addAttribute("memberDTO",memberDTO);
		modelMap.addAttribute("fileList",fileList);		
		modelMap.addAttribute("boardDTO",boardDTO);
		return "board/boardView";
	}
	
	
	@RequestMapping(value="member/board/update/{boardSeq}", method = RequestMethod.GET)
	public String boardUpdateForm(HttpServletRequest request, Authentication authentication, @PathVariable("boardSeq") String boardSeq, ModelMap modelMap) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)authentication.getPrincipal();
		BoardDTO boardDTO = boardService.selectOneBoard(boardSeq);
		
		if(!memberDTO.getMemberSeq().equals(boardDTO.getBoardWriterSeq())) {
			return "etc/accessDenied";
		}
		
		modelMap.addAttribute("boardDTO", boardDTO);
		
		return "board/boardForm";
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
	@RequestMapping(value = "member/board/insertInfi", method = RequestMethod.GET)
	public String boardInsertDummy(HttpServletRequest request, ModelMap modelMap, @ModelAttribute BoardDTO boardDTO,
			Authentication authentication) throws Exception {
		boardService.insertBoardDummy();
		return "redirect:/member/board/list";
	}
	
	
	
}// CLASS END
