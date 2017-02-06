package eclipseJDT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BugInfo {
	private String className;
	private Integer[] metrics = new Integer[18];
	private boolean fault;

	public BugInfo(String className, Integer[] metrics) {
		setClassName(className);
		setMetrics(metrics);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = replace(className);
	}

	public Integer[] getMetrics() {
		return metrics;
	}

	public void setMetrics(Integer[] metrics) {
		this.metrics = metrics;
	}

	public boolean isFaulty() {
		return fault;
	}

	public String replace(String str) {
		String regex = "::";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		String result = m.replaceAll(".");
		return result;
	}
}
