/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Humanoide
 */
public class Blur {
    /**
     * hace un desenfoque gaussiano
     * @param source
     * @return 
     */
    public static Mat gaussianBlur(Mat source){
        Imgproc.GaussianBlur(source, source,new Size(45,45), 0);
        return source;
    }
    
}
