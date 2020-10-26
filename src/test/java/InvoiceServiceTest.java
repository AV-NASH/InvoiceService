import com.cg.invoiceservice.InvoiceService;
import com.cg.invoiceservice.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void whenGivenTimeAndDistanceCalculateFare() {
        InvoiceService invoiceService= new InvoiceService();
        double distance=10; int time=10;
        double fare=invoiceService.calcNormalFare(distance,time);
        Assert.assertEquals(110,fare,0);
    }

    @Test
    public void givenLessDistanceAndTimeReturnMinimumFare() {
        InvoiceService invoiceService= new InvoiceService();
        double distance=0.2;int time=1;
        double fare=invoiceService.calcNormalFare(distance,time);
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
       double totalfare=invoiceService.calculateTotalFare(rides);
        Assert.assertEquals(225,totalfare,0);

    }

    @Test
    public void givenMultipleRidesReturnEnhancedInvoice() {
        InvoiceService invoiceService=new InvoiceService();
        Ride[] rides= { new Ride(3.0,10),
                new Ride(10.0,1),
                new Ride(5.0,10),
                new Ride(2.0,4)
        };
        invoiceService.calculateTotalFare(rides);
        Assert.assertEquals("Invoice\n" +
                "total fare=225.0"+
                ", total rides=4"+
                ", average fare=56.25",invoiceService.enhancedInvoice());

    }

    @Test
    public void whenGivenUserIDReturnInvoiceOfTheUser() {
        InvoiceService invoiceService=new InvoiceService();
        Ride[] rides1= { new Ride(3.0,10),
                new Ride(10.0,1),
                new Ride(5.0,10),
                new Ride(2.0,4)
        };
        Ride[] rides2= { new Ride(4.0,8),
                new Ride(20.0,3),
                new Ride(12.0,12),
                new Ride(2.0,2)
        };
        Ride[] rides3= { new Ride(6.0,10),
                new Ride(10.0,8),
                new Ride(3.0,10),
                new Ride(3.0,2)
        };

        invoiceService.addToInvoiceDataBase("tm101",rides1);
        invoiceService.addToInvoiceDataBase("tm102",rides2);
        invoiceService.addToInvoiceDataBase("tm103",rides3);

        invoiceService.generateInvoice("tm101");
        Assert.assertEquals("Invoice\n" +
                "total fare=225.0"+
                ", total rides=4"+
                ", average fare=56.25",invoiceService.enhancedInvoice());
    }

    @Test
    public void whenGivenBothTypeOFRidesGenerateCorrectInvoice() {
        InvoiceService invoiceService=new InvoiceService();
        Ride[] rides1= { new Ride(3.0,10),
                new Ride(10.0,1,"premium"),
                new Ride(5.0,10),
                new Ride(2.0,4,"premium")
        };
        Ride[] rides2= { new Ride(4.0,8,"premium"),
                new Ride(20.0,3),
                new Ride(12.0,12,"premium"),
                new Ride(2.0,2)
        };
        Ride[] rides3= { new Ride(6.0,10),
                new Ride(10.0,8,"premium"),
                new Ride(3.0,10,"Premium"),
                new Ride(3.0,2)
        };

        invoiceService.addToInvoiceDataBase("tm101",rides1);
        invoiceService.addToInvoiceDataBase("tm102",rides2);
        invoiceService.addToInvoiceDataBase("tm103",rides3);

        invoiceService.generateInvoice("tm103");
        Assert.assertEquals("Invoice\n" +
                "total fare=333.0"+
                ", total rides=4"+
                ", average fare=83.25",invoiceService.enhancedInvoice());
    }
}
