/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import org.opencv.core.Point;

/**
 *
 * @author HumanoideFilms
 */
public class Notes {
    
    public static Note[] noteArray;
    static int numNotes=8;
    static int numNotesBlack=5;
    static int width=75;
    static int widthB=75;
    static int dezp=20;
    static int dezpB=20+40;
    static int dezpy=180;
    static int dezpyB=30;
    
        static String notes[]={"Do","Re","Mi","Fa","Sol","La","Si","Do","Do#","Re#","Fa#","Sol#","La#"};
    
    public static void createNotes(){
        int in=numNotes;
        noteArray=new Note[numNotes+numNotesBlack];
        for(int i=0;i<numNotes;i++){
            noteArray[i]=new Note(i,new Point(dezp+i*width,dezpy),new Point(((i+1)*width)+dezp,dezpy+150));
            noteArray[i].text=notes[i];
        }
        for(int i=0;i<numNotesBlack+(numNotesBlack/5)*2;i++){
            boolean d=false;
            if(i==2){
                d=true;
            }
            if((i+1)%7==0){
                d=true;
            }
            if(!d){
            noteArray[in]=new Note(in,new Point(dezpB+i*widthB,dezpyB),new Point(((i+1)*widthB)+dezpB,dezpyB+150));
            noteArray[in].text=notes[in];
            in++;
            }
        }
    }
    
}
