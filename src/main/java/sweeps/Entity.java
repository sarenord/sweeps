package sweeps;

public abstract class Entity {
    private int x;
    private int y;
    private String type;
    private float energy;

    public Entity(int x, int y, String type){
        this.x = x;
        this.y = y;
        this.type = type;
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

}
