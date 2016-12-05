package com.ramitsuri.iotactivity;

/**
 * Created by ramitsuri on 12/4/2016.
 */

public class Item {

    public static int TYPE_BUTTON = 0;
    public static int TYPE_TEXTVIEW = 1;

    private int type;
    private String text;
    private String action;

    public int getType(){
        return this.type;
    }

    public void setType(int type){
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getAction() {
        return action;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAction(String action) {
        this.action = action;
    }
}