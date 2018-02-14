import java.util.ArrayList;

/**
 * Created by adaml on 2/14/2018.
 */
public class Node {
    ArrayList<Node> children;

    Token token;

    public Node(Token token){
        children = new ArrayList<>();
        this.token = token;
    }
}
