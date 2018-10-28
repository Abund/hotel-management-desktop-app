/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Abun
 */
public class Cart {
    private final SimpleStringProperty productName;
    private final SimpleIntegerProperty productPrice;
    
    public Cart(String name,int price){
       
       this.productName = new SimpleStringProperty(name);
       this.productPrice = new SimpleIntegerProperty(price);
       
    }
    
    public String getProductName(){
        return productName.get();
    }
    
    public void setProductName(String name){
        productName.set(name);
    }
    
    public int getProductPrice(){
        return productPrice.get();
    }
    
    public void setProductPrice(int price){
        productPrice.set(price);
    }
}
