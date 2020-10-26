import com.cg.invoiceservice.InvoiceService;
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
}
