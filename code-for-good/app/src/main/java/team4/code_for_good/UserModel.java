package team4.code_for_good;

/**
 * Created by jameshahn on 10/15/16.
 */

public class UserModel {
    public int    user_id;
    public String email;
    public int    zip_code;
    public String password;
    public int    user_point_value;

    public int getUserId(){
        return user_id;
    }

    public int getZipCode(){
        return zip_code;
    }

    public int getUserPointValue(){
        return user_point_value;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
