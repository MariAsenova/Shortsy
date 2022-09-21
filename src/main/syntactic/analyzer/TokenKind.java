package main.syntactic.analyzer;

public enum TokenKind {
    IDENTIFIER,
    OPERATOR,
    ELSE("el"),
    IF("if"),
    COMMA( "," ),
    SEMICOLON( ";" ),
    LEFT_PARENTHESIS( "(" ),
    RIGHT_PARENTHESIS( ")" ),
    LEFT_BRACE("{"),
    RIGHT_BRACE("}"),
    WHILE("whl"),
    DO("do"),
    INPUT("in"),
    OUTPUT("out"),
    INTEGER("i"),
    BOOLEAN("b"),
    VOID("voi"),
    TYPE_IDENTIFIER(">"),
    METHOD_DECLARATION("func"),
    RETURN("ret"),
    EQUALS("="),
    ASSIGNMENT_OPERATOR("=="),
    EOT,
    ERROR;



    private String spelling = null;
    private TokenKind() {
    }
    private TokenKind(String spelling){

    }
    public String getSpelling()
    {
        return spelling;
    }

}
