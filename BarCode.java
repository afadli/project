/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Writer;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Arrays;

/**
 * BarCode.java
 * @version 12/10/023
 * @author Abderrahmane Fadli
 */
public class BarCode {
    
    /* got help from https://www.geeksforgeeks.org/how-to-generate-and-read-qr-code-with-java-using-zxing-library/ */
    /**
     * Function to reads string data in for of <id>$<firstname>$<lastname>$<dateofbirth>
     * and saves the barcode as image in barcode_imgs folders for ease retrievals. Also the user 
     * is prompted to print the barcode.
     * @param data tring representation of the data to encode. i,e: 1$firstname$lastname$01/01/1980
     * @return path where barcode image is saved.
     */
    public static String readToBarCode(String data){
        // split "1$firstname$lastname$01/01/1980" based on '$' delimiter
        String[] tokens = data.split("\\$");
        String dateTime[] = HelperMethods.DateTime().replaceAll("[/:]", "").split("\\s+");
        
        // Save file in /path/to/image/<firstname>_<lastname>.jpg
        String barcodePath = "./barcode_imgs/"  +  tokens[1] + "_" + tokens[2] + "_" + dateTime[0] + "-" + dateTime[1] + ".jpg";
        try{
            Code128Writer codeWrite = new Code128Writer();
            BitMatrix codeMatrix = codeWrite.encode(data, BarcodeFormat.CODE_128, 100, 100);
            MatrixToImageWriter.writeToPath(codeMatrix, "jpg", Paths.get(barcodePath));
            System.out.println("Done creating barcode...!");
            return barcodePath;
            
        } catch (Exception e) {
            System.err.println("[ERROR] Read data to barcode " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * Function that takes a barcode image and return its string presentations.
     * @param barcode path to the barcode iamge that needed to be decoded.
     * @return String representation of the barcode image.
     */
    public static String readFromBarCode(String barcode){
        String ErrorMsg = "Sorry, but barcode provided can't be read!";
        BinaryBitmap image = null;
        MultiFormatReader reader = new MultiFormatReader();
        Result result = null;
        try {
            
            image = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(ImageIO.read(
                            new FileInputStream(barcode)))));
            result = reader.decode(image);
            return result.getText();
            
        } catch (NotFoundException | IOException e){
            System.err.println("[ERROR] Read from barcode " + e.getMessage());
            return ErrorMsg;
        }

    }           
}
