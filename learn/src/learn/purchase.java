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
public class purchase {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty user ;
    private final SimpleStringProperty room ;
    private final SimpleIntegerProperty pricy;
    
    public purchase(int ID,String User,String Room,int Pricy){
     this.id = new SimpleIntegerProperty(ID);
       this.user = new SimpleStringProperty(User);
       this.room = new SimpleStringProperty(Room);
       this.pricy = new SimpleIntegerProperty(Pricy);
          
    }
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int ID){
        id.set(ID);
    }
    
    public String getUser(){
        return user.get();
    }
    
    public void setUser(String User){
        user.set(User);
    }
    
    public String getRooms(){
        return room.get();
    }
    
    public void setRooms(String Rooms){
        room.set(Rooms);
    }
    
    public int getPricy(){
        return pricy.get();
    }
    
    public void setPricy(int Pricy){
        pricy.set(Pricy);
    }
    
}
