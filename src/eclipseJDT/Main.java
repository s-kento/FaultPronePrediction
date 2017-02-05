package eclipseJDT;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader();
		List<BugInfo> bugs = reader.readCSV();
		for(BugInfo bug:bugs){
			System.out.println(bug.getClassName());
		}
	}
}
