import java.awt.event.*;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; // Para las alertas

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GUI extends JFrame implements Constantes, KeyListener{
    JFrame ventana;
    JButton next;
    Personaje pj;
    //Enemigo ene;
    Enemigo ene2;
    Enemigo ene3;

    JLabel simbolo;
    JPanel panelIm;

    JLabel simbolo2;
    JPanel panelIm2;

    int contadorTurnos;

    Factory creador = new Factory(); // Debería ir en controller

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
        //this.setVisible(true);
        this.addKeyListener(this);
        this.setBounds(50,50,720,990); // Cambiar para los nuevos paneles // 1145
        ordenaComplementos();
        crearTablero(1, 0, 0);
        this.setVisible(true); // Tiene que estar después de crear tablero
        //contadorTurnos = 1;
        
        
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
                        Enemigo.enemigos.get(i).paintNPC(g);
                    }
                }

                for (int i=0;i<Aliado.aliados.size();i++) {         //
                    if (Aliado.aliados.get(i).activo == true){ // Antes era visible
                        System.out.println("Activo: " + Aliado.aliados.get(i).visible);
                        if (Aliado.aliados.get(i).visible == true){ // Antes era visible
                            Aliado.aliados.get(i).paintNPC(g);
                        }
                    }      
                } 
            }
        };
        this.add(pn, BorderLayout.CENTER);
        

        URL urlImagen = GUI.class.getClassLoader().getResource("banner2.png"); // getClassLoader()
        ImageIcon imagenInfo = new ImageIcon(urlImagen);
        simbolo = new JLabel(imagenInfo);
        simbolo.setIcon(imagenInfo);
        panelIm = new JPanel();
        panelIm.add(simbolo);
        this.add(panelIm, BorderLayout.SOUTH);
        System.out.println("Llega");

        URL urlImagen2 = GUI.class.getClassLoader().getResource("8.png"); // getClassLoader()
        ImageIcon imagenInfo2 = new ImageIcon(urlImagen2);
        simbolo2 = new JLabel(imagenInfo2);
        simbolo2.setIcon(imagenInfo2);
        panelIm2 = new JPanel();
        panelIm2.add(simbolo2);
        this.add(panelIm2, BorderLayout.NORTH);
        System.out.println("Llega");

    }

    public void ordenaComplementos(){
        creador.creaInstancia(1);

        int cont = 1;
        while (cont <= 3)
        {
            creador.creaInstancia(2);
            cont += 1;
        }
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

    public boolean verificaAliados(){
        int contadorAux = 0;
        for (int i=0;i<Aliado.aliados.size();i++) { 
            if(Aliado.aliados.get(i).activo == true){
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

    public void actualizaCorazones(){
        URL urlImagen2 = GUI.class.getClassLoader().getResource("8.png");
        panelIm2.removeAll();

        if (Personaje.personaje.get(0).vida == 8){
            urlImagen2 = GUI.class.getClassLoader().getResource("8.png");
        }
        if (Personaje.personaje.get(0).vida == 7){
            urlImagen2 = GUI.class.getClassLoader().getResource("7.png");
        }
        if (Personaje.personaje.get(0).vida == 6){
            urlImagen2 = GUI.class.getClassLoader().getResource("6.png");
        }
        if (Personaje.personaje.get(0).vida == 5){
            urlImagen2 = GUI.class.getClassLoader().getResource("5.png");
        }
        if (Personaje.personaje.get(0).vida == 4){
            urlImagen2 = GUI.class.getClassLoader().getResource("4.png");
        }
        if (Personaje.personaje.get(0).vida == 3){
            urlImagen2 = GUI.class.getClassLoader().getResource("3.png");
        }
        if (Personaje.personaje.get(0).vida == 2){
            urlImagen2 = GUI.class.getClassLoader().getResource("2.png");
        }
        if (Personaje.personaje.get(0).vida == 1){
            urlImagen2 = GUI.class.getClassLoader().getResource("1.png");
        }
        if (Personaje.personaje.get(0).vida == 0){
            urlImagen2 = GUI.class.getClassLoader().getResource("0.png");
            
            
        }
        ImageIcon imagenInfo2 = new ImageIcon(urlImagen2);
        //simbolo2 = new JLabel(imagenInfo2);
        simbolo2.setIcon(imagenInfo2);
        //panelIm2 = new JPanel();
        panelIm2.add(simbolo2);
        this.add(panelIm2, BorderLayout.EAST);

        panelIm2.repaint();
        System.out.println("Llega");
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
        if (Personaje.personaje.get(0).vida > 0){
            if (e.VK_W == e.getKeyCode())
            {
                System.out.println("W presionada");
                Personaje.personaje.get(0).move(4);
                Personaje.personaje.get(0).dir = 1;
                this.repaint();
            }
            if (e.VK_D == e.getKeyCode())
            {
                System.out.println("D presionada");
                Personaje.personaje.get(0).move(3);
                Personaje.personaje.get(0).dir = 2;
                this.repaint();
            }
            if (e.VK_S == e.getKeyCode())
            {
                System.out.println("S presionada");
                Personaje.personaje.get(0).move(2);
                Personaje.personaje.get(0).dir = 3;
                this.repaint();
            }
            if (e.VK_A == e.getKeyCode())
            {
                System.out.println("A presionada");
                //dot.move(4); // Flag
                //moveDot();
                Personaje.personaje.get(0).move(1);
                Personaje.personaje.get(0).dir = 4;
                this.repaint();
            }

            if (e.VK_SPACE == e.getKeyCode())
            {
                System.out.println("SPACE presionado");
                Personaje.personaje.get(0).atacar();

                Enemigo auxiliar = new Enemigo();
                auxiliar.borraEnemigos(); // Borra enemigos muertos

                //
                
                


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
                Personaje.personaje.get(0).notificar(); // Realiza el proceso observer

                if ((contadorTurnos % 10) == 0){
                    if (verificaEnemigos() == true){ // Verifica que no pase de 4 enemigos simultáneos
                        creador.creaInstancia(2);
                    }
                    if (verificaAliados() == true){ // Verifica que no pase de 4 enemigos simultáneos
                        creador.creaInstancia(3);
                    }
                }

                
                actualizaCorazones();

                if (Personaje.personaje.get(0).vida == 0){
                    JOptionPane.showMessageDialog(ventana, "Fin del juego");
                }

                contadorTurnos += 1;
            }
        }
        
    }

}