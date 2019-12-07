package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweeps.call_templates.GetSectorJSON;

@RestController
public class API {
    @RequestMapping(value = "/api/getMap", method = RequestMethod.GET)
    String getMap() throws JsonProcessingException {
        return Map.toJson();
    }

    @RequestMapping(value = "/api/getSector", method = RequestMethod.GET)
    String getSector(@RequestBody GetSectorJSON json) throws JsonProcessingException {
        return Map.getSector(json.x, json.y).toJson();
    }

}
