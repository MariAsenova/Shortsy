
package ast;


public class CallExpression
	extends Expression
{
	public Identifier name;
	public ExpressionList listofExpressions;
	
	
	public CallExpression( Identifier name, ExpressionList listofExpressions)
	{
		this.name = name;
		this.listofExpressions = listofExpressions;
	}
}