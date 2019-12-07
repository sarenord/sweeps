package sweeps;

public class Boi extends Entity{

    public static final float MOVEMENT_COST = 1;
    public static enum  Direction{
        north,
        south,
        east,
        west
    };

    public Boi(int x, int y, int sectorX, int sectorY, float energy) throws InvalidPositionException {
        super(x, y, sectorX, sectorY, "boi");
        setEnergy(energy);

    }

    public boolean moveBoi(Direction direction) throws InvalidPositionException {

        setEnergy(getEnergy()-MOVEMENT_COST);

        int newX = getXPosition();
        int newY = getYPosition();

        switch (direction){
            case north:
                newY++;
                break;

            case south:
                newY--;
                break;

            case east:
                newX++;
                break;

            case west:
                newX--;
                break;
        }

        if(!getSector().isBlocked(newX, newY)){
            setPosition(newX, newY);
            return true;
        }
        else return false;
    }

}
