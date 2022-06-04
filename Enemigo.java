import java.awt.Graphics;
import java.util.*;

public class Enemigo extends NPC implements Observer, Model{
    public int targetX;
    public int targetY;
    public boolean vivo;

    static ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();

    public Enemigo(){
        coorX = 0;
        coorY = 0;
        vivo = true;
    }

    public void paintNPC(Graphics g){
        g.setColor(ENEMIGO_COLOR);
        g.fillRect(coorX, coorY, 34, 34); 
    }

    public void update(int posX, int posY){ // De observer
        this.targetX = posX;
        this.targetY = posY;

        this.move();
        this.borraEnemigos(); // Borra enemigos muertos
    }

    public boolean verificaColision(int dir, int xA, int yA){ // No se traslapan los enemigos
        for (int i=0;i<enemigos.size();i++) {
            if (dir == 1){
                if (enemigos.get(i).coorX == xA){
                    if (enemigos.get(i).coorY == yA - 35) {
                        return false;
                    }
                }
            }
            if (dir == 2){
                if (enemigos.get(i).coorY == yA){
                    if (enemigos.get(i).coorX == xA + 35) {
                        return false;
                    }
                }
            }
            if (dir == 3){
                if (enemigos.get(i).coorX == xA){
                    if (enemigos.get(i).coorY == yA + 35) {
                        return false;
                    }
                }
            }
            if (dir == 4){
                if (enemigos.get(i).coorY == yA){
                    if (enemigos.get(i).coorX == xA - 35) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    Personaje auxPj = new Personaje();
    public void move(){
        if (targetX != coorX && targetY != coorY){
            int numRand = (int)Math.floor(Math.random()*(2-1+1)+1);
            if (numRand == 1){
                if (targetX > coorX){
                    if (verificaColision(2, coorX, coorY) == true){ // Verifica si hay otro enemigo en la dirección a la que se dirige
                        coorX += 35;
                    }
                }
                else{
                    if (verificaColision(4, coorX, coorY) == true){
                        coorX -= 35;
                    }
                }
            }
            else{
                if (targetY > coorY){
                    if (verificaColision(3, coorX, coorY) == true){
                        coorY += 35;
                    }
                }
                else{
                    if (verificaColision(1, coorX, coorY) == true){
                        coorY -= 35;
                    }
                }
            }
        }
        else{
            if(targetX != coorX){
                if (targetX > coorX){
                    if (verificaColision(2, coorX, coorY) == true){
                        coorX += 35;
                    }
                }
                else{
                    if (verificaColision(4, coorX, coorY) == true){
                        coorX -= 35; 
                    }
                }
            }
            if(targetY != coorY){
                if (targetY > coorY){
                    if (verificaColision(3, coorX, coorY) == true){
                        coorY += 35;
                    }
                }
                else{
                    if (verificaColision(1, coorX, coorY) == true){
                        coorY -= 35;
                    }
                }
            }
            if (targetX == coorX && targetY == coorY && vivo == true){ // Cuando llega a tocar al personaje
                vivo = false;
                auxPj.bajarVida();
            }
        }
    }

    public void borraEnemigos(){ // Borra enemigos muertos de la lista
        for (int i=0;i<enemigos.size();i++) {
            if (enemigos.get(i).vivo == false){
                enemigos.remove(i);
            }
        }            
    }

    public void respawnObjeto(){
        int numRandom = (int)Math.floor(Math.random()*(19-1)+1);
        int multiplo = (numRandom * 35) + 1;

        coorX = multiplo;
        numRandom = (int)Math.floor(Math.random()*(POSIBILIDADES-1)+1);
        multiplo = (numRandom * 35) + 1;
        coorY = multiplo;
    }
}
