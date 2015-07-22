package dztools.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dztools.model.Lunar;
import dztools.model.LunarUtil;

@ManagedBean(name="calBean")
@SessionScoped
public class CalendarInfoBean implements Serializable{

	private static final long serialVersionUID = -5672206503998832L;
	private static final int MAX_NUMBER_DAY = 56;
	private Calendar calendar;
	private List<List<Lunar>> calData;
	public CalendarInfoBean(){
		calendar = Calendar.getInstance();
		//calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.setTimeZone(TimeZone.getDefault());
		initData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}
	
	public void initData(int year, int month){
		calData = new ArrayList<List<Lunar>>();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1 * cal.get(Calendar.DAY_OF_WEEK) + 1);//this is the start point

		LunarUtil lunar =null;
		List<Lunar> weekList = null;
		for(int i = 0 ; i < MAX_NUMBER_DAY ; i ++){
			if(i % 7 == 0){
				weekList = new ArrayList<Lunar>();
				calData.add(weekList);
			}
			Lunar lunarRow = new Lunar();
			lunar = new LunarUtil(cal);
			lunarRow.setDisplyDate(lunar.toString());
			lunarRow.setDay(lunar.getDay());
			lunarRow.setMonth(lunar.getMonth());
			lunarRow.setYear(lunar.getYear());
			lunarRow.setLeap(lunar.isLeap());
			lunarRow.setSolarDate(cal.get(Calendar.MONTH)+1+ "月" + cal.get(Calendar.DAY_OF_MONTH) + "日");
			if(isToday(cal)){
				lunarRow.setToday(true);
			}
			weekList.add(lunarRow);
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	private boolean isToday(Calendar calendar2) {
		if(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)==calendar2.get(Calendar.DAY_OF_MONTH)
				&&Calendar.getInstance().get(Calendar.MONTH)==calendar2.get(Calendar.MONTH)
				&&Calendar.getInstance().get(Calendar.YEAR)==calendar2.get(Calendar.YEAR)){
			return true;
		}
		return false;
	}

	public int getCurrentYear(){
		return calendar.get(Calendar.YEAR);
	}

	public int getCurrentMonth(){
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	public void actionNextMonth(){
		calendar.add(Calendar.MONTH, 1);
		initData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}

	public void actionPrevMonth(){
		calendar.add(Calendar.MONTH, -1);
		initData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}
	
	public void actionToday(){
		calendar = Calendar.getInstance();
		initData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}

	public void actionNextYear(){
		calendar.add(Calendar.YEAR, 1);
		initData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}
	
	public void actionPrevYear(){
		calendar.add(Calendar.YEAR, -1);
		initData(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
	}
	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public List<List<Lunar>> getCalData() {
		return calData;
	}

	public void setCalData(List<List<Lunar>> calData) {
		this.calData = calData;
	}
}
