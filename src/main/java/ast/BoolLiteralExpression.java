
package ast;


public class BoolLiteralExpression
	extends Expression
{
	public BooleanLiteral literal;


	public BoolLiteralExpression(BooleanLiteral literal )
	{
		this.literal = literal;
	}
}