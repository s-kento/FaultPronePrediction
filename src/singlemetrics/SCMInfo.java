package singlemetrics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SCMInfo {
	private String className;
	private Integer[] metrics = new Integer[18];

	public SCMInfo(String className, Integer[] metrics) {
		setClassName(className);
		setMetrics(metrics);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = replace(CloneInfo.replace(className));
	}

	public Integer[] getMetrics() {
		return metrics;
	}

	public void setMetrics(Integer[] metrics) {
		this.metrics = metrics;
	}

	public boolean isFaulty() {
		if(getMetrics()[17]!=0)
			return true;
		else
			return false;
	}

	public String replace(String str) {
		String regex = "::";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		String result = m.replaceAll(".");
		return result.trim();
	}
}
