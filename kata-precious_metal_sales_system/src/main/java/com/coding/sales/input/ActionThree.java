package com.coding.sales.input;

import java.math.BigDecimal;

public class ActionThree extends Action {

    @Override
    public BigDecimal getActionBigDecimal() {
        if(this.getOrderItemRepresentation().getPrice()
                .multiply(this.getOrderItemRepresentation().getAmount())
                .compareTo(new BigDecimal(1000)) > 0){
            return new BigDecimal(10);
        }
        return super.getActionBigDecimal();
    }
}
