import java.awt.Graphics;
import java.awt.Color;
import java.util.*;

public class Personaje implements Constantes{
    int[] posicion;
    public int posX;
    public int posY;
    public int dir;
    public int vida;

    static ArrayList<Personaje> personaje = new ArrayList<Personaje>();

    public Personaje(){
        posicion = new int[2];
        posX = 1;
        posY = 1;
        dir = 1;
        vida = 8;
    }

    public void paintPersonaje(Graphics g){
        if (dir == 1){
            g.setColor(Color.RED);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(Color.YELLOW);
            g.fillRect(posX, posY, 34, 8);
        }
        if (dir == 2){
            g.setColor(Color.RED);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(Color.YELLOW);
            g.fillRect(posX+26, posY, 8, 34);
        }
        if (dir == 3){
            g.setColor(Color.RED);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(Color.YELLOW);
            g.fillRect(posX, posY+26, 34, 8);
        }
        if (dir == 4){
            g.setColor(Color.RED);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(Color.YELLOW);
            g.fillRect(posX, posY, 8, 34);
        }

        g.setColor(Color.RED);
        g.drawRect(posX-105, posY-105, 243, 243);
    }

    public void bajarVida(){
        for (int i=0;i<personaje.size();i++) {
            personaje.get(i).vida -= 1;
        }
    }

    public void move(int iden){
        if (vida > 0){
            if (iden == 1 && posX > 1){
                posX -= 35; 
            }
            if (iden == 2 && posY < 666){
                posY += 35; 
            }
            if (iden == 3 && posX < 666){
                posX += 35; 
            }
            if (iden == 4 && posY > 1){
                posY -= 35; 
            }
            encontrarAliado();
        }
    }

    public void encontrarAliado(){
        int alcanceP1;
        int alcanceP2;
        alcanceP1 = this.posX + (35 * 3);
        alcanceP2 = this.posX - (35 * 3);
        for (int i=0;i<Aliado.aliados.size();i++) { // Arreglar uno de los dos
            if (alcanceP2 <= Aliado.aliados.get(i).coorX && Aliado.aliados.get(i).coorX <= alcanceP1 && Aliado.aliados.get(i).coorY >= posY - (35 * 3) && Aliado.aliados.get(i).coorY <= posY + (35 * 3)){ // && Aliado.aliados.get(i).coorY == posY
                Aliado.aliados.get(i).visible = true;
                System.out.println("Entra");
            }
            /* if (this.posX > Aliado.aliados.get(i).coorX && Aliado.aliados.get(i).coorX >= alcanceP2 && Aliado.aliados.get(i).coorY >= posY - (35 * 3) && Aliado.aliados.get(i).coorY <= posY + (35 * 3)){ // && Aliado.aliados.get(i).coorY == posY
                Aliado.aliados.get(i).visible = true;
                System.out.println("Entra2");
            } */
            else{
                Aliado.aliados.get(i).visible = false;
            }
        }
    }

    public void atacar(){
        for (int i=0;i<Enemigo.enemigos.size();i++) {
            if (dir == 1){
                if (Enemigo.enemigos.get(i).coorX == posX && Enemigo.enemigos.get(i).coorY == posY - 35){
                    Enemigo.enemigos.get(i).vivo = false;
                }
            }
            if (dir == 2){
                if (Enemigo.enemigos.get(i).coorY == posY && Enemigo.enemigos.get(i).coorX == posX + 35){
                    Enemigo.enemigos.get(i).vivo = false;
                }
            }
            if (dir == 3){
                if (Enemigo.enemigos.get(i).coorX == posX && Enemigo.enemigos.get(i).coorY == posY + 35){
                    Enemigo.enemigos.get(i).vivo = false;
                }
            }
            if (dir == 4){
                if (Enemigo.enemigos.get(i).coorY == posY && Enemigo.enemigos.get(i).coorX == posX - 35){
                    Enemigo.enemigos.get(i).vivo = false;
                }
            }
        }
    }
}
