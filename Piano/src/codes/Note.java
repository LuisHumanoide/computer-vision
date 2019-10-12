/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import org.opencv.core.Point;
import org.opencv.core.Scalar;

/**
 *
 * @author HumanoideFilms
 */
public class Note {
    
    int index;
    Scalar color;
    Scalar off=new Scalar(200,150,50);
    Scalar on=new Scalar(255,255,200);
    String text="Do";
    String dspText="";

    public Scalar getColor() {
        if(!active){
            dspText="";
            color=off;
        }
        if(active){
            dspText=text;
            color=on;
        }
        return color;
    }

    public void setColor(Scalar color) {
        this.color = color;
    }

    public Note(int index, Point p1, Point p2) {
        this.index = index;
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    Point p1;
    Point p2;
    Point p12,p22;

    public Point getP12() {
        return new Point(p1.x+40,p1.y);
    }

    public Point getP22() {
        return new Point(p2.x-40,p2.y);
    }
    boolean active=false;
    boolean previusState=false;

    public boolean isPreviusState() {
        return previusState;
    }

    public void setPreviusState(boolean previusState) {
        this.previusState = previusState;
    }
    
    public boolean isSound(){
        boolean sound=false;
        if(previusState==false&&active==true){
            sound=true;
        }
        return sound;
    }
    
}
