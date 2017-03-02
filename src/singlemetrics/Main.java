package singlemetrics;

import java.io.IOException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import weka.ARFF;

public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		Config conf = new Config();
		CommandLine cl = conf.getOptions(args);
		ARFF arff = new ARFF();
		arff.addValue(cl);
	}
}
