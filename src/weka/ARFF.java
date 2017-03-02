package weka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import singlemetrics.CloneInfo;
import singlemetrics.SCMInfo;

public class ARFF {
	public void makeSCMARFF(List<SCMInfo> bugs, String output) throws IOException {
		PrintWriter pw = makeARFF(output);
		for (SCMInfo bug : bugs) {
			for (int i = 0; i < 17; i++) {
				pw.print(bug.getMetrics()[i] + ",");
			}
			if (bug.isFaulty())
				pw.println("TRUE");
			else
				pw.println("FALSE");
		}
		pw.close();
	}

	public void makeCloneARFF(List<SCMInfo> bugs, List<CloneInfo> clones, String output) throws IOException {
		PrintWriter pw = makeARFFwithClone(output);
		for (SCMInfo bug : bugs) {
			CloneInfo clone = searchClone(bug, clones);
			if (clone.getClassName() != null) {//searchCloneの結果がnullでないならば，ARFFに書き出す
				for (int i = 0; i < 17; i++) {
					pw.print(bug.getMetrics()[i] + ",");
				}
				for (Double value : clone.getMetrics()) {
					pw.print(value + ",");
				}
				if (bug.isFaulty())
					pw.println("TRUE");
				else
					pw.println("FALSE");
			}
		}
		pw.close();
	}

	public PrintWriter makeARFF(String output) throws IOException {
		File fileout = new File(output);
		FileWriter filewriter = new FileWriter(fileout);
		BufferedWriter bw = new BufferedWriter(filewriter);
		PrintWriter pw = new PrintWriter(bw);

		pw.println("@relation CKMetrics\n");
		// 1
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

		pw.println("@attribute FAULTY {TRUE, FALSE}\n");

		pw.println("@data");

		return pw;
	}

	public PrintWriter makeARFFwithClone(String output) throws IOException {
		File fileout = new File(output);
		FileWriter filewriter = new FileWriter(fileout);
		BufferedWriter bw = new BufferedWriter(filewriter);
		PrintWriter pw = new PrintWriter(bw);

		pw.println("@relation CKMetrics\n");
		// 1
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

		pw.println("@attribute NOL numeric");
		pw.println("@attribute NOT numeric");
		pw.println("@attribute NOCL numeric");
		pw.println("@attribute ROC numeric");
		pw.println("@attribute NOF numeric");

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
		System.out.println(bug.getClassName());//見つからなかったファイル(バグ情報csvには書いてるけど，実際のソースコードが見つからない)を出力
		CloneInfo clone = new CloneInfo();
		return clone;
	}


}
