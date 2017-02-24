package com.android.shaap.GetersAndSeters.Hossein;

/**
 * Created by Hossein on 14/02/2017.
 */
public class TarakoneshItems {

    String date,shopperName;
    int cat,howPay,nameBank, isSuccess;
    double cost;

    public TarakoneshItems(String shopperName,String date,int nameBank, int howPay, int cat, int isSuccess, double cost) {
        this.nameBank = nameBank;
        this.date = date;
        this.howPay = howPay;
        this.cat = cat;
        this.cost = cost;
        this.isSuccess = isSuccess;
        this.shopperName = shopperName;
    }

    public TarakoneshItems() {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getHowPay() {
        return howPay;
    }

    public void setHowPay(int howPay) {
        this.howPay = howPay;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNameBank() {
        return nameBank;
    }

    public void setNameBank(int nameBank) {
        this.nameBank = nameBank;
    }

    public String getShopperName() {
        return shopperName;
    }

    public void setShopperName(String shopperName) {
        this.shopperName = shopperName;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }
}
