/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import org.opencv.core.Core;
import org.opencv.core.Mat;
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
public class FaceDetect {
    /**
     * se carga el clasificador
     */
    static CascadeClassifier faceDetector = new CascadeClassifier(FaceDetect.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));

    public static Mat faceDetect(Mat image) {
        //CascadeClassifier faceDetector = new CascadeClassifier(FaceDetect.class.getResource("haarcascade_frontalface_alt.xml").getPath());
        //matriz de rectangulos
        MatOfRect faceDetections = new MatOfRect();
        //empieza a detectar las caras y las pone en la matriz
        faceDetector.detectMultiScale(image, faceDetections);

        //System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }
        return image;
    }

}
