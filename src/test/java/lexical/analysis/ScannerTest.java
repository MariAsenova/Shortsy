package lexical.analysis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import test.utils.constants.PathToTestFilesConstants;

public class ScannerTest {
    private static final Logger logger = LogManager.getLogger(ScannerTest.class);

    @Before
    public void setup() {
        System.setProperty("log4j.configurationFile", "src/main/resources/log4j2.properties");
    }

    @Test
    public void scanAssignmentOf_BooleanAndIntegerVariable_VariablesSuccessfullyInstantiated() {
        Scanner scanner = arrange(PathToTestFilesConstants.ASSIGN_BOOL_AND_INT);
        Token t = scanner.scan();
        while (t.kind != TokenKind.EOT) {
            logger.info(String.format("[%s] [%s]", t.kind, t.spelling));
            t = scanner.scan();
        }
        // assert with exception
    }

    private Scanner arrange(String sourceTestFile) {
        SourceFile in = new SourceFile(sourceTestFile);
        return new Scanner(in);
    }
}
