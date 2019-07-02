package com.coding.sales.input;

import com.coding.sales.output.OrderItemRepresentation;

import java.math.BigDecimal;

public abstract class Action {

    private OrderItemRepresentation orderItemRepresentation;

    public OrderItemRepresentation getOrderItemRepresentation() {
        return orderItemRepresentation;
    }

    public void setOrderItemRepresentation(OrderItemRepresentation orderItemRepresentation) {
        this.orderItemRepresentation = orderItemRepresentation;
    }

    public BigDecimal getActionBigDecimal(){
        return new BigDecimal(0);
    };


    public static Action getActionByString(String ac){
        Action action = null;
        if("actionOne".equals(ac)){
            action = new ActionOne();
        } else if("actionTwo".equals(ac)){
            action = new ActionTwo();
        } else if("actionThree".equals(ac)){
            action = new ActionThree();
        } else if("actionFour".equals(ac)){
            action = new ActionFour();
        } else if("actionFive".equals(ac)){
            action = new ActionFive();
        }
        return action;
    }

}
