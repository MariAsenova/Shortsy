package lexical.analysis;

public enum TokenKind {
    IDENTIFIER,
    INTEGER_LITERAL,
    BOOLEAN_LITERAL,
    OPERATOR,
    DO("do"),
    ELSE("el"),
    FUNC("func"),
    IF("if"),
    RETURN("ret"),
    SAY("say"),
    THEN("then"),

    WHILE("whl"),
    VOID("voi"),
    INTEGER("i"),
    BOOLEAN("b"),
    INPUT("in"),
    OUTPUT("out"),
    DECLARE(">"),
    ASSIGNMENT_OPERATOR("="),

    COMMA(","),
    SEMICOLON(";"),
    LEFT_PARAM("("),
    RIGHT_PARAM(")"),
    RIGHT_BRACE("{"),
    LEFT_BRACE("}"),


    EOT,

    ERROR;


    private String spelling = null;


    TokenKind() {
    }


    TokenKind(String spelling) {
        this.spelling = spelling;
    }


    public String getSpelling() {
        return spelling;
    }
}
