package com.ramitsuri.mashup;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonNewActivity;
    static String LAYOUT_EXTRA = "layout_extra";
    String layout = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BackgroundTask().execute();
        buttonNewActivity = (Button)findViewById(R.id.buttonNewActivity);
        buttonNewActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonNewActivity){
            Intent intentIoTActivity = new Intent(this, IoTActivity.class);
            intentIoTActivity.putExtra(LAYOUT_EXTRA, layout);
            startActivity(intentIoTActivity);
        }
    }

    class BackgroundTask extends AsyncTask<String, Integer, String>{

        @Override
        protected String doInBackground(String... strings) {
            return executeRestCall();
        }
        protected void onPostExecute(String result) {
            layout = result;
        }
    }

    private String executeRestCall() {
        String url = "http://52.39.204.2:1398/activity";
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }
        catch (IOException ex){
            return "";
        }
    }
}
