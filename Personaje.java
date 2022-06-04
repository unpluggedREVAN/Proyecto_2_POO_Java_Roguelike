// Proyecto roguelike - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Personaje

import java.awt.Graphics;
import java.util.*;

public class Personaje implements Model, Observable{
    public int posX;
    public int posY;
    public int dir;
    public int vida;

    static ArrayList<Personaje> personaje = new ArrayList<Personaje>();

    static ArrayList<Enemigo> observerE = new ArrayList<Enemigo>(); // Lista observers
    static ArrayList<Aliado> observerA = new ArrayList<Aliado>(); // Lista observers

    public Personaje(){
        posX = 1;
        posY = 1;
        dir = 1;
        vida = VIDA_DEFAULT;
    }

    /// Métodos de la interfaz Observable ///
    public void notificar(){
        for (int i=0;i<observerE.size();i++) { 
            observerE.get(i).update(personaje.get(0).posX, personaje.get(0).posY); // Llama a update de enemigo
            eliminarObserver();
        }
        for (int i=0;i<observerA.size();i++) { 
            if (observerA.get(i).confirmaPos(personaje.get(0).posX, personaje.get(0).posY) == true){
                if (personaje.get(0).vida < VIDA_DEFAULT){
                    personaje.get(0).vida += 1;
                }

                observerA.get(i).update(0, 0); // Llama a update de aliado
                eliminarObserver();
            }
        }
    }

    public void eliminarObserver(){
        for (int i=0;i<observerA.size();i++) { // Se eliminan de la lista de observadores
            if (observerA.get(i).activo == false){
                observerA.remove(i);
            }
        }  
        for (int i=0;i<observerE.size();i++) {
            if (observerE.get(i).vivo == false){
                observerE.remove(i);
            }
        }   
    }

    public void paintPersonaje(Graphics g){
        if (dir == 1){
            g.setColor(PJ_COLOR_1);
            g.fillRect(posX, posY, 34, 34); // Genera versiones dependiendo de la dirección del personaje

            g.setColor(PJ_COLOR_2);
            g.fillRect(posX, posY, 34, 8);
        }
        if (dir == 2){
            g.setColor(PJ_COLOR_1);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(PJ_COLOR_2);
            g.fillRect(posX+26, posY, 8, 34);
        }
        if (dir == 3){
            g.setColor(PJ_COLOR_1);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(PJ_COLOR_2);
            g.fillRect(posX, posY+26, 34, 8);
        }
        if (dir == 4){
            g.setColor(PJ_COLOR_1);
            g.fillRect(posX, posY, 34, 34);

            g.setColor(PJ_COLOR_2);
            g.fillRect(posX, posY, 8, 34);
        }

        g.setColor(PJ_COLOR_1); // Dibujar rango
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
            if (iden == 2 && posY < LIMITE_HORIZONTAL){
                posY += 35; 
            }
            if (iden == 3 && posX < LIMITE_HORIZONTAL){
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
        for (int i=0;i<Aliado.aliados.size();i++) {
            if (alcanceP2 <= Aliado.aliados.get(i).coorX && Aliado.aliados.get(i).coorX <= alcanceP1 && Aliado.aliados.get(i).coorY >= posY - (35 * 3) && Aliado.aliados.get(i).coorY <= posY + (35 * 3)){ // && Aliado.aliados.get(i).coorY == posY
                Aliado.aliados.get(i).visible = true;
            }
            else{
                Aliado.aliados.get(i).visible = false;
            }
        }
    }

    public void atacar(){
        for (int i=0;i<Enemigo.enemigos.size();i++) {
            if (dir == 1){ // Solo ataca hacia donde se encuentra la dirección
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
