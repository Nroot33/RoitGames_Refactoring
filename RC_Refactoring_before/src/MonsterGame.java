import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MonsterGame extends JFrame {
    JPanel gamePanel = new GamePanel("@", "M", 'q', 200);

    public MonsterGame() {
        setTitle("괴물 피하기 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(gamePanel);

        setSize(250,250);
        setVisible(true);

        gamePanel.requestFocus();
    }


    class GamePanel extends JPanel {
        String User;
        String Monster;
        char quit;
        long Delay;
        JLabel U;
        JLabel M;

        public GamePanel(String User, String Monster, char quit, long Delay) {
            this.User = User;
            this.Monster = Monster;
            this.quit = quit;
            this.Delay = Delay;


            U = new JLabel(User);
            M = new JLabel(Monster);

            setLayout(null);
            addKeyListener(new MyKeyListener());

            U.setLocation(30,30);
            U.setSize(15,15);
            U.setForeground(Color.RED);
            add(U);

            M.setLocation(100,100);
            M.setSize(15,15);
            add(M);

            Monster t = new Monster(M, U, Delay);
            t.start();

        }

        class MyKeyListener extends KeyAdapter {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == quit)
                    System.exit(0);
                int keyCode = e.getKeyCode();
                switch(keyCode) {
                    case KeyEvent.VK_UP:
                        U.setLocation(U.getX(), U.getY()-10);
                        break;
                    case KeyEvent.VK_DOWN:
                        U.setLocation(U.getX(), U.getY()+10);
                        break;
                    case KeyEvent.VK_LEFT:
                        U.setLocation(U.getX()-10, U.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        U.setLocation(U.getX()+10, U.getY());
                        break;
                }
                repaint();
            }
        }
    }
    class Monster extends Thread {
        JLabel M1;
        JLabel U1;
        long Delay;

        Monster(JLabel M1, JLabel U1, long Delay) {
            this.M1 = M1;
            this.U1 = U1;
            this.Delay = Delay;
        }

        public void run() {
            int x=M1.getX(),y=M1.getY();

            while(true) {
                if(U1.getX() < M1.getX())
                    x = M1.getX() - 5;
                else
                    x = M1.getX() + 5;

                if(U1.getY() < M1.getY())
                    y = M1.getY() - 5;
                else
                    y = M1.getY() + 5;

                M1.setLocation(x, y);
                M1.repaint();

                try {
                    if(Math.abs((M1.getX() -7.5) - (U1.getX()-7.5)) < 10 && Math.abs((M1.getY()-7.5) - (U1.getY()-7.5)) < 10) {
                        System.exit(0);
                    }
                    sleep(Delay);
                }catch(InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String [] args) {
        new MonsterGame();
    }
}