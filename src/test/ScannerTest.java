package test;

import main.syntactic.analyzer.Scanner;
import main.syntactic.analyzer.SourceFile;
import main.syntactic.analyzer.Token;

public class ScannerTest {
    public static void main(String[] args) {
        SourceFile sourceFile = new SourceFile("C:/Users/Pál Jámbor/Desktop/example.txt");
        Scanner scanner = new Scanner(sourceFile);

        System.out.println(scanner.scan().kind);

    }
}
