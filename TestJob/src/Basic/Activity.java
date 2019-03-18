package Basic;

import actions.*;
import actions.operations.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Activity {
    protected final static Map<String, Operations> SIGNNUMBER = new HashMap();
    protected String oper;
    protected BigDecimal first, second, res;
    
    static {
        SIGNNUMBER.put("+", new Addition());
        SIGNNUMBER.put("-", new Substr());
        SIGNNUMBER.put("/", new Division());
        SIGNNUMBER.put("*", new Multiple());
        SIGNNUMBER.put("^", new Degree());
    }

    public Activity(BigDecimal first, BigDecimal second, String oper) throws Exception {
        this.oper = oper;
        this.first = first;
        this.second = second ;
        compute();
    }
       
    protected void compute() throws Exception{
        Operations myf = SIGNNUMBER.get(oper);
        if(myf != null) {
            res = myf.getRes(first, second);
        }
        else
            throw new UnsupportedOperationException();
    }
    
    public BigDecimal getRes() {
        return res;
    }
}
