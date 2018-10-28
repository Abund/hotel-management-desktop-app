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

public class resturant {
    private final SimpleIntegerProperty foodID;
    private final SimpleStringProperty foodName ;
    private final SimpleStringProperty foodContent;
    private final SimpleIntegerProperty foodPrice;
    private final SimpleStringProperty foodStatus;
    
    public resturant(int foodid,String foodname,String foodcontent,int foodprice,String foodstatus){
       this.foodID = new SimpleIntegerProperty(foodid);
       this.foodName = new SimpleStringProperty(foodname);
       this.foodContent = new SimpleStringProperty(foodcontent);
       this.foodPrice = new SimpleIntegerProperty(foodprice);
       this.foodStatus = new SimpleStringProperty(foodstatus);
    }
    
    public int getFoodID(){
        return foodID.get();
    }
    
    public void setFoodID(int foodid){
        foodID.set(foodid);
    }
    
    public String getFoodName(){
        return foodName.get();
    }
    
    public void setFoodName(String foodname){
        foodName.set(foodname);
    }
    
    public int getFoodPrice(){
        return foodPrice.get();
    }
    
    public void setFoodPrice(int foodprice){
        foodPrice.set(foodprice);
    }
    
     public String getFoodStatus(){
        return foodStatus.get();
    }
    
    public void setFoodStatus(String foodstatus){
        foodStatus.set(foodstatus);
    }
    
    public String getFoodContent(){
        return foodContent.get();
    }
    
    public void setFoodContent(String foodcontent){
        foodContent.set(foodcontent);
    }
    
}
