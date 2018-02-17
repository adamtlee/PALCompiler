import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Immediate extends Node {
    public Immediate(ArrayList<Token> tokens) {
        super(tokens);
        token = tokens.remove(0);
        type = Type.IMMEDIATE;
        int num = -1;
        try {
            num = Integer.parseInt(token.data,8);
        } catch (Exception e) {
            Lexer.addError(Error.WRONG_OPERAND_TYPE,"Expected IMMEDIATE_VALUE, but encountered: " + token);
        }
    }
}
