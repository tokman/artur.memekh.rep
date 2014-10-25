package by.home.clientdb.action.menu;

import by.home.clientdb.action.AbstractAction;
import by.home.clientdb.panel.BackgroundPanel;
import by.home.clientdb.panel.ClientDBPanel;

/**
 * Date: 3/22/14
 * Time: 7:26 PM
 *
 * @author Artur Memekh
 */
public class NewClientListMenuAction extends AbstractAction {

    @Override
    public void performAction() {

        BackgroundPanel bp = BackgroundPanel.getInstance();
        bp.add(ClientDBPanel.getInstance());
        bp.revalidate();
    }
}
