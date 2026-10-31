import javax.swing.SwingUtilities;

public class VisualMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });
    }
}