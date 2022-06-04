// Proyecto roguelike - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Aliado

import java.awt.Graphics;
import java.util.ArrayList;

public class Aliado extends NPC implements Observer, Model{
    public boolean visible;
    public boolean activo;
    
    static ArrayList<Aliado> aliados = new ArrayList<Aliado>();
    
    public Aliado(){
        visible = false;
        activo = true;
    }

    public void paintNPC(Graphics g){
        g.setColor(ALIADO_COLOR);
        g.fillRect(coorX, coorY, 34, 34); 
    }

    /// Método update de la interfaz ///
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
        for (int i=0;i<Personaje.observerA.size();i++) { // Se eliminan de la lista de observadores
            if (Personaje.observerA.get(i).activo == false){
                Personaje.observerA.remove(i);
            }
        }         
    }

    // Verifica si el aliado fue rescatado por el personaje
    public boolean confirmaPos(int pX, int pY){
        if (pX == this.coorX && pY == this.coorY){
            return true;
        }
        else{
            return false;
        }
    }
    
    /// Reordena de forma aleatoria las nuevas instancias aliado ///
    public void respawnObjeto(){
        int numRandom = (int)Math.floor(Math.random()*(POSIBILIDADES-1)+1);
        int multiplo = (numRandom * 35) + 1;

        coorX = multiplo;
        numRandom = (int)Math.floor(Math.random()*(POSIBILIDADES-1)+1);
        multiplo = (numRandom * 35) + 1;
        coorY = multiplo;
    }
}