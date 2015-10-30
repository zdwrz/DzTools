package dztools.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="dateCalBean")
@SessionScoped
public class DateCalculatorBean implements Serializable{

	private static final long serialVersionUID = -5123080510420887819L;
	private Date inputDate;
	private Integer inputNumOfDays;
	private Date result;
	private Date result60;
	private Date result90;
	private Date result120;
	
	public void actionCal(){
		if(inputDate == null){
			inputDate = new Date();
		}
		calFixed();
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.DAY_OF_YEAR, inputNumOfDays);
		result = cal.getTime();
	}
	
	private void calFixed() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.DAY_OF_YEAR, 60);
		result60 = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 30);
		result90 = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 30);
		result120 = cal.getTime();
	}

	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Integer getInputNumOfDays() {
		return inputNumOfDays;
	}
	public void setInputNumOfDays(Integer inputNumOfDays) {
		this.inputNumOfDays = inputNumOfDays;
	}
	public Date getResult() {
		return result;
	}
	public void setResult(Date result) {
		this.result = result;
	}

	public Date getResult60() {
		return result60;
	}

	public void setResult60(Date result60) {
		this.result60 = result60;
	}

	public Date getResult90() {
		return result90;
	}

	public void setResult90(Date result90) {
		this.result90 = result90;
	}

	public Date getResult120() {
		return result120;
	}

	public void setResult120(Date result120) {
		this.result120 = result120;
	}
}
