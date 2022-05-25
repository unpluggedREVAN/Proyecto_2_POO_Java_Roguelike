public class Personaje implements Constantes{
    int[] posicion;

    public Personaje(){
        posicion = new int[2];
        posicion[X] = 0;
        posicion[Y] = 0;
    }

    public void move(){
        posicion[X] += 1;
    }
}
