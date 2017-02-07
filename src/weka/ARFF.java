package weka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ARFF {
	public void makeARFF() throws IOException{
		File fileout = new File("output.arff");
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



		pw.println("@data");
	}
}
