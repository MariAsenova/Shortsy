import syntatic.analyzer.Scanner;
import syntatic.analyzer.SourceFile;
import syntatic.analyzer.Token;
import syntatic.analyzer.TokenKind;

import javax.swing.*;

public class ScannerTest {

    // TODO make into a class with unit tests instead
    // import .txt files for testing into C:\git\shortsy-compiler\src\test\resources instead of local machine
    private static final String EXAMPLES_DIR = "C:/Users/Pál Jámbor/Desktop/example.txt";


    public static void main( String args[] )
    {
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
