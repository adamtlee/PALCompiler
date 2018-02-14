/**
 * Created by adaml on 2/14/2018.
 */
public class Token {
    public Type type;
    public String data = "";
    public Token(Type type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type + ": " + data;
    }
}
enum Type {
    WORD, NUMBER, COMMENT, LABEL, UNKOWN, OPERATOR;
}
