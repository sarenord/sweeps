package sweeps;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Entity {
    private int x, y;
    private int sectorX, sectorY;
    private String type;
    private float energy;
    private int id;


    public Entity(int x, int y, int sectorX, int sectorY, String type) throws InvalidPositionException {
        this.x = x;
        this.y = y;
        this.sectorX = sectorX;
        this.sectorY = sectorY;
        this.type = type;

        Sector sector = Map.getSector(sectorX, sectorY);

        if(!sector.isBlocked(x, y) && sector.inBounds(x, y)){
            sector.entities.add(this);
        }else throw new InvalidPositionException();

        id = Map.generateEntityNum();

    }

    public void tick(){}

    public int getID(){
        return id;
    }

    public String getType(){
        return type;
    }

    public int getSectorX(){
        return sectorX;
    }

    public int getSectorY(){
        return sectorY;
    }

    public int getXPosition(){
        return x;
    }

    public int getYPosition(){
        return y;
    }

    public float getEnergy(){
        return energy;
    }

    public void setEnergy(float energy) throws InvalidPositionException {
        this.energy = energy;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    @JsonIgnore
    public Sector getSector() throws InvalidPositionException {
        return Map.getSector(sectorX, sectorY);
    }

}
