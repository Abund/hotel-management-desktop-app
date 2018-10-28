/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.collections.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import learn.*;
/**
 * FXML Controller class
 *
 * @author Abun
 */
public class ProductpageController implements Initializable {
    sqlModel sqmod = new sqlModel();
    
    
    @FXML
    private Label userLb1;
    
    @FXML
    private Label username;
    
    @FXML
    private TableView hotel;
    
    @FXML
    private Button clicky;
    
    @FXML
    private FlowPane otherbuttons;
    
    @FXML
    private FlowPane hotelbuttons;
    
    @FXML
    private BorderPane cartarea;
    
    @FXML
    private BorderPane profile;
    
    @FXML
    private StackPane stacky;
    
    @FXML
    private TableColumn column2;
    
    @FXML
    private TableColumn column1;
    
    @FXML
    private GridPane gridy;
    
    @FXML
    private TableView resturanttable;
    
    @FXML
    private TableView hotelex;
    
    @FXML
    private TextField totalnumber;
    
    @FXML
    private TextField itemsPurchased;
    
    @FXML
    private TextArea description;
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField email1;
    @FXML
    private TextField username1;
            
    @FXML
    private TableView onlinestore;
    
    @FXML
    private TableView bookings;
    
    
    @FXML
    private Button removebutton;
    
    @FXML
    private Button removebutton1;
    
    @FXML
    private TableView<Cart> cart;
    
    @FXML
    private DatePicker datep;
    
    @FXML
    private ImageView pictures;
    
    @FXML
    private Image pictures13;
    
    @FXML
    private FileChooser filechooser;
    
    @FXML
    private File file;
    
    @FXML
    private Spinner<Integer> spinner;
    
    @FXML
    private Spinner<Integer> spinner1;
    
    @FXML
    private ObservableList<descriptC> booking3 ;

    @FXML
    private ObservableList<hotel> hotel1 = FXCollections.observableArrayList() ;
    
    @FXML
    private ObservableList<resturant> resturanttable1 = FXCollections.observableArrayList();
    
    @FXML
    private ObservableList<Cart> onlinestore333;
    @FXML
    private ObservableList<onlinestores> onlinestore3 = FXCollections.observableArrayList();
    
    
    ArrayList<Integer> mm = new ArrayList<Integer>();
    ArrayList<String> mm1 = new ArrayList<String>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hotel.setVisible(true);
        sqmod.DisplayHotel(hotel1, hotel);
        sqmod.DisplayResturant( resturanttable1,resturanttable);
        sqmod.DisplayOnlinestore( onlinestore3,onlinestore);
        hotelbuttons.setVisible(true);
        otherbuttons.setVisible(false);
        profile.setVisible(false);
        //sqmod.getNameAndPriceForO(hotel,mm);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,7,1);
        spinner.setValueFactory(valueFactory);
        //description.setVisible(false);
        bookings.setVisible(true);
        hotel.setOnMouseClicked(e->{
            hotel hot =(hotel) hotel.getSelectionModel().getSelectedItem();
            sqmod.description(hot,this.pictures);
            
        });
     
        
    }    
    String user2;
    public void GetUser(String user){
        userLb1.setText("hi " + user+"!");
        this.user2=user;
    }
    
    public void GetHotelb(boolean user){
        this.bookings.setVisible(user);
        if(bookings.isVisible()){
            
        }
    }
    
    public void hotel(ActionEvent event) throws IOException{
        hotel.setVisible(true);
        resturanttable.setVisible(false);
        onlinestore.setVisible(false);
        cartarea.setVisible(false);
        profile.setVisible(false);
        stacky.setVisible(true);
        hotelbuttons.setVisible(true);
        otherbuttons.setVisible(false);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,7,1);
        spinner.setValueFactory(valueFactory);
        description.setVisible(false);
        bookings.setVisible(true);
       removebutton1.setVisible(true);
       pictures.setVisible(false);
        hotel.setOnMouseClicked(e->{
            pictures.setVisible(true);
            hotel hot =(hotel) hotel.getSelectionModel().getSelectedItem();
            sqmod.description(hot,this.pictures);
            
        });
    }
    public void resturant(ActionEvent event) throws IOException{
        hotel.setVisible(false);
        resturanttable.setVisible(true);
        onlinestore.setVisible(false);
        cartarea.setVisible(false);
        stacky.setVisible(true);
        hotelbuttons.setVisible(false);
        profile.setVisible(false);
        otherbuttons.setVisible(true);
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);
        spinner1.setValueFactory(valueFactory1);
        bookings.setVisible(false);
        removebutton1.setVisible(false);
        description.setWrapText(true);
        description.setVisible(true);
        description.clear();
        pictures.setVisible(false);
        resturanttable.setOnMouseClicked(e->{
            pictures.setVisible(true);
            resturant hot =(resturant) resturanttable.getSelectionModel().getSelectedItem();
            sqmod.appear(hot,this.description,this.pictures);
            
        });
        
    }
    
    public void onlinestore(ActionEvent event) throws IOException{
        onlinestore.setVisible(true);
        cartarea.setVisible(false);
        resturanttable.setVisible(false);
        hotel.setVisible(false);
        stacky.setVisible(true);
        profile.setVisible(false);
        hotelbuttons.setVisible(false);
        otherbuttons.setVisible(true);
        description.setWrapText(true);
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);
        spinner1.setValueFactory(valueFactory1);
        bookings.setVisible(false);
        removebutton1.setVisible(false);
        description.setVisible(true);
        description.clear();
        pictures.setVisible(false);
        onlinestore.setOnMouseClicked(e->{
            pictures.setVisible(true);
            onlinestores hot1 =(onlinestores) onlinestore.getSelectionModel().getSelectedItem();
            sqmod.appear1(hot1,this.description,this.pictures);            
        });
        
    }
    public void profile(ActionEvent event) throws IOException {
        profile.setVisible(true);
        cartarea.setVisible(false);
        stacky.setVisible(false);
        sqmod.profiler(user2,firstname,lastname,username1,email1);
    }
    public void cart(ActionEvent event) throws IOException{
        cartarea.setVisible(true);
        stacky.setVisible(false);
        profile.setVisible(false);
    }
    
    
    int hotelID;
    String rooms;
    int pricy;
    public int addToCartHotel(ActionEvent event) throws IOException{
        
        
        
        if(hotel.isVisible()){
            
            rooms = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getOurRooms();
            pricy = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getPrice();
            this.hotelID = hotel1.get(hotel.getSelectionModel().getSelectedIndex()).getId();
            pricy =  (Integer)spinner.getValue()* pricy;
            String date = datep.getValue().toString();
            hotel.getSelectionModel().clearSelection();
            mm.add(pricy);
            mm1.add(rooms);
            
            //onlinestore333.add(C,new Cart(rooms,pricy));
            //sqmod.updateHotel(hotel,hotelID);
            onlinestore333.add(0,new Cart(rooms,pricy));
            booking3.add(0,new descriptC(rooms,date));
            
            return hotelID;
        }else if(resturanttable.isVisible()){
            rooms = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodName();
            pricy = resturanttable1.get(resturanttable.getSelectionModel().getSelectedIndex()).getFoodPrice();
            pricy =  (Integer)spinner1.getValue()* pricy;
            resturanttable.getSelectionModel().clearSelection();
            mm.add(pricy);
            mm1.add(rooms);
            //sqmod.description(description,rooms);
            //onlinestore333.add(resturanttable.getSelectionModel().getSelectedIndex(),new Cart(rooms,pricy));
            onlinestore333.add(0,new Cart(rooms,pricy));
            
            
            
        }else if(onlinestore.isVisible()){
            rooms = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getProductName();
            pricy = onlinestore3.get(onlinestore.getSelectionModel().getSelectedIndex()).getPrice();
            pricy =  (Integer)spinner1.getValue()* pricy;
            onlinestore.getSelectionModel().clearSelection();
            mm.add(pricy);
            mm1.add(rooms);
            //onlinestore333.add(onlinestore.getSelectionModel().getSelectedIndex(),new Cart(rooms,pricy));
            onlinestore333.add(0,new Cart(rooms,pricy));
            
        }
        
        
        
        return hotelID;
    }
    
    public void Remove(ActionEvent event) throws IOException{
            
                String namey = onlinestore333.get(cart.getSelectionModel().getSelectedIndex()).getProductName();
                String roomy="room";
                
                if(namey.startsWith(roomy)){
                    onlinestore333.remove(cart.getSelectionModel().getSelectedItem());
                    cart.getSelectionModel().clearSelection();
                }else{
                    onlinestore333.remove(cart.getSelectionModel().getSelectedItem());
                    cart.getSelectionModel().clearSelection();
                }
            
    }
    
    public void Remove1(ActionEvent event) throws IOException{
        if(bookings.getSelectionModel().getSelectedItem()== null){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("nothing is selected");
            alert.showAndWait();
        }else{
            
//            for(Object i:cart.getItems()){ 
//                if(onlinestore333.contains(booking3.get(bookings.getSelectionModel().getSelectedIndex()).getRooms())){
//                    String things = booking3.get(bookings.getSelectionModel().getSelectedIndex()).getRooms();
//                   onlinestore333.remove(things) ;
//                }
//            }
            booking3.remove(bookings.getSelectionModel().getSelectedItem());
            cart.getSelectionModel().clearSelection();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("please delete the corresponding in the cart table");
            alert.showAndWait();
            }
        
    }
    
    public void Confirm(ActionEvent event) throws IOException{
        cartarea.setVisible(true);
        stacky.setVisible(false);
        
        int total = 0;
//        for(int i=0;i<mm.size();i++){
//            
//            total += mm.get(i);
//            String total1 = Integer.toString(total);
//            totalnumber.setText(total1);
//        }
        
//        StringBuilder tt = new StringBuilder();
//        for(int i=0;i<mm1.size();i++){
//           
//            tt.append(","+mm1.get(i));
//            
//        }
//        String sb = tt.toString();
//        itemsPurchased.setText(sb);
        
        int tot = 0;
        for(Object i:cart.getItems()){
           tot +=(int)column2.getCellData(i);
        }
        String total1 = Integer.toString(tot);
        totalnumber.setText(total1);
        
        //for name of items
        StringBuilder tt1 = new StringBuilder();
        for(Object i:cart.getItems()){
           
           tt1.append((String)column1.getCellData(i) + ",");
           
            
        }
        String sb = tt1.toString();
        itemsPurchased.setText(sb);
        
       
    }
    
    public void SignOut(ActionEvent event) throws IOException{
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage1 = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/learn/FXMLDocument.fxml").openStream()); 
            FXMLDocumentController pg = (FXMLDocumentController)loader.getController();
            //pg.GetUser(username.getText());
            Scene scene = new Scene(root,1400,980);
            scene.getStylesheets().add(getClass().getResource("/learn/learnstyle.css").toExternalForm());
            primaryStage1.setTitle("Nicon Places");
            primaryStage1.setScene(scene);
            primaryStage1.show();
    }
    
    public void confirm1(ActionEvent event) throws IOException{
        sqmod.updateHotel(hotel,hotelID);
        sqmod.updatepurchase(user2,rooms,pricy);
        
    }
}