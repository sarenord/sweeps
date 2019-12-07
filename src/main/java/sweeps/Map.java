package sweeps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class Map implements Serializable {

    public static final int WORLD_HEIGHT = 10;
    public static final int WORLD_WIDTH = 10;

    private static Sector[][] sectors = new Sector[WORLD_HEIGHT][WORLD_WIDTH];

    public static void init() throws InvalidPositionException {
        for(int x = 0; x < WORLD_WIDTH; x++){
            for(int y = 0; y < WORLD_HEIGHT; y++){
                sectors[x][y] = new Sector(x, y);
            }
        }

        for(int i = 0; i < 500; i++){
            int x = (int)Math.round(Math.random()*(WORLD_WIDTH-1));
            int y = (int)Math.round(Math.random()*(WORLD_HEIGHT-1));

            int xPos = (int)(Math.random()*Sector.SECTOR_WIDTH);
            int yPos = (int)(Math.random()*Sector.SECTOR_HEIGHT);

            while(sectors[x][y].isBlocked(xPos, yPos)) {
                xPos = (int)(Math.random()*Sector.SECTOR_WIDTH);
                yPos = (int)(Math.random()*Sector.SECTOR_HEIGHT);
            }

            new EnergySource(xPos, yPos, x, y);

        }

    }

    public static String toJson() throws JsonProcessingException {

        return "{\"width\": "+WORLD_HEIGHT+", \"height\": "+WORLD_WIDTH+" }";
    }

    public static Sector getSector(int x, int y) throws InvalidPositionException {
        if(x < WORLD_WIDTH && x >= 0 && y < WORLD_HEIGHT && y >= 0)
            return sectors[x][y];
        return new Sector(x, y);
    }

}
