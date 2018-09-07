package domean.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import domean.util.DateUtil;
import domean.util.PropertiesUtil;


/**
 * 파일 업로드 클래스
 * @author CM
 *
 */
public class FileUpload {
	
	
	/**
	 * 파일을 저장한다.
	 * @param file 저장 할 파일
	 * @param basePath 저장하고자 하는 폴더경로
	 * @param fileName 파일명
	 * @return 풀 경로
	 * @throws Exception 오류발생
	 */
	public String saveFile(MultipartFile file, String savePath, String newFileName) throws Exception {
	
		if(file == null || file.getName().equals("") || file.getSize() < 1) {
			return null;
		}
		
		File dir = new File(savePath); //폴더 생성
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String serverFullPath = savePath + newFileName;
  
		File file1 = new File(serverFullPath);
		file.transferTo(file1);
        
		return serverFullPath;
	}
	
	
	
	public String getNewName() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        return ft.format(new Date()) + (int) (Math.random()*10);
	}
	
	
	/**
	 * 단일 파일업로드 
	 * @param upfile 파일 덩어리
	 * @return 저장한 파일의 정보들
	 * @throws Exception 오류발생 처리
	 */
	public FileVO SaveOneFile(MultipartFile upfile, String type) throws Exception {
		String filePath = PropertiesUtil.getOption("domean", "upload.file");
		String newFileName = getNewName();
		
		saveFile(upfile, filePath+"/"+DateUtil.getCurrentTime("yyyy")+"/", newFileName);
			
		String fpath = ""; 
		FileVO fileVO = new FileVO();
		fileVO.setFileOriginalName(upfile.getOriginalFilename());
		fileVO.setFileName(newFileName);
		fileVO.setFilePath(fpath);
		fileVO.setFileSize(upfile.getSize());
		
		return fileVO;
	}
	
	
	
	/**
	 * 멀티 파일 업로드
	 * @param upfiles 파일 리스트
	 * @return 저장한 파일들의 리스트
	 * @throws Exception 오류발생 처리
	 */
	public List<FileVO> SaveAllFiles(List<MultipartFile> upfiles) throws Exception {
		String filePath = PropertiesUtil.getOption("domean", "upload.file");
		List<FileVO> filelist = new ArrayList<FileVO>();

		for(MultipartFile uploadfile : upfiles ){			
			if (uploadfile.getSize()==0){
				continue;
			}
			
			String newFileName = getNewName();
			
			saveFile(uploadfile, filePath+"/"+DateUtil.getCurrentTime("yyyy")+"/", newFileName); //파일 ,파일만들위치 , 가공한 파일명
			
			FileVO fileVO = new FileVO();
			fileVO.setFileOriginalName(uploadfile.getOriginalFilename());
			fileVO.setFileName(newFileName);
			fileVO.setFileSize(uploadfile.getSize());
			
			filelist.add(fileVO);
        }
		
		return filelist;
	}
	
	
	
	/**
	 * 확장자를 추출하는 메소드
	 * @param Filename
	 * @return ex) ".zip"
	 */
	public String getFileExtension(String Filename) {
		  int index = Filename.lastIndexOf(".");
		  return Filename.substring(index, Filename.length());
	}
	
	
	
	/**
	 * 업로드파일 허용 확장자 체크
	 * @param upfiles 첨부파일 리스트
	 * @return 성공,실패
	 * @throws Exception 오류발생
	 */
	public Boolean isExtension(List<MultipartFile> upfiles) throws Exception {
		String allowFiles = PropertiesUtil.getOption("domean", "ALLOW_FILE");
		
		for(MultipartFile uploadfile : upfiles ){
			if (uploadfile.getSize()==0){
				continue;
			}
			String filename = uploadfile.getOriginalFilename();
			String extension =getFileExtension(filename).toLowerCase();				
			
			if(allowFiles.contains(extension)){
				return false;
			}
        }
		return true;
	}
	
}
