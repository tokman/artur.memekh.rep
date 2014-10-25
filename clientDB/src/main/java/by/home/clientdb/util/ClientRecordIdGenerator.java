package by.home.clientdb.util;

/**
 * Date: 3/26/14
 * Time: 11:42 PM
 *
 * @author Artur Memekh
 */
public class ClientRecordIdGenerator {

    private static int id = 1;

    public static int generateId() {
        return id++;
    }
}
