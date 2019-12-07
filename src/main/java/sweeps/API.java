package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweeps.call_templates.AuthAPIKeyJSON;
import sweeps.call_templates.GetSectorJSON;

import java.security.NoSuchAlgorithmException;

@RestController
public class API {
    @RequestMapping(value = "/api/getMap", method = RequestMethod.GET)
    String getMap() throws JsonProcessingException {
        return Map.toJson();
    }

    @RequestMapping(value = "/api/getSector", method = RequestMethod.PUT)
    String getSector(@RequestBody GetSectorJSON json) throws JsonProcessingException {
        return Map.getSector(json.x, json.y).toJson();
    }

    @RequestMapping(value = "/api/getNewAPIKey", method = RequestMethod.GET)
    String getNewAPIKey() throws NoSuchAlgorithmException, JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(APIKeys.makeAPIKey());
    }

    @RequestMapping(value = "/api/authenticateAPIKey", method = RequestMethod.PUT)
    String authenticateAPIKey(@RequestBody AuthAPIKeyJSON json) throws NoSuchAlgorithmException, JsonProcessingException {
        return new ObjectMapper().writeValueAsString(APIKeys.authenticate(json.key));
    }

}
