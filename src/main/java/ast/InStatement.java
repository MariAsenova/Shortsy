
package ast;


public class InStatement
	extends Statement
{
	public Expression exp;


	public InStatement(Expression exp )
	{
		this.exp = exp;
	}
}