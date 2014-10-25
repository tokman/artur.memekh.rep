package by.home.clientdb.mainframe;

import by.home.clientdb.bundle.ResourceManager;
import by.home.clientdb.color.ColorManager;
import by.home.clientdb.listener.MouseListener;
import by.home.clientdb.panel.BackgroundPanel;

import java.awt.*;
import javax.swing.*;
import java.util.Locale;

/**
 * Date: 3/17/14
 * Time: 9:38 PM
 *
 * @author Artur Memekh
 */
public class Run {

    public static void main(String[] args) {

        initMainFrame();
    }

    private static void initMainFrame() {

        // Main window initialization
        JFrame mainframe = new JFrame();
        String appTitle = ResourceManager.getResourceBundle(Locale.getDefault()).getString("application_title");
        mainframe.setTitle(appTitle);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image img = new ImageIcon(mainframe.getClass().getResource("/images/ra_logo_20x21.png")).getImage();
        mainframe.setIconImage(img);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainframe.setSize(d);
        mainframe.setMinimumSize(d);
        mainframe.setLocationRelativeTo(null);

        mainframe.setResizable(true);

        // Menu bar initialization
        JMenuBar mBar = new JMenuBar();
        mBar.setBackground(ColorManager.MENUBAR_COLOR);
        mainframe.setJMenuBar(mBar);
        String mFileValue = ResourceManager.getResourceBundle(Locale.getDefault()).getString("menu_file");
        JMenu mFile = new JMenu(mFileValue);
        mBar.add(mFile);
        String mFileNewValue = ResourceManager.getResourceBundle(Locale.getDefault()).getString("menu_item_new");
        JMenu mFileNew = new JMenu(mFileNewValue);
        mFile.add(mFileNew);
        String mFileNewClientDBValue = ResourceManager.getResourceBundle(Locale.getDefault()).getString("menu_item_new_cliendb");
        JMenuItem mFileNewClientDB = new JMenuItem(mFileNewClientDBValue);
        mFileNewClientDB.setActionCommand("menu-item-new-clientdb");
        mFileNewClientDB.addMouseListener(MouseListener.getInstance());
        mFileNew.add(mFileNewClientDB);

        // Background panel initialization
        BackgroundPanel backgroundPanel = BackgroundPanel.getInstance();
        backgroundPanel.setSize(mainframe.getContentPane().getSize());
        mainframe.setContentPane(backgroundPanel);

        mainframe.pack();
        mainframe.setVisible(true);
    }
}