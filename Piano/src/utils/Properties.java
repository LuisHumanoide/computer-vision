/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author HumanoideFilms
 */
public class Properties {
    
    public static int width;
    public static int height;
    public static int locationX;
    public static int locationY;
    public static int blur;
    public static int thresh;
    public static int autoErase;
    public static int tErase;
    public static int refreshTime;
    public static int camera;
    public static double decay;

    public static double getDecay() {
        return decay;
    }

    public static void setDecay(double decay) {
        Properties.decay = decay;
    }

    public static int getCamera() {
        return camera;
    }

    public static void setCamera(int camera) {
        Properties.camera = camera;
    }

    public static String getString() {
        return "Properties{" + width+"  "+ height+ "  "+locationX+"   "+locationY+ "  "+blur+"    "+thresh+'}';
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Properties.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Properties.height = height;
    }

    public static int getLocationX() {
        return locationX;
    }

    public static void setLocationX(int locationX) {
        Properties.locationX = locationX;
    }

    public static int getLocationY() {
        return locationY;
    }

    public static void setLocationY(int locationY) {
        Properties.locationY = locationY;
    }

    public static int getBlur() {
        return blur;
    }

    public static void setBlur(int blur) {
        Properties.blur = blur;
    }

    public static int getThresh() {
        return thresh;
    }

    public static void setThresh(int thresh) {
        Properties.thresh = thresh;
    }

    public static int getAutoErase() {
        return autoErase;
    }

    public static void setAutoErase(int autoErase) {
        Properties.autoErase = autoErase;
    }

    public static int gettErase() {
        return tErase;
    }

    public static void settErase(int tErase) {
        Properties.tErase = tErase;
    }

    public static int getRefreshTime() {
        return refreshTime;
    }

    public static void setRefreshTime(int refreshTime) {
        Properties.refreshTime = refreshTime;
    }
    
}
