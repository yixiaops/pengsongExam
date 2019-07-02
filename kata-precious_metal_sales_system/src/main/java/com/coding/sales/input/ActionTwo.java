package com.coding.sales.input;

import java.math.BigDecimal;

public class ActionTwo extends Action {

    @Override
    public BigDecimal getActionBigDecimal() {
        if(this.getOrderItemRepresentation().getPrice()
                .multiply(this.getOrderItemRepresentation().getAmount())
                .compareTo(new BigDecimal(2000)) > 0){
            return new BigDecimal(30);
        }
        return super.getActionBigDecimal();
    }
}
