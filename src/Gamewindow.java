//import libraries
import java.awt.*;
import javax.swing.JFrame;

//Create Gamewindow class as superclass. it use to make windows for snake game.
public class Gamewindow {

    public static void main(String[] args)
    {

        JFrame obj = new JFrame();                           //make parent windows
        Gamelogin login = new Gamelogin();                   // make object in Gamelogin class


        obj.setTitle("WinSnake 1.0.1");
        obj.setBounds(500,200,945,690);   // set Boundaries to Frame
        obj.setResizable(false);                              // prevent resizable
        obj.setVisible(true);                                // set visible
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the application.(stop background running)
        obj.setBackground(Color.DARK_GRAY);                  // set Background colour for login panel
        obj.add(login);
        obj.setVisible(true);

    }
}
