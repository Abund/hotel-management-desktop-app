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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abun
 */

public class CreateAccountController implements Initializable {

    sqlModel sqmod1 = new sqlModel();
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField passwordField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void handleSignUpButtonAction(ActionEvent event) throws IOException{
            sqmod1.inserttoCustomertb1(firstName.getText(),lastName.getText(),username.getText(),email.getText(),passwordField.getText());
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/productpage.fxml").openStream());
            ProductpageController pg = (ProductpageController)loader.getController();
            pg.GetUser(username.getText());
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.resizableProperty().setValue(Boolean.FALSE);
            primaryStage1.setScene(scene);
            primaryStage1.show();
    }
    
    public void loginpage(ActionEvent event) throws IOException{
            
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/FXMLDocument.fxml").openStream());
            FXMLDocumentController pg = (FXMLDocumentController)loader.getController();
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.setScene(scene);
            primaryStage1.show();
    }
    
}
