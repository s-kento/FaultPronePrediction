package singlemetrics;

public class PastBugInfo {
	private String className;
	private Integer[] metrics = new Integer[5];

	public PastBugInfo(String className, Integer[] metrics) {
		setClassName(className);
		setMetrics(metrics);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = SCMInfo.replace(CloneInfo.replace(className));
	}

	public Integer[] getMetrics() {
		return metrics;
	}

	public void setMetrics(Integer[] metrics) {
		this.metrics = metrics;
	}
}
