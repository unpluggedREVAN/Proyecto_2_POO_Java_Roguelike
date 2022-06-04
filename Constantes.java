import java.awt.Color;

public interface Constantes {
    public static final int X = 0;
    public static final int Y = 1;

    public static final int CASILLA_WIDTH = 35;
    public static final int CASILLA_HEIGHT = 35;

    public static final int TABLERO_SIZE = 20; // Era 15

    public static final Color TARGET_COLOR = Color.GREEN;
    public static final Color BG_COLOR = Color.LIGHT_GRAY;
    public static final Color DOT_COLOR = Color.RED;
    
    public int contadorTurnos = 1;
}
