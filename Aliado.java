
//package proyecto.pkg2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import java.util.ArrayList;

/**
 *
 * @author Diana
 */
public class Aliado {
    public boolean visible;
    public int color;
    
    public int coorX;
    public int coorY;
    
    static ArrayList<Aliado> aliados = new ArrayList<Aliado>();
    
    public Aliado(){
        this.visible=false;
        
    }
    
    public void ActivarVisibilidad(){
        this.visible=true;
    
    }
    public void paintAliados(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(coorX, coorY, 34, 34); 
    }
    
    
    public void respawnObjeto(){
        int numRandom = (int)Math.floor(Math.random()*(19-1)+1);
        int multiplo = (numRandom * 35) + 1;

        coorX = multiplo;

        /* for (int i = 0; i < listaAmenazas.size(); i++){
            if (i == 0 || i == 3){
                listaAmenazas.get(i).coorX = multiplo;
            }
            else{
                listaAmenazas.get(i).coorX = multiplo + 15;
            }
        } */

        numRandom = (int)Math.floor(Math.random()*(19-1)+1);
        multiplo = (numRandom * 35) + 1;

        coorY = multiplo;

        /* for (int i = 0; i < listaAmenazas.size(); i++){
            if (i == 0 || i == 1){
                listaAmenazas.get(i).coorY = multiplo;
            }
            else{
                listaAmenazas.get(i).coorY = multiplo + 15;
            }
        } */
    }
}
