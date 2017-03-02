package weka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.cli.CommandLine;

import singlemetrics.CSVReader;
import singlemetrics.CloneInfo;
import singlemetrics.SCMInfo;

public class ARFF {
	public void addValue(CommandLine cl) throws IOException {
		String buffer="";
		PrintWriter pw = makeARFF(cl);
		CSVReader reader = new CSVReader();
		List<SCMInfo> scms = reader.readSCMCSV(cl);
		List<CloneInfo> clones = reader.readCloneCSV(cl.getOptionValue("c"));
		if (cl.hasOption("s")) {
			for (SCMInfo scm : scms) {
				for (int i = 0; i < 17; i++) {
					buffer+=scm.getMetrics()[i]+",";
				}
				if (cl.hasOption("c")) {
					CloneInfo clone = searchClone(scm, clones);
					if (clone.getClassName() != null) {// searchCloneの結果がnullでないならば，ARFFに書き出す
						for (Double value : clone.getMetrics()) {
							buffer+=value+",";
						}
					}else{
						break;
					}
				}
				if(cl.hasOption("b")){
					//TODO
				}
				pw.println(buffer);
				if (scm.isFaulty())
					pw.println("TRUE");
				else
					pw.println("FALSE");
			}
		}
		pw.close();
	}

	public PrintWriter makeARFF(CommandLine cl) throws IOException {
		File fileout = new File(cl.getOptionValue("o"));
		FileWriter filewriter = new FileWriter(fileout);
		BufferedWriter bw = new BufferedWriter(filewriter);
		PrintWriter pw = new PrintWriter(bw);

		pw.println("@relation Fault Prone Prediction\n");
		if (cl.hasOption("s")) {
			pw.println("@attribute CBO numeric");
			pw.println("@attribute DIT numeric");
			pw.println("@attribute FANIN  numeric");
			pw.println("@attribute FANOUT   numeric");
			pw.println("@attribute LCOM numeric");
			pw.println("@attribute NOC numeric");
			pw.println("@attribute NOA numeric");
			pw.println("@attribute NOAI numeric");
			pw.println("@attribute LOC numeric");
			pw.println("@attribute NOM numeric");
			pw.println("@attribute NOMI numeric");
			pw.println("@attribute NOPRA numeric");
			pw.println("@attribute NOPRM numeric");
			pw.println("@attribute NOPA numeric");
			pw.println("@attribute NOPM numeric");
			pw.println("@attribute RFC numeric");
			pw.println("@attribute WMC numeric\n");
		}
		if (cl.hasOption("c")) {
			pw.println("@attribute NOL numeric");
			pw.println("@attribute NOT numeric");
			pw.println("@attribute NOCL numeric");
			pw.println("@attribute ROC numeric");
			pw.println("@attribute NOF numeric");
		}
		if (cl.hasOption("b")) {
			// TODO
		}
		pw.println("@attribute FAULTY {TRUE, FALSE}\n");

		pw.println("@data");

		return pw;
	}

	public CloneInfo searchClone(SCMInfo bug, List<CloneInfo> clones) throws IOException {
		for (CloneInfo clone : clones) {
			if ((clone.getClassName()).equals(bug.getClassName())) {
				return clone;
			}
		}
		System.out.println(bug.getClassName());// 見つからなかったファイル(バグ情報csvには書いてるけど，実際のソースコードが見つからない)を出力
		CloneInfo clone = new CloneInfo();
		return clone;
	}

}
