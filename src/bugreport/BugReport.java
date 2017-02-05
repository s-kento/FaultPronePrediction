package bugreport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//bugreportの属性をフィールド変数にもつ
public class BugReport {
	int id;
	int bug_id;
	Calendar report_time;
	int report_timestamp;
	String status;
	String commit;
	int commit_timestamp;
	String[] file;

	public BugReport(String attr[]) throws ParseException{
		setId(Integer.parseInt(attr[0]));
		setBug_id(Integer.parseInt(attr[1]));
		setReport_time(stringToCalendar(attr[2]));
		setReport_timestamp(Integer.parseInt(attr[3]));
		setStatus(attr[4]);
		setCommit(attr[5]);
		setCommit_timestamp(Integer.parseInt(attr[6]));
		setFile(attr[7]);
	}

	public Calendar stringToCalendar(String str) throws ParseException{
		final String DATE_PATTERN="yyyy/MM/dd HH:mm";
		SimpleDateFormat dateformat = new SimpleDateFormat(DATE_PATTERN);
		Date date = new Date(dateformat.parse(str).getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBug_id() {
		return bug_id;
	}

	public void setBug_id(int bug_id) {
		this.bug_id = bug_id;
	}

	public Calendar getReport_time() {
		return report_time;
	}

	public void setReport_time(Calendar report_time) {
		this.report_time = report_time;
	}

	public int getReport_timestamp() {
		return report_timestamp;
	}

	public void setReport_timestamp(int report_timestamp) {
		this.report_timestamp = report_timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

	public int getCommit_timestamp() {
		return commit_timestamp;
	}

	public void setCommit_timestamp(int commit_timestamp) {
		this.commit_timestamp = commit_timestamp;
	}

	public String[] getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file.split(" ",0);
	}
}
