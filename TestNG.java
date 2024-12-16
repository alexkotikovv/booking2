import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BookingTest {
    
    private BookingPage bookingPage;

    @BeforeClass
    public void setUp() {
        bookingPage = new BookingPage();
        System.setProperty("selenide.browser", "chrome");
    }

    @Test
    @Description("Automate the booking.com search process")
    public void testBookingSearch() {
        bookingPage.open("https://www.booking.com/");
        
        bookingPage.searchForCity("Paris");
        bookingPage.selectRandomDates();
        bookingPage.clickSearch();
        
        bookingPage.clickShowOnMap();

        String hotelDetails = bookingPage.getHotelDetails();
        System.out.println(hotelDetails);

        //
        assertTrue(hotelDetails.contains("Star"), "Hotel details should contain star information.");
        
        //
    }
}
