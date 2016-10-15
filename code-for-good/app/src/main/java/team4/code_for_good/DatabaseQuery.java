package team4.code_for_good;

/**
 * Created by jameshahn on 10/14/16.
 */

import org.json.JSONObject;

import java.util.*;

public class DatabaseQuery{
    public static HashMap<Integer, HashMap<String, String>> getLoginData(){
        HashMap<Integer, HashMap<String, String>> userInfo = new HashMap<Integer, HashMap<String, String>>();
        userInfo.put(1, new HashMap<String, String>() {{ put("email", "jamhahn@yahoo.com"); put("zip_code", "44667"); put("password", "password"); put("first_name", "James"); put("point_value", "100"); }});
        userInfo.put(2, new HashMap<String, String>() {{ put("email", "email@gmail.com"); put("zip_code", "12345"); put("password", "pass"); put("first_name", "Jim"); put("point_value", "20"); }});
        userInfo.put(3, new HashMap<String, String>() {{ put("email", "alexischandler@gmail.com"); put("zip_code", "23456");  put("first_name", "Alexis"); put("point_value", "101"); }});
        userInfo.put(4, new HashMap<String, String>() {{ put("email", "email2@gmail.com"); put("zip_code", "34567");  put("first_name", "Sage"); put("point_value", "99"); }});
        userInfo.put(5, new HashMap<String, String>() {{ put("email", "email3@gmail.com"); put("zip_code", "45678");  put("first_name", "Vaughn"); put("point_value", "50"); }});
        userInfo.put(6, new HashMap<String, String>() {{ put("email", "email4@gmail.com"); put("zip_code", "56789");  put("first_name", "Lawrence"); put("point_value", "55"); }});
        userInfo.put(7, new HashMap<String, String>() {{ put("email", "email5@gmail.com"); put("zip_code", "67890"); put("password", "code"); put("first_name", "John"); put("point_value", "52"); }});
        userInfo.put(8, new HashMap<String, String>() {{ put("email", "email6@gmail.com"); put("zip_code", "78901"); put("password", "for"); put("first_name", "Bill"); put("point_value", "68"); }});
        userInfo.put(9, new HashMap<String, String>() {{ put("email", "email7@gmail.com"); put("zip_code", "89012"); put("password", "good"); put("first_name", "Jack"); put("point_value", "100"); }});
        userInfo.put(10, new HashMap<String, String>() {{ put("email", "email8@gmail.com"); put("zip_code", "90123"); put("password", "codeforgood"); put("first_name", "Eric"); put("point_value", "34"); }});

        return userInfo;
    }
}
