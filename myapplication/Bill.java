package com.example.myapplication;

public class Bill {
    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    private  String  billid;
    private String shop;
      private String money;
      private String type;
      private String  time;
    public Bill(String billid, String shop, String money, String type, String time) {
        this.billid = billid;
        this.shop = shop;
        this.money = money;
        this.type = type;
        this.time = time;
    }
    public  Bill(){

    }
    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
