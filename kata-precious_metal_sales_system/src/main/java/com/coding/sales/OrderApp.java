package com.coding.sales;

import com.coding.sales.input.*;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 销售系统的主入口
 * 用于打印销售凭证
 */
public class OrderApp {

    public static void main(String[] args) {

        if (args.length != 4) {
            throw new IllegalArgumentException("参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
        }

        String jsonFileName = args[0];
        String goodsFile = args[1];
        String userInfoFile = args[2];
        String txtFileName = args[3];

        String orderCommand = FileUtils.readFromFile(jsonFileName);
        String goodsCommand = FileUtils.readFromFile(goodsFile);
        String userCommand = FileUtils.readFromFile(userInfoFile);
        OrderApp app = new OrderApp();
        String result = app.checkout(orderCommand, goodsCommand, userCommand);
        FileUtils.writeToFile(result, txtFileName);
    }

    public String checkout(String orderCommand, String goodsCommand, String userCommand) {
        List<Goods> goodses = GoodsCommand.from(goodsCommand);
        List<User> users = UserCommand.from(userCommand);
        OrderCommand command = OrderCommand.from(orderCommand);


//        OrderRepresentation result = checkout(command);
        
//        return result.toString();
        return "";
    }

    OrderRepresentation checkout(OrderCommand command, List<Goods> goodses, List<User> users) {
        OrderRepresentation result = null;
        User user = null;
        for (int i = 0; i < users.size(); i++){
            user = users.get(i);
            if (users.get(i).getBankNo().equals(command.getMemberId()))break;
        }
        List<OrderItemRepresentation> orderItems = new ArrayList<OrderItemRepresentation>();
        List<OrderItemCommand> orderItemCommands = command.getItems();
        BigDecimal totalPrice = new BigDecimal("0");
        List<DiscountItemRepresentation> discounts = new ArrayList<DiscountItemRepresentation>();
        for (int i = 0; i < orderItemCommands.size(); i++){
            OrderItemCommand orderItemCommand = orderItemCommands.get(i);
            Goods goods = GoodsCommand.getGoods(orderItemCommand.getProduct(), goodses);

            OrderItemRepresentation itemRepresentation = new OrderItemRepresentation(goods.getProductNo(), goods.getProductName(),
            goods.getPrice(), orderItemCommand.getAmount(), goods.getPrice() .multiply(orderItemCommand.getAmount()));
            orderItems.add(itemRepresentation);
            totalPrice.add(itemRepresentation.getSubTotal());
        }

//        String orderId, Date createTime,
//                String memberNo, String memberName, String oldMemberType, String newMemberType, int memberPointsIncreased, int memberPoints,
//        List<OrderItemRepresentation> orderItems,
//        BigDecimal totalPrice, List<DiscountItemRepresentation> discounts, BigDecimal totalDiscountPrice,
//                BigDecimal receivables, List<PaymentRepresentation> payments, List<String> discountCards
        OrderRepresentation orderRepresentation = new OrderRepresentation(command.getOrderId(), command.getCreateTime(),user.getBankNo(),
                user.getName(), user.getLevel(), "new",  100, user.getPoints() + 100,
                orderItems, totalPrice, command.getDiscounts())

        //TODO: 请完成需求指定的功能

        return result;
    }
}
