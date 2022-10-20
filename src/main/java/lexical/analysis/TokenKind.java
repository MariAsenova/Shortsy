package lexical.analysis;

public enum TokenKind {
    DECLARE("go"),
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
    DECLARE_VAR_TYPE(">"),
    ASSIGNMENT_OPERATOR("="),

    COMMA(","),
    SEMICOLON(";"),
    LEFT_PARAM("("),
    RIGHT_PARAM(")"),
    LEFT_BRACE("{"),
    RIGHT_BRACE("}"),

    EQUALS("=="),
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
