package com.ramitsuri.mashup;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class IoTActivity extends AppCompatActivity {

    public static String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_t);
        String layout = getIntent().getStringExtra(MainActivity.LAYOUT_EXTRA);
        //String layout = "[{\"type\":0, \"text\":\"button1\", \"action\":\"\"},{\"type\":0, \"text\":\"button1\", \"action\":\"\"},{\"type\":0, \"text\":\"button1\", \"action\":\"\"}]";
        Type listType = new TypeToken<List<Item>>(){}.getType();
        List<Item> items = new Gson().fromJson(layout, listType);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (Item item: items) {
            if(item.getType() == Item.TYPE_BUTTON){
                Button buttonNew = new Button(this);
                buttonNew.setText(item.getText());
                linearLayout.addView(buttonNew);
                final String url = item.getAction();
                buttonNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new BackgroundTask().execute(url);
                    }
                });
            }
            else if(item.getType() == Item.TYPE_TEXTVIEW){
                TextView textView = new TextView(this);
                textView.setText(item.getText());
                linearLayout.addView(textView);
            }
        }
    }

    class BackgroundTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return executeRestCall(strings[0]);
        }
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
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
            return "";
        }
    }
}
