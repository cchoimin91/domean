package domean.board.service;

import java.util.List;

import domean.board.model.BoardDTO;
import domean.common.FileVO;
import domean.common.SearchVO;

public interface BoardService {

	/**
	 * 게시물 리스트
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> listBoard(SearchVO searchVO)  throws Exception;
	
	
	
	/**
	 * 게시물 등록
	 * @param boardDTO
	 * @param memberSeq
	 * @throws Exception
	 */
	public void insertBoard(BoardDTO boardDTO, String memberSeq) throws Exception;
	
	
	
	/**
	 * 게시물 수정
	 * @throws Exception
	 */
	public void updateBoard()  throws Exception;
	
	
	
	/**
	 * 게시물 삭제
	 * @throws Exception
	 */
	public void deleteBoard()  throws Exception;
	
	
	
	/**
	 * 총 게시물 수
	 * @param searchVO
	 * @return
	 * @throws Exception
	 */
	public Integer totalCountBoard(SearchVO searchVO)  throws Exception;
	
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> updateViewBoard()  throws Exception;
	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void insertBoardDummy() throws Exception;
	
	
	
	/**
	 * 게시물 1건 조회
	 * @throws Exception
	 */
	public BoardDTO selectOneBoard(String boardSeq) throws Exception;
	
	
	
	/**
	 * 게시물의 모든 파일을 가져옵니다.
	 * @param boardSeq
	 * @return
	 * @throws Exception
	 */
	public List<FileVO> selectAllBoardFile(String boardSeq) throws Exception;
}
