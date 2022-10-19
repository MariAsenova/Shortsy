package syntatic.analysis.test;

import exceptions.SyntaticException;
import lexical.analysis.Scanner;
import lexical.analysis.SourceFile;
import org.junit.jupiter.api.Test;
import syntatic.analysis.Parser;
import test.utils.constants.PathToTestFilesConstants;

/**
 * guidance to UnitTest naming convention and structure
 * <a href="https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-best-practices"></a>
 */

//TODO add rainy scenarios of failing unit test to assure the right exceptions are thrown
public class ParserTest {

    @Test
    public void assignmentOf_BooleanAndInteger_BooleanAndIntegerValuesAssignedToVariables() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.ASSIGN_BOOL_AND_INT);
        parser.parseProgram();
        // assert with exception
    }

    @Test
    public void callOfFunction_WithOneArgument_ResultsInCorrectFunctionCall() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.CALL_FUNC_WITH_ARG);
        parser.parseProgram();
        // assert with exception
    }

    @Test
    public void declareFunction() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.DECLARATION_OF_FUNC);
        parser.parseProgram();
        // assert with exception
    }
    @Test
    public void DECLARATION_OF_IF_ELSE() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.DECLARATION_OF_IF_ELSE);
        parser.parseProgram();
        // assert with exception
    }
    @Test
    public void DECLARATION_OF_WHILE() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.DECLARATION_OF_WHILE);
        parser.parseProgram();
        // assert with exception
    }
    @Test
    public void DECLARATION_OF_DO_WITH_IF_ELSE() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.DECLARATION_OF_DO_WITH_IF_ELSE);
        parser.parseProgram();
        // assert with exception
    }
    @Test
    public void DECLARATION_OF_DO() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.DECLARATION_OF_DO);
        parser.parseProgram();
        // assert with exception
    }
    @Test
    public void INPUT_OUTPUT() throws SyntaticException {
        Parser parser = arrange(PathToTestFilesConstants.INPUT_OUTPUT);
        parser.parseProgram();
        // assert with exception
    }


    private Parser arrange(String pathSourceTest) {
        SourceFile sourceFile = new SourceFile(pathSourceTest);
        Scanner scanner = new Scanner(sourceFile);
        return new Parser(scanner);
    }
}
