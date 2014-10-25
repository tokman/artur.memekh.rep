package by.home.clientdb.panel;

import by.home.clientdb.bundle.ResourceManager;
import by.home.clientdb.color.ColorManager;
import by.home.clientdb.listener.MouseListener;
import java.awt.*;
import javax.swing.*;

/**
 * Date: 3/23/14
 * Time: 8:19 PM
 *
 * @author Artur Memekh
 */
public class ToolbarPanel extends JPanel {

    public ToolbarPanel() {

        init();
    }

    private void init() {

        double width = BackgroundPanel.getInstance().getWidth();
        setPreferredSize(new Dimension((int)width, 30));
        setBackground(ColorManager.TOOLBAR_COLOR);

        String addClientRecordValue = ResourceManager.getResourceBundle(getLocale()).getString("b_add_client_record");
        JButton bAddClientRecord = new JButton(addClientRecordValue);
        bAddClientRecord.setBackground(ColorManager.BUTTON_COLOR);
        bAddClientRecord.setMargin(new Insets(2, 3, 2, 3));
        bAddClientRecord.setPreferredSize(new Dimension(70, 20));
        bAddClientRecord.setActionCommand("b-add-client-record");
        bAddClientRecord.addMouseListener(MouseListener.getInstance());

        add(bAddClientRecord);
        revalidate();
    }
}
