package RestAssuredConcepts;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DefaultHostAndPortExample {


    public static void main(String[] args) {

        // Hitting a GET request without setting any base URI and Path
        RestAssured
                .given()
                // Logging all details
                .log()
                .all()
                .when()
                .get();

//        BDD Style
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .port(8181)
                .when()
                .get();

        //Non BDD ::
        RequestSpecification request1= RestAssured.given();
        // Setting Base URI
        request1.baseUri("https://restful-booker.herokuapp.com");
        // Setting Base Path
        request1.basePath("/ping");
        request1.port(8181);

//        RequestSpecification::

        RequestSpecification req2= new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setBasePath("/ping")
                .setPort(8181)
                .build();

//        Using static property of RestAssured class
        RestAssured.port = 9191;

    }

}
