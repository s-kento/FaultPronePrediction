package singlemetrics;

import java.io.IOException;
import java.util.List;

import weka.ARFF;

public class Main {
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader();
		List<BugInfo> bugs = reader.readBugCSV();
		List<CloneInfo> clones = reader.readCloneCSV();
		ARFF arff = new ARFF();
		if (Integer.parseInt(args[1]) == 0)
			arff.makeBugARFF(bugs, args[0]);
		if (Integer.parseInt(args[1]) == 1)
			arff.makeCloneARFF(bugs, clones, args[0]);
	}
}
