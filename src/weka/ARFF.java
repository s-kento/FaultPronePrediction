package weka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import eclipseJDT.BugInfo;
import eclipseJDT.CloneInfo;

public class ARFF {
	public void makeBugARFF(List<BugInfo> bugs) throws IOException {
		PrintWriter pw = makeARFF();
		for (BugInfo bug : bugs) {
			for (int value : bug.getMetrics()) {
				pw.print(value + ",");
			}
			if (bug.isFaulty())
				pw.println("TRUE");
			else
				pw.println("FALSE");
		}
		pw.close();
	}

	public void makeCloneARFF(BugInfo bug, CloneInfo clone) {

	}

	public PrintWriter makeARFF() throws IOException {
		File fileout = new File("result.arff");
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
		pw.println("@attribute LCOM numeric");
		pw.println("@attribute NOA numeric");
		pw.println("@attribute NOAI numeric");
		pw.println("@attribute LOC numeric");
		pw.println("@attribute NOM numeric");
		pw.println("@attribute NOMI numeric");
		pw.println("@attribute LCOM numeric");
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
}
