
import javax.swing.JFrame;// Noncompliant

public class NoSwingClassesTemplate
{

    private static void initAndShowGUI()
    {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        //final JFXPanel fxPanel = new JFXPanel();
        //frame.add(fxPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
