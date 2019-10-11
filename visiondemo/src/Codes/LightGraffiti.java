/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Luis Humanoide
 */
public class LightGraffiti {
    static int value=200;
    static int t=0;
    static Mat buffer=new Mat();
    public static Mat graffiti(Mat source){
        Mat thresh=new Mat();
        Mat gray=source.clone();
        Mat combined=source.clone();
        Imgproc.cvtColor(gray, gray, Imgproc.COLOR_RGB2GRAY);
        Mat masked=new Mat();
        Imgproc.threshold(gray, thresh, value, 255, Imgproc.THRESH_BINARY);
        source.copyTo(masked, thresh);
        Imgproc.GaussianBlur(masked, masked, new Size(11,11),11);
        if(t>0){
            Core.max(buffer, masked, buffer);
            t++;
        }
        if(t==0){
            buffer=masked.clone();
            t++;
        }
        if(t>1000){
            t=0;
        }
        
        Core.add(source, buffer, combined);
        Mat ret=combined.clone();
        
       
        return ret;
    }
    
}
