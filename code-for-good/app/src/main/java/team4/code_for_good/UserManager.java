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

        for(Integer key: loginData.keySet()){
            String userEmail = loginData.get(key).get("email");
            System.out.println("Email: " + userEmail);
            if(userEmail.equals(email)){
                String userPassword = loginData.get(key).get("password");
                if(userPassword.equals(password)){
                    System.out.println("Success!!!  Logging in... ");
                    return true;
                }
            }
        }

        System.out.println("Failed attempt to login");
        return true;
    }
}
