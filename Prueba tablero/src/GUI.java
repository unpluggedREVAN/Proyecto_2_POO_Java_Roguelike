import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI implements ActionListener, Constantes{

    private static Teclado teclado;

    JFrame ventana;
    JButton next;
    Mapa mapa;
    Dot dot;
    
    public GUI(){
        teclado = new Teclado();
        //teclado.addKeyListener(this);
        //addKeyListener(teclado);

        ventana = new JFrame();
        mapa = new Mapa(this);


        ventana.add(mapa.panelTablero);

        next = new JButton("continuar");
        next.addActionListener(this);
        next.setActionCommand("next");

        ventana.add(next, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

        dot = new Dot();
        moveDot();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("next")){
            dot.move();
            moveDot();

        }
        else{
            mapa.tablero[dot.target[X]][dot.target[Y]].clearTarget();
            dot.target = ((Casilla)e.getSource()).getCoords();
            ((Casilla)e.getSource()).setAsTarget();
            moveDot();
        }

        teclado.actualizar();

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
        }
        
    }

    public void moveDot(){
        mapa.tablero[dot.lastPosition[X]][dot.lastPosition[Y]].clearDot();
        mapa.tablero[dot.currentPosition[X]][dot.currentPosition[Y]].setAsDot();
    }

}