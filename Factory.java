// Proyecto roguelike - POO
// Diana Sanabria (2021436548) / Jose Pablo Agüero Mora (2021126372) 
// Clase Factory

public class Factory {
    
    public void creaInstancia(int categoria){
        if (categoria == 1){ // Crear instancia de personaje
            agregaPersonaje();
        }
        if (categoria == 2){ // Crear instancia de enemigo
            agregaEnemigo();
        }
        if (categoria == 3){ // Crear instancia de aliado
            agregarAliados();
        }
    }

    public void agregaEnemigo(){
        Enemigo ene = new Enemigo();
        ene.respawnObjeto();
        Enemigo.enemigos.add(ene);
        Personaje.observerE.add(ene); // Observer
    }

    public void agregarAliados(){
        Aliado ali = new Aliado();
        ali.respawnObjeto();
        Aliado.aliados.add(ali);
        Personaje.observerA.add(ali); // Agrega a la lista de observer
    }

    public void agregaPersonaje(){
        Personaje pj;
        pj = new Personaje();
        Personaje.personaje.add(pj);
    }
}