package team4.code_for_good;

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

public class ProductEngine extends Thread implements Runnable {

    String urlStr = "http://www.vaughnsplayground.me/codeForGood/products.php";
    List<Product> products = null;
    volatile boolean done = false;

    public ProductEngine() { super(); }

    public void run() {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            parseProductStream(in);
        } catch (Exception e) { e.printStackTrace();
        } finally { urlConnection.disconnect(); }
    }

    public void printProducts() {
        if (products == null) return;
        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) Log.i("info", itr.next().toString());
    }

    private void parseProductStream(InputStream in) {
        products = new ArrayList<Product>();
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
                        products.add(currProduct);
                        currIndex = -1;
                        currentProduct++;
                        break;
                }
                currIndex++;
            }
            reader.endArray();
            reader.endObject();
        } catch (IOException e) { e.printStackTrace(); }
        done = true;
    }

    public List<Product> retrieveProducts() {
        this.start();
        while (!done);
        return products;
    }

    private String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader rdr = new BufferedReader(new InputStreamReader(in));
            for (int c; (c = rdr.read()) != -1;) sb.append((char) c);
        } catch (IOException io) { io.printStackTrace(); }
        return sb.toString();
    }
}
