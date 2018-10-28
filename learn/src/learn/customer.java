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
public class customer {
    
    private final SimpleIntegerProperty id ;
    private final SimpleStringProperty firstName ;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty userName ;
    private final SimpleStringProperty email;
    private final SimpleStringProperty password ;
    
    public customer(int ID,String FirstName,String LastName,String UserName,String Email,String Password){
       this.id = new SimpleIntegerProperty(ID); 
       this.firstName = new SimpleStringProperty(FirstName);
       this.lastName = new SimpleStringProperty(LastName);
       this.userName = new SimpleStringProperty(UserName);
       this.email = new SimpleStringProperty(Email);
       this.password = new SimpleStringProperty(Password);
    }
    
    public int getId(){
        return id.get();
    }
    
    public void setId(int ID){
        id.set(ID);
    }
    
    public String getFirstName(){
        return firstName.get();
    }
    
    public void setFirstName(String FirstName){
        firstName.set(FirstName);
    }
    
    public String getLastName(){
        return lastName.get();
    }
    
    public void setLastName(String LastName){
        lastName.set(LastName);
    
    }
    
    public String getUserName(){
        return userName.get();
    }
    
    public void setUserName(String UserName){
        userName.set(UserName);
    }
    
    public String getEmail(){
        return email.get();
    }
    
    public void setEmail(String Email){
        email.set(Email);
    }
    
    public String getPassword(){
        return password.get();
    }
    
    public void setPassword(String Password){
        password.set(Password);
    }
}
