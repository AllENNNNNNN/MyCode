// <primitive command> ::= go | right | left
public class PrimitiveCommandNode implements Command{
    private String name;
    
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("go") && !name.equals("right") && !name.equals("left")) {
            throw new ParseException(name + " is undefined");
        }
    }
    
    public String toString() {
        return name+" ";
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
