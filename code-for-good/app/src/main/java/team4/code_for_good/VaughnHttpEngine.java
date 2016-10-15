package me.vaughnsplayground.apitester;

import android.util.JsonReader;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 *
 * Header Retrieval Example
 *
 * Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
 * Iterator it = headerFields.entrySet().iterator();
 * while (it.hasNext()) {
 *     Map.Entry pair = (Map.Entry)it.next();
 *     System.out.println(pair.getKey() + " = " + pair.getValue());
 * }
 *
 */

public class VaughnHttpEngine extends Thread implements Runnable {

    String urlStr = "http://www.vaughnsplayground.me/codeForGood/products.php";
    String body = null;
    List<Product> products = null;

    public VaughnHttpEngine() {
        super();
    }

    public void run() {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //body = readStream(in);
            //Log.i("info", body);
            products = parseProductStream(in);
            Iterator<Product> itr = products.iterator();
            while (itr.hasNext()) Log.i("info", itr.next().toString());
        } catch (Exception e) { e.printStackTrace();
        } finally { urlConnection.disconnect(); }
    }

    private List<Product> parseProductStream(InputStream in) {
        ArrayList<Product> retval = new ArrayList<Product>();
        JsonReader reader = null;
        int numProducts = -1;
        try { reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
        try {
            reader.beginObject();
            reader.nextName();
            numProducts = reader.nextInt();
            reader.nextName();
            int currIndex = 0, currentProduct = 0, currId = -1, currPointVal = -1;
            Product currProduct;
            String currName = "";
            reader.beginArray();
            while (currentProduct < numProducts && reader.hasNext()) {
                switch (currIndex) {
                    case 0:
                        reader.beginObject();
                        reader.nextName();
                        currId = reader.nextInt();
                        break;
                    case 1:
                        reader.nextName();
                        currName = reader.nextString();
                        break;
                    case 2:
                        reader.nextName();
                        currPointVal = reader.nextInt();
                        reader.endObject();
                        break;
                    case 3:
                        currProduct = new Product(currId, currName, currPointVal);
                        retval.add(currProduct);
                        currIndex = -1;
                        currentProduct++;
                        break;
                }
                currIndex++;
            }
            reader.endArray();
            reader.endObject();
        } catch (IOException e) { e.printStackTrace(); }
        return retval;
    }

    private String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader rdr = new BufferedReader(new InputStreamReader(in))) {
            for (int c; (c = rdr.read()) != -1;) sb.append((char) c);
        } catch (IOException io) { io.printStackTrace(); }
        return sb.toString();
    }

    public void callAPI() {
        this.start();
    }
}
