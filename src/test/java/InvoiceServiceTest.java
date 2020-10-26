import com.cg.invoiceservice.InvoiceService;
import com.cg.invoiceservice.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void whenGivenTimeAndDistanceCalculateFare() {
        InvoiceService invoiceService= new InvoiceService();
        double distance=10; int time=10;
        double fare=invoiceService.calcFare(distance,time);
        Assert.assertEquals(110,fare,0);
    }

    @Test
    public void givenLessDistanceAndTimeReturnMinimumFare() {
        InvoiceService invoiceService= new InvoiceService();
        double distance=0.2;int time=1;
        double fare=invoiceService.calcFare(distance,time);
        Assert.assertEquals(5,fare,0);


    }

    @Test
    public void givenMultipleRidesGivesAggregrateTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
       Ride[] rides= { new Ride(3.0,10),
                       new Ride(10.0,1),
                       new Ride(5.0,10),
                       new Ride(2.0,4)
                        };
       double totalfare=invoiceService.calcTotalFare(rides);
        Assert.assertEquals(225,totalfare,0);

    }
}
