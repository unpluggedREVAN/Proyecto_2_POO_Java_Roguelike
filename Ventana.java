
package proyecto.pkg2;

import javax.swing.JFrame;

/**
 *
 * @author Diana
 */
public class Ventana {
    JFrame frame;
    
    public Ventana(){
    frame = new JFrame("Proyecto Roguelike - POO");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(50,50,860,800);
    frame.setVisible(true);
    }
}
