package eclipseJDT;

import java.io.IOException;
import java.util.List;

import weka.ARFF;

public class Main {
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader();
		List<BugInfo> bugs = reader.readBugCSV();
		List<CloneInfo> clones = reader.readCloneCSV();
		ARFF arff = new ARFF();
		arff.makeBugARFF(bugs);
	}
}
