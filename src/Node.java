import java.util.ArrayList;

/**
 * Created by adaml on 2/14/2018.
 */
public class Node {
    ArrayList<Node> children;
    Type type;
    Token token;

    public Node(ArrayList<Token> tokens){
        if (tokens.isEmpty()) {
            // oops
        } else {
            token = tokens.get(0);
        }
        children = new ArrayList<>();
    }
    @Override
    public String toString() {
        return type + " " + token + ": " + children;
    }
}
