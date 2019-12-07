package sweeps;

public abstract class Entity {
    private int x;
    private int y;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getXPosition(){
        return x;
    }

    public int getYPosition(){
        return y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

}
