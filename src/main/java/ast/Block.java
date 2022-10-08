
package ast;


public class Block
	extends AST
{
	public Declarations declarations;
	public ExpressionStatement expressionStatement;
	
	
	public Block( Declarations decs, ExpressionStatement stats )
	{
		this.declarations = decs;
		this.expressionStatement = stats;
	}
}