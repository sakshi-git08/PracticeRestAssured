package RestFulBooker.putExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.log4testng.Logger;

public class BDDStylePutRequest {

    public static final Logger log = Logger.getLogger(BDDStylePutRequest.class);

    public static void main(String[] args) {

        // There is no need to add escape character manually. Just paste string within
        // double
        // quotes. It will automatically add escape sequence as required.
        String jsonString = "{\r\n" + "    \"firstname\" : \"Amol\",\r\n" + "    \"lastname\" : \"Palekar\",\r\n"
                + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";

        //GIVEN
        ValidatableResponse response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking/1")
                .cookie("token", "f436cb69689ce50")
                .contentType(ContentType.JSON)
                .body(jsonString)
                // WHEN
                .when()
                .put()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstname", Matchers.equalTo("Amol"))
                .body("lastname", Matchers.equalTo("Palekar"));
        log.info("response" + response);

    }
}
