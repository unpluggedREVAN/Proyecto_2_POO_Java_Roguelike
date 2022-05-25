import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements ActionListener, Constantes, KeyListener{
    JFrame ventana;
    JButton next;
    Mapa mapa;
    Dot dot;
    Personaje pj;

    /*private static Teclado teclado;

    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];

    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha; */
    GUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        agregarElementos();
        this.pack();
    }
    
    public void agregarElementos(){
        //teclado = new Teclado();
        //teclado.addKeyListener(this);
        //addKeyListener(teclado);

        

        next = new JButton("continuar");
        next.addActionListener(this);
        next.setActionCommand("next");

        mapa = new Mapa(this);

        //ventana = new JFrame();
        this.add(mapa.panelTablero);
        //this.add(next, BorderLayout.SOUTH); // Para botón
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ventana.pack();
        //ventana.setVisible(true);
        //ventana.addKeyListener(this);

        dot = new Dot();
        moveDot();

        pj = new Personaje();

        //accionTeclado();
        //ventana.addKeyListener(ventana);

    }

    /**Este metodo se ejecuta cuando se presiona una tecla*/
    @Override
    public void keyPressed(KeyEvent e) {
        
        /*if (e.VK_W == e.getKeyCode())
        {
            System.out.println("Arriba");
        }
        /*if (e.VK_E==e.getKeyCode())
        {
            vocales+="e "; 
            cantidadVocales++;
        }
        if (e.VK_I==e.getKeyCode())
        {
            vocales+="i ";
            cantidadVocales++;
        }
        if (e.VK_O==e.getKeyCode())
        {
            vocales+="o "; 
            cantidadVocales++;
        }
        if (e.VK_U==e.getKeyCode())
        {
            vocales+="u ";
            cantidadVocales++;
        } */
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
        

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.VK_W == e.getKeyCode())
        {
            System.out.println("W presionada");
            dot.move(1);
            moveDot();
        }
        if (e.VK_D == e.getKeyCode())
        {
            System.out.println("D presionada");
            dot.move(2);
            moveDot();
        }
        if (e.VK_S == e.getKeyCode())
        {
            System.out.println("S presionada");
            dot.move(3);
            moveDot();
        }
        if (e.VK_A == e.getKeyCode())
        {
            System.out.println("A presionada");
            dot.move(4);
            moveDot();
        }
        //System.out.println("You released key char: " + e.getKeyChar());
        
    }

    /*public void actualizar() {
        arriba = teclas[KeyEvent.VK_W];
        abajo =  teclas[KeyEvent.VK_S];
        izquierda =  teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
    }

    protected void accionTeclado(){
        KeyListener l = new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                teclas[e.getKeyCode()] = true;
            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                teclas[e.getKeyCode()] = false;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }

        };
        ventana.addKeyListener(l);
        if(teclado.arriba){
            System.out.println("Arriba");
        }
    } */

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

        /* teclado.actualizar();

        if(teclado.arriba){
            System.out.println("Arriba");
        }
        if(teclado.abajo){
            System.out.println("Abajo");
        }
        if(teclado.izquierda){
            System.out.println("Izquierda");
        }
        if(teclado.derecha){
            System.out.println("Derecha");
        } */
        
    }

    public void moveDot(){
        mapa.tablero[dot.lastPosition[X]][dot.lastPosition[Y]].clearDot();
        mapa.tablero[dot.currentPosition[X]][dot.currentPosition[Y]].setAsDot();
    }

}