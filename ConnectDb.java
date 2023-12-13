/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteConfig;
/**
 * ConnectDb.java
 * @version 12/10/2023
 * @author Abderrahmane Fadli
 */
public class ConnectDb {
    private static String url = "jdbc:sqlite:./db_location/blood_sample.db";
    private static int recordNum = -1;
    
    /**
     * Opens a connection to the in-memory SQLite instance.
     * If the underlying connection is closed, it creates a new connection. Otherwise, the current instance is returned
     * @throws SQLException JDBC {@link DriverManager} exception
     */
    
    private static Connection openConnection() throws SQLException {
        Connection localConn = null;
        if (localConn == null || localConn.isClosed()) {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            localConn = DriverManager.getConnection(url, config.toProperties());
        }
        
        return localConn;
    }
    
    
    /**
     * Closes the underlying connection to the in-memory SQLite instance.
     * It's a good practice to free up resources after you're done with them.
     * @throws SQLException JDBC {@link Connection} exception
     */
    private static void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
    

    
    /**
     * Function that takes user's info and samples and checks the database. 
     * If the user does not exist, then a new row is added with his firstname, 
     * date of birth and email. Otherwise append the samples to the user's id 
     * after retrieving it.
     * 
     * @param userInfo Hashmap of user's data that contains firstname, lastname dob.
     * @param userSample Ten information about blood work.
     * @return String is returned representing barcode of a new record in 
     *          <id>$<firstname>$<lastname>$<mm/dd/yyyy> format
     */
    
    public static String checkRecord(HashMap<Integer, String> userInfo, 
                            HashMap<Integer, Double> userSample){
        
        String barcodeImage = null;
        Connection conn = null;
        try {      
             conn = openConnection();
            // check if the user exists
            int index = userExists(userInfo, conn);

            // -1 if the user does not exists, otherwise user's id will be returned
            if (index == -1){
                System.out.println("User does not exist. Creating new record");
                
                // Gettinghte last id from users table
                /*
                index: 1 is firstname
                index: 2 is lastname 
                index: 3 is email
                index: 4 is date of birth
                index: 5 is address
                */
                recordNum = lastRecord(conn);
                newRecord(recordNum, userInfo, userSample, conn);
                String barcodeData = recordNum + "$" + userInfo.get(1) +
                            "$" + userInfo.get(2) + "$" +
                            userInfo.get(4);
                
                /* 
                Create a barcode from the user info as specified in barcodeData variable.
                barcode path is returned.
                */
                barcodeImage = BarCode.readToBarCode(barcodeData);
            } else {
                // If the user already in the db, we just update user's record.
                System.out.print("Update the samples for the user ");
                String msg = "User exists already.\n Update the user's samples.";
                JOptionPane.showMessageDialog(null, msg);
                updateRecord(index, userSample, conn);
                String barcodeData = index + "$" + userInfo.get(1) +
                            "$" + userInfo.get(2) + "$" +
                            userInfo.get(4);
                barcodeImage = BarCode.readToBarCode(barcodeData);
                
            }
        } catch (SQLException e){
            System.err.println("[ERROR]: checkRecord function: " + e.getMessage());
        } finally {
            try {
                if(conn!= null){
                  conn.close();
                }
            } catch(SQLException e) {
              // Also failed to close the file
              System.err.println("[ERROR] createSchema : " + e.getMessage());
            }
        }
        
        return barcodeImage;
    }
    
    /**
     * Function that will create a new user record and user's samples. 
     * @param index id number retrieved from lastRecord() function.
     * @param userInfo Hashmap of user's information
     * @param userSample Hashmap of  user's samples.
     * @param conn Connection object to established database connection.
     */
    private static void newRecord(int index, HashMap<Integer, String> userInfo, 
                            HashMap<Integer, Double> userSample,
                            Connection conn){
        
        String insert_user = "INSERT INTO users" +
                            "(firstname, lastname, email, dob, address) VALUES " +
                            "(?, ? ,? ,?, ?)";
        String insert_samples = "INSERT INTO samples" +
                            "(user_id, wbc, rbc, hbg,\n" +
                            "hct, mpv, mch,\n" +
                            "mchc, rdw, platelet, mcv) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        
        // Create a prepared statment object to make loop easy 
        
        try{
            try (PreparedStatement userStmt = conn.prepareStatement(insert_user)){
                
                for (HashMap.Entry<Integer, String> hm : userInfo.entrySet()){               
                    userStmt.setString(hm.getKey(), hm.getValue());
                }
                
                int result = userStmt.executeUpdate();
                
                if (result < 0){
                    throw new NumberFormatException("User data was not added!.");
                }
            }
            
           
            try (PreparedStatement sampleStmt = conn.prepareStatement(insert_samples)){                
                for (HashMap.Entry<Integer, Double> hm : userSample.entrySet()){
                sampleStmt.setInt(1, index);                    
                    sampleStmt.setDouble((hm.getKey() + 1), hm.getValue());
                }
                
                int result = sampleStmt.executeUpdate();
                if (result < 0){
                    throw new NumberFormatException("User samples were not added!.");
                }
            }
            
            
        } catch (SQLException | NumberFormatException e){
            System.err.println("[ERROR] newRecord function: " + e.getMessage());
        }
        
    }
    
    /**
     * Function to update user's sample data if the user already exists.
     * @param index id number of the existing user in the database.
     * @param userSample Hashmap of the user's blood sample.
     * @param conn Connectin object to the database.
     */
    
    private static void updateRecord(int index, 
                            HashMap<Integer, Double> userSample,
                            Connection conn){
        
        
        String insert_samples = "INSERT INTO samples" +
                        "(user_id, wbc, rbc, hbg,\n" +
                        "hct, mpv, mch,\n" +
                        "mchc, rdw, platelet, mcv) VALUES " +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try (PreparedStatement sampleStmt = conn.prepareStatement(insert_samples)){
            
                sampleStmt.setInt(1, index);
                for (HashMap.Entry<Integer, Double> hm : userSample.entrySet()){
                    sampleStmt.setDouble((hm.getKey() + 1), hm.getValue());
                }
                
                int result = sampleStmt.executeUpdate();
                if (result < 0){
                    throw new NumberFormatException("User samples were not added!.");
                }
                
        } catch(SQLException | NumberFormatException e){
            System.err.println("[ERROR] newRecord function: " + e.getMessage());
        }
    }
    
    
    /**
     * Function to check if a user exist in database or not. If the user exists, 
     * return the user's id from users table, otherwise return -1.
     * @param userInfo Hashmap of the user information
     * @param conn Connection object to the database.
     * @return user's id in exists, otherwise -1.
     */
    private static int userExists(HashMap<Integer, String> userInfo, 
                            Connection conn){
         try{
            Statement stmt = conn.createStatement();
            stmt.setQueryTimeout(30);
            /*  1: fisrtname
                2: last name 
                4:  dob 
            */

            String existUserSql = "SELECT * FROM users WHERE firstname = ?" +
                                   "AND lastname = ? AND dob = ?";
            
            PreparedStatement existUserPs = conn.prepareStatement(existUserSql);
            existUserPs.setString(1, userInfo.get(1));
            existUserPs.setString(2, userInfo.get(2));
            existUserPs.setString(3, userInfo.get(4));
            
            ResultSet rsUserExist = existUserPs.executeQuery(); 
            // if rsUserExist is true, then there is data
            if (rsUserExist.isBeforeFirst()){
                // return the id number 
                rsUserExist.next();
                return rsUserExist.getInt(1);
            }
            
            System.out.println("Done!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            
        }
         
        return -1;
    }


    /**
     * Function to return the last id to keep information consistant.
     * @param conn Connection object to the database;
     * @return last id in the table, otherwise return 1
     */
    private static int lastRecord(Connection conn){
        int id = 1;
        String lastUserIdSql = "SELECT id FROM users ORDER BY id DESC LIMIT 1;";
        Statement stmt = null;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(lastUserIdSql);
            if (rs.next()){                    
                id = Integer.parseInt(rs.getString("id")) + 1;         
            }
                
        } catch (SQLException e){
            System.err.println("[ERROR] lastRecord: " + e.getMessage());
        }
        
        return id;
    }
   
    /**
     * Function the retrieve data of a specific user. 
     * @param tokens an array of string containing decoded barcode 
     *          ( [<id>, <firstname>, <lastname>, <date of birsth> ])
     * @return returns Hashmap of all user's samples to display it later.
     */
    public static HashMap<Integer, String> retrieveRecord(String[] tokens){
        HashMap<Integer, String> list = new HashMap<>();

        String querySamples = "SELECT * FROM samples " +
                            "WHERE user_id = " + tokens[0] + ";";
        Connection conn = null;
        try {
            
            conn = openConnection();
            Statement samplesStmt = conn.createStatement();
            
            ResultSet samplesRs = samplesStmt.executeQuery(querySamples);
            int index = 0;

            while(samplesRs.next()){
                list.put((index + 1), samplesRs.getString("created"));
                list.put((index + 2), samplesRs.getString("wbc"));
                list.put((index + 3), samplesRs.getString("rbc"));
                list.put((index + 4), samplesRs.getString("hbg"));
                list.put((index + 5), samplesRs.getString("hct"));
                list.put((index + 6), samplesRs.getString("mpv"));
                list.put((index + 7), samplesRs.getString("mch"));
                list.put((index + 8), samplesRs.getString("mchc"));
                list.put((index + 9), samplesRs.getString("rdw"));
                list.put((index + 10), samplesRs.getString("platelet"));
                list.put((index + 11), samplesRs.getString("mcv"));
                index += 11;
            }
            
            // get the samples 
        } catch (SQLException e){
            System.err.println("[ERROR] retrieveRecord function " + e.getMessage());
        } finally {
            try {
                if(conn != null){
                  conn.close();
                }
            } catch(SQLException e) {
              // Also failed to close the file
              System.err.println("[ERROR] retreiveData function : " + e.getMessage());
            }
        }
        
        return list;
    }
       
}
