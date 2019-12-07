package sweeps;

public class EnergySource extends Entity{

    private static final float MAX_ENERGY = 1000;
    private static final float ENERGY_PER_GET = 10;
    private static final float ENERGY_REGEN = 5;

    private float energy = MAX_ENERGY;

    public EnergySource(int x, int y, int sectorX, int sectorY) throws InvalidPositionException {
        super(x, y, sectorX, sectorY, "energy_source");
    }

    public float pullEnergy(){
        if(energy > ENERGY_PER_GET) {
            energy -= ENERGY_PER_GET;
            return ENERGY_PER_GET;
        }else {
            float temp = energy;
            energy = 0;
            return temp;
        }
    }

    @Override
    public void tick(){
        super.tick();
        energy += ENERGY_REGEN;
    }

}
