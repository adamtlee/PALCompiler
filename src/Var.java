import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Var extends Node {
    public Var(ArrayList<Token> tokens) {
        super(tokens);
        token = tokens.remove(0);
        type = Type.DECLARED_VAR;
        if (Lexer.variables.containsKey(token.data)) {
            tokens.remove(0); // remove token
            // good
        } else {
            children.add(new Register(tokens));
        }
    }
}
