package by.home.clientdb.listener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Date: 3/23/14
 * Time: 9:19 PM
 *
 * @author Artur Memekh
 */
public class FocusListener extends FocusAdapter {

    private static final FocusListener instance = new FocusListener();

    private FocusListener() {

    }

    public static FocusListener getInstance() {

        return instance;
    }

    public void focusGained(FocusEvent e) {

        System.out.println("dsfgds");
    }
}
