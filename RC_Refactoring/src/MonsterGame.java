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
}