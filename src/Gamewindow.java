
//import libraries
import java.awt.Color;
import javax.swing.JFrame;

//Create Gamewindow class as superclass. it use to make windows for snake game.
public class Gamewindow {

    public static void main(String[] args)
    {

        JFrame obj = new JFrame();//make parent windows
        Gamelogin login = new Gamelogin();// make object in Gamelogin class

        obj.getContentPane().setBackground(Color.black);                      // set Background colour
        obj.setBounds(10,10,955,700);     // set Boundaries to window
        obj.setResizable(false);                             // prevent resizable
        obj.setVisible(true);                                // set visible
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit the application.(stop background running)
        obj.add(login);
        login.setBackground(Color.DARK_GRAY);                // set Background colour for login panel


    }
}
