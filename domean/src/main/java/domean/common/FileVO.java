package domean.common;

public class FileVO {

	private String fileSeq;
	private String parentPK;
	private String fileOriginalName;
	private String fileName;
	private long fileSize;
	private String fileDeleteFlag;
	private String filePath;
	
	
	
	
	
	
	public String getFileDeleteFlag() {
		return fileDeleteFlag;
	}
	public void setFileDeleteFlag(String fileDeleteFlag) {
		this.fileDeleteFlag = fileDeleteFlag;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	public String getParentPK() {
		return parentPK;
	}
	public void setParentPK(String parentPK) {
		this.parentPK = parentPK;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
