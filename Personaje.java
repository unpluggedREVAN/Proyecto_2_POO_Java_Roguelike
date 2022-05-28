import java.awt.Graphics;
import java.awt.Color;

public class Personaje implements Constantes{
    int[] posicion;
    public int posX;
    public int posY;
    public int dir;

    public Personaje(){
        posicion = new int[2];
        posX = 1;
        posY = 1;
        dir = 1;
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
    }

    public void move(int iden){
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
    }
}
