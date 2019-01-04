package domean.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domean.board.dao.BoardDAO;
import domean.board.model.BoardDTO;
import domean.common.FileUpload;
import domean.common.FileVO;
import domean.common.SearchVO;

@Service("BoardServiceImple")
public class BoardServiceImple implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	
	
	
	@Override
	public List<BoardDTO> listBoard(SearchVO searchVO) throws SQLException {
		return boardDAO.listBoard(searchVO);
	}
	
	
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insertBoard(BoardDTO boardDTO, String memberSeq) throws Exception {
		
		boardDTO.setBoardWriterSeq(memberSeq);
		boardDTO.setBoardUpdateMemberSeq(memberSeq);
		
		boardDAO.insertBoard(boardDTO);
		
		List<FileVO> fileList =  new ArrayList<FileVO>();
		if(boardDTO.getUploadFile()!=null) {
			fileList = new FileUpload().SaveAllFiles(boardDTO.getUploadFile());
		}
		
		for (Integer i=0; i<fileList.size();i++) {					
			FileVO fileVO = fileList.get(i);
			fileVO.setParentPK(boardDTO.getBoardSeq());
			boardDAO.insertBoardFile(fileVO);
		}
	}

	

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateBoard(BoardDTO boardDTO,String[] fileSeqs, String memberSeq) throws Exception {
		
		boardDTO.setBoardUpdateMemberSeq(memberSeq);
		boardDAO.updateBoard(boardDTO);
		
		List<FileVO> fileList =  new ArrayList<FileVO>();
		
		if(boardDTO.getUploadFile()!=null) {
			fileList = new FileUpload().SaveAllFiles(boardDTO.getUploadFile());
			
			for (Integer i=0; i<fileList.size();i++) {					
				FileVO fileVO = fileList.get(i);
				fileVO.setParentPK(boardDTO.getBoardSeq());
				boardDAO.insertBoardFile(fileVO);
			}
		}
		
		if(fileSeqs!=null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			List<String> list = new ArrayList<String>(Arrays.asList(fileSeqs));
			map.put("fileSeqs", list);
			boardDAO.deleteFiles(map);
		}
		
	}

	
	
	@Override
	public void deleteBoard(String boardSeq) throws SQLException {
		boardDAO.deleteBoard(boardSeq); 
	}

	
	
	@Override
	public Integer totalCountBoard(SearchVO searchVO) throws SQLException {
		Integer count = boardDAO.totalCountBoard(searchVO);
		return count;
	}

	
		
	
	@Override
	public List<BoardDTO> updateViewBoard() throws SQLException {
		return null;
	}



	@Override
	public void insertBoardDummy() throws Exception {
		BoardDTO dummy = new BoardDTO();
		dummy.setBoardContent("123123");
		dummy.setBoardTitle("sdfsdfsdf");
		dummy.setBoardWriterSeq("9");
		dummy.setBoardUpdateMemberSeq("9");
		for(int i=0; i<=30000;i++) {
			boardDAO.insertBoard(dummy);
		}
	}



	@Override
	public BoardDTO selectOneBoard(String boardSeq) throws Exception {
		return boardDAO.selectOneBoard(boardSeq);
	}



	@Override
	public List<FileVO> selectAllBoardFile(String boardSeq) throws Exception {
		return boardDAO.selectAllBoardFile(boardSeq);
	}
	
	
}
