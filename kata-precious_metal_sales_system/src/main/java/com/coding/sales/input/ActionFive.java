package com.coding.sales.input;

import java.math.BigDecimal;

public class ActionFive extends Action {

    @Override
    public BigDecimal getActionBigDecimal() {
        if(this.getOrderItemRepresentation().getAmount().compareTo(new BigDecimal(4)) >= 0){
            return this.getOrderItemRepresentation().getPrice();
        }
        return super.getActionBigDecimal();
    }
}
