package uz.pdp.b6cinemarestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.pdp.b6cinemarestservice.common.DataLoader;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class B6CinemaRestServiceApplication {


    public static void main(String[] args) {


        SpringApplication.run(B6CinemaRestServiceApplication.class, args);


        try {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Task ishladi!!!" + new Date());

                }
            };


            Timer timer = new Timer();


            System.out.println("Started... " + new Date());




            timer.schedule(task, 5000);
            System.out.println("Next statement... " + new Date());
        }catch (IllegalStateException e){
        }

    }

}
