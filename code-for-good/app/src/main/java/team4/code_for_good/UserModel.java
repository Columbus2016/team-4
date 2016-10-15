package team4.code_for_good;

/**
 * Created by jameshahn on 10/15/16.
 */

public class UserModel {

    public int    user_id, zip_code, user_point_value;
    public String email, password;

    public UserModel(int user_id, String email, int zip_code, String password, int user_point_value) {
        this.user_id = user_id;
        this.email = email;
        this.zip_code = zip_code;
        this.password = password;
        this.user_point_value = user_point_value;
    }

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

    @Override
    public String toString() {
        return user_id + ": " + email + " " + user_point_value + " " + zip_code;
    }

}
