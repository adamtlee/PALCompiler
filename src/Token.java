/**
 * Created by adaml on 2/14/2018.
 */
public class Token {
    public Type type;
    public int line;
    public int index;
    public String data = "";
    public Token(int line, int index) {
        this.line = line;
        this.index = index;
        type = Type.UNKOWN;
    }
    public Token(Type type, int line, int index) {
        this(line,index);
        this.type = type;
    }
    @Override
    public String toString() {
        return "("+ line + ":" + index +") " + type + ": " + data;
    }
}
enum Type {
    WORD, NUMBER, COMMENT, LABEL, UNKOWN, OPERATOR, REGISTER, DESTINATION, IMMEDIATE, INSTRUCTION, MEMLOC, NEWVAR, SOURCE, DECLARED_VAR;
}
