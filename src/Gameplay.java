import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements ActionListener,KeyListener{

    private int[] snakexlength =new int[750];
    private int[] snakeylength =new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private boolean flag = true;
    private boolean play = true;

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    private ImageIcon snakeimage;

    private int lengthofsnake = 3;

    private Timer timer;
    private int delay =100;


    private int [] enemyxpos = { 25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,
            800,825,850
    };
    private int [] enemyypos = { 75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625
    };

    private ImageIcon enemyimage;

    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    private int score = 0;

    private int moves = 0;

    private ImageIcon titleImage;


    Gameplay() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);


        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setBounds(30,30,900,600);
        setVisible(true);
        timer = new Timer (delay, this);
        timer.start();


    }


    public void paint(Graphics g) {

        super.paint(g);

        if(moves == 0) {
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;

            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;
        }

        //Draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 901, 55);

        //Draw the title image
        titleImage =new ImageIcon("snaketitle.png");
        titleImage.paintIcon(this, g, 25, 11);

        //Draw border for gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 901, 577);

        //Draw background for this gameplay
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 900, 575);

        //Draw instruction
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 14));
        g.drawString("Use Arrow Keys. ", 30, 50);


        //Draw scores
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores : "+ score, 830, 30);

        //Draw length of snake
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length : "+ lengthofsnake, 830, 50);

        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);


        for(int a=0;a < lengthofsnake;a++) {

            if(a == 0 && right) {
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

            }
            if(a == 0 && left && moves!=0) {
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

            }
            if(a == 0 && up && moves!=0) {
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

            }
            if(a == 0 && down && moves!=0) {
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

            }
            if(a != 0) {
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);

            }

        }
        enemyimage= new ImageIcon("enemy.png");
        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);

        //pause and play command
        if(play)
        {
            g.drawString("Press Enter to pause.", 30, 30);
            repaint();
        }
        else
        {
            g.setFont(new Font("arial", Font.BOLD, 30));
            g.drawString("Press Enter to play.", 350, 350);
            repaint();
        }


        if((enemyxpos[xpos] == snakexlength[0] && enemyypos[ypos] == snakeylength[0])) {

            score++;
            lengthofsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);

        }

        for(int b =1; b< lengthofsnake; b++) {

            if(snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0]) {

                right = false;
                left = false;
                up = false;
                down = false;

                flag =false;

                g.setColor(Color.WHITE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over!", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 30));
                g.drawString("Scores: "+ score, 350, 340);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Press Space to RESTART", 325, 380);

                g.drawRect(290, 255, 300, 150);


            }
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (play) {
            if (right) {

                if (lengthofsnake - 1 + 1 >= 0)
                    System.arraycopy(snakeylength, 0, snakeylength, 1, lengthofsnake - 1 + 1);
                for (int r = lengthofsnake; r >= 0; r--) {

                    if (r == 0) {
                        snakexlength[r] = snakexlength[r] + 25;
                    } else {
                        snakexlength[r] = snakexlength[r - 1];
                    }
                    if (snakexlength[r] > 900) {

                        snakexlength[r] = 25;

                    }

                }

                repaint();
            }
            if (left) {

                if (lengthofsnake - 1 + 1 >= 0)
                    System.arraycopy(snakeylength, 0, snakeylength, 1, lengthofsnake - 1 + 1);

                for (int r = lengthofsnake; r >= 0; r--) {

                    if (r == 0) {
                        snakexlength[r] = snakexlength[r] - 25;
                    } else {
                        snakexlength[r] = snakexlength[r - 1];
                    }
                    if (snakexlength[r] < 25) {

                        snakexlength[r] = 900;

                    }

                }

                repaint();

            }
            if (up) {

                if (lengthofsnake - 1 + 1 >= 0)
                    System.arraycopy(snakexlength, 0, snakexlength, 1, lengthofsnake - 1 + 1);
                for (int r = lengthofsnake; r >= 0; r--) {

                    if (r == 0) {
                        snakeylength[r] = snakeylength[r] - 25;
                    } else {
                        snakeylength[r] = snakeylength[r - 1];
                    }
                    if (snakeylength[r] < 75) {

                        snakeylength[r] = 625;

                    }

                }

                repaint();

            }
            if (down) {

                if (lengthofsnake - 1 + 1 >= 0)
                    System.arraycopy(snakexlength, 0, snakexlength, 1, lengthofsnake - 1 + 1);

                for (int r = lengthofsnake; r >= 0; r--) {

                    if (r == 0) {
                        snakeylength[r] = snakeylength[r] + 25;
                    } else {
                        snakeylength[r] = snakeylength[r - 1];
                    }
                    if (snakeylength[r] > 625) {

                        snakeylength[r] = 75;

                    }

                }

                repaint();

            }


        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("fuck0");

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("fucker");
            up = false;
            down = false;
            right = false;
            left = false;
            moves = 0;
            score = 0;
            lengthofsnake = 3;
            flag= true;
            play = true;
            repaint();

        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(play)
            {
                play = false;
            }
            else
            {
                play = true;
            }
        }

        if(flag && play) {

            if(key == KeyEvent.VK_RIGHT) {
                moves++;
                System.out.println("fuck1");
                right = true;
                if(left) {
                    right = false;
                    left = true;
                }
                up = false;
                down = false;
            }
            else if(key == KeyEvent.VK_LEFT) {
                moves++;
                System.out.println("fuck2");
                left = true;
                if(right) {
                    left = false;
                    right = true;
                }
                up = false;
                down = false;
            }
            else if(key == KeyEvent.VK_UP) {
                moves++;
                System.out.println("fuck3");
                up = true;
                if(down) {
                    up = false;
                    down = true;
                }
                right = false;
                left = false;
            }
            else if(key == KeyEvent.VK_DOWN) {
                moves++;
                System.out.println("fuck4");
                down = true;
                if(up) {
                    down = false;
                    up = true;
                }
                right = false;
                left = false;
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
