/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ruben
 */
public class Columna {
  
     
    
    Rectangle2D capitel,base;
    Ellipse2D redondeoInferior,redondeoSuperior;
    int hueco = 80;
     int ALTURA_COLUMNA = 500;
      int ANCHO_COLUMNA = 79;
      private  int ancho_pantalla;
      Image col_abajo,col_arriba;
    
    
    
    public Columna (int _ancho, int _anchopantalla){
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(300);
      capitel = new Rectangle2D.Double(_ancho,-desplazamiento ,ANCHO_COLUMNA, ALTURA_COLUMNA);
      base = new Rectangle2D.Double(_ancho,  ALTURA_COLUMNA + hueco - desplazamiento , ANCHO_COLUMNA, ALTURA_COLUMNA);
      
      
      redondeoInferior = new Ellipse2D.Double(_ancho, 
              ALTURA_COLUMNA + hueco - desplazamiento, 
              ANCHO_COLUMNA, ANCHO_COLUMNA);
      
      
      ancho_pantalla = _anchopantalla;
      precargaImagenes();
    }
    
    
    private void precargaImagenes(){
        col_abajo = (new ImageIcon(new ImageIcon(
                getClass().getResource("/Imagenes/pipe_bottom.png"))
                .getImage().getScaledInstance(79,500,Image.SCALE_DEFAULT)))
                .getImage();
         
                
         col_arriba = (new ImageIcon(new ImageIcon(
                getClass().getResource("/Imagenes/pipe_top.png"))
                .getImage().getScaledInstance(79,500,Image.SCALE_DEFAULT)))
                .getImage();
    }
    public void Mueve (Graphics2D g2){
        
        //mueve la columna y la base
        mueveColumna();

        
        
        
        g2.setColor(Color.BLUE);
        //g2.fill(capitel);
        //g2.fill(base);
        
        
        g2.drawImage(col_abajo, (int)base.getX(),(int)base.getY(),null);
        g2.drawImage(col_arriba, (int)capitel.getX(),(int)capitel.getY(),null);
    }
    
    
    
    private void mueveColumna (){
        
            if(capitel.getX()+ ANCHO_COLUMNA < 0){
                 Random aleatorio = new Random();
                 int desplazamiento = aleatorio.nextInt(300);
                capitel.setFrame(ancho_pantalla,-desplazamiento,
                        capitel.getWidth(),capitel.getHeight());
                
                 base.setFrame(ancho_pantalla, 
                         ALTURA_COLUMNA + hueco - desplazamiento,
                         base.getWidth(),base.getHeight());
                 
          }
            else{
                 capitel.setFrame(capitel.getX()-1,capitel.getY(),
                         capitel.getWidth(),capitel.getHeight());
                 
                base.setFrame(base.getX()-1,base.getY(),
                        base.getWidth(),base.getHeight()); 
            }
    }
}
