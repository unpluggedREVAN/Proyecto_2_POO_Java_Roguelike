// Proyecto roguelike - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Juego (Main)

public class Juego {
    public static void main(String[] args) throws Exception {
        Controller controlador = new Controller();
        GUI dotGame = new GUI(controlador);
    }
}
