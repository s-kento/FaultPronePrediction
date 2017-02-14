package singlemetrics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
	String csvBugFilePath = "D:\\fault-prone予測用データセット\\eclipse\\eclipse\\single-version-ck-oo.csv";
	String csvCloneFilePath="input\\eclipseJDT_s.csv";
	private List<BugInfo> bugs = new ArrayList<BugInfo>();
	private List<CloneInfo> clones = new ArrayList<CloneInfo>();

	public List<BugInfo> readBugCSV() throws IOException{
		FileReader fr = new FileReader(csvBugFilePath);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] info = line.split(";",0);
			BugInfo bug = new BugInfo(info[0],extractCKMetrics(info));
			bugs.add(bug);
		}

		br.close();
		return bugs;
	}

	public Integer[] extractCKMetrics(String[] info){
		Integer[] metrics= new Integer[18];
		for(int i=0;i<18;i++){
			metrics[i]=(int)Double.parseDouble(info[i+1]);
		}
		return metrics;
	}

	public List<CloneInfo> readCloneCSV() throws IOException{
		FileReader fr = new FileReader(csvCloneFilePath);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] info = line.split(",",0);
			CloneInfo clone = new CloneInfo(info[7],extractCloneMetrics(info));
			clones.add(clone);
		}

		br.close();
		return clones;
	}

	public Double[] extractCloneMetrics(String[] info){
		Double[] metrics= new Double[5];
		for(int i=0;i<5;i++){
			metrics[i]=Double.parseDouble(info[i+2]);
		}
		return metrics;
	}
}
