/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import piano.WindowFrame;
import piano.ImageManager;

/**
 * Class for receive information from unity, the information is codified in jpeg
 * format
 *
 * @author Humanoide
 */
public class Camera implements Runnable {
    //ande ca
    public VideoCapture videoDevice = new VideoCapture();
    Mat src = new Mat();
    WindowFrame frame;
    public boolean active=true;
    /**
     * recibe la clase frame a la cual se le pasará la imagen
     * @param frame 
     */
    public Camera(WindowFrame frame) {
        /* si no funciona se cambia a otro número*/
        videoDevice.open(Properties.camera);
        this.frame=frame;
    }
    /**
     * aquí corre el hilo donde se estará haciendo la captura de video
     * ANDE CA
     * YA VAMONOS
     */
    @Override
    public void run() {
        while (active) {
            try {
                videoDevice.read(src);
                Core.flip(src, src, 1);
                MatHandler(src);
                Thread.sleep(Properties.refreshTime);
            } catch (Exception ex) {
            }
        }
        if(!active){
            videoDevice.release();
        }
    }

    /**
     * Esta madre de aquí le pasa la matriz de opencv de regreso a la clase frame
     * @param matrix recargado
     */
    private void MatHandler(Mat matrix) {
        ImageManager.setImage(matrix,frame);
    }

}
