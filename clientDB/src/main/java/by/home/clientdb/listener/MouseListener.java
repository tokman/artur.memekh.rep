package by.home.clientdb.listener;

import by.home.clientdb.action.ActionManager;
import by.home.clientdb.action.IAction;
import by.home.clientdb.panel.ClientRecordPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Date: 3/22/14
 * Time: 6:29 PM
 *
 * @author Artur Memekh
 */
public class MouseListener extends MouseAdapter {

    private static final MouseListener instance = new MouseListener();

    private MouseListener() {

    }

    public static MouseListener getInstance() {

        return instance;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        String actionCommand;
        IAction mouseAction = null;
        if(e.getSource() instanceof AbstractButton) {
            actionCommand = ((AbstractButton)e.getSource()).getActionCommand();
            mouseAction = ActionManager.getInstance().getAction(actionCommand);
        } else if(e.getSource() instanceof ClientRecordPanel) {
            ClientRecordPanel crPanel = ((ClientRecordPanel)e.getSource());
            actionCommand = crPanel.getActionCommand();
            Object param = crPanel.getId();
            mouseAction = ActionManager.getInstance().getAction(actionCommand, param);
        }

        mouseAction.performAction();
    }
}
