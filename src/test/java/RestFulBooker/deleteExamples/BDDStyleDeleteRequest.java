package RestFulBooker.deleteExamples;

import io.restassured.RestAssured;

public class BDDStyleDeleteRequest {

    public static void main(String[] args) {


        // Delete Booking

        //GIVEN
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .cookie("token", "fa28901e842f316")
                // WHEN
                .when()
                .delete()
                // THEN
                .then()
                .assertThat()
                .statusCode(201).log().all();

        // Verifying booking is deleted
        // Given
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                // When
                .when()
                .get()
                // Then
                .then()
                .statusCode(404);

    }
}
