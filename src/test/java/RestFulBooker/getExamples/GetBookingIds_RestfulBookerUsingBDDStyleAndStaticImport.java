package RestFulBooker.getExamples;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class GetBookingIds_RestfulBookerUsingBDDStyleAndStaticImport {
    @Test
    public void GetBookingIds_VerifyStatusCode() {

        // Given
       ValidatableResponse response = given()
                .baseUri("https://restful-booker.herokuapp.com")
                // When
                .when()
                .get("/booking")
                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking count
                .body("bookingid", hasSize(10))
                // To verify booking id at index 3
                .body("bookingid[3]", equalTo(8));

       String resString = response.toString();
       System.out.println("Response String is ::" + resString);

    }
}
