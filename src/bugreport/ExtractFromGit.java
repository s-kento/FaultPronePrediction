package bugreport;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

//JGitを用いてリポジトリを取得するクラス
public class ExtractFromGit {
	public static void main(String[] args) throws IOException, ParseException {
		CSVReader csvr = new CSVReader();
		List<BugReport> bugs = csvr.readCSV(args[0]);
		for(BugReport bug:bugs){
			System.out.println(bug.getCommit());
		}
	}
}
