package Basic;

import exception.MissingBracketExceprion;
import java.util.Stack;
import java.util.StringTokenizer;
import java.math.BigDecimal;

public class Calculation extends Structure{

    public Calculation(String str) {
        this.str = str;
    }
    
    protected boolean isNumber(String token) {
        try{
            Double.parseDouble(token);
        } catch (Exception ex) {
            if(token.equals(VARIABLE)) 
                return true;
            return false;
        }
        return true;
    }
    protected boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }    
    protected boolean isOpenBracket(String token) {
        return token.equals("(");
    }
    protected boolean isCloseBracket(String token) {
        return token.equals(")");
    }  
    protected byte getPrec(String token) {
        switch(token) {
            case "+": return 1;
            case "-": return 2;
            case "*": return 3;
            case "/": return 4;
            case "^": return 5;
            default: return 6;
        }
    }
    
    public Stack<String> parse(String exp) throws Exception {
        stackOperations.clear();
        stackAnswer.clear();
        exp=exp.trim();
        exp=exp.replace("(-", "(0-");
        if (exp.charAt(0) == '-')
            exp="0"+exp;
        StringTokenizer strToken = new StringTokenizer(exp, OPERATORS + "()", true);
        while(strToken.hasMoreTokens()) {
            String token = strToken.nextToken();
            if (isNumber(token)) {
                stackAnswer.push(token);
            }
            else if (isOperator(token)) {
                while(!stackOperations.empty() && !isOperator(stackOperations.lastElement()) 
                        && getPrec(token) <= getPrec(stackOperations.lastElement())) {
                    stackAnswer.push(stackOperations.pop());
                }
                stackOperations.push(token);
            }
            else if(isOpenBracket(token)) {
                stackOperations.push(token);
                countBracket++;
            }
            else if(isCloseBracket(token)) {
                while(!stackOperations.empty() && !isOpenBracket(stackOperations.lastElement())) {
                    stackAnswer.push(stackOperations.pop());
                }
                countBracket--;
            }
        }
        if(countBracket!=0) throw new MissingBracketExceprion();
        while(!stackOperations.empty()) {
            stackAnswer.push(stackOperations.pop());
        }
        return stackAnswer;
    }
    
    public String calculate(String str) throws Exception {
        BigDecimal result=null;
        Calculation obj = new Calculation(str);
        Stack<String> tmp=obj.parse(str);
        Stack<BigDecimal> stack=new Stack<BigDecimal>();
        StringTokenizer strToken = new StringTokenizer(str, "+-*/" + "()", true);
        for(String token : tmp) {
            if (isNumber(token)) {
                stack.push(new BigDecimal(token));
            }
            else if(isOperator(token)) {
                BigDecimal second=stack.pop();
                BigDecimal first=stack.pop();
                Activity act=new Activity(first, second, token);
                result=act.getRes();
                stack.push(result);
            }
        }
        return stack.peek().toString();
    }
}
