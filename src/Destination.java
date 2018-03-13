import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Destination extends Node {
    /**
     * Instantiates a new destination in the Grammer.
     * @author adaml
     * @param tokens Tokens is the list of tokens that we use to parse
     */
    public Destination(ArrayList<Token> tokens){
        super(tokens);
        type = Type.DESTINATION;
        switch(token.type) {
            case REGISTER:
                children.add(new Register(tokens));
                break;
            default:
                children.add(new Var(tokens));
        }
    }
}
