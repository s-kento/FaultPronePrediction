package eclipseJDT;

import java.io.IOException;
import java.util.List;

import weka.ARFF;

public class Main {
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader();
		List<BugInfo> bugs = reader.readBugCSV();
		ARFF arff = new ARFF();
		if (Integer.parseInt(args[2]) == 0) {
			arff.makeBugARFF(bugs, args[0]);
		}
		if (Integer.parseInt(args[2]) == 1){
			List<CloneInfo> clones = reader.readCloneCSV(args[0]);
			arff.makeCloneARFF(bugs, clones, args[1]);
		}
	}
}
