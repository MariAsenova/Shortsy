package test;

import main.syntactic.analyzer.Scanner;
import main.syntactic.analyzer.SourceFile;
import main.syntactic.analyzer.Token;
import main.syntactic.analyzer.TokenKind;

import javax.swing.*;

public class ScannerTest {
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
