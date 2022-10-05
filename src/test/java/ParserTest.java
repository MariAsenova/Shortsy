import syntatic.analyzer.Parser;
import syntatic.analyzer.Scanner;
import syntatic.analyzer.SourceFile;

import javax.swing.*;


public class ParserTest {
    private static final String EXAMPLES_DIR = "c:\\usr\\undervisning\\CMC\\IntLang\\examples";

    public static void main(String args[]) {
        JFileChooser fc = new JFileChooser(EXAMPLES_DIR);


        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            SourceFile in = new SourceFile(fc.getSelectedFile().getAbsolutePath());
            Scanner s = new Scanner(in);
            Parser p = new Parser(s);

            p.ParseProgram();
        }
    }
}
