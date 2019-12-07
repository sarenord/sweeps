package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class Map implements Serializable {

    public static final int WORLD_HEIGHT = 10;
    public static final int WORLD_WIDTH = 10;

    private static Sector[][] sectors = new Sector[WORLD_HEIGHT][WORLD_WIDTH];

    public static void init(){
        for(int x = 0; x < WORLD_WIDTH; x++){
            for(int y = 0; y < WORLD_HEIGHT; y++){
                sectors[x][y] = new Sector();
            }
        }
    }

    public static String toJson() throws JsonProcessingException {

        return "{\"width\": "+WORLD_HEIGHT+", \"height\": "+WORLD_WIDTH+" }";
    }

    public static Sector getSector(int x, int y){
        if(x < WORLD_WIDTH && x >= 0 && y < WORLD_HEIGHT && y >= 0)
            return sectors[x][y];
        return new Sector();
    }

}
