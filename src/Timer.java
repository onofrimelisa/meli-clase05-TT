import java.util.Date;

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        this.startTime = new Date().getTime();
    }

    public void end() {
        this.endTime = new Date().getTime();
    }

    public long elapsedTime () {
        return this.endTime - this.startTime;
    }
}
