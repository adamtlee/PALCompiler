import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Destination extends Node {
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
