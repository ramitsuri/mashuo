package mashup;

import mashup.controller.ActivityController;
import mashup.resource.Activity;
import mashup.resource.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ActivityController controller = new ActivityController();
        ActivityController.activities = new ArrayList<>();
        Activity activity = new Activity();
        View view = new View(1, "HELLO", "");
        activity.views.add(view);
        view = new View(0, "Button1", "http://52.39.204.2:1398/action/1");
        activity.views.add(view);
        view = new View(1, "WORLD", "");
        activity.views.add(view);
        view = new View(0, "Button2", "http://52.39.204.2:1398/action/2");
        activity.views.add(view);
        controller.postActivity(activity);
        activity = new Activity();
        view = new View(0, "Button1", "http://52.39.204.2:1398/action/1");
        activity.views.add(view);
        view = new View(0, "Button2", "http://52.39.204.2:1398/action/2");
        activity.views.add(view);
        view = new View(0, "Button3", "http://52.39.204.2:1398/action/3");
        activity.views.add(view);
        controller.postActivity(activity);
        activity = new Activity();
        view = new View(1, "Android", "");
        activity.views.add(view);
        view = new View(1, "Mashup", "");
        activity.views.add(view);
        view = new View(0, "Button1", "http://52.39.204.2:1398/action/1");
        activity.views.add(view);
        controller.postActivity(activity);

        SpringApplication.run(Application.class, args);
    }
}
