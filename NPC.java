import java.awt.Graphics;

public abstract class NPC {
    int coorX;
    int coorY;
    int direccion;

    public NPC (){
        coorX = 0;
        coorY = 0;
        direccion = 0;
    }

    // Se van a usar con polimorfismo
    public abstract void paintNPC(Graphics g);
    public abstract void respawnObjeto();
}
