package team4.code_for_good;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vkottler on 10/15/2016.
 *
 * Basically a clone of ProductEngine
 */

public class UserEngine extends Thread implements Runnable {

    String urlStr = "http://www.vaughnsplayground.me/codeForGood/login.php";
    List<UserModel> users;
    volatile boolean done = false;

    public UserEngine() { super(); }

    public void run() {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            parseUserStream(in);
        } catch (Exception e) { e.printStackTrace();
        } finally { urlConnection.disconnect(); }
    }

    public void printUsers() {
        if (users == null) return;
        Iterator<UserModel> itr = users.iterator();
        while (itr.hasNext()) Log.i("info", itr.next().toString());
    }

    public List<UserModel> getUsers() {
        this.start();
        while(!done);
        return users;
    }

    private void parseUserStream(InputStream in) {
        users = new ArrayList<UserModel>();



        done = true;
    }

}
