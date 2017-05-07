package com.wcf;



public class FullBorder extends Border {
    public FullBorder(Printable printable) {
        super(printable);
    }
    public int getColumns() {                 
        return 1 + printer.getColumns() + 1;
    }
    public int getRows() {                     
        return 1 + printer.getRows() + 1;
    }
    public String getRowText(int row) {       
        if (row == 0) {                                                 
            return "+" + makeLine('-', printer.getColumns()) + "+";
        } else if (row == printer.getRows() + 1) {                     
            return "+" + makeLine('-', printer.getColumns()) + "+";
        } else {                                                        
            return "|" + printer.getRowText(row - 1) + "|";
        }
    }
    private String makeLine(char ch, int count) {        
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.printer.getName();
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.printer.setName(name);
	}
	@Override
	public void setContext(String context) {
		// TODO Auto-generated method stub
		this.printer.setContext(context);
		
	}
}
