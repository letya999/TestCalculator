package actions.operations;

import actions.Operations;
import java.math.BigDecimal;

public class Division implements Operations {

    @Override
    public BigDecimal getRes(BigDecimal first, BigDecimal second) throws ArithmeticException {
        if(second.equals(BigDecimal.ZERO)) 
            throw new ArithmeticException("Please entere any number.");
        else
            return first.divide(second);
    } 
}
