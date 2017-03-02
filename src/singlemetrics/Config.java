package singlemetrics;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Config {
	public CommandLine getOptions(String[] args) throws ParseException{
		Options options = new Options();
		options.addOption("p","project",true,"ターゲットプロジェクト");
		options.addOption("s","scm",false,"SCMメトリクス");
		options.addOption("c","clone",true,"クローンメトリクス");
		options.addOption("b","bug",false,"バグメトリクス");
		options.addOption("o","output",true,"出力ファイル名");

		CommandLineParser parser = new BasicParser();
		CommandLine commandLine;
		commandLine = parser.parse(options, args);

		return commandLine;
	}
}
