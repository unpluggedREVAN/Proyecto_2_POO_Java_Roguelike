import java.awt.Graphics;
import java.awt.Color;
//import java.util.Random;

public class Enemigo {
    public int targetX;
    public int targetY;

    public int coorX;
    public int coorY;

    public Enemigo(){
        coorX = 351;
        coorY = 36;
    }

    public void paintEnemigo(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(coorX, coorY, 34, 34); 
    }

    public void move(){
        if (targetX != coorX && targetY != coorY){
            int numRand = (int)Math.floor(Math.random()*(2-1+1)+1);
            if (numRand == 1){
                if (targetX > coorX){
                    coorX += 35;
                }
                else{
                    coorX -= 35;
                }
            }
            else{
                if (targetY > coorY){
                    coorY += 35;
                }
                else{
                    coorY -= 35;
                }
            }
        }
        else{
            if(targetX != coorX){
                if (targetX > coorX){
                    coorX += 35;
                }
                else{
                    coorX -= 35;
                }
            }
            if(targetY != coorY){
                if (targetY > coorY){
                    coorY += 35;
                }
                else{
                    coorY -= 35;
                }
            }
        }
    }
}
