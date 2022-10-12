
package ast;


public class IfStatement
	extends Statement
{
	public Expression exp;
	public Statements ifStatement;
	public Statements elseStatement;
	
	
	public IfStatement( Expression exp, Statements thenPart, Statements elseStatement)
	{
		this.exp = exp;
		this.ifStatement = thenPart;
		this.elseStatement = elseStatement;
	}
}