package by.home.clientdb.mainframe;

import by.home.clientdb.color.ColorManager;
import java.awt.*;
import javax.swing.*;

/**
 * Date: 4/23/2014
 * Time: 11:51 PM
 *
 * @author Artur Memekh
 */
public class ScrollFrame {

    public static void main(String[] args) {

        JFrame scrollableFrame = new JFrame();
        scrollableFrame.setSize(600,300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);

        for(int i = 0; i < 20; i++) {
            JPanel jp = new JPanel();
            jp.setPreferredSize(new Dimension(600, 50));
            jp.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
            panel.add(jp);
        }

        scrollableFrame.add(scrollPane);
        scrollableFrame.setVisible(true);
    }
}
