/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;  
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Abun
 */
public class FXMLDocumentController implements Initializable {
    
    public sqlModel sqmod= new sqlModel();
    
//    @FXML
//    private Label label;
//    
    @FXML
    private Button actiontarget;
//    
    @FXML
    private TextField username;
    
    @FXML
    private TextField passwordField;
    
    
    
    String user3;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public String getUsers(){
        return user3;
    }
    
    public void setUsers(String user3){
        
        user3 = username.getText();
        
    }
    public void login(ActionEvent event) throws SQLException, IOException{
        try {
            if(sqmod.verifyCustomer(username.getText(),passwordField.getText())){
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("/learn/productpage.fxml").openStream());
                ProductpageController pg = (ProductpageController)loader.getController();
                pg.GetUser(username.getText());
                Scene scene = new Scene(root,1400,980);
                scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
                primaryStage.setTitle("Nicon Places");
                primaryStage.setScene(scene);
                primaryStage.resizableProperty().setValue(Boolean.FALSE);
                primaryStage.show();
                if(sqmod.checkpurchase(username.getText())){
                    pg.GetHotelb(true);
                }

            }
            else{
                actiontarget.setText("forget password?? please click here....");


            }

        }
        catch (SQLException e){
            
        }
    }
    

    public void createAccount(ActionEvent event)throws IOException  {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/CreateAccount.fxml").openStream()); 
            CreateAccountController pg = (CreateAccountController)loader.getController();
            //pg.GetUser(username.getText());
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.setScene(scene);
            primaryStage1.resizableProperty().setValue(Boolean.FALSE);
            primaryStage1.show();
    }
    
    public void forgetPassword1(ActionEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/forgetpassword1.fxml").openStream());
            Forgetpassword1Controller pg = (Forgetpassword1Controller)loader.getController();
            //pg.GetUser(username.getText());
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.resizableProperty().setValue(Boolean.FALSE);
            primaryStage1.setScene(scene);
            primaryStage1.show();
            
    }
    
    public void Dashboard(ActionEvent event) throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/adminlogin.fxml").openStream());
            AdminloginController pg = (AdminloginController)loader.getController();
            //pg.GetUser(username.getText());
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.setScene(scene);
            primaryStage1.resizableProperty().setValue(Boolean.FALSE);
            primaryStage1.show();
            
    }
 
}