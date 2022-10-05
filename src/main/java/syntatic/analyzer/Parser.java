package syntatic.analyzer;

import static syntatic.analyzer.TokenKind.*;

public class Parser {
    private Scanner scanner;
    private Token currentTerminal;
    public Parser(Scanner scanner){
        this.scanner= scanner;
        currentTerminal = scanner.scan();
    }
    public void ParseProgram(){
        parseBlock();
        if( currentTerminal.kind != EOT )
            System.out.println( "Tokens found after end of program" );
    }

    private void parseBlock()
    {// I think this should be how we make a function
        accept( DECLARE );
        parseDeclarations();
        accept( DO );
        parseStatements();
    }


    private void parseDeclarations()
    {
        while( currentTerminal.kind ==  EOT||
                currentTerminal.kind == FUNC )
            parseOneDeclaration();
    }


    private void parseOneDeclaration()
    {
        switch( currentTerminal.kind ) {
            case INTEGER:
                accept( INTEGERLITERAL );
                accept(DECLARE);
                accept( IDENTIFIER );
                accept( SEMICOLON );
                break;
            case BOOLEAN:
                accept( BOOLEANLITERAL );
                accept(DECLARE);
                accept( IDENTIFIER );
                accept( SEMICOLON );
                break;

            case FUNC:
                accept( FUNC );
                accept( IDENTIFIER );
                accept( LEFTPARAN );

                if( currentTerminal.kind == IDENTIFIER )
                    parseIdList();

                accept( RIGHTPARAN );
                parseBlock();
                accept( RETURN );
                parseExpression();
                accept( SEMICOLON );
                break;

            default:
                System.out.println( "var or func expected" );
                break;
        }
    }


    private void parseIdList()
    {
        accept( IDENTIFIER );

        while( currentTerminal.kind == COMMA ) {
            accept( COMMA );
            accept( IDENTIFIER );
        }
    }


    private void parseStatements()
    {
        while( currentTerminal.kind == IDENTIFIER ||
                currentTerminal.kind == OPERATOR ||
                currentTerminal.kind == INTEGERLITERAL ||
                currentTerminal.kind == LEFTPARAN ||
                currentTerminal.kind == IF ||
                currentTerminal.kind == WHILE ||
                currentTerminal.kind == INPUT  ||
                currentTerminal.kind == OUTPUT )
            parseOneStatement();
    }


    private void parseOneStatement()
    {switch( currentTerminal.kind ) {
        case IDENTIFIER:
        case INTEGERLITERAL:
        case OPERATOR:
        case LEFTPARAN:
            parseExpression();
            accept( SEMICOLON );
            break;

        case IF:
            accept( IF );
            parseExpression();
            parseStatements();
            if( currentTerminal.kind == ELSE ) {
                accept( ELSE );
                parseStatements();
            }

            break;

        case WHILE:
            accept( WHILE );
            parseExpression();
            accept( DO );
            parseStatements();
            accept( SEMICOLON );
            break;

        case INPUT:
            accept( INPUT );
            parseExpression();
            accept( SEMICOLON );
            break;
        case OUTPUT:
            accept( OUTPUT );
            parseExpression();
            accept( SEMICOLON );
            break;

        default:
            System.out.println( "Error in statement" );
            break;
    }
    }


    private void parseExpression()
    {
        parsePrimary();
        while( currentTerminal.kind == OPERATOR ) {
            accept( OPERATOR );
            parsePrimary();
        }
    }


    private void parsePrimary()
    {
        switch( currentTerminal.kind ) {
            case IDENTIFIER:
                accept( IDENTIFIER );

                if( currentTerminal.kind == LEFTPARAN ) {
                    accept( LEFTPARAN );

                    if( currentTerminal.kind == IDENTIFIER ||
                            currentTerminal.kind == INTEGERLITERAL ||
                            currentTerminal.kind == OPERATOR ||
                            currentTerminal.kind == LEFTPARAN )
                        parseExpressionList();


                    accept( RIGHTPARAN );
                }
                break;

            case INTEGERLITERAL:
                accept( INTEGERLITERAL );
                break;
            case BOOLEANLITERAL:
                accept( BOOLEANLITERAL );
                break;

            case OPERATOR:
                accept( OPERATOR );
                parsePrimary();
                break;

            case LEFTPARAN:
                accept( LEFTPARAN );
                parseExpression();
                accept( RIGHTPARAN );
                break;

            default:
                System.out.println( "Error in primary" );
                break;
        }
    }


    private void parseExpressionList()
    {
        parseExpression();
        while( currentTerminal.kind == COMMA ) {
            accept( COMMA );
            parseExpression();
        }
    }


    private void accept( TokenKind expected )
    {
        if( currentTerminal.kind == expected )
            currentTerminal = scanner.scan();
        else
            System.out.println( "Expected token of kind " + expected );
    }
}
