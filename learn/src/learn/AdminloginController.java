/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abun
 */
public class AdminloginController implements Initializable {
    
    public sqlModel sqmod= new sqlModel();
    
    @FXML
    private Button actiontarget;
//    
    @FXML
    private TextField username;
    
    @FXML
    private TextField passwordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void login(ActionEvent event) throws SQLException, IOException{
        try {
            if(sqmod.verifyAdmin(username.getText(),passwordField.getText())){
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("/learn/dashBoard.fxml").openStream());
                DashBoardController pg = (DashBoardController)loader.getController();
                
                Scene scene = new Scene(root,1400,980);
                scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.resizableProperty().setValue(Boolean.FALSE);
                primaryStage.show();
                

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
            Pane root = loader.load(getClass().getResource("/learn/adminCreateLoginAccount.fxml").openStream()); 
            AdminCreateLoginAccountController pg = (AdminCreateLoginAccountController)loader.getController();
            //pg.GetUser(username.getText());
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setScene(scene);
            primaryStage1.resizableProperty().setValue(Boolean.FALSE);
            primaryStage1.show();
    }
    
}
