package by.home.clientdb.action;

import by.home.clientdb.action.button.AddClientRecordAction;
import by.home.clientdb.action.menu.NewClientListMenuAction;
import by.home.clientdb.action.panel.FocusOnClientRecordAction;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 3/22/14
 * Time: 7:19 PM
 *
 * @author Artur Memekh
 */
public class ActionManager {

    private static final Map<String, IAction> mouseActionMap = new HashMap();
    private static final ActionManager instance = new ActionManager();

    private ActionManager() {

        mouseActionMap.put("menu-item-new-clientdb", new NewClientListMenuAction());
        mouseActionMap.put("b-add-client-record", new AddClientRecordAction());
        mouseActionMap.put("client-record-panel-focus", new FocusOnClientRecordAction());
    }

    public static ActionManager getInstance() {

        return instance;
    }

    public IAction getAction(String actionCode) {

        return mouseActionMap.get(actionCode);
    }

    public IAction getAction(String actionCode, Object param) {
        IAction mouseAction = mouseActionMap.get(actionCode);
        mouseAction.setParam(param);
        return mouseAction;

    }
}
