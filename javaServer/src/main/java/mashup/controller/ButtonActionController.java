package mashup.controller;

import mashup.resource.ButtonAction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ramitsuri on 12/5/2016.
 */

@RestController
public class ButtonActionController {

    @RequestMapping("/action")
    public ButtonAction action(@RequestParam(value="id", defaultValue="1") String id) {
        return new ButtonAction(id);
    }
}
