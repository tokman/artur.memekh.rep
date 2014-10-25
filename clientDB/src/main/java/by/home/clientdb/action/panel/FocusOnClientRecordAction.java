package by.home.clientdb.action.panel;

import by.home.clientdb.action.AbstractAction;
import by.home.clientdb.panel.ClientDBPanel;
import by.home.clientdb.panel.ClientListPanel;
import by.home.clientdb.panel.ClientRecordPanel;

/**
 * Date: 3/26/14
 * Time: 11:59 PM
 *
 * @author Artur Memekh
 */
public class FocusOnClientRecordAction extends AbstractAction {

    private int newCleintRecordId;

    @Override
    public void performAction() {
        ClientListPanel pClientList = (ClientListPanel)ClientDBPanel.getInstance().getScrollPClientList().getViewport().getView();
        int currentRecordId = pClientList.getCurrentRecordId();
        ClientRecordPanel currentRecord = pClientList.getClientRecordMap().get(currentRecordId);
        if(currentRecordId != 0) {
            currentRecord.setDefaultBorder();
        }
        ClientRecordPanel newRecord = pClientList.getClientRecordMap().get(newCleintRecordId);
        newRecord.setFocusedBorder();
        pClientList.setCurrentRecordId(newCleintRecordId);
    }

    @Override
    public void setParam(Object param) {
        newCleintRecordId = (int)param;
    }
}
