/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

import javafx.scene.image.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abun
 */
public class DashBoardController implements Initializable {
    sqlModel sqmod = new sqlModel();
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView customer;
    @FXML
    private TableView hotel;
    @FXML
    private TableView resturanttable;
    @FXML
    private TableView onlinestore;
    @FXML
    private TableView purchase;
    
    @FXML
    private FlowPane controls;
    
    @FXML
    private GridPane customerfield;
    
    @FXML
    private GridPane hotelfield;
    
    @FXML
    private GridPane resturantfield;
    
    @FXML
    private GridPane onlinestoresfield;
    
    @FXML
    private GridPane purchasefield;
    
    @FXML
    private ObservableList<hotel> hotel1 = FXCollections.observableArrayList() ;
    
    @FXML
    private ObservableList<resturant> resturanttable1 = FXCollections.observableArrayList();
    
    @FXML
    private ObservableList<onlinestores> onlinestore3 = FXCollections.observableArrayList();
    
    @FXML
    private ObservableList<customer> customerid = FXCollections.observableArrayList();
    
    @FXML
    private ObservableList<purchase> purchase1 = FXCollections.observableArrayList();
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField userName;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField ourrooms;
    
    @FXML
    private TextField status;
    
    @FXML
    private TextField description;
    
    @FXML
    private TextField price;
    
    @FXML
    private TextField id;
    @FXML
    private TextField foodid;
    @FXML
    private TextField foodname;
    @FXML
    private TextField foodcontent;
    @FXML
    private TextField foodprice;
    @FXML
    private TextField foodstatus;
    @FXML
    private TextField productname;
    @FXML
    private TextField productdescription;
    @FXML
    private TextField productstatus;
    @FXML
    private TextField productprice;
    @FXML
    private TextField productid;
    
    @FXML
    private TextField user;
    @FXML
    private TextField room;
    @FXML
    private TextField purchaseprice;
    
    @FXML
    private TextField cutid;
    
    @FXML
    private Button uploadButton;
    @FXML
    private ImageView pictures;
    
    @FXML
    private Image pictures1;
    
    @FXML
    private FileChooser filechooser =new FileChooser();
    
    @FXML
    private File file;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        customer.setVisible(true);
        customerfield.setVisible(true);
        hotel.setVisible(false);
        sqmod.DisplayHotel(hotel1, hotel);
        sqmod.DisplayResturant( resturanttable1,resturanttable);
        sqmod.DisplayOnlinestore( onlinestore3,onlinestore);
        sqmod.DisplayCustomer(customerid,customer);
        uploadButton.setVisible(false);
    }    
    
    public void customer(ActionEvent event) {
        customer.setVisible(true);
        hotel.setVisible(false);
        resturanttable.setVisible(false);
        onlinestore.setVisible(false);
        purchase.setVisible(false);
        controls.setVisible(true);
        customerfield.setVisible(true);
        purchasefield.setVisible(false);
        onlinestoresfield.setVisible(false);
        hotelfield.setVisible(false);
        resturantfield.setVisible(false);
        uploadButton.setVisible(false);
    }
    
    public void hotel(ActionEvent event) {
        customer.setVisible(false);
        hotel.setVisible(true);
        resturanttable.setVisible(false);
        onlinestore.setVisible(false);
        purchase.setVisible(false);
        controls.setVisible(true);
        hotelfield.setVisible(true);
        purchasefield.setVisible(false);
        customerfield.setVisible(false);
        onlinestoresfield.setVisible(false);
        resturantfield.setVisible(false);
        uploadButton.setVisible(true);
    }
    
    public void resturant(ActionEvent event) {
        customer.setVisible(false);
        hotel.setVisible(false);
        resturanttable.setVisible(true);
        onlinestore.setVisible(false);
        purchase.setVisible(false);
        controls.setVisible(true);
        resturantfield.setVisible(true);
        purchasefield.setVisible(false);
        customerfield.setVisible(false);
        onlinestoresfield.setVisible(false);
        hotelfield.setVisible(false);
        uploadButton.setVisible(true);
    }
    
    public void onlinestore(ActionEvent event) {
        customer.setVisible(false);
        hotel.setVisible(false);
        resturanttable.setVisible(false);
        onlinestore.setVisible(true);
        purchase.setVisible(false);
        controls.setVisible(true);
        onlinestoresfield.setVisible(true);
        purchasefield.setVisible(false);
        customerfield.setVisible(false);
        hotelfield.setVisible(false);
        resturantfield.setVisible(false);
        uploadButton.setVisible(true);
    }
   
    
    public void upload(ActionEvent event) throws IOException {
        
        
                file = filechooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
                filechooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files","*txt"),
                new ExtensionFilter("Image Files","*.png","*jpg","*.gif"),
                new ExtensionFilter("Audio Files","*wav","*.mp3","*.aac"),
                new ExtensionFilter("All Files","*."));
        if(file !=null){ 
            pictures1 = new Image(file.toURI().toString(), 300, 450,true,true);
            //pictures = new ImageView(pictures1);
            pictures.setImage(pictures1);
            pictures.setFitWidth(300);
            pictures.setFitHeight(450);
            pictures.setPreserveRatio(true);
        }
    }
    
    public void purchase(ActionEvent event) {
       customer.setVisible(false);
       hotel.setVisible(false);
       resturanttable.setVisible(false);
       onlinestore.setVisible(false);
       purchase.setVisible(true);
       controls.setVisible(true);  
       purchasefield.setVisible(true);
       customerfield.setVisible(false);
       onlinestoresfield.setVisible(false);
       hotelfield.setVisible(false);
       resturantfield.setVisible(false);
       uploadButton.setVisible(false);
    }
    
    public void add(ActionEvent event) {
       if(customer.isVisible()){
           //int id = customerid.get(customer.getSelectionModel().getSelectedIndex()).getId();
           String pri1 = cutid.getText();
           int prii1 = Integer.parseInt(pri1);
           customerid.add(new customer(prii1,firstName.getText(),lastName.getText(),userName.getText(),email.getText(),password.getText()));
           sqmod.inserttoCustomertb1(firstName.getText(), lastName.getText(), userName.getText(), email.getText(), password.getText());
           cutid.clear();
           firstName.clear();
           lastName.clear();
           userName.clear();
           email.clear();
           password.clear();
       }else if(hotel.isVisible()){
           String pri = price.getText();
           int prii = Integer.parseInt(pri);
           sqmod.addToHotelTable(ourrooms.getText(),status.getText(),description.getText(),prii,file);
           //hotel1.add(new hotel(ourrooms.getText(),status.getText(),description.getText(),price.getText()));
           String pri1 = id.getText();
           int prii1 = Integer.parseInt(pri1);
           hotel1.add(new hotel(prii1,ourrooms.getText(),status.getText(),description.getText(),prii));
           id.clear();
           ourrooms.clear();
           status.clear();
           description.clear();
           price.clear();
       }else if(resturanttable.isVisible()){
           String pri = foodprice.getText();
           int prii = Integer.parseInt(pri);
           String pri1 = foodid.getText();
           int prii1 = Integer.parseInt(pri1);
           sqmod.addToresturantTable(foodname.getText(),foodcontent.getText(),prii,foodstatus.getText(),file);
           resturanttable1.add(new resturant(prii1,foodname.getText(),foodcontent.getText(),prii,foodstatus.getText()));
           foodid.clear();
           foodname.clear();
           foodcontent.clear();
           foodstatus.clear();
           foodprice.clear();
       }else if(onlinestore.isVisible()){
           String pri = productprice.getText();
           int prii = Integer.parseInt(pri);
           String pri1 = productid.getText();
           int prii1 = Integer.parseInt(pri1);
           sqmod.addToOnlinestore(productname.getText(),productdescription.getText(),productstatus.getText(),prii,file);
           onlinestore3.add(new onlinestores(prii1,productname.getText(),productdescription.getText(),prii,productstatus.getText()));
           productid.clear();
           productname.clear();
           productdescription.clear();
           productstatus.clear();
           productprice.clear();
       }else if(purchase.isVisible()){
           sqmod.addToPurchaseTable(user.getText(),room.getText(),purchaseprice.getText());
           user.clear();
           room.clear();
           purchaseprice.clear();
           
       }
            
    }
    
    public void replace(ActionEvent event) {
       if(customer.isVisible()){
           int id = customerid.get(customer.getSelectionModel().getSelectedIndex()).getId();
           //customerid.add(new customer(id,firstName.getText(),lastName.getText(),userName.getText(),email.getText(),password.getText()));
           int cutid1 = customerid.get(customer.getSelectionModel().getSelectedIndex()).getId();
           String FirstName = customerid.get(customer.getSelectionModel().getSelectedIndex()).getFirstName();
           String LastName = customerid.get(customer.getSelectionModel().getSelectedIndex()).getLastName();
           String Email = customerid.get(customer.getSelectionModel().getSelectedIndex()).getEmail();
           String Password = customerid.get(customer.getSelectionModel().getSelectedIndex()).getPassword();
           String UserName = customerid.get(customer.getSelectionModel().getSelectedIndex()).getUserName();
           if(!firstName.getText().isEmpty()){
               FirstName = firstName.getText();
           }
           if(!lastName.getText().isEmpty()){
               LastName = lastName.getText();
           }
           if(!userName.getText().isEmpty()){
               UserName = userName.getText();
           }
           if(!email.getText().isEmpty()){
               Email = email.getText();
           }
           if(!password.getText().isEmpty()){
               Password = password.getText();
           }
           customerid.set(customer.getSelectionModel().getSelectedIndex(), new customer(cutid1,FirstName,LastName,UserName,Email,Password));
           
           sqmod.updateCustomer(FirstName, LastName,UserName,Password,Email,id);
           firstName.clear();
           lastName.clear();
           userName.clear();
           email.clear();
           password.clear();
       }else if(hotel.isVisible()){
           int id = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getId();
           //customerid.add(new customer(id,firstName.getText(),lastName.getText(),userName.getText(),email.getText(),password.getText()));
           int cutid1 = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getId();
           String ourroom = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getOurRooms();
           String descriptions = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getDescription();
           String status1 = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getStatus();
           int price1 = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getPrice();
           
           if(!ourrooms.getText().isEmpty()){
               ourroom = ourrooms.getText();
           }
           if(!status.getText().isEmpty()){
               status1 = status.getText();
           }
           if(!description.getText().isEmpty()){
               descriptions = description.getText();
           }
           if(!price.getText().isEmpty()){
               String pri = price.getText();
               price1 = Integer.parseInt(pri);
           }
           
           
           hotel1.set(hotel.getSelectionModel().getSelectedIndex(), new hotel(cutid1,ourroom,status1,descriptions,price1));
           if(file == null){
               sqmod.updateHotel1(ourroom,status1,descriptions,price1,id);
           }else{
            sqmod.updateHotel22(ourroom,status1,descriptions,price1, id,file);   
           }
           
           ourrooms.clear();
           status.clear();
           description.clear();
           price.clear();
       }else if(resturanttable.isVisible()){
           int id = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodID();
           //customerid.add(new customer(id,firstName.getText(),lastName.getText(),userName.getText(),email.getText(),password.getText()));
           int cutid1 = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodID();
           String foodcontent1 = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodContent();
           String foodstatus1 = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodStatus();
           int foodprice1 = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodPrice();
           String foodname1 = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodName();
           int prii =0;
           if(!foodname.getText().isEmpty()){
               foodname1 = foodname.getText();
           }
           if(!foodstatus.getText().isEmpty()){
               foodstatus1 = foodstatus.getText();
           }
           if(!foodcontent.getText().isEmpty()){
               foodcontent1 = foodcontent.getText();
           }
           if(!foodprice.getText().isEmpty()){
               String pri = foodprice.getText();
               foodprice1 = Integer.parseInt(pri);
           }
           
           resturanttable1.set(resturanttable.getSelectionModel().getSelectedIndex(), new resturant(cutid1,foodname1,foodcontent1,foodprice1,foodstatus1));
           if(file == null){
               sqmod.updateResturant11(foodname1,foodcontent1,foodprice1,foodstatus1,id);
           }else{
            sqmod.updateResturant(foodname1,foodcontent1,foodprice1,foodstatus1, id,file);  
           }
           
           foodname.clear();
           foodcontent.clear();
           foodstatus.clear();
           foodprice.clear();
       }else if(onlinestore.isVisible()){
           int id = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductID();
           //customerid.add(new customer(id,firstName.getText(),lastName.getText(),userName.getText(),email.getText(),password.getText()));
           int cutid1 = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductID();
           String prodescript = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductDescription();
           String proname = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductName();
           String prostatus = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductStatus();
           int proprice = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getPrice();
           int prii =0;
           if(!productname.getText().isEmpty()){
               proname = productname.getText();
           }
           if(!productdescription.getText().isEmpty()){
               prodescript = productdescription.getText();
           }
           if(!productstatus.getText().isEmpty()){
               prostatus = productstatus.getText();
           }
           if(!productprice.getText().isEmpty()){
               String pri = productprice.getText();
               proprice = Integer.parseInt(pri);
           }
           
           onlinestore3.set(onlinestore.getSelectionModel().getSelectedIndex(), new onlinestores(cutid1,proname,prodescript,proprice,prostatus));
           if(file == null){
               sqmod.updateOnlineStore1(proname,prodescript,prostatus,proprice, id);
           }else{
            sqmod.updateOnlineStore(proname,prodescript,prostatus,proprice, id,file);  
           }
           
           productname.clear();
           productdescription.clear();
           productstatus.clear();
           productprice.clear();
       }else if(purchase.isVisible()){
           //sqmod.updatePurcahse(user.getText(),room.getText(),purchaseprice.getText(), 0);
           user.clear();
           room.clear();
           purchaseprice.clear();
       }    
    }
    
    public void remove(ActionEvent event) {
        if(customer.isVisible()){
            int id = customerid.get(customer.getSelectionModel().getSelectedIndex()).getId();
            customerid.remove(customer.getSelectionModel().getSelectedItem());
           sqmod.deleteCustomer(id);
       }else if(hotel.isVisible()){
           int id = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getId();
           sqmod.deleteHotel(id);
           hotel1.remove(hotel.getSelectionModel().getSelectedItem());
       }else if(resturanttable.isVisible()){
           int id = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodID();
           sqmod.deletePurchase(id);
           resturanttable1.remove(resturanttable.getSelectionModel().getSelectedItem());
       }else if(onlinestore.isVisible()){
           int id = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductID();
           sqmod.deleteOnlineStores(id);
           onlinestore3.remove(onlinestore.getSelectionModel().getSelectedItem());
       }else if(purchase.isVisible()){
           int id = purchase1.get(purchase.getSelectionModel().getSelectedIndex()).getId();
           sqmod.deletePurchase(id);
           purchase1.remove(purchase.getSelectionModel().getSelectedItem());
       }    
            
    }
    
    public void SignOut(ActionEvent event) throws IOException{
            
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/FXMLDocument.fxml").openStream());
            FXMLDocumentController pg = (FXMLDocumentController)loader.getController();
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.setScene(scene);
            primaryStage1.resizableProperty().setValue(Boolean.FALSE);
            primaryStage1.show();
    }
    
}