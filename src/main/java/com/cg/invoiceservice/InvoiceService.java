package com.cg.invoiceservice;

public class InvoiceService {
    private final double COST_PER_KM=10;
    private final int COST_PER_MINUTE=1;
    private double totalfare=0;
    private int totalrides;
    private double averagefare;

    public double calcFare(double distance, int timeInMinute) {
        double fare=distance*COST_PER_KM+timeInMinute*COST_PER_MINUTE;
        if(fare<5) return 5;
        else return fare;
    }
    public void calculateTotalRide(Ride[] rides){
        this.totalrides= rides.length;
    }

    public double calculateTotalFare(Ride[] rides) {
        calculateTotalRide(rides);
        for(Ride ride:rides){
            totalfare=totalfare+calcFare(ride.getDistance(),ride.getTime());
        }
        calculateAverageFare();
        return totalfare;
    }
    public void calculateAverageFare(){
        averagefare=totalfare/totalrides;
    }


    public String enhancedInvoice() {
        return "Invoice\n" +
                "total fare=" + totalfare +
                ", total rides=" + totalrides +
                ", average fare=" + averagefare;
    }
}
