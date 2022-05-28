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
    Enemigo ene;

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
                pj.paintPersonaje(g);
                ene.paintEnemigo(g);
            }
        };
        this.add(pn, BorderLayout.CENTER);
    }

    public void ordenaComplementos(){
        pj = new Personaje();
        ene = new Enemigo();
        //pj.posicion[X] = 0; // Flags
        //pj.posicion[Y] = 0;
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
        ene.targetX = pj.posX;
        ene.targetY = pj.posY;
        ene.move();
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