
 
package ast;


public class OutStatement
	extends Statement
{
	public Expression exp;
	
	
	public OutStatement(Expression exp )
	{
		this.exp = exp;
	}
}