package actions.operations;

import actions.Operations;
import java.math.BigDecimal;

public class Substr implements Operations {

    @Override
    public BigDecimal getRes(BigDecimal first, BigDecimal second) throws Exception {
        return first.subtract(second);
    }
}