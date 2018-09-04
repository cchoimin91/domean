package domean.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 현재시간을  format 형식의 형태로 반환한다.
	 * @param format format형식
	 * @return String타입 포멧형식으로 변환된 현재시간
	 */
	public static String getCurrentTime(String format) {
		SimpleDateFormat simple = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		String result = simple.format(calendar.getTime()).toString();
		return result;
	}

}
