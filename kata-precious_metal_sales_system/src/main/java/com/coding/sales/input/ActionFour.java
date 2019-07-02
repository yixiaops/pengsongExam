package com.coding.sales.input;

import java.math.BigDecimal;

public class ActionFour extends Action {

    @Override
    public BigDecimal getActionBigDecimal() {
        if(this.getOrderItemRepresentation().getAmount().compareTo(new BigDecimal(3)) >= 0){
            return this.getOrderItemRepresentation().getPrice().multiply(new BigDecimal(0.5));
        }
        return super.getActionBigDecimal();
    }
}
