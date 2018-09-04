package domean.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class downloadFile{

	@RequestMapping(value = "downloadFile")
	public void execDownloadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		filedownload( CommUtil.getOption("domean", "upload.image"), true, request,response );
	}
	
	@RequestMapping(value = "downloadPhoto")
	public void downloadPhoto(HttpServletRequest request,HttpServletResponse response) throws Exception {
		filedownload( CommUtil.getOption("domean", "upload.image"), true, request,response );
	}
	
	/**
	 * 파일다운로드를 수행합니다.
	 * @param path 파일경로
	 * @param chk 경로보정여부라는데, 잘모르겠음.
	 * @param request request를 사용할 수 있도록 선언
	 * @param response response를 사용할 수 있도록 선언
	 * @throws Exception 예외처리
	 */
	public void filedownload(String path, boolean chk, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String fileName = request.getParameter("fileName");
		String originalName = request.getParameter("originalName");
		String realPath = "";
		
		originalName.trim();
		
		String browser = request.getHeader("User-Agent"); //파일 인코딩 
		if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){ 
			originalName = URLEncoder.encode(originalName,"UTF-8").replaceAll("\\+", "%20"); 
		} else { 
			originalName = new String(originalName.getBytes("UTF-8"), "ISO-8859-1"); 
		}
		
		if (chk){ // 경로 보정 여부
			 realPath = path + fileName.substring(0,4)+"/" + fileName;
		}else {
			realPath = path + fileName;
		} 

		File file1 = new File(realPath);
		if (!file1.exists()){
			return ;
		}
		// 파일명 지정
        response.setHeader("Content-Disposition", "attachment; fileName=\""+originalName+"\"");
        response.setContentType("application/octet-stream;");
        //response.setHeader("Content-Transfer-Encoding", "binary;");

        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(realPath);

        int ncount = 0;

        byte[] bytes = new byte[512];

        while((ncount = fis.read(bytes)) != -1 ) {
            os.write(bytes, 0, ncount);
        }

        fis.close();
        os.close();

	}
	
}
