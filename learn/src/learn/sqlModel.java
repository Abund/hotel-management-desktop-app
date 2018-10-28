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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import static java.nio.file.Files.size;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.collections.ObservableList;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

	
public class sqlModel {
	 
	 String url;
	 String serverName;
	 String instanceName;
	 String databaseName;
	 String userName;
	 String password;
         String sql;
 private FileInputStream fis;
//
	sqlModel() {
		url = "jdbc:sqlserver://";
		serverName = "DESKTOP-2O47DPJ"; 
		instanceName = ""; 
		databaseName = "trialstuff3"; 
		userName = "DESKTOP-2O47DPJ\\Abun"; 
		password = null;
	 } 
	private String getConnectionUrl() { 
		// Constructing the connection string 
		return url + serverName  +" ;DatabaseName = " +databaseName+"; integratedSecurity=true";
	 } 

	private java.sql.Connection getConnection() throws SQLException, ClassNotFoundException { 
            Connection con;
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			// Establishing the connection 
			con = DriverManager.getConnection(getConnectionUrl());
 			if(con != null){ 
				System.out.println("Connection Successful!");
                        }
			else{
				System.out.println(" no Connection ");
			}
                       return con; 
 		
	 	
                
	}
//        private  Connection getConnection() throws ClassNotFoundException, SQLException{
//            
//                Class.forName("com.mysql.jdbc.Driver");
//                    String user = "root"; 
//                      String password ="ebubechukwu";
//                      String url ="jdbc:mysql://localhost/mydb";
//                //Connection conn = DriverManager.getConnection("jdbc:sqlite:trialstuff3.sqlite");
//                Connection conn = DriverManager.getConnection(url,user,password);
//                if(conn != null){ 
//				System.out.println("Connection Successful!");
//                        }
//			else{
//				System.out.println(" no Connection ");
//			}
//                return conn;
//            
//        }
        //login verification code
        public boolean verifyCustomer(String username,String password)throws SQLException{
            Connection con1;
            ResultSet resultSet = null;
            String query = "select * from customertb where username =? and password=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                return false;
            } finally {
                
                if(resultSet != null)
                resultSet.close();
            }
        }
        
        public boolean verifyAdmin(String username,String password)throws SQLException{
            Connection con1;
            ResultSet resultSet = null;
            String query = "select * from admintb where username =? and password=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                return false;
            } finally {
                
                if(resultSet != null)
                resultSet.close();
            }
        }
        
        
//        public boolean verifyCustomer1(String username,String password)throws SQLException{
//            Connection con1;
//            try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con1 = DriverManager.getConnection(getConnectionUrl());
//            CallableStatement cstmt = con1.prepareCall("{call verfy2 (?, ?)}",ResultSet.TYPE_SCROLL_INSENSITIVE
//            ,ResultSet.CONCUR_READ_ONLY);
//            
//            cstmt.setString(1,username);
//            cstmt.setString(2,password);
//            
//            
//            if(cstmt.getResultSet().next()){
//                return true;
//            }else{
//                    return false;
//                }
//            
//            }catch(Exception e){
//                return false;
//            }    
//            
//        }
        //end of login verification code
        
        //code to insert to all table
        public void inserttoCustomertb1(String firstName1,String lastName1,String username,String emailAddress1,String password1){
                
            Connection con1;
            String query = "insert into customertb(firstName,lastName,userName,email,password) values(?, ?, ?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, firstName1);
                stmt.setString(2, lastName1);
                stmt.setString(3, username);
                stmt.setString(4, emailAddress1);
                stmt.setString(5, password1);
                
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
        }
        
        public void inserttoAdmin(String firstName1,String lastName1,String username,String emailAddress1,String password1){
                
            Connection con1;
            String query = "insert into admintb(firstName,lastName,userName,email,password) values(?, ?, ?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, firstName1);
                stmt.setString(2, lastName1);
                stmt.setString(3, username);
                stmt.setString(4, emailAddress1);
                stmt.setString(5, password1);
                
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
        }
       
        public void addToHotelTable(String rooms,String status,String description,int productPrice,File file){
                
            Connection con1;
            String query = "insert into hotel(rooms,status,description,productPrice,images) values(?,?, ?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, rooms);
                stmt.setString(2, status);
                stmt.setString(3, description);
                stmt.setInt(4, productPrice);
                fis = new FileInputStream(file);
                stmt.setBinaryStream(5, (InputStream)fis, (int) file.length());
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
        }

    void addToresturantTable(String foodName,String foodContent,int foodPrice,String foodStatus,File file) {
       Connection con1;
            String query = "insert into resturant(foodName,foodContent,foodPrice,foodStatus,images) values(?,?, ?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, foodName);
                stmt.setString(2, foodContent);
                stmt.setInt(3, foodPrice);
                stmt.setString(4, foodStatus);
                fis = new FileInputStream(file);
                stmt.setBinaryStream(5, (InputStream)fis, (int) file.length());
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }

    public void addToOnlinestore(String productName, String productDescription, String productStatus, int productPrice,File file) {
        Connection con1;
            String query = "insert into onlineStore(productName,productDescription,productStatus,productPrice,images) values(?,?, ?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, productName);
                stmt.setString(2, productDescription);
                stmt.setString(3, productStatus);
                stmt.setInt(4, productPrice);
                fis = new FileInputStream(file);
                stmt.setBinaryStream(5, (InputStream)fis, (int) file.length());
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }

    public void addToPurchaseTable(String user1, String rooms, String price) {
        Connection con1;
            String query = "insert into purchasetb11(user1,rooms,price) values(?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, user1);
                stmt.setString(2, rooms);
                stmt.setString(3, price);
                
                
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
        // coe to display all the tables
        public void DisplayHotel(ObservableList<hotel> data, TableView hotel1){
            Connection con1;
            String query ="select * from hotel";
            try {
            con1 = getConnection();
            PreparedStatement pst = con1.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                data.add(new hotel(
                rs.getInt("roomsID"),
                rs.getNString("rooms"),
                rs.getNString("status"),
                rs.getNString("description"),
                rs.getInt("productPrice")
                ));
                hotel1.setItems(data);
            }
                pst.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        public void DisplayCustomer(ObservableList<customer> data, TableView hotel1){
            Connection con1;
            String query ="select * from customertb";
            try {
            con1 = getConnection();
            PreparedStatement pst = con1.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                data.add(new customer(
                rs.getInt("custId"),
                rs.getNString("firstName"),
                rs.getNString("lastName"),
                rs.getNString("userName"),
                rs.getNString("email"),
                rs.getNString("password")
                ));
                hotel1.setItems(data);
            }
                pst.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                System.out.println(e.getCause());
            }
        }
        
        public void DisplayResturant(ObservableList<resturant> resturanttable1, TableView resturanttable){
            Connection con1;
            String query ="select * from resturant";
            try {
            con1 = getConnection();
            PreparedStatement pst = con1.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                resturanttable1.add(new resturant(
                rs.getInt("foodID"),
                rs.getNString("foodName"),
                rs.getNString("foodContent"),
                rs.getInt("foodPrice"),
                rs.getNString("foodStatus")
                ));
                resturanttable.setItems(resturanttable1);
            }
                pst.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        public void DisplayOnlinestore(ObservableList<onlinestores> onlinestore3, TableView onlinestore){
            Connection con1;
            String query ="select * from onlineStore";
            try {
            con1 = getConnection();
            PreparedStatement pst = con1.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                onlinestore3.add(new onlinestores(
                rs.getInt("productID"),
                rs.getNString("productName"),
                rs.getNString("productDescription"),
                rs.getInt("productPrice"),
                rs.getNString("productStatus")
                ));
                onlinestore.setItems(onlinestore3);
            }
                pst.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        //code to update tables in database
        public void updateHotel(TableView pam,int hotelID){
            
            String status1 = "not avalable";
            try{
                Connection con1 = getConnection();
                String query1 = "update hotel set status = ? where roomsID = ?";
                PreparedStatement stmt1 = con1.prepareStatement(query1);
                stmt1.setString(1, status1);
                stmt1.setInt(2, hotelID);
                stmt1.executeUpdate();
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
        
        public void updateHotel1(TableView pam,int hotelID){
            
            String status1 = "avalable";
            try{
                Connection con1 = getConnection();
                String query1 = "update hotel set status = ? where roomsID = ?";
                PreparedStatement stmt1 = con1.prepareStatement(query1);
                stmt1.setString(1, status1);
                stmt1.setInt(2, hotelID);
                stmt1.executeUpdate();
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }
        
        public void updatepurchase(String user,String rooms,int pricy){
            Connection con1;
            String query = "insert into purchasetb11(user1,rooms,pricy) values(?, ?, ?)";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, user);
                stmt.setString(2, rooms);
                stmt.setInt(3, pricy);
                
                stmt.executeUpdate();
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
        }
        
        public void updateCustomer(String firstName,String lastName,String userName,String password,String email,int sn){
            Connection con1;
            String query = "update customertb set firstName =?,lastName=?,userName=?,email =?, password=? where custId=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,firstName);
                stmt.setString(2,lastName);
                stmt.setString(3,userName);
                stmt.setString(4,email);
                stmt.setString(5,password);
                stmt.setInt(6,sn);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
                 System.out.println(e.getCause());
            }
    }
    
    public void updateHotel22(String rooms,String status,String description,int productPrice,int roomsID,File file){
        Connection con1;
            String query = "update hotel set rooms =?,status=?,description=?,productPrice =?,images=? where roomsID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,rooms);
                stmt.setString(2,status);
                stmt.setString(3,description);
                stmt.setInt(4,productPrice);
                stmt.setInt(6,roomsID);
                fis = new FileInputStream(file);
                stmt.setBinaryStream(5, (InputStream)fis, (long) file.length());
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 
            }
    }
    
    public void updateHotel1(String rooms,String status,String description,int productPrice,int roomsID){
        Connection con1;
            String query = "update hotel set rooms =?,status=?,description=?,productPrice =? where roomsID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,rooms);
                stmt.setString(2,status);
                stmt.setString(3,description);
                stmt.setInt(4,productPrice);
                stmt.setInt(5,roomsID);
                
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
                 System.out.println(e.getCause());
            }
    }
    
    public void updateOnlineStore(String productName,String productDescription,String productStatus,int productPrice,int productID,File file){
        Connection con1;
            String query = "update onlineStore set productName =?,productDescription=?,productStatus=?,productPrice =?,images=? where productID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,productName);
                stmt.setString(2,productDescription);
                stmt.setString(3,productStatus);
                stmt.setInt(4,productPrice);
                stmt.setInt(6,productID);
                
                fis = new FileInputStream(file);
                stmt.setBinaryStream(5, (InputStream)fis, (int) file.length());
                
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
                 System.out.println(e);
            }
    }
    
    public void updateOnlineStore1(String productName,String productDescription,String productStatus,int productPrice,int productID){
        Connection con1;
            String query = "update onlineStore set productName =?,productDescription=?,productStatus=?,productPrice =? where productID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,productName);
                stmt.setString(2,productDescription);
                stmt.setString(3,productStatus);
                stmt.setInt(4,productPrice);
                stmt.setInt(5,productID);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
                 System.out.println(e);
            }
    }
    
    public void updatePurcahse(String user1,String rooms,int pricy,int roomsID){
        Connection con1;
            String query = "update purchasetb11 set user1 =?,rooms=?,pricy=?where roomsID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,user1);
                stmt.setString(2,rooms);
                stmt.setInt(3,pricy);
                stmt.setInt(4,roomsID);
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    
    public void updateResturant(String foodName,String foodContent,int foodPrice,String foodStatus, int foodID,File file){
        Connection con1;
            String query = "update resturant set foodName =?,foodContent=?,foodPrice=?,foodStatus =?,images=? where foodID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,foodName);
                stmt.setString(2,foodContent);
                stmt.setInt(3,foodPrice);
                stmt.setString(4,foodStatus);
                stmt.setInt(6,foodID);
                fis = new FileInputStream(file);
                stmt.setBinaryStream(5, (InputStream)fis, (long) file.length());
                stmt.executeUpdate();
            }catch(Exception e){
                 System.out.println(e.getMessage());
                 System.out.println(e.getCause());
                 System.out.println(e.getLocalizedMessage());
            }
    }
    
     
    public void updateResturant11(String foodName,String foodContent,int foodPrice,String foodStatus, int foodID){
        Connection con1;
            String query = "update resturant set foodName =?,foodContent=?,foodPrice=?,foodStatus =? where foodID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1,foodName);
                stmt.setString(2,foodContent);
                stmt.setInt(3,foodPrice);
                stmt.setString(4,foodStatus);
                stmt.setInt(5,foodID);
                
                stmt.executeUpdate();
            }catch(Exception e){
                 System.out.println(e.getMessage());
                 System.out.println(e.getCause());
                 System.out.println(e.getLocalizedMessage());
            }
    }
        
    //code to delete from tables
    public void deleteCustomer( int custId){
        Connection con1;
            String query = "delete from customertb  where custId=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                ;
                stmt.setInt(1,custId);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    
    public void deleteOnlineStores( int productID){
        Connection con1;
            String query = "delete from onlineStores  where productID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                ;
                stmt.setInt(1,productID);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    public void deleteHotel( int roomsID){
        Connection con1;
            String query = "delete from hotel  where roomsID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                ;
                stmt.setInt(1,roomsID);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    public void deleteResturant( int foodID){
        Connection con1;
            String query = "delete from onlineStores  where foodID=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                ;
                stmt.setInt(1,foodID);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    public void deletePurchase( int purchId){
        Connection con1;
            String query = "delete from purchasetb11  where purchId=?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                
                stmt.setInt(1,purchId);
                stmt.executeUpdate();
                
            
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    //end of delete code
    
     //onclick code for images
        public void appear(resturant hot,TextArea description,ImageView pics){
                try{
                Connection con1 = getConnection();
                String query ="select * from resturant where foodID =?";
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setInt(1,hot.getFoodID());
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    description.setText(rs.getNString("foodContent"));
                    InputStream is = rs.getBinaryStream("images");
                    OutputStream os = new FileOutputStream(new File("photo1.jpg"));
                    byte[] content = new byte[1024];
                    int size = 0;
                        while((size=is.read(content))!=-1){
                            os.write(content,0,size);
                        }
                    os.close();
                    is.close();
                    Image image = new Image("file:photo1.jpg",350,600,true,true);
                    pics.setImage(image);
                    pics.setFitWidth(350);
                    pics.setFitHeight(600);
                    pics.setPreserveRatio(true);
                }
                
                stmt.close();
                rs.close();
                }catch(Exception e){
                    
                }
            
            
        }
        
        public void appear1(onlinestores hot,TextArea description,ImageView pics){
                try{
                Connection con1 = getConnection();
                String query ="select * from onlineStore where productID =?";
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setInt(1,hot.getProductID());
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    description.setText(rs.getNString("productDescription"));
                    InputStream is = rs.getBinaryStream("images");
                    OutputStream os = new FileOutputStream(new File("photo.jpg"));
                    byte[] content = new byte[1024];
                    int size = 0;
                        while((size=is.read(content))!=-1){
                            os.write(content,0,size);
                        }
                    os.close();
                    is.close();
                    Image image = new Image("file:photo.jpg",350,600,true,true);
                    pics.setImage(image);
                    pics.setFitWidth(350);
                    pics.setFitHeight(600);
                    pics.setPreserveRatio(true);
                }
                
                stmt.close();
                rs.close();
                }catch(Exception e){
                    
                }
            
        }
        //end of onclick code
        //description code for hotel
        public void description(hotel hot,ImageView pics){
            try{
                Connection con1 = getConnection();
                String query ="select * from hotel where roomsID =?";
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setInt(1,hot.getId());
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    
                    InputStream is = rs.getBinaryStream("images");
                    OutputStream os = new FileOutputStream(new File("photo2.jpg"));
                    byte[] content = new byte[1024];
                    int size = 0;
                        while((size=is.read(content))!=-1){
                            os.write(content,0,size);
                        }
                    os.close();
                    is.close();
                    Image image = new Image("file:photo2.jpg",350,600,true,true);
                    pics.setImage(image);
                    pics.setFitWidth(350);
                    pics.setFitHeight(600);
                    pics.setPreserveRatio(true);
                }
                
                stmt.close();
                rs.close();
                }catch(Exception e){
                    
                }
        }
           //code for profile page in proguct page
    void profiler(String user2, TextField firstname, TextField lastname, TextField username1, TextField email1) {
        Connection con1;
            String query = "select * from customertb where userName = ?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, user2);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                   firstname.setText(rs.getNString("firstName"));
                   lastname.setText(rs.getNString("lastName"));
                   username1.setText(rs.getNString("userName"));
                   email1.setText(rs.getNString("email"));
                }
            }catch(Exception e){
                 System.out.println(e.getMessage());
            }
    }
    //end of profile code
    
     
        public boolean verifyCustomerPurchase(String username)throws SQLException{
            Connection con1;
            ResultSet resultSet = null;
            ResultSet resultSet1 = null;
            String query = "select * from purchasetb where username =? ";
            String query1 = "select * from customertb where username =? ";
            try {
                con1 = getConnection();
                PreparedStatement stmt1 = con1.prepareStatement(query1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                stmt1.setString(1, username);
                int purchaserID = 0;
                resultSet1 = stmt1.executeQuery();
                if(resultSet1.next()){
                   purchaserID = resultSet1.getInt("purchaserID");
                }
                PreparedStatement stmt = con1.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                stmt.setInt(1,purchaserID);
                
                resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                return false;
            } finally {
                
                if(resultSet != null)
                    resultSet.close();
            }
        }
       
    
       
        public boolean checkpurchase(String user){
            Connection con1;
            String query = "select * from purchasetb11 where user = ?";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query);
                stmt.setString(1, user);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                 return false;
            }
        }
        
        public boolean verifyCustomer11(String username)throws SQLException{
            Connection con1;
            ResultSet resultSet = null;
            String query = "select * from purchasetb11 where username =? ";
            try {
                con1 = getConnection();
                PreparedStatement stmt = con1.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                stmt.setString(1, username);
                
                resultSet = stmt.executeQuery();
                if(resultSet.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                return false;
            } finally {
                
                if(resultSet != null)
                resultSet.close();
            }
        }

      
  
}