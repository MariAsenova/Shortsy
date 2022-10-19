package lexical.analysis;

public class Scanner {
    private SourceFile sourceFile;
    private char currentChar;
    private StringBuffer currentSpelling;

    public Scanner(SourceFile sourceFile) {
        this.sourceFile = sourceFile;
        currentChar = sourceFile.getSource();
        currentSpelling = new StringBuffer();
    }

    /**
     * Appends the current character to the current token,
     * then gets the next character from the src file
     */
    private void takeIt() {
        currentSpelling.append(currentChar);
        currentChar = sourceFile.getSource();
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean isBooleanValue(char c) {
        return (c == 't' || c == 'f');
    }

    private boolean isBoolean(char curCharacter) {
        return curCharacter == 'b';
    }

    private boolean isInteger(char curCharacter) {
        return curCharacter == 'i';
    }

    private boolean isLessThanSign(char curCharacter) {
        return curCharacter == '>';
    }

    private void scanSeparator() {
        switch (currentChar) {
            case '#' -> {
                takeIt();
                while (currentChar != SourceFile.EOL && currentChar != SourceFile.EOT) takeIt();
                if (currentChar == SourceFile.EOL) takeIt();
            }
            case ' ', '\n', '\r', '\t' -> takeIt();
        }
    }

    private TokenKind scanToken() {
         if (isLetter(currentChar)) {
            if(currentChar == 'b'){
                takeIt();
                if(currentChar=='>'){
                    return TokenKind.BOOLEAN;
                }
                else{
                    while (isLetter(currentChar) || isDigit(currentChar)) {
                        takeIt();
                    } return TokenKind.IDENTIFIER;
                }
            }
             if(currentChar == 'i'){
                 takeIt();
                 if(currentChar=='>'){
                     return TokenKind.INTEGER;
                 }
                 else{
                     while (isLetter(currentChar) || isDigit(currentChar)) {
                         takeIt();
                     } return TokenKind.IDENTIFIER;
                 }
             }



            while (isLetter(currentChar) || isDigit(currentChar)) {
                takeIt();
            }
            if(currentSpelling.toString().equals("func")){
                return TokenKind.FUNC;
            }
            if(currentSpelling.toString().equals("while")){
                return TokenKind.WHILE;
            }
            if (currentSpelling.length()==1 && isBooleanValue(currentSpelling.charAt(0))) {
                return TokenKind.BOOLEAN_LITERAL;
            }
            return TokenKind.IDENTIFIER;
        } else if (isDigit(currentChar)) {
            takeIt();
            while (isDigit(currentChar)) {
                takeIt();
            }
            return TokenKind.INTEGER_LITERAL;
        }

        switch (currentChar) {
            case '+':
            case '-':
            case '*':
            case '/':
                takeIt();
                return TokenKind.OPERATOR;

            case ',':
                takeIt();
                return TokenKind.COMMA;

            case ';':
                takeIt();
                return TokenKind.SEMICOLON;

            case '(':
                takeIt();
                return TokenKind.LEFT_PARAM;

            case ')':
                takeIt();
                return TokenKind.RIGHT_PARAM;

            case '{':
                takeIt();
                return TokenKind.LEFT_BRACE;

            case '}':
                takeIt();
                return TokenKind.RIGHT_BRACE;
            case '>':
                takeIt();
                return TokenKind.DECLARE_VAR_TYPE;
            case '=':
                takeIt();
                if(currentChar == '='){
                    takeIt();
                    return TokenKind.EQUALS;
                }
                return TokenKind.ASSIGNMENT_OPERATOR;

            case SourceFile.EOT:
                return TokenKind.EOT;

            default:
                takeIt();
                return TokenKind.ERROR;
        }
    }


    public Token scan() {
        while (currentChar == '#' || currentChar == '\n' || currentChar == '\r' || currentChar == '\t' || currentChar == ' ')
            scanSeparator();

        currentSpelling = new StringBuffer();
        TokenKind kind = scanToken();

        return new Token(kind, new String(currentSpelling));
    }
}
