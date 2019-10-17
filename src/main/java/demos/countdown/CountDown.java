package demos.countdown;

public class CountDown implements Runnable {
    private boolean chronoOn = false;
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public CountDown(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    public String toString() {
        String h = Integer.toString(hours);
        String m = Integer.toString(minutes);
        String s = Integer.toString(seconds);
        return h + ":" + m + ":" + s;
    }
    
    public int toSeconds() {
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }
    
    public boolean isActive() {
        return chronoOn;
    }
    
    public void print() {
        System.out.println(toString());
    }
    
    
    public void start() {
        chronoOn = true;
        new Thread(this).start();
    }
    
    public void stop() {
        chronoOn = false;
    }

    @Override
    public void run() {
        System.out.println("Chrono to seconds = " + toSeconds());
        
        // Horas
        for(;hours >= 0; hours--) {
            // Minutos
            for(;minutes >= 0;minutes--) {
                // Segundos
                for(;seconds >= 0;seconds--) {
                    if(!chronoOn) {
                        stop();
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    CountDownUI.ui.setHours(hours);
                    CountDownUI.ui.setMinutes(minutes);
                    CountDownUI.ui.setSeconds(seconds);
                    CountDownUI.ui.updateBar();
                    print();
                }
                seconds = 59;
            }
            minutes = 59;
        }
    }
}
