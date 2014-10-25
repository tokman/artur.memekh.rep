package by.home.clientdb.panel;

import by.home.clientdb.color.ColorManager;
import java.util.HashMap;
import javax.swing.*;

/**
 * Date: 3/23/14
 * Time: 8:22 PM
 *
 * @author Artur Memekh
 */
public class ClientListPanel extends JPanel {

    private HashMap<Integer, ClientRecordPanel> clientRecordMap;
    private int currentRecordId;

    public HashMap<Integer, ClientRecordPanel> getClientRecordMap() {
        return clientRecordMap;
    }

    public int getCurrentRecordId() {
        return currentRecordId;
    }

    public void setCurrentRecordId(int currentRecordId) {
        this.currentRecordId = currentRecordId;
    }

    public ClientListPanel() {

        init();
    }

    private void init() {

        clientRecordMap = new HashMap<>();
        setBackground(ColorManager.RECORD_LIST_BG_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
