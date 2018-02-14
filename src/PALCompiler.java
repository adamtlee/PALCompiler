import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by adaml on 2/9/2018.
 */
public class PALCompiler {

    public static void main (String [] args){
        ArrayList<Token> tokens = Lexer.lex("MOV R2, R3");
        System.out.println(tokens);
    }
}
