// Proyecto roguelike - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Super clase NPC

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
