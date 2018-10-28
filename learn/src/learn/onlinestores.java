/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

/**
 *
 * @author Abun
 */
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class onlinestores {
    private final SimpleIntegerProperty productID;
    private final SimpleStringProperty productName ;
    private final SimpleStringProperty productDescription;
    private final SimpleStringProperty productStatus;
    private final SimpleIntegerProperty price;
    
    public onlinestores(int productid,String productname,String productdescription,int Price,String productStatus1){
       this.productID = new SimpleIntegerProperty(productid);
       this.productName = new SimpleStringProperty(productname);
       this.productDescription = new SimpleStringProperty(productdescription);
       this.price = new SimpleIntegerProperty(Price);
       this.productStatus = new SimpleStringProperty(productStatus1);
       
    }
    
    public int getProductID(){
        return productID.get();
    }
    
    public void setProductID(int productid){
        productID.set(productid);
    }
    
    public String getProductName(){
        return productName.get();
    }
    
    public void setProductName(String productname){
        productName.set(productname);
    }
    
    public String getProductDescription(){
        return productDescription.get();
    }
    
    public void setProductDescription(String productname){
        productDescription.set(productname);
    }
    
     public int getPrice(){
        return price.get();
    }
    
    public void setPrice(int Price){
        price.set(Price);
    }
    
    public String getProductStatus(){
        return productStatus.get();
    }
    
    public void setProductStatus(String productStatus1){
        productStatus.set(productStatus1);
    }
}
