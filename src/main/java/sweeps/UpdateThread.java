package sweeps;

public class UpdateThread extends Thread {

    @Override
    public void run() {
        super.run();

        for(Sector i : Map.getSectors()){
            for(Entity n : i.entities){
                n.tick();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
