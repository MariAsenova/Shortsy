package syntatic.analyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static syntatic.analyzer.TokenKind.*;

public class Parser {
    private final Scanner scanner;
    private Token currentTerminal;
    private static final Logger logger = LogManager.getLogger(Parser.class);

    public Parser(Scanner scanner) {
        System.setProperty("log4j.configurationFile", "src/main/resources/log4j2.properties");
        this.scanner = scanner;
        currentTerminal = scanner.scan();
    }

    public void ParseProgram() {
        parseBlock();
        if (currentTerminal.kind != EOT)
            logger.error("Tokens found after end of program");
    }

    private void parseBlock() {// I think this should be how we make a function
        accept(DECLARE);
        parseDeclarations();
        accept(DO);
        parseStatements();
    }


    private void parseDeclarations() {
        while (currentTerminal.kind == EOT ||
                currentTerminal.kind == FUNC)
            parseOneDeclaration();
    }


    private void parseOneDeclaration() {
        switch (currentTerminal.kind) {
            case INTEGER:
                accept(INTEGERLITERAL);
                accept(DECLARE);
                accept(IDENTIFIER);
                accept(SEMICOLON);
                break;
            case BOOLEAN:
                accept(BOOLEANLITERAL);
                accept(DECLARE);
                accept(IDENTIFIER);
                accept(SEMICOLON);
                break;

            case FUNC:
                accept(FUNC);
                accept(IDENTIFIER);
                accept(LEFTPARAN);

                if (currentTerminal.kind == IDENTIFIER)
                    parseIdList();

                accept(RIGHTPARAN);
                parseBlock();
                accept(RETURN);
                parseExpression();
                accept(SEMICOLON);
                break;

            default:
                logger.error("Variable or function expected");
                break;
        }
    }

    private void parseIdList() {
        accept(IDENTIFIER);

        while (currentTerminal.kind == COMMA) {
            accept(COMMA);
            accept(IDENTIFIER);
        }
    }

    private void parseStatements() {
        while (currentTerminal.kind == IDENTIFIER ||
                currentTerminal.kind == OPERATOR ||
                currentTerminal.kind == INTEGERLITERAL ||
                currentTerminal.kind == LEFTPARAN ||
                currentTerminal.kind == IF ||
                currentTerminal.kind == WHILE ||
                currentTerminal.kind == INPUT ||
                currentTerminal.kind == OUTPUT)
            parseOneStatement();
    }

    private void parseOneStatement() {
        switch (currentTerminal.kind) {
            case IDENTIFIER:
            case INTEGERLITERAL:
            case OPERATOR:
            case LEFTPARAN:
                parseExpression();
                accept(SEMICOLON);
                break;

            case IF:
                accept(IF);
                parseExpression();
                parseStatements();
                if (currentTerminal.kind == ELSE) {
                    accept(ELSE);
                    parseStatements();
                }

                break;

            case WHILE:
                accept(WHILE);
                parseExpression();
                accept(DO);
                parseStatements();
                accept(SEMICOLON);
                break;

            case INPUT:
                accept(INPUT);
                parseExpression();
                accept(SEMICOLON);
                break;
            case OUTPUT:
                accept(OUTPUT);
                parseExpression();
                accept(SEMICOLON);
                break;

            default:
                logger.error("Error found in statement");
                break;
        }
    }


    private void parseExpression() {
        parsePrimary();
        while (currentTerminal.kind == OPERATOR) {
            accept(OPERATOR);
            parsePrimary();
        }
    }


    private void parsePrimary() {
        switch (currentTerminal.kind) {
            case IDENTIFIER:
                accept(IDENTIFIER);

                if (currentTerminal.kind == LEFTPARAN) {
                    accept(LEFTPARAN);

                    if (currentTerminal.kind == IDENTIFIER ||
                            currentTerminal.kind == INTEGERLITERAL ||
                            currentTerminal.kind == OPERATOR ||
                            currentTerminal.kind == LEFTPARAN)
                        parseExpressionList();


                    accept(RIGHTPARAN);
                }
                break;

            case INTEGERLITERAL:
                accept(INTEGERLITERAL);
                break;
            case BOOLEANLITERAL:
                accept(BOOLEANLITERAL);
                break;

            case OPERATOR:
                accept(OPERATOR);
                parsePrimary();
                break;

            case LEFTPARAN:
                accept(LEFTPARAN);
                parseExpression();
                accept(RIGHTPARAN);
                break;

            default:
                logger.error("Error occurred in while primary parsing");
                break;
        }
    }


    private void parseExpressionList() {
        parseExpression();
        while (currentTerminal.kind == COMMA) {
            accept(COMMA);
            parseExpression();
        }
    }


    private void accept(TokenKind expected) {
        if (currentTerminal.kind == expected)
            currentTerminal = scanner.scan();
        else
            logger.error(String.format("Expected token of kind [%s]", expected));
    }
}
