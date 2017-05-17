import java.util.ArrayList;

// <command list> ::= <command>* end
public class CommandListNode extends Node {
    private ArrayList list = new ArrayList();
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }
    public String toString() {
    	String result="";
    	for(int i=0;i<this.list.size();i++)
    		result+=this.list.get(i);
    	return result;
        //return list.toString();
    }
}
