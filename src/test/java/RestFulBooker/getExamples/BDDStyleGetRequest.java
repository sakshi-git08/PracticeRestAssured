package RestFulBooker.getExamples;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BDDStyleGetRequest {
    @Test
    public void GetBookingIds_VerifyStatusCode() {

        List<String> Bookings = Arrays.asList("S", "A","K");
        int Size = Bookings.size();


        // Given
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                // When
                .when()
                .get("/booking")
                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking count
                .body(Integer.toString(Size) , Matchers.hasSize(14))
                // To verify booking id at index 3
                .body(Bookings.get(3), Matchers.equalTo(1));


    }
}
