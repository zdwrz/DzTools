import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import dztools.model.LunarUtil;


public class Test {
	public static void main(String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
	}
}
