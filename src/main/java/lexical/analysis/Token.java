package lexical.analysis;

public class Token {

    public TokenKind kind;
    public String spelling;


    public Token( TokenKind kind, String spelling )
    {
        this.kind = kind;
        this.spelling = spelling;

        if( kind == TokenKind.IDENTIFIER )
            for( TokenKind tk: KEYWORDS )
                if( spelling.equals( tk.getSpelling() ) ) {
                    this.kind = tk;
                    break;
                }
    }


    public boolean isAssignOperator()
    {
        if( kind == TokenKind.OPERATOR )
            return containsOperator( spelling, ASSIGNOPS );
        else
            return false;
    }

    public boolean isAddOperator()
    {
        if( kind == TokenKind.OPERATOR )
            return containsOperator( spelling, ADDOPS );
        else
            return false;
    }

    public boolean isMulOperator()
    {
        if( kind == TokenKind.OPERATOR )
            return containsOperator( spelling, MULOPS );
        else
            return false;
    }


    private boolean containsOperator(String spelling, String[] OPS)
    {
        for (String op : OPS)
            if (spelling.equals(op))
                return true;

        return false;
    }

    private static final TokenKind[] KEYWORDS = { TokenKind.DECLARE, TokenKind.DECLARE_VAR_TYPE, TokenKind.DO, TokenKind.ELSE,  TokenKind.FUNC, TokenKind.IF,  TokenKind.RETURN, TokenKind.SAY, TokenKind.THEN, TokenKind.WHILE, TokenKind.VOID, TokenKind.INTEGER, TokenKind.BOOLEAN, TokenKind.INPUT, TokenKind.OUTPUT, TokenKind.ASSIGNMENT_OPERATOR, TokenKind.COMMA, TokenKind.SEMICOLON, TokenKind.LEFT_PARAM, TokenKind.RIGHT_PARAM, TokenKind.LEFT_BRACE, TokenKind.RIGHT_BRACE, TokenKind.INTEGER_LITERAL, TokenKind.BOOLEAN_LITERAL};


    private static final String[] ASSIGNOPS =
            {
                    "=",
            };


    private static final String[] ADDOPS =
            {
                    "+",
                    "-",
            };


    private static final String[] MULOPS =
            {
                    "*",
                    "/"
            };
}
