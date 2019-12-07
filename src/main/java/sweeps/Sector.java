package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sector {

    public static final int SECTOR_HEIGHT = 25;
    public static final int SECTOR_WIDTH = 25;

    public int[][] map = new int[SECTOR_WIDTH][SECTOR_HEIGHT];

    public Sector(){
        for(int x = 0; x < SECTOR_WIDTH; x++){
            for(int y = 0; y < SECTOR_HEIGHT; y++){
                map[x][y] = (int)Math.round(Math.random());
            }
        }
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

}
