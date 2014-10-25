package by.home.clientdb.panel;

import by.home.clientdb.color.ColorManager;
import by.home.clientdb.listener.KeyListener;
import by.home.clientdb.listener.MouseListener;
import by.home.clientdb.util.ClientRecordIdGenerator;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Date: 3/21/14
 * Time: 1:32 AM
 *
 * @author Artur Memekh
 */
public class ClientRecordPanel extends JPanel{

    /*private static ClientRecordPanel instance;

    private ClientRecordPanel() {

        init();
    }

    public static ClientRecordPanel getInstance() {

        if(instance == null) {
            instance = new ClientRecordPanel();
        }
        return instance;
    }*/
    private String actionCommand;
    private int id;

    public String getActionCommand() {
        return actionCommand;
    }

    public int getId() {
        return id;
    }

    public ClientRecordPanel() {

        init();
    }

    private void init() {

        id = ClientRecordIdGenerator.generateId();
        double width = ClientDBPanel.getInstance().getWidth();
        setPreferredSize(new Dimension((int)width, 100));
        setMaximumSize(new Dimension((int)width, 100));
        setBackground(ColorManager.RECORD_BG_COLOR);
        setDefaultBorder();
        actionCommand = "client-record-panel-focus";
        addMouseListener(MouseListener.getInstance());
    }

    public void setDefaultBorder() {
        Border border = BorderFactory.createLineBorder(ColorManager.RECORD_BORDER_DEFAULT_COLOR, 1, true);
        setBorder(border);
    }

    public void setFocusedBorder() {
        Border border = BorderFactory.createLineBorder(ColorManager.RECORD_BORDER_FOCUSED_COLOR, 2, true);
        setBorder(border);
    }
}
