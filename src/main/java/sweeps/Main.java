package sweeps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String [] args) throws InvalidPositionException {
        Map.init();
        Thread updateThread = new UpdateThread();
        updateThread.start();;
        SpringApplication.run(Main.class, args);
    }

}
