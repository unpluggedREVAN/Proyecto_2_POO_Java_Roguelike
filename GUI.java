import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements ActionListener, Constantes, KeyListener{
    JFrame ventana;
    JButton next;
    Mapa mapa;
    Dot dot;
    Personaje pj;
    //Enemigo ene;
    Enemigo ene2;
    Enemigo ene3;

    int contadorTurnos;

    /*private static Teclado teclado; // Flags

    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];

    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha; */
    GUI(){
        this.setTitle("Proyecto 2 - Roguelike");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        this.setBounds(50,50,740,745); // Cambiar para los nuevos paneles
        ordenaComplementos();
        crearTablero(1, 0, 0);
        contadorTurnos = 1;
        
        //agregarElementos(); // Flags
        //this.pack();
    }
    
    private void crearTablero(int opcion, int x, int y){
        //this.setBounds(50,50,1145,800);
        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for(int y = 0; y < 20; y++){
                    for(int x = 0; x < 20; x++){
                        g.setColor(Color.black);
                        g.drawRect(x*35, y*35, 35, 35);
                    }
                }

                for (int i=0;i<Personaje.personaje.size();i++) {
                    if (Personaje.personaje.get(i).vida != 0){ // Solo imprime al personaje si sigue vivo
                        Personaje.personaje.get(i).paintPersonaje(g);
                    }
                }
                
                for (int i=0;i<Enemigo.enemigos.size();i++) {
                    if (Enemigo.enemigos.get(i).vivo == true){
                        Enemigo.enemigos.get(i).paintEnemigo(g);
                    }
                }
            }
        };
        this.add(pn, BorderLayout.CENTER);
    }

    public void ordenaComplementos(){
        pj = new Personaje();
        Personaje.personaje.add(pj);

        int cont = 1;
        while (cont <= 3)
        { 
            agregaEnemigo();
            cont += 1;
        }
    }

    public void agregaEnemigo(){
        Enemigo ene = new Enemigo();
        ene.respawnObjeto();
        Enemigo.enemigos.add(ene);
    }

    public boolean verificaEnemigos(){
        int contadorAux = 0;
        for (int i=0;i<Enemigo.enemigos.size();i++) { 
            if(Enemigo.enemigos.get(i).vivo == true){
                contadorAux += 1;
            }
        }
        if (contadorAux <= 3){
            return true;
        }
        else{
            return false;
        }
    }

    /**Este metodo se ejecuta cuando se presiona una tecla*/
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
        

    @Override
    public void keyReleased(KeyEvent e) {
        if (pj.vida > 0){
            if (e.VK_W == e.getKeyCode())
            {
                System.out.println("W presionada");
                pj.move(4);
                pj.dir = 1;
                this.repaint();
            }
            if (e.VK_D == e.getKeyCode())
            {
                System.out.println("D presionada");
                pj.move(3);
                pj.dir = 2;
                this.repaint();
            }
            if (e.VK_S == e.getKeyCode())
            {
                System.out.println("S presionada");
                pj.move(2);
                pj.dir = 3;
                this.repaint();
            }
            if (e.VK_A == e.getKeyCode())
            {
                System.out.println("A presionada");
                //dot.move(4); // Flag
                //moveDot();
                pj.move(1);
                pj.dir = 4;
                this.repaint();
            }

            if (e.VK_SPACE == e.getKeyCode())
            {
                System.out.println("SPACE presionado");
                pj.atacar();

                Enemigo auxiliar = new Enemigo();
                auxiliar.borraEnemigos(); // Borra enemigos muertos

                this.repaint();
                //dot.move(4); // Flag
                //moveDot();
                //pj.move(1);
                //pj.dir = 4;
                //this.repaint();
            }

            /* if (e.VK_P == e.getKeyCode())
            {
                System.out.println("P presionada");
                Enemigo auxiliar = new Enemigo();
                auxiliar.borraEnemigos();
                this.repaint();
            } */

            if ((e.VK_W == e.getKeyCode()) || (e.VK_A == e.getKeyCode()) || (e.VK_S == e.getKeyCode()) || (e.VK_D == e.getKeyCode())){
                for (int i=0;i<Enemigo.enemigos.size();i++) { 
                    Enemigo.enemigos.get(i).targetX = pj.posX;
                    Enemigo.enemigos.get(i).targetY = pj.posY;
        
                    Enemigo.enemigos.get(i).move();

                    Enemigo auxiliar = new Enemigo();
                    auxiliar.borraEnemigos(); // Borra enemigos muertos
                }
                if ((contadorTurnos % 10) == 0){
                    if (verificaEnemigos() == true){
                        agregaEnemigo();
                    }
                }

                contadorTurnos += 1;
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("next")){
            dot.move(3);
            moveDot();

        }
        else{
            mapa.tablero[dot.target[X]][dot.target[Y]].clearTarget();
            dot.target = ((Casilla)e.getSource()).getCoords();
            ((Casilla)e.getSource()).setAsTarget();
            moveDot();
        }
    }

    public void moveDot(){
        mapa.tablero[dot.lastPosition[X]][dot.lastPosition[Y]].clearDot();
        mapa.tablero[dot.currentPosition[X]][dot.currentPosition[Y]].setAsDot();
    }

}