package com.coding.sales.input;

import java.math.BigDecimal;

public class ActionOne extends Action {

    @Override
    public BigDecimal getActionBigDecimal() {
        if(this.getOrderItemRepresentation().getPrice()
                .multiply(this.getOrderItemRepresentation().getAmount())
                .compareTo(new BigDecimal(3000)) > 0){
            return new BigDecimal(350);
        }
        return super.getActionBigDecimal();
    }
}
