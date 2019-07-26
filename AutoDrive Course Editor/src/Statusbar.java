import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Statusbar extends JPanel {

    private JLabel textLabel_;
    private JLabel editorStateLabel_;
    private final Statusbar statusbar;
    public Statusbar(){
        super(new FlowLayout(FlowLayout.LEFT));
        statusbar = this;
        textLabel_ = new JLabel("");
        editorStateLabel_ = new JLabel("");
        add(textLabel_);
        add(editorStateLabel_);
    }

    private void refresh(){
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                statusbar.repaint();
            }

        });
    }

    public void setText(String text){
        textLabel_.setText(text);
        refresh();
    }

    public void setCurrentEditorState (EditorState editorState){
        String newText = "Current state: ";
        editorStateLabel_.setText(newText+editorState.toString());
        refresh();
    }
}