/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * @author ruben
 */
public class Columna {
    
    Rectangle2D capitel,base;
    int hueco = 100;
     int ALTURA_COLUMNA = 400;
      int ANCHO_COLUMNA = 40;
      private  int ancho_pantalla;
    
    
    
    public Columna (int _ancho, int _anchopantalla){
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(300);
      capitel = new Rectangle2D.Double(_ancho,-desplazamiento ,ANCHO_COLUMNA, ALTURA_COLUMNA);
      base = new Rectangle2D.Double(_ancho,  ALTURA_COLUMNA + hueco - desplazamiento , ANCHO_COLUMNA, ALTURA_COLUMNA);
      
      
      ancho_pantalla = _anchopantalla;
    }
    
    
    
    public void Mueve (Graphics2D g2){
        
        //mueve la columna y la base
        mueveColumna();

        
        
        
        g2.setColor(Color.BLUE);
        g2.fill(capitel);
        g2.fill(base);
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
