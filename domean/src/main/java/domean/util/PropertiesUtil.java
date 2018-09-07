package domean.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class PropertiesUtil {
	
	private static Logger logger = Logger.getLogger(PropertiesUtil.class.getName());
	
	
	
	/**
	 * 프로퍼티 파일읽은 값을 반환한다.
	 * @param propertiesFileName 프로퍼티파일명
	 * @param option 가져올 옵션
	 * @return 옵션의 데이터 값 반환
	 */
    public static String getOption(String propertiesFileName, String option){
        HashMap hashMap = PropertiesUtil.toProperties(propertiesFileName);
        String data = (String)hashMap.get(option);
        return data;
    }
    
    

    /**
     * properties를 읽어서 HashMap에 저장.
     * @param propertiesFileName 프로퍼티파일명
     * @return HashMap에 저장된값
     */
    public static HashMap<String, String> toProperties(String propertiesFileName){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        try{
            ResourceBundle rb = ResourceBundle.getBundle(propertiesFileName);
            Enumeration<?> enumer = rb.getKeys();

            while (enumer.hasMoreElements()){
                String bkey = (String) enumer.nextElement();
                hashMap.put(bkey, rb.getString(bkey));
            }
        } catch (Exception e) {
        	logger.severe("toPropertice ERROR");
        }
        return hashMap;
    }
    
}//END
