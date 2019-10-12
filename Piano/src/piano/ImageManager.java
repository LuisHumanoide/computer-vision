/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;


import codes.PianoVision;
import utils.Convertor;
import utils.Properties;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

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
    public static void setImage(Mat image, WindowFrame frame) {
        // TODO Auto-generated method stub
        try {
            Mat graffiti=PianoVision.lightDect(image);
            Imgproc.resize(graffiti, graffiti, new Size(Properties.width, Properties.height));
            frame.addImg(Convertor.ConvertMat2Image(graffiti));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
