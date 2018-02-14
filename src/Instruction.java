import java.util.ArrayList;

/**
 * Created by adaml on 2/14/2018.
 */
public class Instruction extends Node {
    public Instruction(ArrayList<Token> tokens) {
        super(tokens.get(0));
        Token token = tokens.remove(0);
        switch (token.data) {
            case "MOVE":
                children.add(new Source(tokens));
                eatOperator();
                children.add(new Source(tokens));
                eatOperator();
                children.add(new Destination(tokens));
                break;
            case "COPY":
                break;
            case "ADD":
                break;
            case "SUB":
                break;
            default:
                Lexer.addError(Error.INVALID_OPCODE,"Expected OPCODE, but encountered: " + token);
            case
        }
    }
    public void eatOperator(ArrayList<Token> tokens) {
        Token operator = tokens.remove(0);
        if (operator.type == Type.OPERATOR) {
            // yes
        } else {
            Lexer.addError(Error.TOO_FEW_OPERANDS,"Expected COMMA, but encountered: " + token);
        }
    }
}
