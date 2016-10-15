package team4.code_for_good;

/**
 * Created by jameshahn on 10/15/16.
 */

public class CodeManager {
    public static boolean redeemCode(String code){
        if(code.length() != 5){
            return false;
        }
        
        //Get code data
        //Find product name and foreign key it with the ProductsInfo table to find the points value
        //Return it here
        //Remove that code from the Codes table
        //Add the points of the product to the user's points value in the PersonalInfo table
        return true;
    }

}
