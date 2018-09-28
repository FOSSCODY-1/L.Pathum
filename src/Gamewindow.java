//import libraries
import java.awt.*;
import javax.swing.*;

//Create Gamewindow class as superclass. it use to make windows for snake game.
public class Gamewindow extends JFrame{

    public static void main(String[] args)
    {
        Gameplay play = new Gameplay();                      // Gameplay class object
        Gamelogin login = new Gamelogin();                   // Gamelogin class object

        Gamewindow obj = new Gamewindow();                   // Gamewindow classobject

        ImageIcon iconimage = new ImageIcon("snakeicon.png"); // get icon image

        obj.setTitle("WinSnake 1.0.1");                      // set title for game window
        obj.setBounds(500,200,945,690);   // set boundaries for window
        obj.setResizable(false);                             // prevent resizable
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the application.(stop background running)
        obj.setBackground(Color.DARK_GRAY);                  // set Background colour for frame
        obj.setIconImage(Toolkit.getDefaultToolkit().getImage(String.valueOf(iconimage)));  // set window icon
        obj.setVisible(true);                                // set visible

        obj.add(login);                                       // add game login panel

    }

}
