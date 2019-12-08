package sweeps;

public class UpdateThread implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {

                for (Sector i : Map.getSectors()) {
                    for (Entity n : i.entities) {
                        n.tick();
                    }
                }

                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
