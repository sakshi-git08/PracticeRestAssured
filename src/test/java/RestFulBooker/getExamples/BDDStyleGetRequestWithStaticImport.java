package RestFulBooker.getExamples;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BDDStyleGetRequestWithStaticImport {
    @Test
    public void GetBookingIds_VerifyStatusCode() {

        List<String> Bookings = new ArrayList<String>();

        // Given
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                // When
                .when()
                .get("/booking")
                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking count
                .body(String.valueOf(Bookings.size()), hasSize(25))
                // To verify booking id at index 3
                .body("bookingid[3]", equalTo(1));

    }
}
