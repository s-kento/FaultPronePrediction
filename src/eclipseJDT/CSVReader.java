package eclipseJDT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
	String csvFilePath = "D:\\fault-prone予測\\eclipse\\eclipse\\single-version-ck-oo.csv";
	List<BugInfo> bugs = new ArrayList<BugInfo>();

	public List<BugInfo> readCSV() throws IOException{
		FileReader fr = new FileReader(csvFilePath);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] info = line.split(";",0);
			BugInfo bug = new BugInfo(info[0],extractMetrics(info));
			bugs.add(bug);
		}

		br.close();
		return bugs;
	}

	public Integer[] extractMetrics(String[] info){
		Integer[] metrics= new Integer[18];
		for(int i=0;i<18;i++){
			metrics[i]=(int)Double.parseDouble(info[i+1]);
		}
		return metrics;
	}
}
