package domean.board.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	  
	private String boardSeq;
	private String boardTitle;
	private String boardContent;
	private String boardWriterSeq;
	private String boardWriteDate;
	private String boardUpdateDate;
	private String boardUpdateMemberSeq;
	private String boardDeleteflag;
	
	private List<MultipartFile> uploadFile;
	
	private String memberName;
	private String rowNum;
	private String fileOriginalname;
	
	
	
	public String getFileOriginalname() {
		return fileOriginalname;
	}
	public void setFileOriginalname(String fileOriginalname) {
		this.fileOriginalname = fileOriginalname;
	}
	public String getRowNum() {
		return rowNum;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriterSeq() {
		return boardWriterSeq;
	}
	public void setBoardWriterSeq(String boardWriterSeq) {
		this.boardWriterSeq = boardWriterSeq;
	}
	public String getBoardWriteDate() {
		return boardWriteDate;
	}
	public void setBoardWriteDate(String boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}
	public String getBoardUpdateDate() {
		return boardUpdateDate;
	}
	public void setBoardUpdateDate(String boardUpdateDate) {
		this.boardUpdateDate = boardUpdateDate;
	}
	public String getBoardUpdateMemberSeq() {
		return boardUpdateMemberSeq;
	}
	public void setBoardUpdateMemberSeq(String boardUpdateMemberSeq) {
		this.boardUpdateMemberSeq = boardUpdateMemberSeq;
	}
	public String getBoardDeleteflag() {
		return boardDeleteflag;
	}
	public void setBoardDeleteflag(String boardDeleteflag) {
		this.boardDeleteflag = boardDeleteflag;
	}
	
	

}
