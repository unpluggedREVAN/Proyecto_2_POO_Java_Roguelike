// Proyecto roguelike - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Controller

public class Controller implements Model{

    Factory creador = new Factory();

    public void ordenaComplementos(){
        creador.creaInstancia(1);

        int cont = 1;
        while (cont <= LIMITE_COMPLEMENTOS)
        {
            creador.creaInstancia(2);
            cont += 1;
        }
    }

    public boolean verificaEnemigos(){ // No permite más de 4 enemigos simultáneos
        int contadorAux = 0;
        for (int i=0;i<Enemigo.enemigos.size();i++) { 
            if(Enemigo.enemigos.get(i).vivo == true){
                contadorAux += 1;
            }
        }
        if (contadorAux <= LIMITE_COMPLEMENTOS){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verificaAliados(){ // No permite más de 4 aliados simultáneos
        int contadorAux = 0;
        for (int i=0;i<Aliado.aliados.size();i++) { 
            if(Aliado.aliados.get(i).activo == true){
                contadorAux += 1;
            }
        }
        if (contadorAux <= LIMITE_COMPLEMENTOS){
            return true;
        }
        else{
            return false;
        }
    }

    public void respawnSystem(int turnos){ // Reaparece NPC
        if ((turnos % TURNOS_RESPAWN) == 0){
            if (verificaEnemigos() == true){ // Verifica que no pase de 4 enemigos simultáneos
                creador.creaInstancia(2);
            }
            if (verificaAliados() == true){ // Verifica que no pase de 4 aliados simultáneos
                creador.creaInstancia(3);
            }
        }
    }

    public void wPresiona(){ // Reacción a los controles
        Personaje.personaje.get(0).move(4);
        Personaje.personaje.get(0).dir = 1;
    }
    public void dPresiona(){
        Personaje.personaje.get(0).move(3);
        Personaje.personaje.get(0).dir = 2;
    }
    public void sPresiona(){
        Personaje.personaje.get(0).move(2);
        Personaje.personaje.get(0).dir = 3;
    }
    public void aPresiona(){
        Personaje.personaje.get(0).move(1);
        Personaje.personaje.get(0).dir = 4;
    }
    public void spacePresiona(){
        Personaje.personaje.get(0).atacar();
        Enemigo auxiliar = new Enemigo();
        auxiliar.borraEnemigos(); 
    }
}
