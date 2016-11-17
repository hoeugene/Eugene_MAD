package com.example.eugene.lab8coffee;

/**
 * Created by hodominic on 10/11/2016.
 */

public class CoffeeShop {
    private String shopName;
    private String shopURL;


    public void setCoffeeShop(Integer coffeeCrowd){
        setCoffeeInfo(coffeeCrowd);
    }

    public String getShopName(){
        return shopName;
    }

    public String getShopURL(){
        return shopURL;
    }

    private void setCoffeeInfo(Integer coffeeCrowd){
        switch(coffeeCrowd){
            case 0:
                shopName="Starbucks";
                shopURL="http://www.starbucks.com/";
                break;
            case 1:
                shopName="Amante";
                shopURL="http://www.amantecoffee.com/";
                break;
            case 2:
                shopName="Alpine Modern";
                shopURL="https://www.alpinemodern.com/";
                break;
            case 3:
                shopName="Allegro";
                shopURL="www.allegrocoffee.com/";
                break;
            case 4:
                shopName="Innisfree";
                shopURL="innisfreepoetry.com/";
                break;
            default:
                shopName="Starbucks";
                shopURL="http://www.starbucks.com/";
                break;
        }
    }
}
