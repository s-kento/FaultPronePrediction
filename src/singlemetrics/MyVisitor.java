package singlemetrics;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;;

public class MyVisitor extends ASTVisitor {
	public String packageName;
	public String className;

	@Override
	public boolean visit(PackageDeclaration node){
		packageName=node.getName().toString();
		return true;
	}

	@Override
	public boolean visit(TypeDeclaration node){
		className=node.getName().toString();
		return false;
	}
}
