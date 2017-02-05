package eclipseJDT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
	static String csvFilePath = "D:\\fault-prone予測\\eclipse\\eclipse\\single-version-ck-oo.csv";

	public void readCSV() throws IOException{
		List<BugInfo> bugs = new ArrayList<BugInfo>();
		FileReader fr = new FileReader(csvFilePath);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] attr = line.split(";",0);

		}

		br.close();
	}
}
