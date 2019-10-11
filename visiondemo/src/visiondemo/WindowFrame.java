/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visiondemo;

import Codes.LightGraffiti;
import Utils.Camera;
import Utils.Properties;
import Utils.Reader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;

/**
 * Esta clase es para mostrar las imagenes del opencv
 *
 * @author Humanoide
 */
public class WindowFrame extends javax.swing.JFrame {

    private Thread thread;
    Camera cam;
    int width;
    int height; 
    /**
     * Creates new form Fram
     */
    public WindowFrame() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Reader.readXML();
        initComponents();
        cam = new Camera(this);
        thread = new Thread(cam);
        thread.start();
       
        this.setSize(Properties.width, Properties.height+50);
        this.setLocation(Properties.locationX, Properties.locationY);
        jTextField1.setText(""+Properties.decay);
        label.setSize(Properties.width, Properties.height);  
        label.setLocation(0, 50);
        jSlider1.setValue(Properties.thresh);
        jSlider2.setValue(Properties.blur);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Umbral:");

        jSlider1.setBackground(new java.awt.Color(51, 51, 51));
        jSlider1.setForeground(new java.awt.Color(0, 102, 102));
        jSlider1.setMaximum(255);
        jSlider1.setMinimum(100);
        jSlider1.setValue(245);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Desenfoque:");

        jSlider2.setBackground(new java.awt.Color(51, 51, 51));
        jSlider2.setMaximum(50);
        jSlider2.setMinimum(1);
        jSlider2.setValue(11);
        jSlider2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider2MouseDragged(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(51, 51, 51));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("estela");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Decaimiento:");

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("set");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LightGraffiti.t=0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        // TODO add your handling code here:
        Properties.thresh=jSlider1.getValue();
    }//GEN-LAST:event_jSlider1MouseDragged

    private void jSlider2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider2MouseDragged
        // TODO add your handling code here:
        try{
        Properties.blur=jSlider2.getValue();
        }catch(Exception ex){}
    }//GEN-LAST:event_jSlider2MouseDragged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            LightGraffiti.check=1;
        }
        if(!jCheckBox1.isSelected()){
            LightGraffiti.check=0;
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
        Properties.decay=Double.parseDouble(jTextField1.getText());
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "pon un numero");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * esta cosa se llama cuando se cierra la ventana, si no lo pongo la captura
     * de video no se detiene
     */
    void exitProcedure() {
        cam.active = false;
        cam.videoDevice.release();
        System.exit(0);
    }


    /**
     * para visualizar la imagen hay varias formas, una de las mas faciles es
     * pasar la imagen a un label la otra es usar un canvas y pasarle la imagen
     * por ahí
     *
     * @param img
     */
    public void addImg(BufferedImage img) {
        label.setLocation(0, 20);
        label.setSize(Properties.width, Properties.height);
        label.setIcon(new ImageIcon(img));
        label.repaint();
    }

    public void setImage(Mat data) {
        // TODO Auto-generated method stub
        /*
        try {
            addImg(Convertor.ConvertMat2Image(data));

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}