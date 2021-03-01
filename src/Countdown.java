import java.util.TimerTask;
import java.util.Timer;

//A countdown that takes time and counts down by second and alerts the user when the time has reached 00:00:00

public class Countdown {

    public static void main(String[] args){

        Timer timer = new Timer();
        System.out.println("Counting down from " + Integer.parseInt(args[0]) + " seconds");

        TimerTask task = new TimerTask() {
            int seconds = Integer.parseInt(args[0]);
            Time time = new Time(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            @Override
            public void run() {
                if (seconds > 1) {
                    seconds--;
                    System.out.println(seconds + " seconds");
                }
                else {
                    System.out.println("0 seconds \n End");
                    timer.cancel();
                }

            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
}
