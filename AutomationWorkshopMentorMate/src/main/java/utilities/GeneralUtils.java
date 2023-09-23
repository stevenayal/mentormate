package utilities;

import java.util.Base64;

public class GeneralUtils {

    public static String HashPasswordB64(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}
