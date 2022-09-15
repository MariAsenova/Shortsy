package TokenManager;

public class Token {
    public TokenKind kind;
    public String spelling;

    public Token(TokenKind kind, String spelling){
        this.kind=kind;
        this.spelling=spelling;
        if( kind == TokenKind.IDENTIFIER )

            for( TokenKind tk: KEYWORDS )
                if( spelling.equals( tk.getSpelling() ) ) {
                    this.kind = tk;
                    break;
                }
    }
    private static final TokenKind[] KEYWORDS = { TokenKind.INPUT, TokenKind.OUTPUT, TokenKind.DO, TokenKind.ELSE, TokenKind.IF, TokenKind.RETURN, TokenKind.EQUALS, TokenKind.WHILE };
    public boolean isAssignOperator()
    {//since our assignment might not always use = for assignment maybe this has to be different
        if( kind == TokenKind.OPERATOR )
            return containsOperator( spelling, ASSIGNMENT_OPERATORS);
        else
            return false;
    }

    public boolean isAddMinusOperator()
    {
        if( kind == TokenKind.OPERATOR )
            return containsOperator( spelling, ADD_MINUS_OPERATORS);
        else
            return false;
    }

    public boolean isMultiplyDivideOperator()
    {
        if( kind == TokenKind.OPERATOR )
            return containsOperator( spelling, MULTIPLY_DIVIDE_OPERATORS);
        else
            return false;
    }


    private boolean containsOperator( String spelling, String OPS[] )
    {
        for( int i = 0; i < OPS.length; ++i )
            if( spelling.equals( OPS[i] ) )
                return true;

        return false;
    }
    private static final String ASSIGNMENT_OPERATORS[] =
            {
                    String.valueOf(TokenKind.ASSIGNMENT_OPERATOR),
            };


    private static final String ADD_MINUS_OPERATORS[] =
            {
                    "+",
                    "-",
            };


    private static final String MULTIPLY_DIVIDE_OPERATORS[] =
            {
                    "*",
                    "/",
            };
}
