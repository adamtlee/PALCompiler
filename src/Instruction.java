import java.util.ArrayList;

/**
 * Created by adaml on 2/14/2018.
 */
public class Instruction extends Node {
    public Instruction(ArrayList<Token> tokens) {
        super(tokens);
        type = Type.INSTRUCTION;
        if (tokens.isEmpty()) {
            Lexer.addError(Error.TOO_FEW_OPERANDS,"Expected OPERAND, but encountered nothing.");
            return;
        }
        token = tokens.get(0);
        if (token.data.endsWith(":")) {
            children.add(new Label(tokens));
            children.add(new Instruction(tokens));
            return;
        } else {
            token = tokens.remove(0);
            try {
                switch (token.data) {
                    case "SRT":
                        break;
                    case "MOVE":
                        children.add(new Immediate(tokens));
                        eatOperator(tokens);
                        children.add(new Destination(tokens));
                        break;
                    case "COPY":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Destination(tokens));
                        break;
                    case "DEF":
                        children.add(new NewVar(tokens));
                        eatOperator(tokens);
                        children.add(new MemoryLocation(tokens));
                        break;
                    case "INC":
                        children.add(new Source(tokens));
                        break;
                    case "DEC":
                        children.add(new Source(tokens));
                        break;
                    case "DIV":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Destination(tokens));
                        break;
                    case "MUL":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Destination(tokens));
                        break;
                    case "BEQ":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new MemoryLocation(tokens));
                        break;
                    case "BGT":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new MemoryLocation(tokens));
                        break;
                    case "BR":
                        children.add(new MemoryLocation(tokens));
                        break;
                    case "ADD":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Destination(tokens));
                        break;
                    case "SUB":
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Source(tokens));
                        eatOperator(tokens);
                        children.add(new Destination(tokens));
                        break;
                    case "END":
                        // Done
                        break;
                    default:
                        Lexer.addError(Error.INVALID_OPCODE, "Expected OPCODE, but encountered: " + token);
                }
            } catch (Exception e) {
                Lexer.addError(Error.TOO_FEW_OPERANDS, "Expected COMMA, but encountered nothing.");
            }
        }
        if (tokens.isEmpty()) {
            // end
        } else {
            eatComment(tokens);
        }
    }
    public void eatOperator(ArrayList<Token> tokens) throws Exception {
        if (tokens.isEmpty()) {
            Lexer.addError(Error.TOO_FEW_OPERANDS,"Expected COMMA, but encountered nothing.");
            throw new Exception("Too few operands");
        }
        Token operator = tokens.remove(0);
        if (operator.type == Type.OPERATOR) {
            if (operator.data.equals(",")) {
                // good
            } else {
                Lexer.addError(Error.TOO_FEW_OPERANDS,"Expected COMMA, but encountered: " + operator);
            }
        } else {
            Lexer.addError(Error.TOO_FEW_OPERANDS,"Expected COMMA, but encountered: " + token);
        }
        if (tokens.isEmpty()) {
            Lexer.addError(Error.TOO_FEW_OPERANDS,"Expected COMMA, but encountered nothing.");
            return;
        }
    }
    public void eatComment(ArrayList<Token> tokens) {
        Token comment = tokens.remove(0);
        if (comment.type == Type.COMMENT) {
            // yes
        } else {
            Lexer.addError(Error.TOO_MANY_OPERANDS,"Expected COMMENT, but encountered: " + comment);
        }
    }
}
