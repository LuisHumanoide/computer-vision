/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import utils.Properties;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Range;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Luis Humanoide
 */
public class PianoVision {

    public static int t = 0;
    public static int check = 0;
    static Mat buffer = new Mat();

    public static Mat lightDect(Mat source) {

        Mat thresh = new Mat();
        Mat gray = source.clone();
        Imgproc.cvtColor(gray, gray, Imgproc.COLOR_RGB2GRAY);
        Imgproc.blur(gray, gray, new Size(Properties.blur, Properties.blur));
        Imgproc.threshold(gray, thresh, Properties.thresh, 255, Imgproc.THRESH_BINARY);
        checkLight(thresh);
        return rectangles(source);
    }

    public static Mat rectangles(Mat mat) {
        Mat matrix = mat.clone();
        for (int i = 0; i < Notes.noteArray.length; i++) {
            Imgproc.rectangle(
                    matrix, //Matrix obj of the image
                    Notes.noteArray[i].p1, //p1
                    Notes.noteArray[i].p2, //p2
                    new Scalar(0, 0, 0), //Scalar object for color
                    15//Thickness of the line
            );
        }
        for (int i = 0; i < Notes.noteArray.length; i++) {
            Imgproc.rectangle(
                    matrix, //Matrix obj of the image
                    Notes.noteArray[i].p1, //p1
                    Notes.noteArray[i].p2, //p2
                    Notes.noteArray[i].getColor(), //Scalar object for color
                    3 //Thickness of the line
            );
            Imgproc.putText(matrix, Notes.noteArray[i].dspText, new Point(Notes.noteArray[i].p1.x+10,Notes.noteArray[i].p1.y+80), Core.FONT_HERSHEY_TRIPLEX, 1, new Scalar(0,0,0));
            Imgproc.putText(matrix, Notes.noteArray[i].dspText, new Point(Notes.noteArray[i].p1.x+10,Notes.noteArray[i].p1.y+80), Core.FONT_ITALIC, 1, Notes.noteArray[i].getColor());
        }
        return matrix;
    }

    public static void checkLight(Mat thresh) {
        for (int i = 0; i < Notes.noteArray.length; i++) {
            Notes.noteArray[i].previusState = Notes.noteArray[i].active;
            Mat checkMat = new Mat(thresh.size(), thresh.type());
            Mat roiMat;
            Rect r = new Rect(Notes.noteArray[i].p1, Notes.noteArray[i].p2);
            //Range rowRange=new Range((int)Notes.noteArray[i].p1.x,(int)Notes.noteArray[i].p2.x);
            //Range colRange=new Range((int)Notes.noteArray[i].p1.y,(int)Notes.noteArray[i].p2.y);
            roiMat = new Mat(thresh, r);
            double sum = Core.sumElems(roiMat).val[0];
            if (sum > 0) {
                Notes.noteArray[i].active = true;
            } else {
                Notes.noteArray[i].active = false;
            }
            if (Notes.noteArray[i].isSound()) {
                Sound.play(i);
            }

        }
    }

}
