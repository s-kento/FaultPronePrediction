package eclipseJDT;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader();
		List<BugInfo> bugs = reader.readBugCSV();
		List<CloneInfo> clones = reader.readCloneCSV();
		int bugNum=0;
		for (BugInfo bug : bugs) {
			if (bug.getMetrics()[17] != 0){
				System.out.println(bug.getClassName());
				bugNum++;
			}
		}
		System.out.println("バグ含有率は"+(double)bugNum/(double)bugs.size());

	}
}
