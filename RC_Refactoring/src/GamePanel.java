import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class GamePanel extends JPanel {
    String User;
    String Monster;
    char quit;
    int Delay;
    JLabel U;
    JLabel M;

    public GamePanel(String User, String Monster, char quit, int Delay) {
        this.User = User;
        this.Monster = Monster;
        this.quit = quit;
        this.Delay = Delay;

        U = new JLabel(User);
        M = new JLabel(Monster);

        setLayout(null);
        addKeyListener(new MoveUser());

        UnitSetting(U, 30, 30, 15, 15, Color.BLUE);
        UnitSetting(M, 100, 100, 15, 15, Color.RED);

        Monster t = new Monster(M, U, Delay);
        t.start();

    }

    public void UnitSetting(JLabel Unit, int x, int y, int width, int height, Color color) {
        Unit.setLocation(x, y);
        Unit.setSize(width, height);
        Unit.setForeground(color);
        add(Unit);
    } // Extract Method 방법 사용

    class MoveUser extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == quit)
                System.exit(0);
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_NUMPAD8:
                    U.setLocation(U.getX(), U.getY() - 10);
                    break;
                case KeyEvent.VK_NUMPAD5:
                    U.setLocation(U.getX(), U.getY() + 10);
                    break;
                case KeyEvent.VK_NUMPAD4:
                    U.setLocation(U.getX() - 10, U.getY());
                    break;
                case KeyEvent.VK_NUMPAD6:
                    U.setLocation(U.getX() + 10, U.getY());
                    break;
            }
            repaint();
        }
    }
} // Rename Method


