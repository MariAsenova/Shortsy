import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import syntatic.analyzer.Scanner;
import syntatic.analyzer.SourceFile;
import syntatic.analyzer.Token;
import syntatic.analyzer.TokenKind;

import javax.swing.*;

public class ScannerTest {

    // TODO make into a class with unit tests instead
    // import .txt files for testing into C:\git\shortsy-compiler\src\test\resources instead of local machine
    /**
     * Example of how to use the logger
     * 1) create a private field of type Logger initiated with the name of the class in which is used
     * 2) Set the system property of log4j.configurationFile to point to the location where the log4j properties are defined
     */
    private static final String EXAMPLES_DIR = "C:/Users/Pál Jámbor/Desktop/example.txt";
    private static final Logger logger = LogManager.getLogger(ScannerTest.class);

    public static void main(String[] args)
    {
        System.setProperty("log4j.configurationFile", "src/main/resources/log4j2.properties");
        logger.debug(String.format("Testing log with log4j from: %s", Scanner.class.getName()));

        JFileChooser fc = new JFileChooser( EXAMPLES_DIR );

        if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            SourceFile in = new SourceFile( fc.getSelectedFile().getAbsolutePath() );
            Scanner s = new Scanner( in );

            Token t = s.scan();
            while( t.kind != TokenKind.EOT ) {
                System.out.println( t.kind + " " + t.spelling );

                t = s.scan();
            }
        }
    }
}
