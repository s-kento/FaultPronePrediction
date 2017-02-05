package eclipseJDT;

public class BugInfo {
	private String className;
	private Integer[] metrics = new Integer[17];
	private boolean fault;

	public BugInfo(String className, Integer[] metrics){
		setClassName(className);
		setMetrics(metrics);
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer[] getMetrics() {
		return metrics;
	}
	public void setMetrics(Integer[] metrics) {
		this.metrics = metrics;
	}
	public boolean isFaulty(){
		return fault;
	}
}
