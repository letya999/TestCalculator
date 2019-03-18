package Basic;

import java.util.Stack;

abstract class Structure {
    protected final String OPERATORS="*/^+-";
    protected final String VARIABLE="var";
    protected byte countBracket=0;
    
    protected Stack<String> stackOperations=new Stack<String>();
    protected Stack<String> stackAnswer=new Stack<String>();
    
    public String str;
}
