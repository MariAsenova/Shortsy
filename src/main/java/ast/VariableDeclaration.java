
package ast;


public class VariableDeclaration
	extends Declaration
{
	public Identifier identifier;
	
	
	public VariableDeclaration( Identifier id )
	{
		this.identifier = id;
	}
}