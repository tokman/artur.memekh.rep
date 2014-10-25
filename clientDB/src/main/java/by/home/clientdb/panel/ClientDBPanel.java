package by.home.clientdb.panel;

import by.home.clientdb.color.ColorManager;
import java.awt.*;
import javax.swing.*;

/**
 * Date: 3/22/14
 * Time: 9:05 PM
 *
 * @author Artur Memekh
 */
public class ClientDBPanel extends JPanel {

    private static ClientDBPanel instance;
    private ToolbarPanel pToolbar;
    private JScrollPane scrollPClientList;

    private ClientDBPanel() {

        init();
        importAllClients();
    }

    public JScrollPane getScrollPClientList() {
        return scrollPClientList;
    }

    public static ClientDBPanel getInstance() {

        if(instance == null) {
            instance = new ClientDBPanel();
        }
        return instance;
    }

    private void init() {

        BackgroundPanel bgPanel = BackgroundPanel.getInstance();
        setSize(bgPanel.getWidth(), bgPanel.getHeight());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        pToolbar = new ToolbarPanel();
        add(pToolbar);
        add(createSeparator());
        ClientListPanel clp = new ClientListPanel();

        scrollPClientList = new JScrollPane();
        scrollPClientList.setViewportView(clp);
        scrollPClientList.getViewport().setPreferredSize(new Dimension(1200, 650));
        scrollPClientList.setWheelScrollingEnabled(true);
        scrollPClientList.getVerticalScrollBar().setUnitIncrement(16);
        scrollPClientList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPClientList.setFocusable(true);

        add(scrollPClientList);

        revalidate();
    }

    private JPanel createSeparator() {

        JPanel separator = new JPanel();
        separator.setPreferredSize(new Dimension(getWidth(), 1));
        separator.setBackground(ColorManager.BG_COLOR);
        return separator;
    }

    private void importAllClients() {

    }
}
