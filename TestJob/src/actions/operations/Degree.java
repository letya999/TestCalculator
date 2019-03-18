package actions.operations;

import actions.Operations;
import java.math.BigDecimal;

public class Degree implements Operations {

    @Override
    public BigDecimal getRes(BigDecimal first, BigDecimal second) throws ArithmeticException {
        return first.pow(second.toBigInteger().intValue());
    } 
}
