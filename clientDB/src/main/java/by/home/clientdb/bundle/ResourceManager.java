package by.home.clientdb.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Artur Memekh on 3/16/14.
 */
public class ResourceManager {

    public static ResourceBundle getResourceBundle(Locale locale) {

        ResourceBundle rb = ResourceBundle.getBundle("properties.lang", locale);
        return rb;
    }
}
