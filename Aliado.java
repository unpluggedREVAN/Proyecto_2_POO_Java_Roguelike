import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Aliado extends NPC implements Observer{
    public boolean visible;

    public boolean activo;
    
    static ArrayList<Aliado> aliados = new ArrayList<Aliado>();
    
    public Aliado(){
        visible = false;
        activo = true;
    }
    
    /* public void ActivarVisibilidad(){
        this.visible=true;
    
    } */

    public void paintNPC(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(coorX, coorY, 34, 34); 
    }

    public void update(int posX, int posY){
        this.inactivarAliado();
        this.borraAliados(); // Borra de la lista los inactivos
    }

    public void inactivarAliado(){
        this.activo = false;
    }

    public void borraAliados(){ // Borra enemigos muertos de la lista
        for (int i=0;i<aliados.size();i++) {
            if (aliados.get(i).activo == false){
                aliados.remove(i);
            }
        }       
        for (int i=0;i<Personaje.observerA.size();i++) { // Aquí se eliminan de la lista de observadores
            if (Personaje.observerA.get(i).activo == false){
                Personaje.observerA.remove(i);
            }
        }         
    }

    public boolean confirmaPos(int pX, int pY){
        if (pX == this.coorX && pY == this.coorY){
            return true;
        }
        else{
            return false;
        }
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