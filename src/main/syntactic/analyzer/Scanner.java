package main.syntactic.analyzer;

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
     * appends the current character to the current token,
     * then gets the next character from the src file
     */
    private void takeIt() {
        currentSpelling.append(currentChar);
        currentChar = sourceFile.getSource();
    }


}
