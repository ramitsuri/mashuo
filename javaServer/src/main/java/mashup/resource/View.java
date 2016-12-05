package mashup.resource;

/**
 * Created by ramitsuri on 12/5/2016.
 */
public class View {

    public View(int type, String text, String action){
        this.text = text;
        this.action = action;
        this.type = type;
    }
    private int type = 0;
    private String text = "";
    private String action = "";

    public int getType(){
        return type;
    }

    public void setType(int type){
        this.type = type;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action = action;
    }
}
