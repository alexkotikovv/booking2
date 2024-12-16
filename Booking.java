import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class BookingPage {
    private SelenideElement searchInput = $("input[name='ss']");
    private SelenideElement checkInDate = $("div[data-placeholder='Check-in']");
    private SelenideElement checkOutDate = $("div[data-placeholder='Check-out']");
    private SelenideElement searchButton = $("button[type='submit']");
    private SelenideElement mapButton = $("a[data-testid='map-button']");
    private SelenideElement firstHotelCard = $("div[data-testid='property-card']:first-child");
    private SelenideElement hotelName = firstHotelCard.$("div[data-testid='title']");
    private SelenideElement hotelStars = firstHotelCard.$("span[data-testid='rating-stars']");
    private SelenideElement hotelRating = firstHotelCard.$("div[data-testid='review-score']");
    private SelenideElement hotelReviewsCount = firstHotelCard.$("div[data-testid='review-score-info']");
    private SelenideElement hotelPrice = firstHotelCard.$("div[data-testid='price-and-discounted-price']");

    public void open(String url) {
        open(url);
    }

    public void searchForCity(String city) {
        searchInput.setValue(city).pressEnter();
    }

    public void selectRandomDates() {
        //
        checkInDate.click();
        //
        checkOutDate.click();
        //
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void clickShowOnMap() {
        mapButton.click();
    }

    public String getHotelDetails() {
        String name = hotelName.getText();
        String stars = hotelStars.getText();
        String rating = hotelRating.getText();
        String reviewsCount = hotelReviewsCount.getText();
        String price = hotelPrice.getText();

        return String.format("Name: %s, Stars: %s, Rating: %s, Reviews: %s, Price: %s", 
            name, stars, rating, reviewsCount, price);
    }
}
