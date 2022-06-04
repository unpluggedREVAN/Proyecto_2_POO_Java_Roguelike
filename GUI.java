import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import java.net.URL;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements Model, KeyListener{
    JFrame ventana;
    JButton next;

    JLabel simbolo;
    JPanel panelIm;

    JLabel simbolo2;
    JPanel panelIm2;

    int contadorTurnos;

    Controller controlador;

    GUI(Controller primarioC){
        controlador = primarioC;
        this.setTitle("Proyecto 2 - Roguelike");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setBounds(50,50,720,990);
        controlador.ordenaComplementos();
        crearTablero(1, 0, 0);
        this.setVisible(true); 
        contadorTurnos = 1;
    }
    
    private void crearTablero(int opcion, int x, int y){
        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for(int y = 0; y < TABLERO_SIZE; y++){
                    for(int x = 0; x < TABLERO_SIZE; x++){
                        g.setColor(Color.black);
                        g.drawRect(x*CASILLA_WIDTH, y*CASILLA_HEIGHT, CASILLA_WIDTH, CASILLA_HEIGHT);
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

                for (int i=0;i<Aliado.aliados.size();i++) {        
                    if (Aliado.aliados.get(i).activo == true){
                        if (Aliado.aliados.get(i).visible == true){ // Solo imprime si está en el rango del personaje
                            Aliado.aliados.get(i).paintNPC(g);
                        }
                    }      
                } 
            }
        };
        this.add(pn, BorderLayout.CENTER);
        
        URL urlImagen = GUI.class.getClassLoader().getResource("banner.png"); 
        ImageIcon imagenInfo = new ImageIcon(urlImagen);
        simbolo = new JLabel(imagenInfo);
        simbolo.setIcon(imagenInfo);
        panelIm = new JPanel();
        panelIm.add(simbolo);
        this.add(panelIm, BorderLayout.SOUTH);

        URL urlImagen2 = GUI.class.getClassLoader().getResource("8.png"); 
        ImageIcon imagenInfo2 = new ImageIcon(urlImagen2);
        simbolo2 = new JLabel(imagenInfo2);
        simbolo2.setIcon(imagenInfo2);
        panelIm2 = new JPanel();
        panelIm2.add(simbolo2);
        this.add(panelIm2, BorderLayout.NORTH);

    }

    public void actualizaCorazones(){
        URL urlImagen2 = GUI.class.getClassLoader().getResource("8.png");
        panelIm2.removeAll();

        if (Personaje.personaje.get(0).vida == 8){
            urlImagen2 = GUI.class.getClassLoader().getResource("8.png"); // Cambia los corazones de vida según el estado del personaje
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
        simbolo2.setIcon(imagenInfo2);
        panelIm2.add(simbolo2);
        this.add(panelIm2, BorderLayout.EAST);
        panelIm2.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
        
    @Override
    public void keyReleased(KeyEvent e) { // Registro de eventos de teclado
        if (Personaje.personaje.get(0).vida > 0){ 
            if (e.VK_W == e.getKeyCode())
            {
                controlador.wPresiona();
                this.repaint();
            }
            if (e.VK_D == e.getKeyCode())
            {
                controlador.dPresiona();
                this.repaint();
            }
            if (e.VK_S == e.getKeyCode())
            {
                controlador.sPresiona();
                this.repaint();
            }
            if (e.VK_A == e.getKeyCode())
            {
                controlador.aPresiona();
                this.repaint();
            }

            if (e.VK_SPACE == e.getKeyCode())
            {  
                controlador.spacePresiona();
                this.repaint();
            }

            if ((e.VK_W == e.getKeyCode()) || (e.VK_A == e.getKeyCode()) || (e.VK_S == e.getKeyCode()) || (e.VK_D == e.getKeyCode())){

                Personaje.personaje.get(0).notificar();
                controlador.respawnSystem(contadorTurnos);
                actualizaCorazones();

                if (Personaje.personaje.get(0).vida == 0){
                    JOptionPane.showMessageDialog(ventana, "Fin del juego");
                }

                contadorTurnos += 1;
            }
        }
    }
}