import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        // implement this method
        int openParenthesis = 0;
        int closeParenthesis = 0;

        for(int i = 0; i < s.length(); i++){
            if ( s.charAt(i) == '(' ) {
                openParenthesis++;
            }
            if ( s.charAt(i) == ')' ) {
                closeParenthesis++;
            }
        }
        if(openParenthesis == closeParenthesis) {
            return true;
        }
        else {
            return false;
        }

    }

    private void checkFile(String filename) throws FileNotFoundException {
        // open file named filename
        // for each line in the file
        // read the line
        // print whether or not the line's parenthesis are balanced
        // CLOSE the file
        File fileTest = new File("TestStrings0.txt");
        Scanner scanner = new Scanner(filename);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line + " : " + isBalanced(line));
        }
        scanner.close();

    }

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