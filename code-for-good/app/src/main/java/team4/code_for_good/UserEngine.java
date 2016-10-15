package team4.code_for_good;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by vkottler on 10/15/2016.
 */

public class UserEngine extends Thread implements Runnable {

    String urlStr = "http://www.vaughnsplayground.me/codeForGood/login.php";
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

    }

    private void parseUserStream(InputStream in) {

    }

}
