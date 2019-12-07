package sweeps;

public abstract class Entity {
    private int x, y;
    private int sectorX, sectorY;
    private String type;
    private float energy;

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
    }

    public void tick(){}

    public int getXPosition(){
        return x;
    }

    public String getType(){
        return type;
    }

    public int getYPosition(){
        return y;
    }

    public float getEnergy(){
        return energy;
    }

    public void setEnergy(float energy){
        this.energy = energy;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Sector getSector() throws InvalidPositionException {
        return Map.getSector(x, y);
    }

}
