import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class MemoryLocation extends Node {
    public MemoryLocation(ArrayList<Token> tokens) {
        super(tokens);
        token = tokens.remove(0);
        type = Type.MEMLOC;
        String data = token.data;
        for(int i = 0; i < data.length(); i++){
            char x = data.charAt(i);
            if (Character.isDigit(x)){
                Lexer.addError(Error.WRONG_OPERAND_TYPE, "Error: Expected MEMORYLOCATION but encountered: " + token);
                return;
            }
        }
    }
}
