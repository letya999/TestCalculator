package actions;

import java.math.BigDecimal;

public interface Operations {
    default BigDecimal getRes(BigDecimal first, BigDecimal second) throws Exception {
        return null;
    }
    default BigDecimal getRes(BigDecimal value) throws Exception {
        return null;
    }
}
