/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * HelperMethods.java
 * @version 12/10/2023
 * @author Abderrahmane Fadli
 */
class HelperMethods {
    
    public static String DateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    public static String parseBloodInfo(String var, String num){
        double number;
        
        try {       
            number = Double.parseDouble(num);
            if (number < 0){
                return var + " has an invalid number";
            }
            
        } catch (NumberFormatException e){
            return var + " is an invalid entry";
        }
        
        return num;
    }
   
}
