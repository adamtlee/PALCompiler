import java.util.ArrayList;

/**
 * Created by adaml on 2/16/2018.
 */
public class Source extends Node{
    public Source(ArrayList<Token> tokens){
        super(tokens);
        type = Type.SOURCE;
        switch(token.type) {
            case REGISTER:
                children.add(new Register(tokens));
                break;
            default:
                children.add(new Var(tokens));
        }
    }
}
