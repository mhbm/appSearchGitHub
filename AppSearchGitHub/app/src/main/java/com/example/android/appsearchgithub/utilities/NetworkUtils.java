package com.example.android.appsearchgithub.utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by lsitec101.macedo on 17/05/18.
 */

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getName().toString();

    private static final String kotlinURL = "https://api.github.com/search/repositories?q=language:Kotlin&sort=stars&page=1";




    public static URL buildUrl() throws MalformedURLException {
        Uri builtUri = null;
        builtUri = Uri.parse(kotlinURL).buildUpon().build();

        URL url = null;
        url = new URL(builtUri.toString());

        Log.d(TAG, "buildUrl: " + url);

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            Log.d(TAG, "getResponseFromHttpUrl: " + hasInput);
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }

    }

}
