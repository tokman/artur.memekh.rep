package by.home.clientdb.action.button;

import by.home.clientdb.action.AbstractAction;
import by.home.clientdb.panel.ClientDBPanel;
import by.home.clientdb.panel.ClientListPanel;
import by.home.clientdb.panel.ClientRecordPanel;

/**
 * Date: 3/23/14
 * Time: 5:06 PM
 *
 * @author Artur Memekh
 */
public class AddClientRecordAction extends AbstractAction {

    @Override
    public void performAction() {

        ClientRecordPanel pClientRecord = new ClientRecordPanel();
        ClientListPanel pClientList = (ClientListPanel)ClientDBPanel.getInstance().getScrollPClientList().getViewport().getView();
        pClientList.getClientRecordMap().put(pClientRecord.getId(), pClientRecord);
        pClientList.add(pClientRecord);
        pClientList.revalidate();
    }
}
