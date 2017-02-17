package eclipseJDT;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.core.runtime.NullProgressMonitor;

public class CloneInfo {
	private String className;
	private Double[] metrics = new Double[5];

	public CloneInfo(String className, Double[] metrics) throws IOException {
		setClassName(className);
		setMetrics(metrics);
	}

	public CloneInfo() throws IOException{
		Double[] metrics={0.0,0.0,0.0,0.0,0.0};
		setMetrics(metrics);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) throws IOException {
		CompilationUnit unit = getAST(replace(className));
		MyVisitor visitor = new MyVisitor();
		unit.accept(visitor);
		this.className = visitor.packageName+"."+visitor.className;
	}

	public Double[] getMetrics() {
		return metrics;
	}

	public void setMetrics(Double[] metrics) {
		this.metrics = metrics;
	}

	public CompilationUnit getAST(String filePath) throws IOException {
		String source = Files.lines(Paths.get(filePath), Charset.forName("UTF-8"))
				.collect(Collectors.joining(System.getProperty("line.separator")));
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource(source.toCharArray());
		CompilationUnit unit = (CompilationUnit) parser.createAST(new NullProgressMonitor());

		return unit;
	}

	//余分なダブルクオーテーションを削除
	public static String replace(String str) {
		String regex = "\"";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		String result = m.replaceAll("");
		return result;
	}
}
