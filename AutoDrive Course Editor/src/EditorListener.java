import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EditorListener implements ActionListener {

    public AutoDriveEditor editor;

    final JFileChooser fc = new JFileChooser();

    public EditorListener (AutoDriveEditor editor) {
        this.editor = editor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionCommand: " + e.getActionCommand());

        switch (e.getActionCommand()){
            case "Save":
            {
                int returnVal = fc.showSaveDialog(editor);
        
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    editor.savedFile = fc.getSelectedFile();
                    editor.saveMap(editor.loadedFile.getAbsolutePath(), editor.savedFile.getAbsolutePath());
                }
                else {
                    this.editor.saveMap("C:\\Users\\Stephan\\Downloads\\AutoDrive_config.xml", "C:\\Users\\Stephan\\Downloads\\AutoDrive_config_new.xml");
                }
                break;
            }
            case "Move Nodes":
            {
                this.editor.editorState = EditorState.EDITORSTATE_MOVING;
                break;
            }
            case "Remove Nodes":
            {
                this.editor.editorState = EditorState.EDITORSTATE_DELETING;
                break;
            }
            case "Remove Destinations":
            {
                this.editor.editorState = EditorState.EDITORSTATE_DELETING_DESTINATION;
                break;
            }
            case "Connect Nodes":
            {
                this.editor.editorState = EditorState.EDITORSTATE_CONNECTING;
                break;
            }
            case "Create Nodes":
            {
                this.editor.editorState = EditorState.EDITORSTATE_CREATING;
                break;
            }
            case "Create Destinations":
            {
                this.editor.editorState = EditorState.EDITORSTATE_CREATING_DESTINATION;
                break;
            }
            case "Load":
            {
                int returnVal = fc.showOpenDialog(editor);
        
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    editor.loadedFile = fc.getSelectedFile();
                    try {
                        editor.mapPanel.roadMap = editor.loadFile(editor.loadedFile.getAbsolutePath());
                        editor.pack();
                        editor.repaint();
                        editor.mapPanel.repaint();
                    } catch (ParserConfigurationException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (SAXException e1) {
                        e1.printStackTrace();
                    }
                }
                break;
            }
            case "Load Image":
            {
                int returnVal = fc.showOpenDialog(editor);
        
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        editor.mapPanel.image = ImageIO.read(fc.getSelectedFile());
                        editor.pack();
                        editor.repaint();
                        editor.mapPanel.repaint();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                break;
            }
        }
        
        if (e.getActionCommand() == "FourTimesMap") {
            editor.isFourTimesMap = editor.fourTimesMap.isSelected();
        }

        this.editor.setStatusbarText(e.getActionCommand());
    }
}
