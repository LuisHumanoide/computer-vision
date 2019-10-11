/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Humanoide
 */
public class ObjectDetectCascades {
    //clasificador de carros
    public static CascadeClassifier cars = new CascadeClassifier(FaceDetect.class.getResource("cars.xml").getPath().substring(1));
    //clasificador de peatones
    public static CascadeClassifier pedestrian = new CascadeClassifier(FaceDetect.class.getResource("pedestrian.xml").getPath().substring(1));

    /**
     * detecta cosas locas
     * @param image la imagen a analizar
     * @param clasifier el clasificador de cascada como xml
     * @param text el texto a mostrar
     * @return el frame con las detecciones
     */
    public static Mat cascadeDetect(Mat image, CascadeClassifier clasifier, String text) {

        MatOfRect detections = new MatOfRect();
        
        clasifier.detectMultiScale(image, detections);

        for (Rect rect : detections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(255, 255, 0));
            Imgproc.putText(image, text, new Point(rect.x + rect.width, rect.y + rect.height), Core.FONT_HERSHEY_PLAIN, 1.5, new Scalar(255, 255, 0));
            
        }
        Imgproc.putText(image, detections.toArray().length+" objects", new Point ( 50,50), Core.FONT_HERSHEY_DUPLEX, 1.5, new Scalar(100, 100, 255));

        return image;
    }
    
    /**
     * retorna el centro de un rectangulo
     * @param rect
     * @return 
     */
    public static Point center(Rect rect){
        return new Point(rect.x+rect.width/2,rect.y+ rect.height/2);
    }
    

}
