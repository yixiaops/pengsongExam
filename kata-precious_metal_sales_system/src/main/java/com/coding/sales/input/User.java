package com.coding.sales.input;

public class User {
    private String name;
    private int level;
    private String bankNo;
    private int points;

    public User(String name, int level, String bankNo, int points) {
        this.name = name;
        this.level = level;
        this.bankNo = bankNo;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
