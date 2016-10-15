package team4.code_for_good;

import java.util.HashMap;

/**
 * Created by jameshahn on 10/15/16.
 */

public class CodeManager {
    public static boolean redeemCode(String code){
        if(code.length() != 5){
            return false;
        }

        System.out.println("User's Code: " + code);

        HashMap<Integer, HashMap<String, String>> redeemCodes = DatabaseQuery.getRedeemCodeData();

        for(Integer key: redeemCodes.keySet()){
            String currentCode = redeemCodes.get(key).get("redeem_code");
            System.out.println("Code: " + code);

            if(currentCode.equals(code)){
                System.out.println("Valid code!");
                return true;
            }
        }
        //Get code data
        //Find product name and foreign key it with the ProductsInfo table to find the points value
        //Return it here
        //Remove that code from the Codes table
        //Add the points of the product to the user's points value in the PersonalInfo table

        System.out.println("Code was not found.");
        return false;
    }

}
