package com.coding.sales.input;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserCommand {


    public static List<User> from(String goodsCommand) {
        JSONArray jsonArray = new JSONArray(goodsCommand);
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            User user = new User(
                    jsonObject.getString("name"),
                    jsonObject.getInt("level"),
                    jsonObject.getString("bankNo"),
                    jsonObject.getInt("points")
            );
            users.add(user);
        }
        return users;
    }

}
