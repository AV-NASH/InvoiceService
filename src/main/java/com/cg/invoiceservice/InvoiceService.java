package com.cg.invoiceservice;

import java.util.TreeMap;

public class InvoiceService {
    private final double NORMAL_COST_PER_KM=10;
    private final int NORMAL_COST_PER_MINUTE=1;
    private final double PREMIUM_COST_PER_KM=15;
    private final int PREMIUM_COST_PER_MINUTE=2;
    private TreeMap<String,Ride[]> invoiceDatabase=new TreeMap<String,Ride[]>();
    private double totalfare=0;
    private int totalrides;
    private double averagefare;

    public double calcNormalFare(double distance, int timeInMinute) {
        double fare=distance*NORMAL_COST_PER_KM+timeInMinute*NORMAL_COST_PER_MINUTE;
        if(fare<5) return 5;
        else return fare;
    }

    public double calcPremiumFare(double distance, int timeInMinute) {
        double fare=distance*PREMIUM_COST_PER_KM+timeInMinute*PREMIUM_COST_PER_MINUTE;
        if(fare<20) return 20;
        else return fare;
    }
    public void calculateTotalRide(Ride[] rides){
        this.totalrides= rides.length;
    }

    public double calculateTotalFare(Ride[] rides) {
        for(Ride ride:rides){
            if(ride.getType().toLowerCase().equals("premium"))
                totalfare=totalfare+calcPremiumFare(ride.getDistance(),ride.getTime());
            else
            totalfare=totalfare+calcNormalFare(ride.getDistance(),ride.getTime());
        }
        return totalfare;
    }
    public void calculateAverageFare(){
        averagefare=totalfare/totalrides;
    }
    public void addToInvoiceDataBase(String userID,Ride[] rides){
        invoiceDatabase.put(userID,rides);
    }

    public void generateInvoice(String userID){
        calculateTotalRide(invoiceDatabase.get(userID));
        calculateTotalFare(invoiceDatabase.get(userID));
        calculateAverageFare();
    }


    public String enhancedInvoice() {
        return "Invoice\n" +
                "total fare=" + totalfare +
                ", total rides=" + totalrides +
                ", average fare=" + averagefare;
    }
}
