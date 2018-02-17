import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Label extends Node {
    public Label(ArrayList<Token> tokens){
        super(tokens);
        type = Type.LABEL;
        token = tokens.remove(0);
        if(token.data.endsWith(":")){
            // Good
        } else {
            Lexer.addError(Error.ILL_FORMED_LABEL, "Expected Label but encountered: " + token);
        }
    }
}
