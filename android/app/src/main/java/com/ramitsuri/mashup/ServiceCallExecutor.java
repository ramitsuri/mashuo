package com.ramitsuri.mashup;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ramitsuri on 10/3/2016.
 */

public class ServiceCallExecutor extends AsyncTask<String, Integer, String> {

    int type;

    @Override
    protected String doInBackground(String... params) {
        if(params[1].equals("main"))
            type = 0;
        return executeRestCall(params[0]);
    }

    @Override
    protected void onPostExecute(String result){
    }

    private String executeRestCall(String url) {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }
        catch (IOException ex){
            String a = ex.toString();
            return "";
        }
    }
}
