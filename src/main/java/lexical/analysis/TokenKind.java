package lexical.analysis;

public enum TokenKind {
    IDENTIFIER,
    INTEGER_LITERAL,
    BOOLEANLITERAL,
    OPERATOR,
    DO( "do" ),
    ELSE( "el" ),
    FUNC( "func" ),
    IF( "if" ),
    RETURN( "ret" ),
    SAY( "say" ),
    THEN( "then" ),

    WHILE( "whl" ),
    VOID("voi"),
    INTEGER("i"),
    BOOLEAN("b"),
    INPUT("in"),
    OUTPUT("out"),
    DECLARE(">"),
    ASSIGNMENT_OPERATOR("="),

    COMMA( "," ),
    SEMICOLON( ";" ),
    LEFT_PARAN( "(" ),
    RIGHTPARAN( ")" ),
    RIGHTBRACES("{"),
    LEFTBRACES("}"),


    EOT,

    ERROR;


    private String spelling = null;


    TokenKind()
    {
    }


    TokenKind( String spelling )
    {
        this.spelling = spelling;
    }


    public String getSpelling()
    {
        return spelling;
    }
}
