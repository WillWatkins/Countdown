import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class CountdownTimer {
//A countdown timer that alerts the user when the time has reached 00:00:00 (hh:mm:ss).

        public static void main(String[] args){

            Scanner input = new Scanner(System.in);

            //Getting the users desired time to countdown from.
            System.out.print("Please input the time to countdown from in the format (hh:mm:ss): ");
            Time time = new Time(input.nextInt(), input.nextInt(), input.nextInt());

            System.out.println("Counting down from " + time.toString());

            /**
             *
             *
             */
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (time.getSeconds() > 0) {
                        System.out.println(time.toString());
                        time.subtractSecond();
                    }
                    else {
                        System.out.println(time.toString() + "\n END");
                        timer.cancel();
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 1000, 1000);
        }
    }


