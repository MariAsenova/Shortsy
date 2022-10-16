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

    private Parser arrange(String pathSourceTest) {
        SourceFile sourceFile = new SourceFile(pathSourceTest);
        Scanner scanner = new Scanner(sourceFile);
        return new Parser(scanner);
    }
}
