package mashup.controller;

import mashup.resource.Activity;
import mashup.resource.ButtonAction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by ramitsuri on 12/5/2016.
 */
@RestController
public class ActivityController {

    public static ArrayList<Activity> activities;

    @RequestMapping(method = GET, value = "/activity")
    public Activity getActivity(@RequestParam(value="id", defaultValue="1") int id) {
        return activities.get(id);
    }

    public void postActivity(Activity activity) {
        activities.add(activity);
        System.out.println(activities.size());
    }
}
