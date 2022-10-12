package syntatic.analysis.test;

import lexical.analysis.Scanner;
import lexical.analysis.SourceFile;
import org.junit.jupiter.api.Test;
import syntatic.analysis.Parser;
import test.utils.constants.PathToTestFilesConstants;

/**
 * guidance to UnitTest naming convention and structure
 * https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-best-practices
 */
public class ParserTest {
    private String pathSourceTest;

    // add BeforeEach and AfterEach

    @Test
    public void assignmentOf_BooleanAndInteger_BooleanAndIntegerValuesAssignedToVariables() {
        // arrange
        pathSourceTest = PathToTestFilesConstants.ASSIGN_BOOL_AND_INT;
        SourceFile sourceFile = new SourceFile(pathSourceTest);
        Scanner scanner = new Scanner(sourceFile);
        Parser parser = new Parser(scanner);
        // act
        parser.parseProgram();
        // assert
    }

    @Test
    public void callOfFunction_WithOneArgument_ResultsInCorrectFunctionCall() {
        // arrange
        pathSourceTest = "src/test/resources/correct-call-of-func-with-argument.txt";
        SourceFile sourceFile = new SourceFile(pathSourceTest);
        Scanner scanner = new Scanner(sourceFile);
        Parser parser = new Parser(scanner);
        // act
        parser.parseProgram();
        // assert
    }
}
