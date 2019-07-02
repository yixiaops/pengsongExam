package com.coding.sales.input;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GoodsCommand {


    public static List<Goods> from(String goodsCommand) {
        JSONArray jsonArray = new JSONArray(goodsCommand);
        List<Goods> goodses = new ArrayList<Goods>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject);
            List<Action> actionList = new ArrayList<Action>();
            if (jsonObject.has("action")){
                JSONArray actions = jsonObject.getJSONArray("action");
                for (int j = 0; j < actions.length(); j++){
                    Action action = Action.getActionByString(actions.getString(j));
                    actionList.add(action);
                }
            }
            Goods goods = new Goods(
                    jsonObject.getString("productNo"),
                    jsonObject.getString("productName"),
                    jsonObject.getBigDecimal("discount"),
                    jsonObject.getString("productType"),
                    jsonObject.getBigDecimal("productPrice")
            );
            goods.setActions(actionList);
            goodses.add(goods);
        }


        return goodses;
    }


    public static Goods getGoods(String no, List<Goods> goodses){
        for (int i = 0; i < goodses.size(); i++){
            Goods goods = goodses.get(i);
            if(no.equals(goods.getProductNo())){
                return goods;
            }
        }
         return null;
    }
}
