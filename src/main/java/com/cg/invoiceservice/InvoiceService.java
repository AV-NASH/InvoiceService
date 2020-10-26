package com.cg.invoiceservice;

public class InvoiceService {
    private final double COST_PER_KM=10;
    private final int COST_PER_MINUTE=1;

    public double calcFare(double distance, int timeInMinute) {
        double fare=distance*COST_PER_KM+timeInMinute*COST_PER_MINUTE;
        if(fare<5) return 5;
        else return fare;
    }

}
