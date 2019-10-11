/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Utils.Properties;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Luis Humanoide
 */
public class LightGraffiti {

    public static int t = 0;
    public static int check = 0;
    static Mat buffer = new Mat();

    public static Mat graffiti(Mat source) {

        Mat thresh = new Mat();
        Mat gray = source.clone();
        Mat combined = source.clone();
        Imgproc.cvtColor(gray, gray, Imgproc.COLOR_RGB2GRAY);
        Mat masked = new Mat();
        Imgproc.threshold(gray, thresh, Properties.thresh, 255, Imgproc.THRESH_BINARY);
        source.copyTo(masked, thresh);
        Imgproc.blur(masked, masked, new Size(Properties.blur, Properties.blur));

        if (t > 0) {
            if (check == 0) {
                Core.max(buffer, masked, buffer);
            }
            if (check == 1) {
                Core.addWeighted(buffer, Properties.decay, masked, 1, -0.5, buffer);
            }
        }
        if (t == 0) {
            buffer = masked.clone();
            t = 1;
        }

        Core.add(source, buffer, combined);
        Mat ret = combined.clone();

        return ret;
    }

}
