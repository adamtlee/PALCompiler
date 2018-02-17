import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class NewVar extends Node {
    public NewVar(ArrayList<Token> tokens) {
        super(tokens);
        token = tokens.remove(0);
        type = Type.NEWVAR;
        Lexer.variables.put(token.data,"");
    }
}
