// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode implements Command{
    private int number;
    private Node commandListNode;
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    public String toString() {
    	String result="";
    	for(int i=0;i<this.number;i++)
    	{
    		result+=this.commandListNode;
    	}
    	return result;
        //return "[repeat " + number + " " + commandListNode + "]";
    }
	@Override
	public void execute(Context context) {
		// TODO Auto-generated method stub
		try {
			this.parse(context);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
