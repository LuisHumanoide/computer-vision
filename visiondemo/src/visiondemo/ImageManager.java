/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visiondemo;

import Codes.Blur;
import Codes.ObjectDetectCascades;
import Codes.FaceDetect;
import Utils.Convertor;
import org.opencv.core.Mat;

/**
 * Esta clase es para poner el método donde se podrán llamar las otras clases
 * para diversos métodos de visión
 *
 * @author Humanoide
 */
public class ImageManager {
    
    /**
     * Metodo para hacer los tests
     * @param image
     * @param frame 
     */
    public static void setImage(Mat image, Frame frame) {
        // TODO Auto-generated method stub
        try {
            Mat dect=ObjectDetectCascades.cascadeDetect(image, ObjectDetectCascades.pedestrian, "peaton");
            frame.addImg(Convertor.ConvertMat2Image(dect));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
