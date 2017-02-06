package eclipseJDT;

public class CloneInfo {
	private String className;
	private Double[] metrics = new Double[5];

	public CloneInfo(String className, Double[] metrics) {
		setClassName(className);
		setMetrics(metrics);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Double[] getMetrics() {
		return metrics;
	}

	public void setMetrics(Double[] metrics) {
		this.metrics = metrics;
	}
}
