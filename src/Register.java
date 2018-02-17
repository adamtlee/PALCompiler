import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Register extends Node {
    public Register(ArrayList<Token> tokens) {
        super(tokens);
        token = tokens.remove(0);
        type = Type.REGISTER;
        if (token.type != Type.REGISTER) {
            Lexer.addError(Error.WRONG_OPERAND_TYPE,"Expected REGISTER, but encountered: " + token);
        } else {
            String register = token.data;
            register = register.substring(1);
            int number = 13;
            try {
                number = Integer.parseInt(register);
            } catch (Exception e) {
                Lexer.addError(Error.WRONG_OPERAND_TYPE,"Expected REGISTER, but encountered: " + token);
            }
            if (number < 0 || number > 7) {
                Lexer.addError(Error.WRONG_OPERAND_TYPE,"Expected REGISTER between 0 and 7, but encountered: " + token);
            }
        }
    }
}
