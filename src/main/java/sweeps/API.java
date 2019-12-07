package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sweeps.call_templates.AuthAPIKeyJSON;
import sweeps.call_templates.CreateBoiJSON;
import sweeps.call_templates.GetSectorJSON;

import java.security.NoSuchAlgorithmException;

@RestController
public class API {
    @RequestMapping(value = "/api/getMap", method = RequestMethod.GET)
    String getMap() throws JsonProcessingException {
        return Map.toJson();
    }

    @RequestMapping(value = "/api/getSector", method = RequestMethod.PUT)
    String getSector(@RequestBody GetSectorJSON json) throws JsonProcessingException, InvalidPositionException {
        return Map.getSector(json.x, json.y).toJson();
    }

    @RequestMapping(value = "/api/getNewAPIKey", method = RequestMethod.GET)
    String getNewAPIKey() throws NoSuchAlgorithmException, JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(Profiles.makeAPIKey());
    }

    @RequestMapping(value = "/api/authenticateAPIKey", method = RequestMethod.PUT)
    String authenticateAPIKey(@RequestBody AuthAPIKeyJSON json) throws NoSuchAlgorithmException, JsonProcessingException {
        return new ObjectMapper().writeValueAsString(Profiles.authenticate(json.key));
    }

    @RequestMapping(value = "/api/createInitialBoi", method = RequestMethod.PUT)
    String createInitialBoi(@RequestBody CreateBoiJSON json) throws NoSuchAlgorithmException, JsonProcessingException, InvalidPositionException {
        Profile profile = Profiles.getProfile(json.key);
        if(profile.getOwned().size() == 0){
            Entity e = new Boi(json.x, json.y, json.sectorX, json.sectorY, 250);
            profile.getOwned().add(e);
            return new ObjectMapper().writeValueAsString(e);
        }
        return new ObjectMapper().writeValueAsString("failure");
    }




}
