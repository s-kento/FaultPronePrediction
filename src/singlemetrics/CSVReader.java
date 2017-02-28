package singlemetrics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
	String csvSCMFilePath = "D:\\fault-prone予測用データセット\\lucene\\lucene\\single-version-ck-oo.csv";
	//String csvCloneFilePath="input\\specificClone_60_kai.csv";
	String csvPastBugFilePath = "D:\\fault-prone予測用データセット\\lucene\\lucene\\bug-metrics.csv";
	private List<SCMInfo> bugs = new ArrayList<SCMInfo>();
	private List<CloneInfo> clones = new ArrayList<CloneInfo>();
	private List<PastBugInfo> pastBugs = new ArrayList<PastBugInfo>();

	public List<SCMInfo> readSCMCSV() throws IOException{
		FileReader fr = new FileReader(csvSCMFilePath);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] info = line.split(";",0);
			SCMInfo bug = new SCMInfo(info[0],extractCKMetrics(info));
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

	public List<CloneInfo> readCloneCSV(String csvCloneFilePath) throws IOException{
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

	public List<PastBugInfo> readPastBugCSV() throws IOException{
		FileReader fr = new FileReader(csvPastBugFilePath);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		while((line=br.readLine())!=null){
			String[] info = line.split(";",0);
			PastBugInfo pastBug = new PastBugInfo(info[0],extractPastBugMetrics(info));
			pastBugs.add(pastBug);
		}

		br.close();
		return pastBugs;
	}

	public Integer[] extractPastBugMetrics(String[] info){
		Integer[] metrics= new Integer[5];
		for(int i=0;i<5;i++){
			metrics[i]=Integer.parseInt(info[i]);
		}
		return metrics;
	}
}
