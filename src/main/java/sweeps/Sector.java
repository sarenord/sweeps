package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;

public class Sector implements Serializable {

    public static final int SECTOR_HEIGHT = 25;
    public static final int SECTOR_WIDTH = 25;

    public int[][] map = new int[SECTOR_WIDTH][SECTOR_HEIGHT];

    public ArrayList<Entity> entities = new ArrayList<>();

    public Sector(){
        for(int y = 0; y < SECTOR_WIDTH; y++){
            for(int x = 0; x < SECTOR_HEIGHT; x++){
                map[x][y] = (int)Math.round(Math.random());
            }
        }

        entities.add(new EnergySource((int)(Math.random()*SECTOR_WIDTH), (int)(Math.random()*SECTOR_HEIGHT)));

    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

}
