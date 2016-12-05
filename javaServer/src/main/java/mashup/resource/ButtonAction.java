package mashup.resource;

/**
 * Created by ramitsuri on 12/5/2016.
 */
public class ButtonAction {

    public ButtonAction(String id){
        response = response + id;
    }

    private String response = "You pressed button ";

    public void setResponse(String response){
        this.response = response;
    }

    public String getResponse(){
        return response;
    }
}
