package team4.code_for_good;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by jameshahn on 10/15/16.
 */

public class UserManager {
    public static boolean emailAndPasswordMatch(String email, String password){
        System.out.println("EMAIL: " + email + ", PASSWORD: " + password);
        HashMap<Integer, HashMap<String, String>> loginData = DatabaseQuery.getLoginData();

        return true;
    }
}
