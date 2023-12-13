/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author afadli
 */
public class NewDb {
    
        public static void main(String[] args) {
        System.out.println("Printing data!");
        initDbTest();
    }
    public static void initDbTest(){
        try{
            System.out.println("Getting test db");
            Connection conn = Connection();
            createSchema(conn);
   
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static Connection Connection() throws SQLException {
        String url = "jdbc:sqlite:./db_location/blood_sample.db";
        Connection localConn = null;
        String[] tokens = url.split("\\:");
        System.out.println("out " + Arrays.toString(tokens));
        String dbPath = tokens[tokens.length - 1];
        File dbFile = new File(dbPath);
        if (!dbFile.exists()){
            try {                
                dbFile.createNewFile();
            } catch (IOException e){};
            dbFile.setReadable(true);
            dbFile.setWritable(true);
        }                
        String localUrl = tokens[0] + ":" + tokens[1] + ":" + tokens[2];
        if (localConn == null || localConn.isClosed()) {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            localConn = DriverManager.getConnection(localUrl, config.toProperties());
        }
        
        return localConn;
    }
    
    
    private static void createSchema(Connection conn) {
        try {
            final Statement stmt = conn.createStatement();
            
            /*https://class.ece.uw.edu/469/peckol/doc/ARM/assemblerDirectives.pdf
            String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
            */
            String user_samples = "CREATE TABLE IF NOT EXISTS samples \n" + 
                                "( id      INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                                "user_id INTEGER NOT NULL,\n" +
                                "created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP NOT NULL,\n" +
                                "wbc         REAL NOT NULL,\n" +
                                "rbc         REAL NOT NULL,\n" +
                                "hbg         REAL NOT NULL,\n" +
                                "hct         REAL NOT NULL,\n" +
                                "mpv         REAL NOT NULL,\n" +
                                "mch         REAL NOT NULL,\n" +
                                "mchc        REAL NOT NULL,\n" +
                                "rdw         REAL NOT NULL,\n" +
                                "platelet    REAL NOT NULL,\n" +
                                "mcv         REAL NOt NULL,\n" +
                                "FOREIGN KEY (user_id) REFERENCES users (id)" +
                                "        ON DELETE CASCADE);";
            
            String user_info = "CREATE TABLE users (\n" +
                                "id          INTEGER PRIMARY KEY  NOT NULL,\n" +
                                "created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                                "firstname   TEXT NOT NULL,\n" +
                                "lastname    TEXT NOT NULL,\n" +
                                "email       TEXT NOT NULL,\n" +
                                "dob         TEXT NOT NULL,\n" +
                                "address     TEXT NOT NULL,\n" +
                                "barcode     TEXT     \n" +
                                ");";
         
            stmt.executeUpdate(user_info);
            stmt.executeUpdate(user_samples);
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        } finally {
            try {
                if(conn != null){
                  conn.close();
                }
            } catch(SQLException e) {
              // Also failed to close the file
              System.err.println("[ERROR] createSchema : " + e.getMessage());
            }
        }
        
    }

}
