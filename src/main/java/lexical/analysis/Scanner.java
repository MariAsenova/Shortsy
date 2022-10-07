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
    private boolean isBoolean(char c){
        return(c=='t'||c=='f');
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

    /**
     * Checks if an int or bool has been declares
     *
     * @param curCharacter  i for int or b for bool
     * @param nextCharacter > as identifier char
     * @return whether is a type of int or bool
     */
    private boolean isIdentifier(char curCharacter, char nextCharacter) {
        Character boolChar = 'b';
        Character intChar = 'i';
        Character currentChar = curCharacter;
        Character nextChar = nextCharacter;

        return ((currentChar.equals(boolChar) && nextChar.equals('>'))|| (currentChar.equals(intChar) && nextChar.equals('>')));
    }

    private TokenKind scanToken() {
        if(isBoolean(currentChar)){
            takeIt();
            while (isBoolean(currentChar)) takeIt();

            return TokenKind.BOOLEAN;
        }
        else if( isLetter( currentChar ) ) {
            takeIt();
            while( isLetter( currentChar ) || isDigit( currentChar ) )
                takeIt();

            return TokenKind.IDENTIFIER;
        } else if (isDigit(currentChar)) {
            takeIt();
            while (isDigit(currentChar)) takeIt();

            return TokenKind.INTEGER;

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
                return TokenKind.LEFTPARAN;

            case ')':
                takeIt();
                return TokenKind.RIGHTPARAN;

            case '{':
                takeIt();
                return TokenKind.LEFTBRACES;

            case '}':
                takeIt();
                return TokenKind.RIGHTBRACES;
            case '>':
                takeIt();
                return TokenKind.DECLARE;
            case '=':
                takeIt();
                return TokenKind.ASSIGNMENT_OPERATOR;

            case SourceFile.EOT:
                return TokenKind.EOT;

            default:
                takeIt();
                return TokenKind.ERROR;
        }
    }



    public Token scan()
    {
        while( currentChar == '#' || currentChar == '\n' ||
                currentChar == '\r' || currentChar == '\t' ||
                currentChar == ' ' )
            scanSeparator();

        currentSpelling = new StringBuffer();
        TokenKind kind = scanToken();

        return new Token( kind, new String( currentSpelling ) );
    }
}
