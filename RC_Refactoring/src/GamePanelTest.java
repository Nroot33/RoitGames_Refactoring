import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GamePanelTest {

    GamePanel gamePanel;
    String Units;
    JLabel U;

    @Before
    public void setUp(){
            gamePanel = new GamePanel("U", "M", 'Q',200);
            U = new JLabel(Units);
            UnitSettingTest();
    }

    public void UnitSettingTest() {
        U.setLocation(5, 5);
        U.setSize(15, 15);
        U.setForeground(Color.RED);
    }

    @Test
    public void NotnullCheck(){
        String User = "U";
        String Monster = "M";
        char quit = 'Q';
        int Delay = 200;
        assertThat(gamePanel.User,is("U"));
        assertThat(gamePanel.Monster,is("M"));
        assertThat(gamePanel.quit,is('Q'));
        assertThat(gamePanel.Delay,is(200));
    }

    @Test
    public void CheckUnit() {
        assertThat(U.getLocation(),is(new Point(5,5)));
        assertThat(U.getHeight(),is(15));
        assertThat(U.getWidth(),is(15));
        assertThat(U.getForeground(),is(Color.RED));
    }
}