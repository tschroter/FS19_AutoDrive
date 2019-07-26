import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sun.swing.SwingAccessor;

public class Statusbar extends JPanel {

    private JLabel textLabel;
    private final Statusbar statusbar;
    public Statusbar(){
        super(new FlowLayout());
        statusbar = this;
        textLabel = new JLabel("");
        add(textLabel);
    }

    public void setText(String text){
        textLabel.setText(text);
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                statusbar.repaint();
            }

        });
    }
}