package sweeps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Main {

    public static void main(String [] args) throws InvalidPositionException {
        Map.init();
        Thread updateThread = new Thread(new UpdateThread());
        updateThread.start();
        SpringApplication.run(Main.class, args);
    }

}
