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

public class hotel {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty ourRooms ;
    private final SimpleStringProperty Status ;
    private final SimpleStringProperty Description;
    private final SimpleIntegerProperty price;
    
    public hotel(int ID,String ourrooms,String status,String description,int Price){
       this.id = new SimpleIntegerProperty(ID);
       this.ourRooms = new SimpleStringProperty(ourrooms);
       this.Status = new SimpleStringProperty(status);
       this.Description = new SimpleStringProperty(description);
       this.price = new SimpleIntegerProperty(Price);
    }
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int ID){
        id.set(ID);
    }
    
    public String getOurRooms(){
        return ourRooms.get();
    }
    
    public void setOurRooms(String ourrooms){
        ourRooms.set(ourrooms);
    }
    
    public String getDescription(){
        return Description.get();
    }
    
    public void setDescription(String description){
        Description.set(description);
    }
    
    public int getPrice(){
        return price.get();
    }
    
    public void setPrice(int a){
        price.set(a);
    }
    
    public String getStatus(){
        return Status.get();
    }
    
    public void setStatus(String status){
        Status.set(status);
    }
   
}
