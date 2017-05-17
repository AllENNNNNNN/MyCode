// <command> ::= <repeat command> | <primitive command>
public class CommandNode extends Node {
    private Command command;
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            command = new RepeatCommandNode();
            command.execute(context);
        } else {
            command = new PrimitiveCommandNode();
            command.execute(context);
        }
    }
    public String toString() {
        return ""+this.command;
    }
}
