package domean.common;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import domean.member.controller.MemberController;

public class CommUtil {
	
	private static Logger logger = Logger.getLogger(CommUtil.class.getName());
	/**
	 * properties에 대한 값 리턴.
	 * @param filename properties파일명
	 * @param key properties에서 사용하려는 변수명
	 * @return properties에서 읽은 값을 리턴한다.
	 */
    public static String getOption(String filename, String key){
        HashMap hashMap = CommUtil.toProperties(filename);
        String data = (String)hashMap.get(key);
        return data;
    }
    
    /**
     * properties를 읽어서 HashMap에 저장.
     * @param resourceName
     * @return HashMap에 저장된값
     */
    public static HashMap<String, String> toProperties(String resourceName){
        HashMap<String, String> hashMap = new HashMap<String, String>();

        try{
            ResourceBundle rb = ResourceBundle.getBundle(resourceName);
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
    
}
