import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.*;

public class Gamelogin extends JPanel implements ActionListener,KeyListener        //create Gamelogin class, extend in Jpanel and add KeyListener and ActionListener
{
    private JLabel Playlable;                          //make label for play button image
    private JLabel background;                         //make label for background image
    private JPanel panel1;

    Gamelogin()
    {

        addKeyListener(this);                       //call keyListener functions
        setFocusable(true);                            //Focus to key

        setBounds(15,15, 920,620);  //set Size and position for panel
        setBackground(Color.DARK_GRAY);                //set background colour to panel
        setLayout(null);                               //disable layout manager
        setVisible(true);                              //set visibility


        background = new JLabel();                                      // initialize the background image label
        background.setOpaque(true);                                     //
        background.setIcon(new ImageIcon("banner.jpg"));        // set image for background label
        background.setBounds(15,15,910,620);         // set boundaries to background label



        Playlable=new JLabel(new ImageIcon("Play.png"));         // initialize the play image label and set image
        Playlable.setBounds(378, 230, 164, 164);      // set boundaries to play label
        Playlable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){    // set mouse click event to that play label

                Component parent = getParent();
                ((Container) parent).removeAll();
                ((Container) parent).add(new Gameplay());
                parent.revalidate();
                parent.repaint();
            }
        });

        background.add(Playlable);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER) {
            Component parent = getParent();
            ((Container) parent).removeAll();
            ((Container) parent).add(new Gameplay());
            parent.revalidate();
            parent.repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}