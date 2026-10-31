import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Robot Grid Simulator");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GamePanel());

        setLocationRelativeTo(null);

        setVisible(true);
    }
}