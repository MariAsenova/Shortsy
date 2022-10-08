
package ast;


public class IntLiteralExpression
	extends Expression
{
	public IntegerLiteral literal;
	
	
	public IntLiteralExpression(IntegerLiteral literal )
	{
		this.literal = literal;
	}
}