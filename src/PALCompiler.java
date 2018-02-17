import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by adaml on 2/9/2018.
 */
public class PALCompiler {

    public static void main (String [] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = in.nextLine();
        File file = new File(filename);
        try{
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                String line = input.nextLine();
                lex(line);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't find file: " + file.getAbsolutePath());
        }

    }
    public static void lex(String input) {
        ArrayList<Token> tokens = Lexer.lex(input);
        if (tokens.size() > 0) {
            System.out.println(tokens);
            Node tree = new Instruction(tokens);
            System.out.println(tree);
            Iterator<Error> it = Lexer.errors.keySet().iterator();
            while (it.hasNext()) {
                Error e = it.next();
                ArrayList<String> errors = Lexer.errors.get(e);
                System.out.println(e + "(" + errors.size() + ")");
                for (String msg : errors) {
                    System.out.println("\t" + msg);
                }
            }
        }
    }
}
