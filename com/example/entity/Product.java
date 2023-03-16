package com.example.entity;

import java.util.Scanner;

public class Product {
    private String name;
    private int price;
    private String description;
    private int productId;
    public Product(String name, int price, String Description,int productId ){
        this.name = name;
        this.price = price;
        this.description = Description;
        this.productId = productId;
    }
    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getDescription(){return description;}
    public void setDescription(String description){
        this.description = description;
    }
    public int getProductId(){return productId;}
    public void setProductId(int productId){
        this.productId = productId;
    }
@Override
    public String toString(){
        return "com.example.model.Product [name=" + name + ",price=" + price + ",description=" + description + ",productId=" + productId +"]";

}
}
