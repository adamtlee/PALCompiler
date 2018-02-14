import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by adaml on 2/14/2018.
 */
public class Lexer {
    private Scanner in;
    private String line = null;
    private int LineIndex = 0;
    // key : value
    private static HashMap<Error,ArrayList<String>> errors;
    public static ArrayList<Token> lex(String input) {
        input += "\n";
        ArrayList<Token> tokens = new ArrayList<>();
        State state = State.START;
        Token token = new Token(Type.UNKOWN);
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            switch (state) {
                // THE Finite automatas
                case START:
                    if (Character.isLetter(x)) {
                        state = State.WORD;
                        token = new Token(Type.WORD);
                        token.data += x;
                    } else if (Character.isDigit(x)) {
                        state = State.NUMBER;
                        token = new Token(Type.NUMBER);
                        token.data += x;
                    } else if (isWhiteSpace(x)) {
                        // Ignore Whitespace
                    } else if (isOperator(x)) {
                        if (x == ';') {
                            state = State.COMMENT;
                            token = new Token(Type.COMMENT);
                            token.data += x;
                        } else {
                            token = new Token(Type.OPERATOR);
                            token.data += x;
                            tokens.add(token);
                            token = new Token(Type.UNKOWN);
                        }
                    } else {
                        addError(Error.LEXER,"Expected a LETTER, DIGIT, or WHITESPACE BUT Encountered: " + x);
                    }
                    break;
                case WORD:
                    if(Character.isLetter(x)){
                        token.data += x;
                    } else if (isWhiteSpace(x)){
                        state = State.START;
                        tokens.add(token);
                        token = new Token(Type.UNKOWN);
                    } else if (isOperator(x)){
                        state = State.START;
                        tokens.add(token);
                        token = new Token(Type.UNKOWN);
                        i--; // put back x
                    } else if (Character.isDigit(x)) {
                        token.data += x;
                    }
                    break;
                case NUMBER:
                    if(Character.isDigit(x)){
                        token.data += x;
                    } else if (isWhiteSpace(x)){
                        tokens.add(token);
                        token = new Token(Type.UNKOWN);
                        state = State.START;
                    } else if (isOperator(x)){
                        tokens.add(token);
                        token = new Token(Type.UNKOWN);
                        state = State.START;
                        i--; // put back x
                    } else {
                        addError(Error.LEXER,"Expected a LETTER, DIGIT, or WHITESPACE BUT Encountered: " + x);
                    }
                    break;
                case COMMENT:
                    token.data += x;
                    if (i >= input.length()){
                        tokens.add(token);
                        token = new Token(Type.UNKOWN);
                        state = State.START;
                    }
                    break;
                default:
            }
        }
        return tokens;
    }
    public static boolean isOperator (char x){
        switch(x){
            case ';':
            case ':':
            case ',':
                return true;
            default:
                return false;
        }
    }
    public static boolean isWhiteSpace(char x){
        switch(x){
            case ' ':
            case '\n':
            case '\r':
            case '\f':
                return true;
            default:
                return false;

        }
    }

    public static void addError(Error type, String msg){
        ArrayList<String> list = errors.get(type);
        if (list == null) {
            list = new ArrayList<String>();
        }
        list.add(msg);

        errors.put(type,list);
    }
}
enum State {
    START, WORD, NUMBER, COMMENT;
}
