/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Humanoide
 */
public class Convertor {


    /**
     * Convert a Buffered image to OpenCV Matrix
     *
     * @param bi
     * @return
     */
    public static Mat bufferedImageToMat(BufferedImage bi) {
        Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }

    /**
     * Convert a matrix to image without multiplying by 255
     *
     * @param mat
     * @return
     */
    public static BufferedImage ConvertMat2Image(Mat mat) {
        MatOfByte bytes = new MatOfByte();
        Imgcodecs.imencode(".jpg", mat, bytes);
        byte[] byteArray = bytes.toArray();
        BufferedImage image = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            image = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return image;
    }
    /**
     * Resize the image 
     * @param value , the max value in pixels
     * @param matrix
     * @return 
     */
    public static Mat reSize(int value, Mat matrix){
        double newHeight = value * (double) (matrix.height() * 1.0 / matrix.width());
        double newWidth = value * (double) (matrix.width() * 1.0 / matrix.height());
        Size size;
        if (matrix.width() > matrix.height()) {
            size = new Size(value, newHeight);
        }
        else{
            size = new Size(newWidth,value);
        }
        Imgproc.resize(matrix, matrix, size);
        return matrix;
    }

}
