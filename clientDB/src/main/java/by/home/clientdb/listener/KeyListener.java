package by.home.clientdb.listener;

import by.home.clientdb.action.ActionManager;
import by.home.clientdb.action.IAction;
import by.home.clientdb.panel.ClientRecordPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Date: 4/24/2014
 * Time: 9:39 PM
 *
 * @author Artur Memekh
 */
public class KeyListener extends KeyAdapter {

    private static final KeyListener instance = new KeyListener();

    private KeyListener() {

    }

    public static KeyListener getInstance() {

        return instance;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        String actionCommand;
        IAction mouseAction = null;

        if (e.getSource() instanceof ClientRecordPanel) {
            ClientRecordPanel crPanel = ((ClientRecordPanel) e.getSource());
            actionCommand = crPanel.getActionCommand();
            int param = 0;
            if (e.getKeyCode() == 38) {          // up
                param = crPanel.getId() - 1;
            } else if (e.getKeyCode() == 40) {   //down
                param = crPanel.getId() + 1;
            }
            mouseAction = ActionManager.getInstance().getAction(actionCommand, param);
        }
        mouseAction.performAction();
    }
}
