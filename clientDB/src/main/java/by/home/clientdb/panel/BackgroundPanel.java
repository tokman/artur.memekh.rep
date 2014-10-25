package by.home.clientdb.panel;

import by.home.clientdb.color.ColorManager;
import javax.swing.*;

/**
 * Date: 3/22/14
 * Time: 5:06 PM
 *
 * @author Artur Memekh
 */
public class BackgroundPanel extends JPanel {

    private static final BackgroundPanel instance = new BackgroundPanel();

    private BackgroundPanel() {

        this.setBackground(ColorManager.BG_COLOR);
    }

    public static BackgroundPanel getInstance() {

        return instance;
    }

}
