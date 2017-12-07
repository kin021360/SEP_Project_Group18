package usermanagementsystem.datastructure;

import java.util.Date;

public class AnnualLeaveInfo {
	private int dayOfAnnualLeave;
	private Date startDate;
	private Date endDate;
	
	public AnnualLeaveInfo(int dayOfAnnualLeave, Date startDate, Date endDate) {
		this.dayOfAnnualLeave = dayOfAnnualLeave;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String toString() {
		return dayOfAnnualLeave + " " + startDate.getTime() + " " + endDate.getTime();
	}
	
	public int getDayOfAnnualLeave() {
		return dayOfAnnualLeave;
	}

	public void setDayOfAnnualLeave(int dayOfAnnualLeave) {
		this.dayOfAnnualLeave = dayOfAnnualLeave;
	}

	public Date getstartDate() {
		return startDate;
	}

	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getendDate() {
		return endDate;
	}

	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}
}
