package com.example.finaltop;

import org.xmlpull.v1.XmlPullParser;

import java.io.Serializable;

public class GoodsEntity implements Serializable {
    private String imgPath;
    private String goodsName;
    private String goodsPrice;
    private String goodsRequire;
    private String imgCompany;
    private String Companymes;

    public GoodsEntity(){}

    public String toString(){
        return "GoodsEntity{"+
                "imgPath='"+imgPath+'\''+
                ",goodsName='"+goodsName+'\''+
                ",goodsPrice='"+goodsPrice+'\''+
                '}';
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsRequire() {
        return goodsRequire;
    }

    public void setGoodsRequire(String goodsRequire) {
        this.goodsRequire = goodsRequire;
    }

    public String getImgCompany() {
        return imgCompany;
    }

    public void setImgCompany(String imgCompany) {
        this.imgCompany = imgCompany;
    }

    public String getCompanymes() {
        return Companymes;
    }

    public void setCompanymes(String companymes) {
        Companymes = companymes;
    }

    public GoodsEntity(String imgPath, String goodsName, String goodsPrice, String goodsRequire, String imgCompany, String companymes){
        this.imgPath = imgPath;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsRequire = goodsRequire;
        this.imgCompany = imgCompany;
        this.Companymes = companymes;
    }

}
