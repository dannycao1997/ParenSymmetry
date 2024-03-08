import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {         // implement this method
        int balance = 0;
        char[] chars = s.toCharArray();
        for (char currentChar : chars ) {
            if (currentChar == '(') {
                balance++;
            } else if ( currentChar == ')') {
                balance--;
            }
        }
        return balance == 0;
    }

    private void checkFile(String filename) {
        File file = new File(filename);
        Scanner scan = new Scanner("");
        int lineNumber = -1;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: file not found!");
                    System.exit(1);
        }
        while(scan.hasNextLine()) {
            ParenSymmetry ps = new ParenSymmetry();
            String next = scan.nextLine();
            lineNumber++;
            boolean isBal = ps.isBalanced(next);
            if(isBal) {     // print whether or not the line's parenthesis are balanced
                System.out.println("Line " + lineNumber + "is balanced!");
            } else {
                System.out.println("Line " + lineNumber + "is not balanced!");
            }
        }
        scan.close(); // CLOSE the file
    }
    // open file named filename

    // for each line in the file
    // read the line
    // print whether or not the line's parenthesis are balanced

    // CLOSE the file

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
