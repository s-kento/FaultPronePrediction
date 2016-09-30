package extraction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	public List<BugReport> readCSV(String file) throws IOException, ParseException{
		List<BugReport> bugs = new ArrayList<BugReport>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] attr = line.split(",",0);
			bugs.add(new BugReport(attr));
		}

		br.close();
		return bugs;
	}
}
