package domean.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domean.board.model.BoardDTO;
import domean.common.FileVO;
import domean.common.SearchVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	/**
	 * 게시물을 정보를 저장합니다
	 * @param boardDTO
	 */
	public void insertBoard(BoardDTO boardDTO) throws SQLException{
		sqlSession.insert("insertBoard", boardDTO);
	}
	
	
	
	/**
	 * 게시물의 파일을 저장합니다.
	 * @param fileVO
	 * @throws SQLException
	 */
	public void insertBoardFile(FileVO fileVO) throws SQLException{
		sqlSession.insert("insertBoardFile", fileVO);
	}
	
	
	
	/**
	 * 게시물의 총 개수를 반환합니다.
	 * @param searchVO
	 * @return
	 * @throws SQLException
	 */
	public Integer totalCountBoard(SearchVO searchVO) throws SQLException{
		return sqlSession.selectOne("totalCountBoard",searchVO);
	}
	
	
	
	/**
	 * 게시물의 리스트를 가져옵니다.
	 * @param searchVO
	 * @return
	 * @throws SQLException
	 */
	public List<BoardDTO> listBoard(SearchVO searchVO) throws SQLException{
		return sqlSession.selectList("listBoard", searchVO);
	}
	
	
	
	/**
	 * 게시물 하나에 대한 정보를 가져옵니다. 
	 * @param boardSeq
	 * @return
	 * @throws SQLException
	 */
	public BoardDTO selectOneBoard(String boardSeq) throws SQLException{
		return sqlSession.selectOne("selectOneBoard",boardSeq);
	}
	
	
	
	
	/**
	 * 게시물의 파일을 모두 가져옵니다. 
	 * @param boardSeq
	 * @return
	 * @throws SQLException
	 */
	public List<FileVO> selectAllBoardFile(String boardSeq) throws SQLException{
		return sqlSession.selectList("selectAllBoardFile",boardSeq);
	}
	
	
	
	/**
	 * 게시물을 수정합니다. 
	 * @param boardDTO
	 * @throws SQLException
	 */
	public void updateBoard(BoardDTO boardDTO) throws SQLException{
		sqlSession.update("updateBoard", boardDTO);
	}
	
	
	
	/**
	 * 게시물을 삭제합니다.
	 * @param boardSeq
	 * @throws SQLException
	 */ 
	public void deleteBoard(String boardSeq) throws SQLException{
		sqlSession.update("deleteBoard", boardSeq);
	}
	
	
	
	/**
	 * 파일을 삭제 합니다 
	 * @param fileSeqs 삭제 할 파일seq들
	 * @throws SQLException
	 */
	public void deleteFiles(Map<String, Object> fileSeqs) throws SQLException{
		sqlSession.update("deleteFiles", fileSeqs);
	}
	
}
