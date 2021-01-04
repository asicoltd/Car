import java.io.Serializable;
import java.util.*;

public class Rides implements Serializable {
    private String Destination ="East West University";
    private String pickupPoint = "Khilgaon Police Station";
    private final Random random = new Random();
    //MapAPI
    private final double estimatedTime = 30 + random.nextInt()%5;
    private final double estimatedBill = 100 + random.nextInt()%10;
    private final double timeNeeded = 25 + random.nextInt()%5;
    private final double billNeeded = 90 + random.nextInt()%10;
    private Calendar startTime = Calendar.getInstance();
    private Calendar endingTime = Calendar.getInstance();
    private double totalTime = Math.abs(endingTime.getTimeInMillis() - startTime.getTimeInMillis());

    public Rides() {
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public double getEstimatedTime(){
        return estimatedTime;
    }
    public double getEstimatedBill(){
        return estimatedBill;
    }

    public double getBillNeeded() {
        return billNeeded;
    }

    public double getTimeNeeded() {
        return timeNeeded;
    }

    private final double totalDistance = 5+ random.nextInt(5);

    public void setStartTime() {
        this.startTime = Calendar.getInstance();
    }

    public void setEndingTime() {
        Calendar t = Calendar.getInstance();
        t.add(Calendar.MINUTE, 30+random.nextInt(5));
        this.endingTime = t;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalTime() {
        this.totalTime = endingTime.get(Calendar.MINUTE)- startTime.get(Calendar.MINUTE);
    }

    public double getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return "Rides{" +
                "Destination='" + Destination + '\'' +
                ", Pickup Point='" + pickupPoint + '\'' +
                ", Start Time=" + startTime.getTime() +
                ", Ending Time=" + endingTime.getTime() +
                ", Total Time=" + totalTime +" "+"minute"+
                '}'+"\n";
    }
}
