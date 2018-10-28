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

public class descriptC {
    private final SimpleStringProperty rooms;
    private final SimpleStringProperty date1 ;
    
    public descriptC(String room,String date){
       this.rooms = new SimpleStringProperty(room);
       this.date1 = new SimpleStringProperty(date);
    }
   
    public String getRooms(){
        return rooms.get();
    }
    
    public void setRooms(String room){
        rooms.set(room);
    }
    public String getDate1(){
        return date1.get();
    }
    
    public void setDate1(String date){
        date1.set(date);
    }
}
