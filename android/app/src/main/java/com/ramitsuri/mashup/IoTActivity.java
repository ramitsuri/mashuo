package com.ramitsuri.mashup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class IoTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io_t);
        //String layout = getIntent().getStringExtra(MainActivity.LAYOUT_EXTRA);
        String layout = "[{\"type\":0, \"text\":\"button1\", \"action\":\"\"},{\"type\":0, \"text\":\"button1\", \"action\":\"\"},{\"type\":0, \"text\":\"button1\", \"action\":\"\"}]";
        Type listType = new TypeToken<List<Item>>(){}.getType();
        List<Item> items = new Gson().fromJson(layout, listType);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (Item item: items
             ) {
            if(item.getType() == Item.TYPE_BUTTON){
                Button buttonNew = new Button(this);
                buttonNew.setText(item.getText());
                linearLayout.addView(buttonNew);
                buttonNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }






    }
}
